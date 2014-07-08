package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ProtocolVersionPacket implements Packet
{
	private int protocolVersionNumber;

	@Override
	public byte getId()
	{
		return 0;
	}

	public int getProtocolVersionNumber()
	{
		return protocolVersionNumber;
	}
}
