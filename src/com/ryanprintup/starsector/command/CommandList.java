package com.ryanprintup.starsector.command;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
	
	private static List<Command> commandList = new ArrayList<Command>();
	
	public  void add(Command cmd)
	{
		commandList.add(cmd);
	}
	
	// Init all default commands here
	private void init()
	{
		commandList.add(new CmdExample());
	}
}
