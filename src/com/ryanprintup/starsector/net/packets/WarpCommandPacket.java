package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class WarpCommandPacket implements Packet
{
	private int warpType;
	private int worldCoordinates; // No idea what world_coordinate datatype is
	private String playerName;

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
