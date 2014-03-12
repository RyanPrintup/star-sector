package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.Server;
import com.ryanprintup.starsector.util.Config;
import com.ryanprintup.starsector.util.Console;

public abstract class Command
{
	protected static Console console = Console.getInstance();
	protected static Server server = Config.getServerInstance();
	protected static CommandList commandList = new CommandList();
	
	public void use(Player player, String command) {
		if (player == null) {
			if (!allowConsole()) {
				console.write("This command can't be used in the console!");
				return;
			}
		} else {
			if (!allowPlayer()) {
				player.sendMessage("This command can't be used by a player!");
				return;
			}
		}
		
		
		// Remove command name
		if (command.contains(" ")) {
			String args = command.substring(command.indexOf(" ") + 1, command.length());
			
			onUse(player, args);
		} else {
			onUse(player, null);
		}
	}
	
	public void help(Player player) {
		if (player == null) {
			console.write(getHelp());
		} else {
			player.sendMessage("/" + getHelp());
		}
	}
	
	public abstract void onUse(Player player, String args);
	
	public abstract String getName();
	public abstract String getShortcut();
	public abstract boolean allowConsole();
	public abstract boolean allowPlayer();
	public abstract String getHelp();
}
