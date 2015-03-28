package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class ClearContainerPacket implements BasePacket
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
    public void read(BufferStream stream)
    {
        entityId = stream.readSVLQ();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

    @Override
	public byte getId()
	{
		return 40;
	}

	public long getEntityId()
	{
		return entityId;
	}
}