package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class WarpCommandPacket extends BasePacket
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
		playerName = stream.readString();
	}

	@Override
	public byte getId()
	{
		return 10;
	}

	public int getWarpType()
	{
		return 0;
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
