package com.ryanprintup.starsector;

import java.io.IOException;
import java.net.Socket;

import com.ryanprintup.starsector.command.CommandSender;
import com.ryanprintup.starsector.configuration.StarSectorConfig;
import com.ryanprintup.starsector.net.PacketWriter;
import com.ryanprintup.starsector.net.Connection;

public class Player implements CommandSender
{
	private Socket socket;
	private Connection client;
	private Connection server;
	
	private String name;
	private String ip;
	private String UUID;
	
	public Player(final Socket socket)
	{
		this.socket = socket;
		ip = socket.getInetAddress().getHostAddress();
		
		try {
			socket.setKeepAlive(true);
			Socket serverSocket = new Socket("127.0.0.1", StarSector.getServer().getConfig().getInt(StarSectorConfig.STARBOUND_PORT));
			
			client = new Connection(socket.getInputStream(), serverSocket.getOutputStream());
			server = new Connection(serverSocket.getInputStream(), socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendMessage(String message)
	{
		PacketWriter pw = new PacketWriter();
		pw.writeUInt8(1);
		pw.writeString("");
		pw.writeUInt32(1);
		pw.writeString("Console");
		pw.writeString(message);
	}
	
	@Override
	public void sendMessage(String[] messages)
	{
		for (String message : messages) {
			sendMessage(message);
		}
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