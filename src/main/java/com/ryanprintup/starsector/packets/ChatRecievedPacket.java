package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class ChatRecievedPacket implements BasePacket
{
	private short channel; // uint8
	private String world;
	private long clientId; // uint32
	private String name;
	private String message;

    public ChatRecievedPacket()
    {
    }

    public ChatRecievedPacket(short channel, String world, long clientId, String name, String message)
	{
		this.channel  = channel;
		this.world    = world;
		this.clientId = clientId;
		this.name     = name;
		this.message  = message;
	}

    @Override
    public void read(BufferStream stream)
    {
        channel  = stream.readUInt8();
        world    = stream.readString();
        clientId = stream.readUInt32();
        name     = stream.readString();
        message  = stream.readString();
    }

    @Override
    public void write(BufferStream stream)
    {

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
