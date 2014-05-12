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
	
	public Command getCommand(String command)
	{
		command = command.toLowerCase();
		
		for (Command cmd : commands) {
			if (cmd.getName().equals(command) || cmd.getShortcut().equals(command)) {
				return cmd;
			}
		}
		
		return null;
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
	
	public boolean isCommand(String command)
	{
		return getCommand(command) == null ? false : true;
	}
	
	public int getSize()
	{
		return commands.size();
	}
}
