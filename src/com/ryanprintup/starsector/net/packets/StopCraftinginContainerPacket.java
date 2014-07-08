package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class StopCraftinginContainerPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 38;
	}

	public long getEntityId()
	{
		return entityId;
	}
}