package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class WorldClientStateUpdatePacket extends BasePacket
{
	private short[] delta;

	public WorldClientStateUpdatePacket()
	{}

	public WorldClientStateUpdatePacket(short delta)
	{
		this.delta = delta;
	}

	@Override
	public byte getId()
	{
		return 41;
	}


	@Override
	public void read(PacketReader stream)
	{
		delta = stream.readUInt8Array();
	}

	@Override
	public void write()
	{
	}

	public short[] getDelta()
	{
		return delta;
	}
}