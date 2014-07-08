package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class EntityCreatePacket implements Packet
{
	private int entityType;
	private int[] storeData;
	private long entityId;

	@Override
	public byte getId()
	{
		return 42;
	}

	public int getEntityType()
	{
		return entityType;
	}

	public int getStoreData()
	{
		return storeData;
	}

	public long getEntityId()
	{
		return entityId;
	}
}