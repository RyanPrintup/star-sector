package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class ConnectionResponsePacket implements Packet
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
	private String sectName;
	private long sectorSeed; // int64
	private String sectorPrefix;
	private Variant parameters;
	private Variant sectorConfig;

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
		return getSectorName;
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
