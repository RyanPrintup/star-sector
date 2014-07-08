package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ClientContextUpdatePacket implements Packet
{
	private int[] clientContextData;

	@Override
	public byte getId()
	{
		return 13;
	}
}