package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class DamageNotificationPacket implements BasePacket
{
    public enum DamageKind
    {
        NORMAL,
        SHIELD,
        ENERGY
    }

    public enum HitResultKind
    {
        NONE,
        HIT,
        KILL
    }

	private long causingEntityId; // sVLQ
	private long targetEntityId; // sVLQ
	private long positionX; // sVLQ, divided by 100 when read, multiplied by 100 when written
	private long positionY; // sVLQ, divided by 100 when read, multiplied by 100 when written
	private long damage; // sVLQ
	private short damageKind; // uint8
	private String damageSourceKind;
	private String targetMaterialKind;
	private short hitResultKind; // uint8

    public DamageNotificationPacket()
    {
    }

    public DamageNotificationPacket(long casuingEntityId, long targetEntityId, long positionX, long positionY, long damage, short damageKind, String damageSourceKind, String targetMaterialKind, short hitResultKind)
	{
		this.causingEntityId    = casuingEntityId;
		this.targetEntityId     = targetEntityId;
		this.positionX          = positionX;
		this.positionY          = positionY;
		this.damage             = damage;
		this.damageKind         = damageKind;
		this.damageSourceKind   = damageSourceKind;
		this.targetMaterialKind = targetMaterialKind;
		this.hitResultKind      = hitResultKind;
	}

    @Override
    public void read(BufferStream stream)
    {
        causingEntityId    = stream.readSVLQ();
        targetEntityId     = stream.readSVLQ();
        positionX          = stream.readSVLQ() / 100;
        positionY          = stream.readSVLQ() / 100;
        damage             = stream.readSVLQ();
        damageKind         = stream.readUInt8();
        damageSourceKind   = stream.readString();
        targetMaterialKind = stream.readString();
        hitResultKind      = stream.readUInt8();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

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