package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

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
