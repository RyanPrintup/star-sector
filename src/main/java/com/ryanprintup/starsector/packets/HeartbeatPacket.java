package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class HeartbeatPacket extends BasePacket
{
	private long currentStep; // VLQ

	public HeartbeatPacket()
	{}

	public HeartbeatPacket(long currentStep)
	{
		this.currentStep = currentStep
	}

	@Override
	public byte getId()
	{
		return 48;
	}

	@Override
	public void read(PacketReader stream)
	{
		currentStep = stream.readVLQ();
	}

	@Override
	public void write()
	{
	}

	public long getCurrentStep()
	{
		return currentStep;
	}
}