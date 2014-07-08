package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class TileUpdatePacket implements Packet
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private NetTile tile;

	@Override
	public byte getId()
	{
		return 17;
	}

	public long getTileX()
	{
		return tileX;
	}

	public long getTileY()
	{
		return tileY;
	}

	public NetTile getTile()
	{
		return tile;
	}
}