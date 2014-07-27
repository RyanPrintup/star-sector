package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;
import com.ryanprintup.starsector.command.CommandSender;

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
	public void onCommand(CommandSender sender, String[] args)
	{
	}
}
