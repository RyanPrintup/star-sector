package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class WorldStopPacket extends Packet
{
	private String status;

	public WorldStopPacket(String status)
	{}

	public WorldStopPacket()
	{
		this.status = status;
	}

	@Override
	public byte getId()
	{
		return 15;
	}

	@Override
	public void read(PacketReader stream)
	{
		status = stream.readString();
	}

	@Override
	public void write()
	{
	}

	public String getStatus() {
		return status;
	}

}