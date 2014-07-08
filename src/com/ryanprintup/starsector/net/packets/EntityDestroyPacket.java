package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class EntityDestroyPacket implements Packet
{
	private long entityId; // sVLQ
	private boolean death;

	@Override
	public byte getId()
	{
		return 44;
	}

	public long getEntityId()
	{
		return entityId;
	}

	public boolean getDeath()
	{
		return death;
	}
}