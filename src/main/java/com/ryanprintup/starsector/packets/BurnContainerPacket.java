package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;

public class BurnContainerPacket extends BasePacket
{
	private long entityId; // sVLQ
	
	public BurnContainerPacket()
	{
	}
	
	public BurnContainerPacket(long entityId)
	{
		this.entityId = entityId;
	}
	
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