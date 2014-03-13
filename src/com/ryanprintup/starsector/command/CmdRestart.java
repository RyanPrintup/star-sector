package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Player;

public class CmdRestart extends Command
{
	public CmdRestart()
	{
		name = "restart";
		shortcut = "restart";
		allowConsole = true;
		allowPlayer = false;
		help = "restart - Restarts the server with a 15 second countdown";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		if (server.isRunning()) {
			console.write("The server isn't started. Use \"start\" to start it");
			return;
		}
		
		server.sendMessage("Restarting server");
		
		for (int s = 15; s > 0; s--) {
			server.sendMessage(s + " seconds");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
		server.stop();
		server.start();
	}
}
