package com.ryanprintup.starsector.starbound;

import com.ryanprintup.starsector.Console;
import com.ryanprintup.starsector.Server;
import com.ryanprintup.starsector.StarSector;

public class StarboundServer
{
	private Server server = StarSector.getServer();
	private Console console = server.getConsole();
	
	private int port;
	private String serverName;

	private static final String WIN_LAUNCHER   = "starbound_server.exe";
    private static final String OSX_LAUNCHER   = "starbound_server.sh";
    private static final String LINUX_LAUNCHER = "starbound_server";

	public void start()
	{
		port = 20125;
		serverName = "Star Sector";

		//editStarboundConfiguration();

		console.info("Starbound configuration successfully modified.");
	}
	
	public void stop()
	{
	}
}
