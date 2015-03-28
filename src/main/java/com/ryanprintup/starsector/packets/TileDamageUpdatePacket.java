package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class TileDamageUpdatePacket implements BasePacket
{
	private int tileX;
	private int tileY;
	private short unknown; // uint8
	private float damagePercentage;
	private float damageEffectPercentage;
	private float sourcePositionX;
	private float sourcePositionY;
	private short damageType; // uint8

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
		return 19;
	}

	public int getTileX()
	{
		return tileX;
	}

	public int getTileY()
	{
		return tileY;
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