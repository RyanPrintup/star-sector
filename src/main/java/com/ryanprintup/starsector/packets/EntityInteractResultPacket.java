package com.ryanprintup.starsector.packets;

import com.ryanprintup.starsector.BasePacket;
import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.BufferStream;

public class EntityInteractResultPacket implements BasePacket
{
	private long clientId; // uint32
	private int entityId;
	private Variant results;
	
	public EntityInteractResultPacket(long clientId, int entityId, Variant results)
	{
		this.clientId = clientId;
		this.entityId = entityId;
		this.results = results;
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
		return 24;
	}

	public long getClientId()
	{
		return clientId;
	}

	public int entityId()
	{
		return entityId;
	}

	public Variant getResults()
	{
		return results;
	}
}