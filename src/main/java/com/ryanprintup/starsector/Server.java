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
import com.ryanprintup.starsector.configuration.StarSectorConfig;
import com.ryanprintup.starsector.exceptions.StarSectorException;
import com.ryanprintup.starsector.starbound.StarboundServer;

public class Server implements Runnable
{
	private Console console;
	private Config config;
	private Logger logger;
	private Updater updater = new Updater();
	
	private CommandList commandList = new CommandList();
	private StarboundServer starboundServer;
	
	private List<Player> players = new ArrayList<Player>();
	
	private static final File logDirectory = new File("logs");
	private static final File serverLogFile = new File(logDirectory + "server.log");
	private static final File configFile = new File("config.json");
	
	private ServerSocket serverSocket;
	private Thread server = new Thread(this);
	private boolean running = false;
	
	public Server()
	{
		StarSector.setServer(this);

		console = new Console();
		starboundServer = new StarboundServer();
		
		setCommandDefaults();
	}
	
	public synchronized void start()
	{
		config = new StarSectorConfig(configFile);
		
		console.info("Starting server....");
		console.info("You are running Star Sector " + StarSector.getVersion());
		console.info("Checking for Star Sector update...");
		updater.check();

		config.load();
		console.info("Config file loaded");
		
		logger = new Logger(serverLogFile);
		
		try {
			starboundServer.start();
		} catch (StarSectorException e) {
			e.printStackTrace();
		}
		
		console.info("Starbound bounded to port " + config.getInt(StarSectorConfig.STARBOUND_PORT));
		
		console.info("Waiting for starbound server to startup...");
		waitForServerStartup();
		console.info("Starbound server started");
		
		try {
			serverSocket = new ServerSocket(config.getInt(StarSectorConfig.SERVER_PORT), config.getInt(StarSectorConfig.MAX_PLAYERS));
		} catch (IOException e) {
			console.error("Error binding Star Sector to port " + config.getInt(StarSectorConfig.SERVER_PORT));
			e.printStackTrace();
			return;
		}
		console.info("Star Sector bounded to port " + config.getInt(StarSectorConfig.SERVER_PORT));
		
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
				test = new Socket("127.0.0.1", config.getInt(StarSectorConfig.STARBOUND_PORT));
				
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
	
	public void broadcastMessage(String message)
	{
		for (Player p : players) {
			p.sendMessage(message);
		}
		
		console.sendMessage(message);
	}
	
	public void addPlayer(Player player)
	{
		if (hasEmptySlot() && findPlayer(player.getName()) == null) {
			players.add(player);
		}
	}
	
	public void removePlayer(Player player)
	{
		if (findPlayer(player.getName()) != null) {
			players.remove(player);
		}
	}
	
	public Player findPlayer(String name)
	{
		for (Player player : players) {
			if (player.getName().equalsIgnoreCase(name)) {
				return player;
			}
		}
		
		return null;
	}
	
	public Player[] getOnlinePlayers()
	{
		return players.toArray(new Player[players.size()]);
	}
	
	public int getPlayerCount()
	{
		return players.size();
	}
	
	public boolean hasEmptySlot()
	{
		return players.size() < config.getInt(StarSectorConfig.MAX_PLAYERS);
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
		return config;
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
