package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class RequestDropPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 28;
	}

	public long getEntityId()
	{
		return entityId;
	}
}