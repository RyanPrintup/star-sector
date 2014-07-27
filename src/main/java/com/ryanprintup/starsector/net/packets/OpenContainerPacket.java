package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class OpenContainerPacket extends Packet
{
	private long entityId; // sVLQ

	public OpenContainerPacket()
	{}

	public OpenContainerPacket(long entityId)
	{
		this.entityId = entityId;
	}

	@Override
	public byte getId()
	{
		return 33;
	}

	@Override
	public void read(PacketReader stream)
	{
		entityId = stream.readSVLQ();
	}

	@Override
	public void write()
	{
	}

	public long getEntityId()
	{
		return entityId;
	}
}