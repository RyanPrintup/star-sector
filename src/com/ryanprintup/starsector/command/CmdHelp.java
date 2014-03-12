package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdHelp extends Command
{
	@Override
	public void onUse(Player player, String args)
	{
		console.write("\n-----Help-----");
		if (player == null) {
			for (int c = 0; c < commandList.getSize() - 1; c++) {
				if (commandList.getCommand(c).allowConsole()) {
					console.write(commandList.getCommand(c).getHelp());
				}
			}
		} else {
			for (int c = 0; c < commandList.getSize() - 1; c++) {
				if (commandList.getCommand(c).allowPlayer()) {
					console.write("/" + commandList.getCommand(c).getHelp());
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
