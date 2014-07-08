package com.ryanprintup.starsector.net;


public class PacketReader
{
	// -1 Because the advance method increments
	// the position and then returns the value
	private int position = -1;
	private byte[] buffer;
	
	public PacketReader(final byte[] buffer)
	{
		this.buffer = buffer;
	}
	
	/**
	 * Advance the current index of the buffer by
	 * {@link count}. Returns the updated position.
	 * If the indexes to advance by are greater than
	 * the buffer length, throws {@link ArrayIndexOutOfBoundsException}.
	 * 
	 * @param count The count of indexes to advance
	 * @return The updated index position
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private int advance(int count)
	{
		position += count;
		
		if (position > buffer.length) {
			throw new ArrayIndexOutOfBoundsException("Position greater than buffer size.");
		}
		
		return position;
	}
	
	public byte readByte()
	{
		return buffer[advance(1)];
	}
	
	private short readUByte()
	{
		return (short) (readByte() & 0xFF);
	}
	
	public long readVLQ()
	{
		long value = 0;
		
		while (true) {
			int curByte = readUByte();
			
			value = (value << 7) | (curByte & 0x7f);
			
			if ((curByte & 0x80) == 0) {
				break;
			}
		}
		
		return value;
	}
	
	public long readSVLQ()
	{
		long value = readVLQ();
		
		if ((value & 1) == 0x00) {
			return (long) value >> 1;
		}
		
		return -((long) (value >> 1) + 1);
	}
	
	public byte[] readByteArray(int length)
	{
		byte data[] = new byte[length];
		
		for (int x = 0; x < length; x++) {
			data[x] = readByte();
		}
		
		return data;
	}
	
	public int readInt8()
	{
		return (int) readByte();
	}
	
	public short readUInt8()
	{
		return readUByte();
	}
	
	public byte[] readInt8Array()
	{
		return readByteArray((int) readVLQ());
	}
	
	public int readInt16()
	{
		return (readInt8() & 0xff) <<  8 |
			    readInt8() & 0xff;
	}
	
	public int readUInt16()
	{
		return readInt16() & 0xFFFFFF;
	}
	
	public int readInt32()
	{
		return  (readInt8() & 0xff) << 24 |
                (readInt8() & 0xff) << 16 |
                (readInt8() & 0xff) <<  8 |
                 readInt8() & 0xff;
	}

	public long readUInt32() 
	{
		return readInt32() & 0xFFFFFFFFL;
	}
	
	public long readInt64()
	{
		return ((long) readInt8() & 0xff) << 56 |
	           ((long) readInt8() & 0xff) << 48 |
	           ((long) readInt8() & 0xff) << 40 |
	           ((long) readInt8() & 0xff) << 32 |
	           ((long) readInt8() & 0xff) << 24 |
	           ((long) readInt8() & 0xff) << 16 |
	           ((long) readInt8() & 0xff) <<  8 |
	            (long) readInt8() & 0xff;
	}
	
	public long readUInt64()
	{
		return readInt64();
	}
	
	public boolean readBoolean()
	{
		return readByte() != 0;
	}

	public short readShort()
	{
		return (short) (readByte() << 8 |
						readByte() & 0xFF);
	}

	public int readUShort()
	{
		return readShort() & 0xFFFF;
	}

	public char readChar()
	{
		return (char) readShort();
	}

	public float readFloat()
	{
		return Float.intBitsToFloat(readInt32());
	}

	public double readDouble()
	{
		return Double.longBitsToDouble(readInt64());
	}
	
	public String readString()
	{
		return new String(readByteArray((int) readVLQ()));
	}
}