package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class StopCraftingInContainerPacket extends BasePacket
{
	private long entityId; // sVLQ

	public StopCraftingInContainerPacket()
	{}

	public StopCraftingInContainerPacket(long entityId)
	{
		this.entityId = entityId;
	}

	@Override
	public byte getId()
	{
		return 38;
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