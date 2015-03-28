package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.datatypes.NetTile;
import com.ryanprintup.starsector.net.BufferStream;

public class TileUpdatePacket implements BasePacket
{
	private long tileX; // sVLQ
	private long tileY; // sVLQ
	private NetTile tile;

    public TileUpdatePacket()
    {
    }

    public TileUpdatePacket(long tileX, long tileY, NetTile tile)
	{
		this.tileX = tileX;
		this.tileY = tileY;
		this.tile  = tile;
	}

    @Override
    public void read(BufferStream stream)
    {
        tileX = stream.readSVLQ();
        tileY = stream.readSVLQ();
        tile  = stream.readNetTile();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

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