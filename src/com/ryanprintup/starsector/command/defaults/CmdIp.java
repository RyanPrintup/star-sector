package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;

public class CmdIp extends Command
{
	public CmdIp()
	{
		name = "ip";
		shortcut = "ip";
		allowConsole = true;
		allowPlayer = false;
		help = "ip <player> - Shows <player>'s IP address";
	}
	
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
}
