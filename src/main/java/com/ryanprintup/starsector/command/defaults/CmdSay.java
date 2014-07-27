package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;
import com.ryanprintup.starsector.command.CommandSender;
import com.ryanprintup.starsector.configuration.StarSectorConfig;

public class CmdSay extends Command
{
	@Override
	public void onUse(CommandSender sender, String args)
	{
		String message = args;

		if (message == null || message.equals("")) {
			sender.sendMessage("Please enter a message to be sent.");
			return;
		}
		
		server.sendMessage(server.getConfig().getString(StarSectorConfig.CONSOLE_NAME) + ": " + message);
	}
}
