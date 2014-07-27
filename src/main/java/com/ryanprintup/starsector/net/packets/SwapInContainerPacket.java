package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class SwapInContainerPacket extends Packet
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