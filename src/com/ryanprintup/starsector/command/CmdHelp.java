package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdHelp extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		if (player == null) {
			console.write("\n-----Help-----");
			
			for (int c = 0; c < commandList.getSize(); c++) {
				if (commandList.getCommand(c).allowConsole()) {
					console.write(commandList.getCommand(c).getHelp());
				}
			}
		} else {
			player.sendMessage("-----Help-----");
			
			for (int c = 0; c < commandList.getSize(); c++) {
				if (commandList.getCommand(c).allowPlayer()) {
					player.sendMessage("/" + commandList.getCommand(c).getHelp());
				}
			}
		}
	}

	@Override
	public String getName()
	{
		return "help";
	}

	@Override
	public String getShortcut()
	{
		return "help";
	}

	@Override
	public boolean allowConsole()
	{
		return true;
	}

	@Override
	public boolean allowPlayer()
	{
		return true;
	}

	@Override
	public String getHelp()
	{
		return "help - Shows a list of useable commands.";
	}
}
