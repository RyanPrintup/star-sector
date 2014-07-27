package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class ClientConnectPacket extends Packet
{
	private short[] assetDigest;
	private Variant claim;
	private boolean UUIDFlag;
	private short[] UUID;
	private String playerName;
	private String species;
	private short[] shipworld;
	private String account;
	
	public ClientConnectPacket()
	{
	}
	
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
	public byte getId()
	{
		return 7;
	}
	
	@Override
	public void read(PacketReader stream)
	{
		assetDigest = stream.readUInt8Array();
		
		try {
			claim = stream.readVariant();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UUIDFlag = stream.readBoolean();
		
		if (UUIDFlag) {
			UUID = stream.readUInt8Array(16);
		}
		
		playerName = stream.readString();
		species = stream.readString();
		shipworld = stream.readUInt8Array();
		account = stream.readString();
		
	}

	@Override
	public byte[] write()
	{
		return null;
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
