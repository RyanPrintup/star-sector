package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ClearContainerPacket extends Packet
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