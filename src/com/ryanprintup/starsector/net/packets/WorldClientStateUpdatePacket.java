package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class WorldClientStateUpdatePacket implements Packet
{
	private int[] delta;

	@Override
	public byte getId()
	{
		return 41;
	}

	public int[] getDelta()
	{
		return delta;
	}
}