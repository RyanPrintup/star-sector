package com.ryanprintup.starsector.net.packets;

public abstract class Packet
{
	protected static byte id;
	
	public Packet(byte id)
	{
		this.id = id;
	}
}
