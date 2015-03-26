package com.ryanprintup.starsector;

import com.ryanprintup.starsector.configuration.StarSectorConfig;
import com.ryanprintup.starsector.starbound.StarboundServer;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable
{
	private Console console;

    private static final String CONFIG_PATH = "starsector.config";
    private StarSectorConfig config = new StarSectorConfig(CONFIG_PATH);
    private int port;

	private StarboundServer starboundServer;
	
	private List<Player> players = new ArrayList<Player>();

    private ServerSocket serverSocket;
	private Thread server = new Thread(this);
	private boolean running = false;
	
	public Server()
	{
		StarSector.setServer(this);

		console = new Console();
		starboundServer = new StarboundServer();
	}
	
	public synchronized void start()
    {
        console.info("Starting Star Sector server.");

        console.info("Loading configuration...");
        try {
            config.load();
        } catch (IOException | ParseException e) {
            console.error("Could not load configuration. Aborting startup. Error: " + e);
            return;
        }

        port = config.getPort();

        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            console.error("Could not bind socket to port " + port + ". Error: " + e);
            return;
        }

        console.info("Server successfully binded to port " + port);

        server.start();
	}
	
	@Override
	public void run()
    {
        while (true) {
            Socket client;

            try {
                client = serverSocket.accept();

                console.info(client.getInetAddress().getHostAddress() + " has connected.");
                addPlayer(new Player(client));
            } catch (IOException e) {
                console.error("Client attempted to join but failed. Error: " + e);
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
		return players.size() < 20;
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public Console getConsole()
	{
		return console;
	}
}
