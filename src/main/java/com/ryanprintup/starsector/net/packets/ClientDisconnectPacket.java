package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ClientDisconnectPacket extends Packet
{
	private short unknown;
	
	public ClientDisconnectPacket()
	{
	}
	
	public ClientDisconnectPacket(short unknown)
	{
		this.unknown = unknown;
	}
	
	@Override
	public byte getId()
	{
		return 8;
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
