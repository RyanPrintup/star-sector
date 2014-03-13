package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdPrivateMessage extends Command
{
	public CmdPrivateMessage()
	{
		name = "message";
		shortcut = "pm";
		allowConsole = true;
		allowPlayer = false;
		help = "message <player> <message> - Sends a private message to <player>";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		Player who = server.findPlayer(args.split(" ")[0]);
		if (who == null) {
			player.sendMessage("Could not find specifeed player.");
			return;
		}
		
		String message = args.split(" ")[1];
		if (message == null || message.equals("")) {
			player.sendMessage("Please enter a message to send.");
			return;
		}
		
		who.sendMessage("[PM] " + player.getName() + ": " + message);
	}
}
