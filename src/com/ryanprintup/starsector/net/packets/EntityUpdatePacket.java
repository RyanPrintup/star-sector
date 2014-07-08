package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class EntityUpdatePacket implements Packet
{
	private int entityType;
	private int[] storeData;
	private long entityId; // sVLQ

	@Override
	public byte getId()
	{
		return 43;
	}

	public int getEntityId()
	{
		return entityType;
	}

	public int[] getStoreData()
	{
		return storeData;
	}

	public long getEntityId()
	{
		return entityId;
	}
}