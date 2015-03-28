package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class StatusEffectRequestPacket implements BasePacket
{
	private long unknown1; // sVLQ
	private String statusEffectName;
	private Variant unknown2;
	private float multiplier;

	public StatusEffectRequestPacket(long unknown1, String statusEffectName, Variant unknown2, float multiplier)
	{
		this.unknown1 = unknown1;
		this.statusEffectName = statusEffectName;
		this.unknown2 = unknown2;
		this.multiplier = multiplier;
	}

    @Override
    public void read(BufferStream stream)
    {

    }

    @Override
    public void write(BufferStream stream)
    {

    }

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