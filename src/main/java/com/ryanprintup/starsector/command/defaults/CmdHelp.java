package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Console;
import com.ryanprintup.starsector.command.Command;
import com.ryanprintup.starsector.command.CommandList;
import com.ryanprintup.starsector.command.CommandSender;

public class CmdHelp extends Command
{	
	@Override
	public void onUse(CommandSender sender, String args)
	{
		CommandList commandList = server.getCommandList();
		
		if (sender instanceof Console) {
			sender.sendMessage("\n-----Help-----");
			
			for (int c = 0; c < commandList.getSize(); c++) {
				if (commandList.getCommand(c).allowConsole()) {
					sender.sendMessage(commandList.getCommand(c).getHelp());
				}
			}
		} else {
			sender.sendMessage("-----Help-----");
			
			for (int c = 0; c < commandList.getSize(); c++) {
				if (commandList.getCommand(c).allowPlayer()) {
					sender.sendMessage("/" + commandList.getCommand(c).getHelp());
				}
			}
		}
	}

	@Override
	public void onCommand(CommandSender sender, String[] args)
	{
	}
}
