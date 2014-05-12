package com.ryanprintup.starsector;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ryanprintup.starsector.command.CommandList;
import com.ryanprintup.starsector.command.defaults.CmdHelp;
import com.ryanprintup.starsector.command.defaults.CmdIp;
import com.ryanprintup.starsector.command.defaults.CmdKick;
import com.ryanprintup.starsector.command.defaults.CmdPlayers;
import com.ryanprintup.starsector.command.defaults.CmdPrivateMessage;
import com.ryanprintup.starsector.command.defaults.CmdRestart;
import com.ryanprintup.starsector.command.defaults.CmdSay;
import com.ryanprintup.starsector.command.defaults.CmdStart;
import com.ryanprintup.starsector.command.defaults.CmdStop;
import com.ryanprintup.starsector.configuration.Config;
import com.ryanprintup.starsector.configuration.ServerConfig;
import com.ryanprintup.starsector.starbound.StarboundServer;

public class Server implements Runnable
{
	private Console console;
	private Config serverConfig;
	private Logger logger;
	
	private CommandList commandList = new CommandList();
	private StarboundServer starboundServer;
	
	private List<Player> players = new ArrayList<Player>();
	
	private static final File logDirectory = new File("logs");
	
	private static final File serverLogFile = new File(logDirectory + "server.log");
	private static final File serverConfigFile = new File("config.yaml");
	
	private ServerSocket serverSocket;
	private Thread server = new Thread(this);
	private boolean running = false;
	
	public Server()
	{
		StarSector.setServer(this);
		
		console = new Console();
		serverConfig = new ServerConfig(serverConfigFile);
		logger = new Logger(serverLogFile);
		
		starboundServer = new StarboundServer();
		
		setCommandDefaults();
	}
	
	public synchronized void start()
	{
		console.info("Starting server....");
		console.info("You are running Star Sector " + StarSector.getVersion());
		
		serverConfig.load();
		console.info("Config file loaded");
		
		starboundServer.setPort(serverConfig.getInt(ServerConfig.STARBOUND_PORT));
		console.info("Starbound bounded to port " + serverConfig.getInt(ServerConfig.STARBOUND_PORT));
		
		if (!starboundServer.start()) {
			console.error("Error starting Starbound server");
			return;
		}
		console.info("Waiting for starbound server to startup...");
		waitForServerStartup();
		console.info("Starbound server started");
		
		try {
			serverSocket = new ServerSocket(serverConfig.getInt(ServerConfig.SERVER_PORT), serverConfig.getInt(ServerConfig.MAX_PLAYERS));
		} catch (IOException e) {
			console.error("Error binding Star Sector to port " + serverConfig.getInt(ServerConfig.SERVER_PORT));
			e.printStackTrace();
			return;
		}
		console.info("Star Sector bounded to port " + serverConfig.getInt(ServerConfig.SERVER_PORT));
		
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
				
				if (!hasEmptySlot()) {
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
	
	/**
	 * The starbound server takes time to load the world
	 * and other important files. In order to see when it is
	 * ready we keep trying to connect to the server until a
	 * connection succeeds. That connection is then closed.
	 */
	private void waitForServerStartup()
	{
		Socket test;
		
		while (true) {		
			try {
				test = new Socket("127.0.0.1", serverConfig.getInt(ServerConfig.STARBOUND_PORT));
				
				break;
			} catch (IOException e) {
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e1) {
				}
			}
		}
		
		try {
			test.close();
		} catch (IOException e) {
		}
	}
	
	private void setCommandDefaults()
	{
		commandList.register(new CmdHelp());
		commandList.register(new CmdIp());
		commandList.register(new CmdKick());
		commandList.register(new CmdPlayers());
		commandList.register(new CmdPrivateMessage());
		commandList.register(new CmdRestart());
		commandList.register(new CmdSay());
		commandList.register(new CmdStart());
		commandList.register(new CmdStop());
	}
	
	public void sendMessage(String message)
	{
		for (Player p : players) {
			p.sendMessage(message);
		}
		
		console.sendMessage(message);
	}
	
	public void addPlayer(Player p)
	{
		if (hasEmptySlot() /*&& findPlayer(p) == null*/) {
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
	
	public boolean hasEmptySlot()
	{
		return players.size() < serverConfig.getInt(ServerConfig.MAX_PLAYERS);
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public Console getConsole()
	{
		return console;
	}
	
	public Config getConfig()
	{
		return serverConfig;
	}
	
	public Logger getLogger()
	{
		return logger;
	}
	
	public CommandList getCommandList()
	{
		return commandList;
	}
}
