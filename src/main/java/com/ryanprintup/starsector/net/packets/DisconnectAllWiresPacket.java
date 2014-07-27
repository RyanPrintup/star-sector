package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class DisconnectAllWiresPacket extends Packet
{
	// TODO
	
	public DisconnectAllWiresPacket()
	{
	}
	
	@Override
	public byte getId()
	{
		return 32;
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