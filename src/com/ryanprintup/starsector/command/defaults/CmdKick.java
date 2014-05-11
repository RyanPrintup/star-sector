package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;

public class CmdKick extends Command
{
	public CmdKick()
	{
		name = "kick";
		shortcut = "kick";
		allowConsole = true;
		allowPlayer = false;
		help = "kick <player> - Kicks <player> from the server";
	}
	
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
}
