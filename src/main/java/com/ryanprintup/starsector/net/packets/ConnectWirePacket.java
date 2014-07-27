package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;
import com.ryanprintup.starsector.net.PacketWriter;

public class ConnectWirePacket extends Packet
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