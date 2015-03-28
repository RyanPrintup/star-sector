package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class WorldClientStateUpdatePacket implements BasePacket
{
	private short[] delta; // uint8[]

	public WorldClientStateUpdatePacket(short[] delta)
	{
		this.delta = delta;
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
		return 41;
	}

	public short[] getDelta()
	{
		return delta;
	}
}