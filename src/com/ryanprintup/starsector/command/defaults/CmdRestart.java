package com.ryanprintup.starsector.command.defaults;

import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.command.Command;

public class CmdRestart extends Command
{
	public CmdRestart()
	{
		name = "restart";
		shortcut = "restart";
		allowConsole = true;
		allowPlayer = false;
		help = "restart <seconds> - Restarts the server. Optional countdown of <seconds>";
	}
	
	@Override
	public void onUse(Player player, String args)
	{
		if (server.isRunning()) {
			console.write("The server isn't started. Use \"start\" to start it");
			return;
		}
		
		server.sendMessage("Restarting server");
		
		if (args != null) {
			int seconds;
			
			try {
				seconds = Integer.parseInt(args);
			} catch (NumberFormatException e) {
				console.write("Invalid number, restarting instantly.");
				seconds = 0;
			}
			
			if (seconds > 0) {
				for (; seconds > 0; seconds--) {
					if (seconds <= 10 || seconds % 15 == 0) {
						server.sendMessage(seconds + " seconds");
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		}
		
		server.stop();
		server.start();
	}
}
