package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class DisconnectResponsePacket extends BasePacket
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
