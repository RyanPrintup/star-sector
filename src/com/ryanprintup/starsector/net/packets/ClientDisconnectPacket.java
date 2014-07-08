package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ClientDisconnectPacket implements Packet
{
	private int unknown;

	@Override
	public byte getId()
	{
		return 8;
	}

	public int getUnknown()
	{
		return unknown;
	}
}
