package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class ChatSentPacket extends BasePacket
{
	private String message;
	private short channel;
	
	public ChatSentPacket()
	{
	}
	
	public ChatSentPacket(String message, short channel)
	{
		this.message = message;
		this.channel = channel;
	}
	
	@Override
	public byte getId()
	{
		return 11;
	}

	@Override
	public void read(PacketReader stream)
	{
		message = stream.readString();
		channel = stream.readUInt8();
	}

	@Override
	public byte[] write()
	{
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