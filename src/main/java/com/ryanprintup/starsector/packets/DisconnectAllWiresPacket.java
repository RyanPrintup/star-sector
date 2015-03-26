package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class DisconnectAllWiresPacket extends BasePacket
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