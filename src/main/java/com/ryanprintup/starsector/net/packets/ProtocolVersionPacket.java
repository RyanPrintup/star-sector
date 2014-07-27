package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ProtocolVersionPacket extends Packet
{
	private long protocolVersionNumber; // uint32

	public ProtocolVersionPacket()
	{}

	public ProtocolVersionPacket(long protocolVersionNumber)
	{
		this.protocolVersionNumber = protocolVersionNumber;
	}

	@Override
	public byte getId()
	{
		return 0;
	}

	@Override
	public void read(PacketReader stream)
	{
		protocolVersionNumber = stream.readUInt32();
	}

	@Override
	public void write()
	{
	}

	public long getProtocolVersionNumber()
	{
		return protocolVersionNumber;
	}

}
