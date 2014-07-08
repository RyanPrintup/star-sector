package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class UniversalTimeUpdatePacket implements Packet
{
	private long time; // sVLQ

	@Override
	public byte getId()
	{
		return 5;
	}

	public long getTime()
	{
		return time;
	}
}
