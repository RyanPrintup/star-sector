package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class HandshakeChallengePacket implements BasePacket
{
	private String claimMessage;
	private String salt;
	private int roundCount;

    public HandshakeChallengePacket()
    {
    }

    public HandshakeChallengePacket(String claimMessage, String salt, int roundCount)
	{
		this.claimMessage = claimMessage;
		this.salt         = salt;
		this.roundCount   = roundCount;
	}

    @Override
    public void read(BufferStream stream)
    {
        claimMessage = stream.readString();
        salt         = stream.readString();
        roundCount   = stream.readInt32();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

	@Override
	public byte getId()
	{
		return 3;
	}

	public String getClaimMessage()
	{
		return claimMessage;
	}

	public String getSalt()
	{
		return salt;
	}

	public int getRoundCount()
	{
		return roundCount;
	}
}
