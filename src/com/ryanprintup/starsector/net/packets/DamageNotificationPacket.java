package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class DamageNotificationPacket implements Packet
{
	private long causingEntityId; // sVLQ
	private long targetEntityId; // sVLQ
	private long positionX; // sVLQ
	private long positionY; // sVLQ
	private long damage; // sVLQ
	private int damageKind;
	private String damageSourceKind

	@Override
	public byte getId()
	{
		return 45;
	}

	public long getCausingEntityId()
	{
		return causingEntityId;
	}

	public long getTargetEntityId()
	{
		return targetEntityId;
	}

	public long getPositionX()
	{
		return positionX;
	}

	public long getPositionY()
	{
		return positionY;
	}

	public long getDamage()
	{
		return damage;
	}

	public int getDamageKind()
	{
		return damageKind;
	}

	public String getDamageSourceKind()
	{
		return damageSourceKind;
	}
}