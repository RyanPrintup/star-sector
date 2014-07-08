package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class CloseContainerPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 34;
	}

	public long getEntityId()
	{
		return entityId;
	}
}