package com.ryanprintup.starsector.net.packets;

public class ChatPacket extends Packet
{
	private byte[] packet;
	
	public ChatPacket(final byte[] packet)
	{
		super(Packets.chatSent);
		
		this.packet = packet;
	}
	
	public ChatPacket()
	{
		this(create());
	}
	
	private static byte[] create()
	{
		return new byte[1];
	}
}
