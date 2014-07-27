package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class HandshakeResponsePacket extends Packet
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
