package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;
import com.ryanprintup.starsector.command.CommandSender;

public class CmdPrivateMessage extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		Player who = server.findPlayer(args.split(" ")[0]);
		if (who == null) {
			player.sendMessage("Could not find specified player.");
			return;
		}
		
		String message = args.split(" ")[1];
		if (message == null || message.equals("")) {
			player.sendMessage("Please enter a message to send.");
			return;
		}
		
		who.sendMessage("[PM] " + player.getName() + ": " + message);
	}

	@Override
	public void onCommand(CommandSender sender, String[] args)
	{
	}
}
