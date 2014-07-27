package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class TileDamageUpdatePacket extends Packet
{
	private int tileX;
	private int tileY;
	private short unknown; // Truly unknown
	private float damagePercentage;
	private float damageEffectPercentage;
	private float sourcePositionX;
	private float sourcePositionY;
	private short damageType;

	public TileDamageUpdatePacket()
	{}

	public TileDamageUpdatePacket(int tileX, int tileY, short unknown, float damagePercentage, float damageEffectPercentage, float sourcePositionX, float sourcePositionY, short damageType)
	{
		this.tileX = tileX;
		this.tileY = tileY;
		this.unknown = unknown;
		this.damagePercentage = damagePercentage;
		this.damageEffectPercentage = damageEffectPercentage;
		this.sourcePositionX = sourcePositionX;
		this.sourcePositionY = sourcePositionY;
		this.damageType = damageType;
	}

	@Override
	public byte getId()
	{
		return 19;
	}


	@Override
	public void read(PacketReader stream)
	{
		tileX = stream.readInt32();
		tileY = stream.readInt32();
		unknown = stream.readUInt8();
		damagePercentage = stream.readFloat();
		damageEffectPercentage = stream.readFloat();
		sourcePositionX = stream.readFloat();
		sourcePositionY = stream.readFloat();
		damageType = stream.readUInt8();
	}

	@Override
	public void write()
	{
	}

	public int getTileX()
	{
		return tileX;
	}

	public int getTileY()
	{
		return tileY
	}

	public short getUnknown()
	{
		return unknown;
	}

	public float getDamagePercentage()
	{
		return damagePercentage;
	}

	public float getDamageEffectPercentage()
	{
		return damageEffectPercentage;
	}

	public float getSourcePositionX()
	{
		return sourcePositionX;
	}

	public float getSourcePositionY()
	{
		return sourcePositionY;
	}

	public short getDamageType()
	{
		return damageType;
	}
}