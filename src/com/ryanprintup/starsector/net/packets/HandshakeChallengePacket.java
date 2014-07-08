package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class HandshakeChallengePacket implements Packet
{
	@Override
	public byte getId()
	{
		return 3;
	}
}
