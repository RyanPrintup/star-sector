package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class ChatSentPacket implements BasePacket
{
	private String message;
	private short channel; // uint8

    public ChatSentPacket()
    {
    }

    public ChatSentPacket(String message, short channel)
	{
		this.message = message;
		this.channel = channel;
	}

    @Override
    public void read(BufferStream stream)
    {
        message = stream.readString();
        channel = stream.readUInt8();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

    @Override
	public byte getId()
	{
		return 11;
	}
	
	public String getMessage()
	{
		return message;
	}

	public int getChannel()
	{
		return channel;
	}
}