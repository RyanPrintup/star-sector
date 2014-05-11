package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;

public class CmdPlayers extends Command
{
	public CmdPlayers()
	{
		name = "players";
		shortcut = "list";
		allowConsole = true;
		allowPlayer = true;
		help = "players - Shows a list of online players";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		String players = "Online Players: ";
		
		if (server.getPlayerCount() == 0) {
			players += "none";
		} else {
			for (int p = 0; p < server.getPlayerCount(); p++) {
				players += server.getPlayer(p).getName();
				
				if (p != server.getPlayerCount()) {
					players += ", ";
				}
			}
		}
		
		if (player == null) {
			console.write(players);
		} else {
			player.sendMessage(players);
		}
	}
}
