package com.ryanprintup.starsector.net;


public abstract class Packet
{
	private byte[] buffer;
	
	public Packet()
	{
		this(null);
	}
	
	public Packet(byte[] buffer)
	{
		this.buffer = buffer;
		read();
	}

	public abstract byte getId();

	public abstract void read();

	public byte[] getBuffer()
	{
		return buffer;
	}
}
