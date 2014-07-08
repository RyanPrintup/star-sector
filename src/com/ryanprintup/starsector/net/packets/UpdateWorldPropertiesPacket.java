package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class UpdateWorldPropertiesPacket implements Packet
{
	private long numberOfPairs; //VLQ
	private String propertyName;
	private Variant propertyValue;

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