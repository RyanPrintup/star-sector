package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdStop extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		if (server.isRunning()) {
			server.stop();
		} else {
			console.write("Server already stopped");
		}
	}

	@Override
	public String getName()
	{
		return "stop";
	}

	@Override
	public String getShortcut()
	{
		return "stop";
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
		return "stop - Stops the server";
	}
}
