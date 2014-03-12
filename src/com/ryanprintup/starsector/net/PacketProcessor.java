package com.ryanprintup.starsector.net;

import com.ryanprintup.starsector.net.packets.Packets;


public class PacketProcessor
{
	private PacketReader packetReader = new PacketReader();
	
	public void process(final byte[] packet)
	{
		switch (packet[0]) {
			case Packets.protocolVersion:
				System.out.println("Server protocol");
				break;
			case Packets.connectionResponse:
				System.out.println("Client join successful");
				break;
			case Packets.chatRecieved:
				System.out.println("Chat message");
				break;
			case Packets.clientConnect:
				System.out.println("Client join");
				break;
			case Packets.clientDisconnect:
				System.out.println("Client disconnect");
				break;
		}
	}
}
