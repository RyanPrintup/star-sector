package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class ClearContainerPacket extends BasePacket
{
	private long entityId; // sVLQ
	
	public ClearContainerPacket()
	{
	}
	
	public ClearContainerPacket(long entityId)
	{
		this.entityId = entityId;
	}
	
	@Override
	public byte getId()
	{
		return 40;
	}

	@Override
	public void read(PacketReader stream)
	{
		entityId = stream.readSVLQ();
	}

	@Override
	public byte[] write()
	{
	}
	
	public long getEntityId()
	{
		return entityId;
	}
}