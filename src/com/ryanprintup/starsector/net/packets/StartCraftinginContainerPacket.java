package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class StartCraftinginContainerPacket implements Packet
{
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 37;
	}

	public long getEntityId()
	{
		return entityId;
	}
}