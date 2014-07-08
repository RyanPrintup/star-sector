package com.ryanprintup.starsector.net.packets;

import com.ryanprintup.starsector.net.Packet;

public class EntityInteractResultPacket implements Packet
{
	private int clientId;
	private int entityId;
	private Variant results;

	@Override
	public byte getId()
	{
		return 24;
	}

	public int getClientId()
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