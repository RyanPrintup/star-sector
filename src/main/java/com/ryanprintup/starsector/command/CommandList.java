package com.ryanprintup.starsector.command;

import java.util.ArrayList;
import java.util.List;

import com.ryanprintup.starsector.command.defaults.CmdHelp;
import com.ryanprintup.starsector.command.defaults.CmdIp;
import com.ryanprintup.starsector.command.defaults.CmdKick;
import com.ryanprintup.starsector.command.defaults.CmdPlayers;
import com.ryanprintup.starsector.command.defaults.CmdPrivateMessage;
import com.ryanprintup.starsector.command.defaults.CmdRestart;
import com.ryanprintup.starsector.command.defaults.CmdSay;
import com.ryanprintup.starsector.command.defaults.CmdStart;
import com.ryanprintup.starsector.command.defaults.CmdStop;

public class CommandList
{
	private static List<Command> commands = new ArrayList<Command>();
	
	public void register(Command command)
	{
		commands.add(command);
	}
	
	public void unregister(Command command)
	{
		if (contains(command.getName())) {
			commands.remove(command);
		}
	}
	
	public Command getCommand(String command)
	{
		for (Command cmd : commands) {
			if (cmd.getName().equalsIgnoreCase(command)) {
				return cmd;
			}
		}
		
		return null;
	}
	
	public boolean contains(String command)
	{
		return commands.contains(command);
	}
	
	public int getSize()
	{
		return commands.size();
	}
}
