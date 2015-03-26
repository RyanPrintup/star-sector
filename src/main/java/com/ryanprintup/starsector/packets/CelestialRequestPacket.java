package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;

public class CelestialRequestPacket extends BasePacket
{
	public CelestialRequestPacket()
	{
	}
	
	@Override
	public byte getId()
	{
		return 12;
	}
}