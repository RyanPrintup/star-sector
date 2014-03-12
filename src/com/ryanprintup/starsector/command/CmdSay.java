package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdSay extends Command
{

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

	@Override
	public String getName()
	{
		return "say";
	}

	@Override
	public String getShortcut()
	{
		return "say";
	}

	@Override
	public boolean allowConsole()
	{
		return true;
	}

	@Override
	public boolean allowPlayer()
	{
		return false;
	}

	@Override
	public String getHelp()
	{
		return "say <message> - Send a message to all the players.";
	}

}
