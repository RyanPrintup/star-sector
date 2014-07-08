package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ChatSentPacket implements Packet
{
	private String messsage;
	private int channel;

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