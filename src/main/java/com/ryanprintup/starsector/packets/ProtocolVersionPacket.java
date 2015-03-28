package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class ProtocolVersionPacket implements BasePacket
{
	private long protocolVersionNumber; // uint32

    public ProtocolVersionPacket()
    {
    }

    public ProtocolVersionPacket(long protocolVersionNumber)
	{
		this.protocolVersionNumber = protocolVersionNumber;
	}

    @Override
    public void read(BufferStream stream)
    {
        protocolVersionNumber = stream.readUInt32();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

	@Override
	public byte getId()
	{
		return 0;
	}

	public long getProtocolVersionNumber()
	{
		return protocolVersionNumber;
	}
}
