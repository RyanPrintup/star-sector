package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class EnvironmentUpdatePacket extends Packet
{
	// TODO
	
	public EnvironmentUpdatePacket()
	{
	}
	
	@Override
	public byte getId()
	{
		return 23;
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