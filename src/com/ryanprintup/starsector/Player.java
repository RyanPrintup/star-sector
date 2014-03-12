package com.ryanprintup.starsector;

import java.io.IOException;
import java.net.Socket;

import com.ryanprintup.starsector.net.Connection;
import com.ryanprintup.starsector.util.Config;

public class Player
{
	private Socket socket;
	private Connection client;
	private Connection server;
	
	private String name;
	private String ip;
	
	public Player(final Socket socket)
	{
		this.socket = socket;
		ip = socket.getInetAddress().getHostAddress();
		
		try {
			socket.setKeepAlive(true);
			Socket serverSocket = new Socket("127.0.0.1", Config.getServerInstance().getConfig().getStarboundPort());
			
			client = new Connection(socket.getInputStream(), serverSocket.getOutputStream());
			server = new Connection(serverSocket.getInputStream(), socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message)
	{
		
	}
	
	private void sendPacket(final byte packet[])
	{
		try {
			socket.getOutputStream().write(packet);
			socket.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect()
	{
		client.endConnection();
		server.endConnection();

		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getIp()
	{
		return ip;
	}
}
