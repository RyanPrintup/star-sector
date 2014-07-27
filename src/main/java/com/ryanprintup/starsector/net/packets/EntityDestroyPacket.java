package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class EntityDestroyPacket extends Packet
{
	private long entityId; // sVLQ
	private boolean death;
	
	public EntityDestroyPacket()
	{
	}
	
	public EntityDestroyPacket(long entityId, boolean death)
	{
		this.entityId = entityId;
		this.death = death;
	}
	
	@Override
	public byte getId()
	{
		return 44;
	}
	
	@Override
	public void read(PacketReader stream)
	{
		entityId = stream.readSVLQ();
		death = stream.readBoolean();
	}

	@Override
	public void write()
	{
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