package com.ryanprintup.starsector.net;

public class PacketWriter
{
	private byte[] buffer;
	private int index;
	
	public void writeByte(final byte b)
	{
		buffer[index] = b;
		index++;
	}
	
	public void writeBytes(final byte[] bytes)
	{
		for (byte b : bytes) {
			writeByte(b);
		}
	}
	
	public void writeByte(final int value)
	{
		writeByte(value);
	}
	
	public void writeShort(final int value) {
		
	}
	
	public void writeInt(final int value) {
		
	}
}
