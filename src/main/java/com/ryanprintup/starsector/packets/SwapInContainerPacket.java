package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class SwapInContainerPacket extends BasePacket
{
	// Todo

	public SwapInContainerPacket()
	{}

	public SwapInContainerPacket()
	{} // Non-Default Constructor

	@Override
	public byte getId()
	{
		return 35;
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