package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class WorldStartPacket extends Packet
{
	private Variant planet;
	private Variant worldStructure;
	private short[] sky;
	private short[] serverWeather;
	private float spawnX;
	private float spawnY;
	private Variant worldProperties;
	private long clientId; // Uint32
	private boolean local;

	public WorldStartPacket()
	{}

	public WorldStartPacket()
	{
		this.planet = planet;
		this.worldStructure;
		this.sky = sky;
		this.serverWeather = serverWeather;
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.worldProperties = worldProperties;
		this.clientId = clientId;
		this.local = local;
	}

	@Override
	public byte getId()
	{
		return 14;
	}


	@Override
	public void read(PacketReader stream)
	{
		planet = stream.readVariant();
		worldStructure = stream.readVariant();
		sky = stream.readUInt8Array();
		serverWeather = stream.readUInt8Array();
		spawnX = stream.readFloat();
		spawnY = stream.readFloat();
		worldProperties = stream.readVariant();
		clientId = stream.readUInt32();
		local = stream.readBoolean();
	}

	@Override
	public void write()
	{
	}

	public Variant getPlanet()
	{
		return planet;
	}

	public Variant getWorldStructure()
	{
		return worldStructure;
	}

	public short[] getSky()
	{
		return sky;
	}

	public short[] getServerWeather()
	{
		return serverWeather;
	}

	public float getSpawnX()
	{
		return spawnX;
	}

	public float getSpawnY()
	{
		return spawnY;
	}

	public Variant getWorldProperties()
	{
		return worldProperties;
	}

	public long getClientId()
	{
		return clientId;
	}

	public boolean getLocal()
	{
		return local;
	}
}