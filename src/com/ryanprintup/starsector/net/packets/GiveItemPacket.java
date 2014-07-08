package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class GiveItemPacket implements Packet
{
	private String itemName;
	private long count; // VLQ
	private Variant itemProperties;

	@Override
	public byte getId()
	{
		return 21;
	}

	public String getItemName()
	{
		return itemName;
	}

	public long getCount()
	{
		return count;
	}

	public Variant getItemProperties()
	{
		return itemProperties;
	}
}