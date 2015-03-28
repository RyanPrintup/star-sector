package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class ConnectionResponsePacket implements BasePacket
{
	private boolean success;
	private long clientId; // VLQ
	private String rejectionReason;
	private boolean celestialInfoExists;
	private int orbitalLevels;
	private int chunkSize;
	private int xyCoordinateMin;
	private int xyCoordinateMax;
	private int zCoordinateMin;
	private int zCoordinateMax;
	private long numberOfSectors; // VLQ
	private String sectorId;
	private String sectorName;
	private long sectorSeed; // uint64
	private String sectorPrefix;
	private Variant parameters;
	private Variant sectorConfig;

    public ConnectionResponsePacket()
    {
    }

    public ConnectionResponsePacket(boolean success, long clientId, String rejectionReason, boolean celestialInfoExists, int orbitalLevels, int chunkSize, int xyCoordinateMin, int xyCoordinateMax, int zCoordinateMin, int zCoordinateMax, long numberOfSectors, String sectorId, String sectorName, long sectorSeed, String sectorPrefix, Variant parameters, Variant sectorConfig)
	{
		this.success             = success;
		this.clientId            = clientId;
		this.rejectionReason     = rejectionReason;
		this.celestialInfoExists = celestialInfoExists;
		this.orbitalLevels       = orbitalLevels;
		this.chunkSize           = chunkSize;
		this.xyCoordinateMin     = xyCoordinateMin;
		this.xyCoordinateMax     = xyCoordinateMax;
		this.zCoordinateMin      = zCoordinateMin;
		this.zCoordinateMax      = zCoordinateMax;
		this.numberOfSectors     = numberOfSectors;
		this.sectorId            = sectorId;
		this.sectorName          = sectorName;
		this.sectorSeed          = sectorSeed;
		this.sectorPrefix        = sectorPrefix;
		this.parameters          = parameters;
		this.sectorConfig        = sectorConfig;
	}

    @Override
    public void read(BufferStream stream)
    {
        success             = stream.readBoolean();
        clientId            = stream.readVLQ();
        rejectionReason     = stream.readString();
        celestialInfoExists = stream.readBoolean();
        orbitalLevels       = stream.readInt32();
        chunkSize           = stream.readInt32();
        xyCoordinateMin     = stream.readInt32();
        xyCoordinateMax     = stream.readInt32();
        zCoordinateMin      = stream.readInt32();
        zCoordinateMax      = stream.readInt32();
        numberOfSectors     = stream.readVLQ();
        sectorId            = stream.readString();
        sectorName          = stream.readString();
        sectorSeed          = stream.readUInt64();
        sectorPrefix        = stream.readString();

        try {
            parameters   = stream.readVariant();
            sectorConfig = stream.readVariant();
        } catch (Exception e) {
            StarSector.getServer().getConsole().error("Could not read variant from Stream. Error: " + e);
            return;
        }

    }

    @Override
    public void write(BufferStream stream)
    {

    }

    @Override
	public byte getId()
	{
		return 1;
	}

	public boolean success()
	{
		return success;
	}

	public long getClientId()
	{
		return clientId;
	}

	public String getRejectionReason()
	{
		return rejectionReason;
	}

	public boolean celestialInfoExists()
	{
		return celestialInfoExists;
	}

	public int getOrbitalLevels()
	{
		return orbitalLevels;
	}

	public int getChunkSize()
	{
		return chunkSize;
	}

	public int xyCoordinateMax()
	{
		return xyCoordinateMax;
	}

	public int xyCoordinateMin()
	{
		return xyCoordinateMin;
	}

	public int zCoordinateMax()
	{
		return zCoordinateMax;
	}

	public int zCoordinateMin()
	{
		return zCoordinateMin;
	}

	public long getNumberOfSectors()
	{
		return numberOfSectors;
	}

	public String getSectorId()
	{
		return sectorId;
	}

	public String getSectorName()
	{
		return sectorName;
	}

	public long getSectorSeed()
	{
		return sectorSeed;
	}

	public String getSectorPrefix()
	{
		return sectorPrefix;
	}

	public Variant getParameters()
	{
		return parameters;
	}

	public Variant getSectorConfig()
	{
		return sectorConfig;
	}
}
