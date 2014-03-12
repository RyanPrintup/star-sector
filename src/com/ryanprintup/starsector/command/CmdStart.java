package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdStart extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		if (server.isRunning()) {
			console.write("Server is already running");
		} else {
			server.start();
		}
	}

	@Override
	public String getName()
	{
		return "start";
	}

	@Override
	public String getShortcut()
	{
		return "start";
	}

	@Override
	public boolean allowConsole()
	{
		return true;
	}

	@Override
	public boolean allowPlayer()
	{
		return false;
	}

	@Override
	public String getHelp()
	{
		return "start - Starts the server";
	}
}
