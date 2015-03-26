package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;

public class CelestialResponsePacket extends BasePacket
{
	public CelestialResponsePacket()
	{
	}

	@Override
	public byte getId()
	{
		return 6;
	}
}
