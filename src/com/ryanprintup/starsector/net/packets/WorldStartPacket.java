package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class WorldStartPacket implements Packet
{
	private Variant planet;
	private Variant worldStructure;
	private int[] sky;
	private int[] serverWeather;
	private float spawnX;
	private float spawnY;
	private Variant worldProperties;
	private int clientId;
	private boolean local;


	@Override
	public byte getId()
	{
		return 14;
	}

	public Variant getPlanet()
	{
		return planet;
	}

	public Variant getWorldStructure()
	{
		return worldStructure;
	}

	public int[] getSky()
	{
		return sky;
	}

	public int[] getServerWeather()
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

	public int getClientId()
	{
		return clientId;
	}

	public boolean getLocal()
	{
		return local;
	}
}