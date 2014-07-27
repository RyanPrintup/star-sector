package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class SwapInContainerResultPacket extends Packet
{
	// Todo

	public SwapInContainerResultPacket()
	{}

	public SwapInContainerResultPacket()
	{] // Non-Default Constructor

	@Override
	public byte getId()
	{
		return 22;
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