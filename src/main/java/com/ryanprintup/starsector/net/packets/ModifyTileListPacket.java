package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ModifyTileListPacket extends Packet
{
	 // Todo

	public ModifyTileListPacket()
	{}

	public ModifyTileListPacket()
	{} // Non-Default Constructor

	@Override
	public byte getId()
	{
		return 25;
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