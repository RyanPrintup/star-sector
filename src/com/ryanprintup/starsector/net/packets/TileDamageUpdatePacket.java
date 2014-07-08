package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class TileDamageUpdatePacket implements Packet
{
	private int tileX;
	private int tileY;
	private int unknown; // Truly unknown
	private float damagePercentage;
	private float damageEffectPercentage;
	private float sourcePositionX;
	private float sourcePositionY;
	private int damageType;

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
		return tileY
	}

	public int getUnknown()
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

	public int getDamageType()
	{
		return damageType;
	}
}