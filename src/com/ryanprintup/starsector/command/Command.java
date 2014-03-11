package com.ryanprintup.starsector.command;

import com.ryanprintup.starsector.Client;
import com.ryanprintup.starsector.util.Console;

public interface Command
{
	public static final Console console = Console.getInstance();
	
	public abstract void use(Client c, String command);
	public abstract void help(Client c);
	
	public abstract String getName();
	public abstract String getShortcut();
}
