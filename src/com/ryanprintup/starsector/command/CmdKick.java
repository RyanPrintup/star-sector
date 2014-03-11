package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Client;
import com.ryanprintup.starsector.Player;

public class CmdKick implements Command
{

	@Override
	public void use(Client c, String command) {
		if (command == "") {
			help(c);
			return;
		}
		
		Client who = server.findClient(command.split(" ")[0]);
		if (who == null) {
			c.sendMessage("Could not find specified player.");
			return;
		}
		
		who.disconnect();
		
		String message = command.split(" ")[1];
		if (message != null) {
			server.sendMessage(message);
		} else {
			server.sendMessage(who.getName() + " was kicked from the server");
		}
	}

	@Override
	public void help(Client c) {
		c.sendMessage("/kick <player> <reason> - Kicks <player> from the server for <reason>");
	}

	@Override
	public String getName() {
		return "kick";
	}

	@Override
	public String getShortcut() {
		return "kick";
	}
	
}
