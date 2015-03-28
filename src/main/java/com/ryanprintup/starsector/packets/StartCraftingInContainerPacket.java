package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class StartCraftingInContainerPacket implements BasePacket
{
	private long entityId; // sVLQ

    public StartCraftingInContainerPacket()
    {
    }

    public StartCraftingInContainerPacket(long entityId)
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
		return 37;
	}

	public long getEntityId()
	{
		return entityId;
	}
}