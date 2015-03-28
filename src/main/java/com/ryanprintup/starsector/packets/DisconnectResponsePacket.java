package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class DisconnectResponsePacket implements BasePacket
{
	private short unknown; // uint8

    public DisconnectResponsePacket()
    {
    }

    public DisconnectResponsePacket(short unknown)
	{
		this.unknown = unknown;
	}

    @Override
    public void read(BufferStream stream)
    {
        unknown = stream.readUInt8();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

    @Override
	public byte getId()
	{
		return 2;
	}

	public short getUnknown()
	{
		return unknown;
	}
}
