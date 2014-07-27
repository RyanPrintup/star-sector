package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ClientContextUpdatePacket extends Packet
{
	private short[] clientContextData;
	
	public ClientContextUpdatePacket()
	{
	}
	
	public ClientContextUpdatePacket(short[] clientContextData)
	{
		this.clientContextData = clientContextData;
	}
	
	@Override
	public byte getId()
	{
		return 13;
	}

	@Override
	public void read(PacketReader stream)
	{
		clientContextData = stream.readUInt8Array();
	}

	@Override
	public void write()
	{
	}
	
	public short[] getClientContextData()
	{
		return clientContextData;
	}
}