package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ChatRecievedPacket implements Packet
{
	private int channel;
	private String world;
	private int clientId;
	private String name;
	private String message;

	@Override
	public byte getId()
	{
		return 4;
	}

	public int getChannel()
	{
		return channel;
	}

	public String getWorld()
	{
		return world;
	}

	public int getClientId()
	{
		return clientId;
	}

	public String getName()
	{
		return name;
	}

	public String getMessage()
	{
		return message;
	}
}
