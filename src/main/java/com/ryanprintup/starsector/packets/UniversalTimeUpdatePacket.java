package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class UniversalTimeUpdatePacket extends BasePacket
{
	private long time; // sVLQ

	public UniversalTimeUpdatePacket()
	{}

	public UniversalTimeUpdatePacket(long time)
	{
		this.time = time;
	}

	@Override
	public byte getId()
	{
		return 5;
	}

	@Override
	public void read(PacketReader stream)
	{
		time = stream.readSVLQ();
	}

	@Override
	public void write()
	{
	}


	public long getTime()
	{
		return time;
	}

}
