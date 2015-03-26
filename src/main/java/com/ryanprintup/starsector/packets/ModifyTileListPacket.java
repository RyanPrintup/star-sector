package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class ModifyTileListPacket extends BasePacket
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