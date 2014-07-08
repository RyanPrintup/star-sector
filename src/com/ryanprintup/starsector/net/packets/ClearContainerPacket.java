package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ClearContainerPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 40;
	}

	public long getEntityId()
	{
		return getEntityId;
	}
}