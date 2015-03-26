package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.datatypes.NetTile;
import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class TileUpdatePacket extends BasePacket
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private NetTile tile;

	public TileUpdatePacket()
	{}

	public TileUpdatePacket(long tileX, long tileY, NetTile tile)
	{
		this.tileX = tileX;
		this.tileY = tileY;
		this.tile = tile;
	}

	@Override
	public byte getId()
	{
		return 17;
	}


	@Override
	public void read(PacketReader stream)
	{
		tileX = stream.readSVLQ();
		tileY = stream.readSVLQ();
		//tile = stream.readNetTile();
	}

	@Override
	public void write()
	{
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