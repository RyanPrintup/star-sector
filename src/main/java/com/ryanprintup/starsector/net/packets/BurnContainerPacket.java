package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;
import com.ryanprintup.starsector.net.PacketWriter;

public class BurnContainerPacket extends Packet
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

	@Override
	public void read(PacketReader stream)
	{
		entityId = stream.readSVLQ();
	}

	@Override
	public PacketWriter write(PacketWriter stream)
	{
		return stream;
	}
	
	public long getEntityId()
	{
		return entityId;
	}
}