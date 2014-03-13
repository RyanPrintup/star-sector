package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdSay extends Command
{
	public CmdSay()
	{
		name = "say";
		shortcut = "say";
		allowConsole = true;
		allowPlayer = false;
		help = "say <message> - Send a message to all players";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		String message = args;
		if (message == null || message.equals("")) {
			console.write("Please enter a message to be sent.");
			return;
		}
		
		server.sendMessage(server.getConfig().getConsoleName() + ": " + message);
	}
}
