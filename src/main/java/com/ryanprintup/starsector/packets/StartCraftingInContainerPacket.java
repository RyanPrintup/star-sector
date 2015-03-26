package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class StartCraftingInContainerPacket extends BasePacket
{
	private long entityId; // sVLQ

	public StartCraftingInContainerPacket()
	{};

	public StartCraftingInContainerPacket(long entityId)
	{
		this.entityId = entityId;
	}

	@Override
	public byte getId()
	{
		return 37;
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