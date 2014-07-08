package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class WorldStopPacket implements Packet
{
	private String status;

	@Override
	public byte getId()
	{
		return 15;
	}

	public String getStatus() {
		return status;
	}
}