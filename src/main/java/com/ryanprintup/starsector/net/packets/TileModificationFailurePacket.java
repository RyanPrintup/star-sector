package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class TileModificationFailurePacket extends Packet
{
	// Todo

	public TileModificationFailurePacket()
	{}

	public TileModificationFailurePacket()
	{} // Non-Default Constructor

	@Override
	public byte getId()
	{
		return 20;
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