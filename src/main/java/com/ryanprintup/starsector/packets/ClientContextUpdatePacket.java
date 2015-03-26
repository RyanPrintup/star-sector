package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class ClientContextUpdatePacket extends BasePacket
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