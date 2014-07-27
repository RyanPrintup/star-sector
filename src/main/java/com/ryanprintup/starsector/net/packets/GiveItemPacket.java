package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class GiveItemPacket extends Packet
{
	private String itemName;
	private long count; // VLQ
	private Variant itemProperties;
	
	public GiveItemPacket()
	{
	}
	
	public GiveItemPacket(String itemName, long count, Variant itemProperties)
	{
		this.itemName = itemName;
		this.count = count;
		this.itemProperties = itemProperties;
	}
	
	@Override
	public byte getId()
	{
		return 21;
	}
	
	@Override
	public void read(PacketReader stream)
	{
		itemName = stream.readString();
		count = stream.readVLQ();
		
		try {
			itemProperties = stream.readVariant();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write()
	{
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