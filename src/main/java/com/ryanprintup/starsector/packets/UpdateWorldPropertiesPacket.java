package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class UpdateWorldPropertiesPacket extends BasePacket
{
	private long numberOfPairs; //VLQ
	private String propertyName;
	private Variant propertyValue;

	public UpdateWorldPropertiesPacket()
	{}

	public UpdateWorldPropertiesPacket(long numberOfPairs, String propertyName, Variant propertyValue)
	{
		this.numberOfPairs = numberOfPairs;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}


	@Override
	public void read(PacketReader stream)
	{
		numberOfPairs = stream.readVLQ();
		propertyName = stream.readString();
		propertyValue = stream.readVariant();
	}

	@Override
	public void write()
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