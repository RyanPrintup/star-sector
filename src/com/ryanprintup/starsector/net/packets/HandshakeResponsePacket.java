package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class HandshakeResponsePacket implements Packet
{
	private String claimResponse;
	private String passwordHash;

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
