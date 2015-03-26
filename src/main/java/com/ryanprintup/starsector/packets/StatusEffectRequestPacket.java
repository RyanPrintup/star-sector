package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class StatusEffectRequestPacket extends BasePacket
{
	private long unknown1; // sVLQ, possibly entity ID
	private String statusEffectName;
	private Variant unknown2; // Possibly the parameters to the status effect
	private float multiplier;

	public StatusEffectRequestPacket()
	{}

	public StatusEffectRequestPacket(long unknown1, String statusEffectName, Variant unknown2, float multiplier)
	{
		this.unknown1 = unknown1;
		this.statusEffectName = statusEffectName;
		this.unknown2 = unknown2;
		this.multiplier = multiplier;
	}

	@Override
	public byte getId()
	{
		return 46;
	}

	@Override
	public void read(PacketReader stream)
	{
		unknown1 = stream.readSVLQ();
		statusEffectName = stream.readString();
		unknown2 = stream.readVariant();
		multiplier = stream.readFloat();
	}

	@Override
	public void write()
	{
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