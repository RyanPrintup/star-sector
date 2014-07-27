package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class CelestialRequestPacket extends Packet
{
	// TODO
	
	public CelestialRequestPacket()
	{
	}
	
	@Override
	public byte getId()
	{
		return 12;
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