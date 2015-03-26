package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;

public class ChatRecievedPacket extends BasePacket
{
	private short channel;
	private String world;
	private long clientId;
	private String name;
	private String message;
	
	public ChatRecievedPacket()
	{
	}
	
	public ChatRecievedPacket(short channel, String world, long clientId, String name, String message)
	{
		this.channel = channel;
		this.world = world;
		this.clientId = clientId;
		this.name = name;
		this.message = message;
	}
	
	@Override
	public byte getId()
	{
		return 4;
	}

	public short getChannel()
	{
		return channel;
	}

	public String getWorld()
	{
		return world;
	}

	public long getClientId()
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
