package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdIp extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		Player who = server.findPlayer(args);
		if (who == null) {
			console.write("Could not find specified player.");
			return;
		}
		
		console.write(who.getName() + " ip address is: " + who.getIp());
	}

	@Override
	public String getName()
	{
		return "ip";
	}

	@Override
	public String getShortcut()
	{
		return "ip";
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
		return "ip <player> - Get <player>'s ip address";
	}
}
