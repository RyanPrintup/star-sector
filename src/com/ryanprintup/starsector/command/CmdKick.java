package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdKick extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		Player who = server.findPlayer(args);
		if (who == null) {
			console.write("Could not find specified player.");
			
			return;
		}
		
		who.disconnect();
		server.sendMessage(who.getName() + "  was kicked from the server!");
	}

	@Override
	public String getName()
	{
		return "kick";
	}

	@Override
	public String getShortcut()
	{
		return "kick";
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
		return "kick <player> - Kicks <player> from the server.";
	}
}
