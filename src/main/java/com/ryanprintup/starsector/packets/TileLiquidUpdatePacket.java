package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class TileLiquidUpdatePacket implements BasePacket
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private short unknown1; // uint8
	private short unknown2; // uint8

	public TileLiquidUpdatePacket(long tileX, long tileY, short unknown1, short unknown2)
	{
		this.tileX = tileX;
		this.tileY = tileY;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
	}

    @Override
    public void read(BufferStream stream)
    {

    }

    @Override
    public void write(BufferStream stream)
    {

    }

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

	public short getUnknown1()
	{
		return unknown1;
	}

	public short getUnknown2()
	{
		return unknown2;
	}
}