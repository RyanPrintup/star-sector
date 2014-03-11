package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Client;

public class CmdExample implements Command
{	
	@Override
	public void use(Client c, String command)
	{
		console.write("Example Command used");
	}

	@Override
	public void help(Client c)
	{
		c.sendMessage("/exampleCmd - Example command");
	}

	@Override
	public String getName()
	{
		return "exampleCmd";
	}

	@Override
	public String getShortcut()
	{
		return "ec";
	}

}
