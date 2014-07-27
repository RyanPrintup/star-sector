package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;
import com.ryanprintup.starsector.command.CommandSender;

public class CmdIp extends Command
{
	@Override
	public void onUse(CommandSender sender, String args)
	{
		Player who = server.findPlayer(args);
		if (who == null) {
			sender.sendMessage("Could not find specified player.");
			return;
		}
		
		sender.sendMessage(who.getName() + " ip address is: " + who.getIp());
	}
}
