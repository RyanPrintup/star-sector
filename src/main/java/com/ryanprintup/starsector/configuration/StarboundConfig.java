package com.ryanprintup.starsector.configuration;

import java.io.File;

public class StarboundConfig extends Config
{
	public StarboundConfig(File configFile)
	{
		super(configFile);
		// TODO Auto-generated constructor stub
	}

	public static final String GAME_PORT = "gamePort";
	public static final String SERVER_NAME = "serverName";
	public static final String SERVER_PASSWORDS = "serverPasswords";

	@Override
	protected void setDefaults()
	{
		throw new UnsupportedOperationException("Can't set defaults for Starbound config.");
	}
}
