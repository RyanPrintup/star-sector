package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdPrivateMessage extends Command
{
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

	@Override
	public String getName()
	{
		return "message";
	}
	
	@Override
	public String getShortcut()
	{
		return "pm";
	}

	@Override
	public boolean allowConsole()
	{
		return false;
	}

	@Override
	public boolean allowPlayer()
	{
		return true;
	}

	@Override
	public String getHelp()
	{
		return "message <player> <message> - Send a private message to <player>";
	}
}
