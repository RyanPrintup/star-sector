package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class TileLiquidUpdatePacket implements Packet
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private int unknown1; // Might be liquid level
	private int unknown2; // Might be liquid type

	@Override
	public byte getId()
	{
		return 18;
	}

	public long getTileX()
	{
		return tileX;
	}

	public long getTileY()
	{
		return tileY;
	}

	public int getUnknown1()
	{
		return unknown1;
	}

	public int getUnknown2()
	{
		return unknown2;
	}
}