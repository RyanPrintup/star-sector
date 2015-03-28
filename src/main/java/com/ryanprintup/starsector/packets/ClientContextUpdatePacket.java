package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class ClientContextUpdatePacket implements BasePacket
{
	private short[] clientContextData; // uint8[]
	
	public ClientContextUpdatePacket(short[] clientContextData)
	{
		this.clientContextData = clientContextData;
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
		return 13;
	}
	
	public short[] getClientContextData()
	{
		return clientContextData;
	}
}