package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class TileArrayUpdatePacket implements Packet
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private long width; // VLQ
	private long height; // VLQ
	private NetTile tiles; // NetTiles[][]? or NetTiles[]? I don't know, verify please 

	@Override
	public byte getId()
	{
		return 16;
	}

	public long getTileX()
	{
		return tileX;
	}

	public long getTileY()
	{
		return tileY;
	}

	public long getWidth()
	{
		return width;
	}

	public long getHeight()
	{
		return height;
	}

	public NetTile getTiles()
	{
		return tiles;
	}
}