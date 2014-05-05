package com.ryanprintup.starsector.configuration;

public enum ConfigDefaults
{
	SERVER_NAME("Star Sector Server"),
	CONSOLE_NAME("Console"),
	MOTD("Welcome to a Star Sector Server!"),
	SERVER_PORT("21025"),
	STARBOUND_PORT("21020"),
	MAX_CLIENTS("20");
	
	private final String value;
	
	ConfigDefaults(String value)
	{
		this.value = value;
	}
	
	
	public String getValue()
	{
		return value;
	}
	/* = "Star Sector Server";
	 
	 = "Console";
	 
	 = "Welcome to a Star Sector Server!";
	 
	 = "21025";
	 
	 = "21020";
	 
	 = "20";*/
}
