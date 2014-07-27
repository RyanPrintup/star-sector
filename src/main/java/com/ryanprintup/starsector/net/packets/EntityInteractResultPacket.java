package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.datatypes.Variant;
import com.ryanprintup.starsector.net.Packet;
import com.ryanprintup.starsector.net.PacketReader;

public class EntityInteractResultPacket extends Packet
{
	private long clientId;
	private int entityId;
	private Variant results;

	public EntityInteractResultPacket()
	{
	}
	
	public EntityInteractResultPacket(long clientId, int entityId, Variant results)
	{
		this.clientId = clientId;
		this.entityId = entityId;
		this.results = results;
	}
	
	@Override
	public byte getId()
	{
		return 24;
	}
	
	@Override
	public void read(PacketReader stream)
	{
		clientId = stream.readUInt32();
		entityId = stream.readInt32();
		
		try {
			results = stream.readVariant();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write()
	{
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