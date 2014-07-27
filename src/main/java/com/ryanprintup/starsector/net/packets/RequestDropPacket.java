package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class RequestDropPacket extends Packet
{
	private long entityId; // sVLQ

	public RequestDropPacket()
	{}

	public RequestDropPacket(long entityId)
	{
		this.entityId = entityId;
	}

	@Override
	public byte getId()
	{
		return 28;
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