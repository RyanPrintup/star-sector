package com.ryanprintup.starsector.configuration;

import java.io.File;

public class ServerConfig extends Config
{	
	public static final String SERVER_NAME = "serverName";
	public static final String CONSOLE_NAME = "consoleName";
	public static final String MOTD = "motd";
	public static final String SERVER_PORT = "serverPort";
	public static final String STARBOUND_PORT = "starboundPort";
	public static final String MAX_PLAYERS = "maxPlayers";
	
	public ServerConfig(File file)
	{
		super(file);
	}

	@Override
	protected void setDefaults()
	{
		config.put(SERVER_NAME, 	"Star Sector");
		config.put(CONSOLE_NAME, 	"Console");
		config.put(MOTD, 			"Welcome to a Star Sector server!");
		config.put(SERVER_PORT, 	21020);
		config.put(STARBOUND_PORT, 	21025);
		config.put(MAX_PLAYERS, 	20);
	}
}
