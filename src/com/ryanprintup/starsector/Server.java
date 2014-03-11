package com.ryanprintup.starsector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ryanprintup.starsector.starbound.StarboundServer;
import com.ryanprintup.starsector.util.Config;
import com.ryanprintup.starsector.util.Console;

public class Server implements Runnable
{	
	private static final String STAR_SECTOR_VERSION = "1.0.0";
	
	private Console console = Console.getInstance();
	private Config config = new Config();
	
	private StarboundServer starboundServer = new StarboundServer();
	
	private Client clients[];
	
	private ServerSocket serverSocket;
	private Thread server = new Thread(this);
	private boolean running = false;
	
	public synchronized void start()
	{
		console.info("Starting server....");
		console.info("You are running Star Sector " + STAR_SECTOR_VERSION);

		if (!config.exists()) {
			console.info("Generating config file...");
			
			try {
				config.generate();
			} catch (IOException e) {
				console.error("Error generating config file");
				e.printStackTrace();
				return;
			}
			
			console.info("Config file generated");
		}
		
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
		
		//if (!starboundServer.start()) {
			//console.error("Error starting Starbound server");
			//return;
		//}
		console.info("Starbound server started");
		
		clients = new Client[config.getMaxClients()];
		
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
				
				if (clients[clients.length - 1] != null) {
					console.info(client.getInetAddress().getHostAddress() + " attempted to join but the server is full");
					client.close();
				} else {
					console.info(client.getInetAddress().getHostAddress() + " has connected");
					clients[clients.length - 1] = new Client(client, new Player("Bob", "1"));
				}
			} catch (IOException e) {
				console.error("Client attempted to join but failed");
				e.printStackTrace();
			}
		}
	}
	
	private void onPlayerDisconnect()
	{
		
	}
	
	public synchronized void stop()
	{
		console.info("Stopping server....");
		
		running = false;
		
		console.info("Disconnecting clients");
		for (Client c : clients) {
			c.disconnect();
		}
		clients = null;
		console.info("Clients disconnected");
		
		starboundServer.stop();
		console.info("Starbound server stopped");
		
		try {
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		console.info("Server stopped");
	}
}
