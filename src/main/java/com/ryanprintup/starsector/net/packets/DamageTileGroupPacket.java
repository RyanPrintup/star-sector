package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class DamageTileGroupPacket extends Packet
{
	// TODO
	
	public DamageTileGroupPacket()
	{
	}

	@Override
	public byte getId()
	{
		return 27;
	}

	@Override
	public void read(PacketReader stream)
	{
	}

	@Override
	public void write()
	{
	}
}