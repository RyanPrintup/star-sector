package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdHelp extends Command
{
	public CmdHelp()
	{
		name = "help";
		shortcut = "help";
		allowConsole = true;
		allowPlayer = true;
		help = "help - Shows a list of commands";
	}
	
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
}
