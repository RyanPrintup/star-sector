package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;

public class SwapInContainerResultPacket extends BasePacket
{
	public SwapInContainerResultPacket()
	{}

	@Override
	public byte getId()
	{
		return 22;
	}
}