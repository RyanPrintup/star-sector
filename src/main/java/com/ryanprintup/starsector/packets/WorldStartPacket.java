package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class WorldStartPacket implements BasePacket
{
	private Variant planet;
	private Variant worldStructure;
	private short[] sky; // uint8[]
	private short[] serverWeather; // uint8[]
	private float spawnX;
	private float spawnY;
	private Variant worldProperties;
	private long clientId; // uint32
	private boolean local;

    public WorldStartPacket()
    {
    }

    public WorldStartPacket(Variant planet, Variant worldStructure, short[] sky, short[] serverWeather, float spawnX, float spawnY, Variant worldProperties, long clientId, boolean local)
	{
		this.planet          = planet;
		this.worldStructure  = worldStructure;
		this.sky             = sky;
		this.serverWeather   = serverWeather;
		this.spawnX          = spawnX;
		this.spawnY          = spawnY;
		this.worldProperties = worldProperties;
		this.clientId        = clientId;
		this.local           = local;
	}

    @Override
    public void read(BufferStream stream)
    {
        try {
            planet          = stream.readVariant();
            worldStructure  = stream.readVariant();
            worldProperties = stream.readVariant();
        } catch (Exception e) {
            StarSector.getServer().getConsole().error("Could not read variant from Stream. Error: " + e);
            return;
        }

        sky           = stream.readUInt8Array();
        serverWeather = stream.readUInt8Array();
        spawnX        = stream.readFloat();
        spawnY        = stream.readFloat();
        clientId      = stream.readUInt32();
        local         = stream.readBoolean();
    }

    @Override
    public void write(BufferStream stream)
    {

    }

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