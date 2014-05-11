package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;

public class CmdStop extends Command
{
	public CmdStop()
	{
		name = "stop";
		shortcut = "stop";
		allowConsole = true;
		allowPlayer = false;
		help = "stop - Stops the server";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		if (server.isRunning()) {
			server.stop();
		} else {
			console.write("Server already stopped");
		}
	}
}
