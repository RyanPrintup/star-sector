package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class UniversalTimeUpdatePacket implements BasePacket
{
	private long time; // sVLQ

	public UniversalTimeUpdatePacket(long time)
	{
		this.time = time;
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
		return 5;
	}

	public long getTime()
	{
		return time;
	}

}
