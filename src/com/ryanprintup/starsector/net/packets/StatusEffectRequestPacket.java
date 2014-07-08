package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class StatusEffectRequestPacket implements Packet
{
	private long unknown1; // sVLQ, unknown, possibly entity ID
	private String statusEffectName;
	private Variant unknown2; // Possibly the parameters to the status effect
	private float multiplier;

	@Override
	public byte getId()
	{
		return 46;
	}

	public long getUnknown1()
	{
		return unknown1;
	}

	public String getStatusEffectName()
	{
		return statusEffectName;
	}

	public Variant getUnknown2()
	{
		return unknown2;
	}

	public float getMultiplier()
	{
		return multiplier;
	}
}