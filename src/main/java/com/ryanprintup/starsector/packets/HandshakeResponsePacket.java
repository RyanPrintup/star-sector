package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.Packet;
import com.ryanprintup.starsector.PacketReader;

public class HandshakeResponsePacket extends BasePacket
{
	private String claimResponse;
	private String passwordHash;

	public HandshakeResponsePacket()
	{}

	public HandshakeResponsePacket(String claimResponse, String passwordHash)
	{
		this.passwordHash = passwordHash;
		this.claimResponse = claimResponse;
	}

	@Override
	public byte getId()
	{
		return 9;
	}

	@Override
	public void read(PacketReader stream)
	{
		claimResponse = stream.readString();
		passwordHash = stream.readString();
	}

	@Override
	public void write()
	{
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
