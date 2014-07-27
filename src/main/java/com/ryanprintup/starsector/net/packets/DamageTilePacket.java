package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class DamageTilePacket extends Packet
{
	// TODO
	
	public DamageTilePacket()
	{
	}

	@Override
	public byte getId()
	{
		return 26;
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