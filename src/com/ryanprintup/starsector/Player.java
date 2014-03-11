package com.ryanprintup.starsector;

public class Player
{
	private final String name;
	private final String UUID;
	
	public Player(final String name, final String UUID)
	{
		this.name = name;
		this.UUID = UUID;
	}
	
	public String getName() {
		return name;
	}

	public String getUUID() {
		return UUID;
	}
}
