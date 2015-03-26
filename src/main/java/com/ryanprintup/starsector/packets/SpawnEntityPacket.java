package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class SpawnEntityPacket extends BasePacket
{
	// Todo

	public SpawnEntityPacket()
	{}

	public SpawnEntityPacket()
	{} // Non-Default Constructor

	@Override
	public byte getId()
	{
		return 29;
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