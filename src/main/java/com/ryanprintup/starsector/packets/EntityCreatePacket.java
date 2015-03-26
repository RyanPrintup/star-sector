package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class EntityCreatePacket extends BasePacket
{
	private short entityType;
	private short[] storeData;
	private long entityId; //sVLQ
	
	public EntityCreatePacket()
	{
	}
	
	public EntityCreatePacket(short entityType, short[] storeData, long entityId)
	{
		this.entityType = entityType;
		this.storeData = storeData;
		this.entityId = entityId;
	}
	
	@Override
	public byte getId()
	{
		return 42;
	}
	
	@Override
	public void read(PacketReader stream)
	{
		entityType = stream.readUInt8();
		storeData = stream.readUInt8Array();
		entityId = stream.readSVLQ();
	}

	@Override
	public void write()
	{
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