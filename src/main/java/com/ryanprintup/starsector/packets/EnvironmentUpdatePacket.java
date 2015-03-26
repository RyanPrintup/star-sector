package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class EnvironmentUpdatePacket extends BasePacket
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