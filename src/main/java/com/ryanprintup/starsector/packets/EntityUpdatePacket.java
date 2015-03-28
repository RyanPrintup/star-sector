package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class EntityUpdatePacket implements BasePacket
{
	private long entityId; //sVLQ
	private short[] delta; // uint8[]
	
	public EntityUpdatePacket(long entityId, short[] delta)
	{
		this.entityId = entityId;
		this.delta = delta;
	}

    @Override
    public void read(BufferStream stream)
    {

    }

    @Override
    public void write(BufferStream stream)
    {

    }

    @Override
	public byte getId()
	{
		return 43;
	}

	public long getEntityId()
	{
		return entityId;
	}
	
	public short[] getDelta()
	{
		return delta;
	}
}