package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class HeartbeatPacket implements Packet
{
	private long currentStep; // VLQ

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