package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class TileLiquidUpdatePacket extends Packet
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private short unknown1; // Might be liquid level
	private short unknown2; // Might be liquid type

	public TileLiquidUpdatePacket()
	{}

	public TileLiquidUpdatePacket(long tileX, long tileY, short unknown1, short unknown2)
	{
		this.tileX = tileX;
		this.tileY = tileY;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
	}

	@Override
	public byte getId()
	{
		return 18;
	}


	@Override
	public void read(PacketReader stream)
	{
		tileX = stream.readSVLQ();
		tileY = stream.readSVLQ();
		unknown1 = stream.readUInt8();
		unknown2 = stream.readUInt8();
	}

	@Override
	public void write()
	{
	}

	public long getTileX()
	{
		return tileX;
	}

	public long getTileY()
	{
		return tileY;
	}

	public short getUnknown1()
	{
		return unknown1;
	}

	public short getUnknown2()
	{
		return unknown2;
	}
}