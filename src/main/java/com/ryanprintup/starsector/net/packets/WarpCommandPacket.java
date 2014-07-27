package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class WarpCommandPacket extends Packet
{
	private long warpType; // Uint32
	private int worldCoordinates; // No idea what world_coordinate datatype is
	private String playerName;

	public WarpCommandPacket()
	{}

	public WarpCommandPacket()
	{
		this.warpType = warpType;
		this.worldCoordinates = worldCoordinates;
		this.playerName = playerName;
	}


	@Override
	public void read(PacketReader stream)
	{
		warpType = stream.readUInt32();
		worldCoordinates;
		playerName = stream.readString();
	}

	@Override
	public void write()
	{
	}

	@Override
	public byte getId()
	{
		return 10;
	}

	public int getWarpType()
	{
		return warpType;
	}

	public int getWorldCoordinates()
	{
		return worldCoordinates
	}

	public String getPlayerName()
	{
		return playerName;
	}
}
