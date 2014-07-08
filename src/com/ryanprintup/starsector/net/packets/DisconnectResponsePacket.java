package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class DisconnectResponsePacket implements Packet
{
	private int unknown; // Truly unknown

	@Override
	public byte getId()
	{
		return 2;
	}

	public int getUnknown()
	{
		return unknown;
	}
}
