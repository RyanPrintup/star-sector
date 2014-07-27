package com.ryanprintup.starsector.net;

public abstract class Packet
{
	public abstract byte getId();

	public abstract void read(PacketReader stream);
	
	protected abstract PacketWriter write(PacketWriter stream);
	
	public byte[] create()
	{
		return write(new PacketWriter()).getBuffer();
	}
}
