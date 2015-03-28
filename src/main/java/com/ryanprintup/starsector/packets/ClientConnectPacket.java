package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class ClientConnectPacket implements BasePacket
{
	private short[] assetDigest; // uint8[]
	private Variant claim;
	private boolean UUIDFlag;
	private short[] UUID; // uint8[16]
	private String playerName;
	private String species;
	private short[] shipworld; // uint8[]
	private String account;
	
	public ClientConnectPacket(short[] assetDigest, Variant claim, boolean UUIDFlag, short[] UUID, String playerName, String species, short[] shipworld, String account)
	{
		this.assetDigest = assetDigest;
		this.claim = claim;
		this.UUIDFlag = UUIDFlag;
		this.UUID = UUID;
		this.playerName = playerName;
		this.species = species;
		this.shipworld = shipworld;
		this.account = account;
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
		return 7;
	}
	
	public short[] assetDigest()
	{
		return assetDigest;
	}

	public Variant getClaim()
	{
		return claim;
	}

	public boolean getUUIDFlag()
	{
		return UUIDFlag;
	}

	public short[] getUUID()
	{
		return UUID;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public String getSpecies()
	{
		return species;
	}

	public short[] getShipworld()
	{
		return shipworld;
	}

	public String getAccount()
	{
		return account;
	}
}
