package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

/**
 * Not fully understood yet.
 */
public class ConnectWirePacket implements BasePacket
{
    public ConnectWirePacket()
    {
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
		return 31;
	}
}