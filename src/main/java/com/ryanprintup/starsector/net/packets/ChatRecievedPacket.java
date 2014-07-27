package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ChatRecievedPacket extends Packet
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
	
	@Override
	public void read(PacketReader stream)
	{
		channel = stream.readUInt8();
		world = stream.readString();
		clientId = stream.readUInt32();
		name = stream.readString();
		message = stream.readString();
	}

	@Override
	public byte[] write()
	{
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
