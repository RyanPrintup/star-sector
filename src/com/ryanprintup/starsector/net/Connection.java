package com.ryanprintup.starsector.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ryanprintup.starsector.Player;

public class Connection implements Runnable
{
	private PacketProcessor packetProcessor;
	
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private boolean connection = false;
	private Thread connectionThread = new Thread(this);
	
	public Connection(InputStream inputStream, OutputStream outputStream)
	{
		packetProcessor = new PacketProcessor();

		this.inputStream = inputStream;
		this.outputStream = outputStream;
		
		connection = true;
		connectionThread.start();
	}

	@Override
	public void run()
	{
		connection = true;
		byte[] buffer = new byte[8192];
		
		try {
			while (connection) {
				int bytes = inputStream.read(buffer);
				if (bytes == -1) {
					break;
				}
				
				packetProcessor.process(buffer);
				
				outputStream.write(buffer, 0, bytes);
				outputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		connection = false;
	}
	
	public void endConnection() {
		connection = false;
		
		try {
			connectionThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
