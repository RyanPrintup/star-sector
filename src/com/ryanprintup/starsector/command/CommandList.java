package com.ryanprintup.starsector.command;

import java.util.ArrayList;
import java.util.List;

public class CommandList
{
	private static List<Command> commands = new ArrayList<Command>();
	
	public void add(Command cmd)
	{
		commands.add(cmd);
	}
	
	public Command getCommand(String command)
	{
		for (Command cmd : commands) {
			if (cmd.getName().equals(command) || cmd.getShortcut().equals(command)) {
				return cmd;
			}
		}
		
		return null;
	}
	
	public boolean isCommand(String command)
	{
		return getCommand(command) == null ? false : true;
	}
	
	public Command getCommand(Command command)
	{
		return getCommand(command.getName());
	}
	
	public Command getCommand(int index)
	{
		if (index > commands.size()) {
			return null;
		}
		
		return commands.get(index);
	}
	
	public int getSize()
	{
		return commands.size();
	}
	
	// Initiate all default commands here
		public static void initDefaults()
		{
			commands.add(new CmdHelp());
			commands.add(new CmdIp());
			commands.add(new CmdKick());
			commands.add(new CmdSay());
			commands.add(new CmdPrivateMessage());
			commands.add(new CmdPlayers());
		}
}
