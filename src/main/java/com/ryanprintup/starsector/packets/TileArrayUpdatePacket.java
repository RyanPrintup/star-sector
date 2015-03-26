package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.datatypes.NetTile;
import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class TileArrayUpdatePacket extends BasePacket
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private long width; // VLQ
	private long height; // VLQ
	private NetTile tiles; // NetTiles[][]? or NetTiles[]? I don't know, verify please

	public TileArrayUpdatePacket()
	{}

	public TileArrayUpdatePacket(long tileX, long tileY, long width, long height, NetTile tiles)
	{
		this.tileX = tileX;
		this.tileY = tileY;
		this.width = width;
		this.height = height;
		this.tiles = tiles;
	}

	@Override
	public void read(PacketReader stream)
	{
		tileX = stream.readSVLQ();
		tileY = stream.readSVLQ();
		width = stream.readVLQ();
		height = stream.readVLQ();
		//tiles = stream.readNetTile(); Method missing?
	}

	@Override
	public void write()
	{
	}

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