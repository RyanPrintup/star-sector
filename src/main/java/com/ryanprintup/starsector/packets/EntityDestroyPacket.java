package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class EntityDestroyPacket implements BasePacket
{
	private long entityId; // sVLQ
	private boolean death;

    public EntityDestroyPacket()
    {
    }

    public EntityDestroyPacket(long entityId, boolean death)
	{
		this.entityId = entityId;
		this.death    = death;
	}

    @Override
    public void read(BufferStream stream)
    {
        entityId = stream.readSVLQ();
        death    = stream.readBoolean();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

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