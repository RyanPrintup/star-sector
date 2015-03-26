package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.PacketReader;

public class ProtocolVersionPacket extends BasePacket
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
