package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;

public class CmdStart extends Command
{
	public CmdStart()
	{
		name = "start";
		shortcut = "start";
		allowConsole = true;
		allowPlayer = false;
		help = "start - Start the server";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		if (server.isRunning()) {
			console.write("Server is already running");
		} else {
			server.start();
		}
	}
}
