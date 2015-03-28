package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class GiveItemPacket implements BasePacket
{
	private String itemName;
	private long count; // VLQ
	private Variant itemProperties;

    public GiveItemPacket()
    {
    }

    public GiveItemPacket(String itemName, long count, Variant itemProperties)
	{
		this.itemName       = itemName;
		this.count          = count;
		this.itemProperties = itemProperties;
	}

    @Override
    public void read(BufferStream stream)
    {
        itemName = stream.readString();
        count    = stream.readVLQ();

        try {
            itemProperties = stream.readVariant();
        } catch (Exception e) {
            StarSector.getServer().getConsole().error("Could not read variant from Stream. Error: " + e);
            return;
        }
    }

    @Override
    public void write(BufferStream stream)
    {

    }

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