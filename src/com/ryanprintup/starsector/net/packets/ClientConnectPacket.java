package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ClientConnectPacket implements Packet
{
	private int[] assetDigest;
	private Variant claim;
	private boolean UUIDFlag;
	private int[16] UUID;
	private String playerName;
	private String species;
	private int[] shipworld;
	private String account;

	@Override
	public byte getId()
	{
		return 7;
	}

	public int[] assetDigest()
	{
		return assetDigest;
	}

	public Variant getClaim()
	{
		return claim;
	}

	public boolean getUUIDFlag()
	{
		return uuidFlag;
	}

	public int[16] getUUID()
	{
		return uuid;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public String getSpecies()
	{
		return species;
	}

	public int[] getShipworld()
	{
		return shipworld;
	}

	private String getAccount()
	{
		return account;
	}
}
