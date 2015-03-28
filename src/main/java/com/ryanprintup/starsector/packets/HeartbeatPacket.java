package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class HeartbeatPacket implements BasePacket
{
	private long currentStep; // VLQ

	public HeartbeatPacket(long currentStep)
	{
		this.currentStep = currentStep;
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
        return 48;
    }

	public long getCurrentStep()
	{
		return currentStep;
	}
}