package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class SpawnEntityPacket extends Packet
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