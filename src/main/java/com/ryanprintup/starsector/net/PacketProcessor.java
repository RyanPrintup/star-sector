package com.ryanprintup.starsector.net;

import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.util.ZlibCompressor;
import com.ryanprintup.starsector.net.Packets;
import com.ryanprintup.starsector.net.packets.ChatRecievedPacket;

public class PacketProcessor
{	
	public void process(final byte[] buffer)
	{
			PacketReader pr = new PacketReader(buffer);
			int packetId = pr.readByte();
			
			if (Packets.contains(packetId)) {
				Packet packet;
				
				try {
					packet = Packets.get(packetId).getClassInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
					StarSector.getServer().getConsole().error("Error processing packet.");
					return;
				}
				
				long payload = pr.readSVLQ();
				boolean compressed = payload < 0;
				
				PacketReader stream;
				
				if (compressed) {
					payload = -payload;
					
					stream = new PacketReader(ZlibCompressor.decompress(pr.readByteArray((int) payload)));
				} else {
					stream = new PacketReader(pr.readByteArray((int) payload));
				}
			}
	}
}