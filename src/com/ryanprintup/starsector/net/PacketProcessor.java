package com.ryanprintup.starsector.net;

import com.ryanprintup.starsector.net.packets.Packets;
import com.ryanprintup.starsector.util.ZlibCompressor;


public class PacketProcessor
{	
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
				System.out.println("Client connect");
				break;
			case Packets.clientDisconnect:
				System.out.println("Client disconnect");
				break;
		}
	}
	
}