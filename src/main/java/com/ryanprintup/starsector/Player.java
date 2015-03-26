package com.ryanprintup.starsector;

import com.ryanprintup.starsector.command.CommandSender;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Player implements CommandSender
{
	private Socket clientSocket;
	private Socket serverSocket;

    private PacketForwarder clientForwarder;
    private PacketForwarder serverForwarder;

	private String name = "Bob";
	private String ip;
	private String UUID;
	
	public Player(final Socket socket)
	{
		this.clientSocket = socket;
		ip = socket.getInetAddress().getHostAddress();

        initConnections();

        try {
            clientForwarder = new PacketForwarder(clientSocket.getInputStream(), serverSocket.getOutputStream());
            serverForwarder = new PacketForwarder(serverSocket.getInputStream(), clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

    public void initConnections()
    {
        try {
            serverSocket = new Socket("127.0.0.1", 21025);

            clientSocket.setKeepAlive(true);
            serverSocket.setKeepAlive(true);
        } catch (IOException e) {
            StarSector.getServer().getConsole().error("Error trying to establish client-server connection. Error: " + e);
        }
    }
	
	@Override
	public void sendMessage(String message)
	{

	}
	
	@Override
	public void sendMessage(String[] messages)
	{
		for (String message : messages) {
			sendMessage(message);
		}
	}
	
	private void sendPacket(final byte packet[])
	{
		try {
			clientSocket.getOutputStream().write(packet);
			clientSocket.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect()
	{
        try {
            serverSocket.close();
            clientSocket.close();
        } catch (IOException e) {

        } finally {
            serverSocket = null;
            clientSocket = null;
        }
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getIp()
	{
		return ip;
	}

    public String getUUID()
    {
        return UUID;
    }

    //Temp forwarder
    private class PacketForwarder implements Runnable
    {
        private Thread packetHandler = new Thread(this);

        private InputStream in;
        private OutputStream out;

        public PacketForwarder(InputStream in, OutputStream out)
        {
            this.in = in;
            this.out = out;

            packetHandler.start();
        }

        @Override
        public void run()
        {
            byte[] buffer = new byte[8291];

            while (true) {
                try {
                    int bytes = in.read(buffer);
                    if (bytes == -1) {
                        break;
                    }

                    out.write(buffer, 0, bytes);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}