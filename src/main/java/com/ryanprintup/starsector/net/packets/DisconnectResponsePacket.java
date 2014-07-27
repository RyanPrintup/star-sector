package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class DisconnectResponsePacket extends Packet
{
	private short unknown;
	
	public DisconnectResponsePacket()
	{
	}
	
	public DisconnectResponsePacket(short unknown)
	{
		this.unknown = unknown;
	}
	
	@Override
	public byte getId()
	{
		return 2;
	}
	
	@Override
	public void read(PacketReader stream)
	{
		unknown = stream.readUInt8();
	}

	@Override
	public void write()
	{
	}

	public short getUnknown()
	{
		return unknown;
	}
}
