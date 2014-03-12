package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdPlayers extends Command
{
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

	@Override
	public String getName()
	{
		return "players";
	}

	@Override
	public String getShortcut()
	{
		return "players";
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
		return "players - Show a list of online players.";
	}
}
