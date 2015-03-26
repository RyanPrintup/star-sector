package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class TileModificationFailurePacket extends BasePacket
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