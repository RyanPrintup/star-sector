package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ItemApplyInContainerPacket extends Packet
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