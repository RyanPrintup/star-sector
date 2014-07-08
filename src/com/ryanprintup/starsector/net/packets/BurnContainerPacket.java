package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class BurnContainerPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 39;
	}

	public long getEntityId()
	{
		return entityId;
	}
}