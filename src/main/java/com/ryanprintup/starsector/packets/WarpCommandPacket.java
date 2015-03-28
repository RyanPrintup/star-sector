package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class WarpCommandPacket implements BasePacket
{
    public enum WarpType
    {
        MOVE_SHIP(1),
        WARP_TO_OWN_SHIP(2),
        WARP_TO_PLAYER_SHIP(3),
        WARP_TO_ORBITED_PLANET(4),
        WARP_TO_HOME_PLANET(5);

        private int value;

        private WarpType(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

	private long warpType; // uint32
	private int worldCoordinates; // To-do datatype
	private String playerName;

	public WarpCommandPacket(long warpType, int worldCoordinates, String playerName)
	{
		this.warpType = warpType;
		this.worldCoordinates = worldCoordinates;
		this.playerName = playerName;
    }

    @Override
    public void read(BufferStream stream)
    {

    }

    @Override
    public void write(BufferStream stream)
    {

    }

	@Override
	public byte getId()
	{
		return 10;
	}

	public long getWarpType()
	{
		return warpType;
	}

	public int getWorldCoordinates()
	{
		return worldCoordinates;
	}

	public String getPlayerName()
	{
		return playerName;
	}
}
