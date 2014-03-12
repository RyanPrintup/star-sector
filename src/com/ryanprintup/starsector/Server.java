package com.ryanprintup.starsector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ryanprintup.starsector.command.CommandList;
import com.ryanprintup.starsector.starbound.StarboundServer;
import com.ryanprintup.starsector.util.Config;
import com.ryanprintup.starsector.util.Console;

public class Server implements Runnable
{	
	private static final String STAR_SECTOR_VERSION = "1.0.0";
	
	private Console console = Console.getInstance();
	private Config config = new Config();
	
	private StarboundServer starboundServer;
	
	private List<Player> players = new ArrayList<Player>();
	
	private ServerSocket serverSocket;
	private Thread server = new Thread(this);
	private boolean running = false;
	
	public Server()
	{
		config.setServerInstance(this);
		CommandList.initDefaults();
		
		// Initiated here because the server instance needs to be set first
		starboundServer = new StarboundServer();
	}
	
	public synchronized void start()
	{
		console.info("Starting server....");
		console.info("You are running Star Sector " + STAR_SECTOR_VERSION);

		checkForFiles();
		
		try {
			config.load();
		} catch (NumberFormatException | IOException e) {
			console.error("Error loading config file");
			e.printStackTrace();
			return;
		}
		
		console.info("Config file loaded");
		
		starboundServer.setPort(21020);
		console.info("Starbound bounded to port " + config.getStarboundPort());
		
		if (!starboundServer.start()) {
			console.error("Error starting Starbound server");
			return;
		}
		console.info("Waiting for starbound server to startup...");
		waitForServerStartup();
		console.info("Starbound server started");
		
		try {
			serverSocket = new ServerSocket(config.getServerPort(), config.getMaxClients());
		} catch (IOException e) {
			console.error("Error binding Star Sector to port " + config.getServerPort());
			e.printStackTrace();
			return;
		}
		console.info("Star Sector bounded to port " + config.getServerPort());
		
		running = true;
		server.start();
		
		console.info("Server started");	
	}
	
	@Override
	public void run()
	{
		Socket client;
		
		while (running) {
			try {
				client = serverSocket.accept();
				
				if (!emptySlot()) {
					console.info(client.getInetAddress().getHostAddress() + " attempted to join but the server is full");
					client.close();
				} else {
					console.info(client.getInetAddress().getHostAddress() + " has connected");
					addPlayer(new Player(client));
				}
			} catch (IOException e) {
				console.error("Client attempted to join but failed");
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void stop()
	{
		console.info("Stopping server....");
		
		running = false;
		
		if (getPlayerCount() > 0) {
			console.info("Disconnecting players");
			for (Player p : players) {
				p.disconnect();
			}
			
			console.info("Players disconnected");
		}	
		
		starboundServer.stop();
		console.info("Starbound server stopped");
		
		try {
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		console.info("Server stopped");
	}
	
	private void checkForFiles()
	{
		if (!config.exists()) {
			console.info("Config file not found.");
			console.info("Generating config file");
			
			try {
				config.generate();
				
				console.info("Config file generated.");
			} catch (IOException e) {
				console.error("Error generating config file");
			}
		}
	}
	
	/**
	 * The starbound server takes time to load the world
	 * and other important files. In order to see when it is
	 * ready we keep trying to connect to the server until a
	 * connection succeeds.
	 */
	private void waitForServerStartup()
	{
		Socket s;
		
		while (true) {
			try {
				s = new Socket("127.0.0.1", config.getStarboundPort());
				
				break;
			} catch (IOException e) {
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e1) {
				}
			}
		}
		
		try {
			s.close();
		} catch (IOException e) {
		}
	}
	
	public void sendMessage(String message)
	{
		for (Player p : players) {
			p.sendMessage(message);
		}
		
		console.write(message);
	}
	
	public void addPlayer(Player p)
	{
		if (emptySlot() /*&& findPlayer(p) == null*/) {
			players.add(p);
		}
	}
	
	public void removePlayer(Player p)
	{
		if (findPlayer(p) != null) {
			players.remove(p);
		}
	}
	
	public Player findPlayer(String name)
	{
		name = name.toLowerCase();
		
		for (Player p : players) {
			if (p.getName().toLowerCase().equals(name)) {
				return p;
			}
		}
		
		return null;
	}
	
	public Player findPlayer(Player p)
	{
		return findPlayer(p.getName());
	}
	
	public Player getPlayer(int index)
	{
		if (index > players.size()) {
			return null;
		}
		
		return players.get(index);
	}
	
	public int getPlayerCount()
	{
		return players.size();
	}
	
	public boolean emptySlot()
	{
		return players.size() < config.getMaxClients();
	}
	
	public Config getConfig()
	{
		return config;
	}
	
	public boolean isRunning()
	{
		return running;
	}
}
