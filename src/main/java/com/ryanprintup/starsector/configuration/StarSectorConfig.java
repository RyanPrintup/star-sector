package com.ryanprintup.starsector.configuration;

import java.io.File;

public class StarSectorConfig extends Config
{	
	public static final String SERVER_NAME = "serverName";
	public static final String DATE_FORMAT = "dateFormat";
	public static final String CONSOLE_NAME = "consoleName";
	public static final String MOTD = "motd";
	public static final String SERVER_PORT = "serverPort";
	public static final String STARBOUND_PORT = "starboundPort";
	public static final String MAX_PLAYERS = "maxPlayers";
	
	public StarSectorConfig(File file)
	{
		super(file);
	}

	@Override
	protected void setDefaults()
	{
		set(SERVER_NAME, 	"Star Sector");
		set(CONSOLE_NAME, 	"Console");
		set(DATE_FORMAT,	"MM.dd.yyyy HH:mm:ss");
		set(MOTD, 			"Welcome to a Star Sector server!");
		set(SERVER_PORT, 	21020);
		set(STARBOUND_PORT, 	21025);
		set(MAX_PLAYERS, 	20);
	}
	
	public void load()
	{
		setDefaults();
	}
}
