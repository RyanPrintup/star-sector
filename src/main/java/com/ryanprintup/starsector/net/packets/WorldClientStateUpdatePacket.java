package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class WorldClientStateUpdatePacket extends Packet
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