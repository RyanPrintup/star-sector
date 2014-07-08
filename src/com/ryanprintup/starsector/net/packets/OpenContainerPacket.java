package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class OpenContainerPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 33;
	}

	public long getEntityId()
	{
		return entityId;
	}
}