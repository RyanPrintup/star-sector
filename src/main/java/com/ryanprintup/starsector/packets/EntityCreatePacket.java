package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class EntityCreatePacket implements BasePacket
{
	private short entityType; // uint8
	private short[] storeData; // uint8[]
	private long entityId; //sVLQ

    public EntityCreatePacket()
    {
    }

    public EntityCreatePacket(short entityType, short[] storeData, long entityId)
	{
		this.entityType = entityType;
		this.storeData  = storeData;
		this.entityId   = entityId;
	}

    @Override
    public void read(BufferStream stream)
    {
        entityType = stream.readUInt8();
        storeData  = stream.readUInt8Array();
        entityId   = stream.readSVLQ();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

    @Override
	public byte getId()
	{
		return 42;
	}

	public short getEntityType()
	{
		return entityType;
	}

	public short[] getStoreData()
	{
		return storeData;
	}

	public long getEntityId()
	{
		return entityId;
	}
}