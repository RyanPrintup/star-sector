package com.ryanprintup.starsector.datatypes;

public class NetTile
{
	private short unknown0;
	private byte unknown1;
	private byte unknown2;
	private short unknown3;
	private byte unknown4;
	private short unknown5;
	private byte unknown6;
	private byte unknown7;
	private short unknown8;
	private byte unknown9;
	private byte unknown10;
	private byte unknown11;
	private byte unknown12;
	private byte unknown13;
	private byte liquidLevel;
	private long gravity;

    public NetTile(short unknown0, byte unknown1, byte unknown2,
                   short unknown3, byte unknown4, short unknown5,
                   byte unknown6, byte unknown7, short unknown8,
                   byte unknown9, byte unknown10, byte unknown11,
                   byte unknown12, byte unknown13, byte liquidLevel,
                   long gravity)
    {
        this.unknown0    = unknown0;
        this.unknown1    = unknown1;
        this.unknown2    = unknown2;
        this.unknown3    = unknown3;
        this.unknown4    = unknown4;
        this.unknown5    = unknown5;
        this.unknown6    = unknown6;
        this.unknown7    = unknown7;
        this.unknown8    = unknown8;
        this.unknown9    = unknown9;
        this.unknown10   = unknown10;
        this.unknown11   = unknown11;
        this.unknown12   = unknown12;
        this.unknown13   = unknown13;
        this.liquidLevel = liquidLevel;
        this.gravity     = gravity;
    }

	public short getUnknown0()
	{
		return unknown0;
	}
	
	public byte getUnknown1()
	{
		return unknown1;
	}
	
	public byte getUnknown2()
	{
		return unknown2;
	}
	
	public short getUnknown3()
	{
		return unknown3;
	}
	
	public byte getUnknown4()
	{
		return unknown4;
	}
	
	public short getUnknown5()
	{
		return unknown5;
	}
	
	public byte getUnknown6()
	{
		return unknown6;
	}
	
	public byte getUnknown7()
	{
		return unknown7;
	}
	
	public short getUnknown8()
	{
		return unknown8;
	}
	
	public byte getUnknown9()
	{
		return unknown9;
	}
	
	public byte getUnknown10()
	{
		return unknown10;
	}
	
	public byte getUnknown11()
	{
		return unknown11;
	}
	
	public byte getUnknown12()
	{
		return unknown12;
	}
	
	public byte getUnknown13()
	{
		return unknown13;
	}
	
	public byte getLiquidLevel()
	{
		return liquidLevel;
	}
	
	public long getGravity()
	{
		return gravity;
	}
}
