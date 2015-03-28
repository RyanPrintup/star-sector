package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class UpdateWorldPropertiesPacket implements BasePacket
{
	private long numberOfPairs; // VLQ
	private String propertyName;
	private Variant propertyValue;

    public UpdateWorldPropertiesPacket()
    {
    }

    public UpdateWorldPropertiesPacket(long numberOfPairs, String propertyName, Variant propertyValue)
	{
		this.numberOfPairs = numberOfPairs;
		this.propertyName  = propertyName;
		this.propertyValue = propertyValue;
	}

    @Override
    public void read(BufferStream stream)
    {
        numberOfPairs = stream.readVLQ();
        propertyName  = stream.readString();

        try {
            propertyValue = stream.readVariant();
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
		return 47;
	}

	public long getNumberOfPairs()
	{
		return numberOfPairs;
	}

	public String getPropertyName()
	{
		return propertyName;
	}

	public Variant getPropertyValue()
	{
		return propertyValue;
	}
}