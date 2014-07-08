package com.ryanprintup.starsector.net;

import com.ryanprintup.starsector.util.ZlibCompressor;



public class PacketProcessor
{	
	public void process(final byte[] buffer)
	{
			PacketReader pr = new PacketReader(buffer);
			int packetId = pr.readByte();
			
			if (packetId != 0x04) {
				return;
			}
			System.out.println(packetId);
			
			long payload = pr.readSVLQ();
			
			boolean compressed = payload < 0;
			
			if (compressed) {
				payload = -payload;
				System.out.println("negative");
			}
			
			System.out.println(packetId + " | " + payload);
			
			PacketReader reader;
			
			if (compressed) {
				reader = new PacketReader(ZlibCompressor.decompress(pr.readByteArray((int) payload)));
			} else {
				reader = new PacketReader(pr.readByteArray((int) payload));
			}
			
			int channel = reader.readUInt8();
			String world = reader.readString();
			long clientId = reader.readUInt32();
			String name = reader.readString();
			String message = reader.readString();
			
			System.out.println(channel + " | " + world + " | " + clientId + " | " + name + " | " + message);
	}
}