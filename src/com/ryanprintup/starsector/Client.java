package com.ryanprintup.starsector;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import com.ryanprintup.starsector.net.Connection;

public class Client
{
	private final String ip;
	private final Socket socket;
	private final Player player;
	private Connection client;
	private Connection server;
	
	public Client(final Socket socket, final Player player)
	{
		this.socket = socket;
		this.ip = socket.getInetAddress().getHostAddress();
		this.player = player;
		
		Socket serverSocket;

		try {
			serverSocket = new Socket("127.0.0.1", 21020);
			
			client = new Connection(socket.getInputStream(), serverSocket.getOutputStream());
			server = new Connection(serverSocket.getInputStream(), socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			socket.setKeepAlive(true);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message)
	{
		//sendPacket(message);
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
	
	public String getIp()
	{
		return ip;
	}
}