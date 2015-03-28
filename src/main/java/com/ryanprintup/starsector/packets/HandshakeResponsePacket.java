package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.net.BufferStream;

public class HandshakeResponsePacket implements BasePacket
{
	private String claimResponse;
	private String passwordHash;

	public HandshakeResponsePacket(String claimResponse, String passwordHash)
	{
		this.passwordHash = passwordHash;
		this.claimResponse = claimResponse;
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
		return 9;
	}

	public String getClaimResponse()
	{
		return claimResponse;
	}

	public String getPasswordHash()
	{
		return passwordHash;
	}
}
