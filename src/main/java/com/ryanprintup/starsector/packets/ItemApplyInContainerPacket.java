package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class ItemApplyInContainerPacket extends BasePacket
{
	// Todo

	public ItemApplyInContainerPacket()
	{}

	public ItemApplyInContainerPacket()
	{} // Non-Default Constructor

	@Override
	public byte getId()
	{
		return 36;
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