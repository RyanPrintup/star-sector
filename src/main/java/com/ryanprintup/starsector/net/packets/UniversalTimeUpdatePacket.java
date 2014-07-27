package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class UniversalTimeUpdatePacket extends Packet
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
