package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;
import com.ryanprintup.starsector.PacketWriter;

public class ConnectWirePacket extends BasePacket
{
	// TODO
	
	public ConnectWirePacket()
	{
	}
	
	@Override
	public byte getId()
	{
		return 31;
	}

	@Override
	public void read(PacketReader stream)
	{
	}

	@Override
	public byte[] write()
	{
		return null;
	}
}