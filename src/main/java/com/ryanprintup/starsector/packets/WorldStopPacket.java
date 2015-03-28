package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class WorldStopPacket implements BasePacket
{
	private String status;

    public WorldStopPacket()
    {
    }

    public WorldStopPacket(String status)
	{
		this.status = status;
	}

    @Override
    public void read(BufferStream stream)
    {
        status = stream.readString();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

	@Override
	public byte getId()
	{
		return 15;
	}

	public String getStatus() {
		return status;
	}

}