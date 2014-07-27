package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class CelestialResponsePacket extends Packet
{
	// TODO
	
	public CelestialResponsePacket()
	{
	}

	@Override
	public byte getId()
	{
		return 6;
	}

	@Override
	public void read(PacketReader stream)
	{
	}

	@Override
	public byte[] write()
	{
		return null;
	}
}
