package com.ryanprintup.starsector;

import java.util.Scanner;

import com.ryanprintup.starsector.command.CommandList;
import com.ryanprintup.starsector.command.CommandSender;

public class Console implements CommandSender
{	
	private Logger logger = StarSector.getServer().getLogger();
	
	private Thread input = new Thread(new ConsoleInput(this));
	
	public Console()
	{
		input.start();
	}
	
	@Override
	public void sendMessage(String message)
	{
		logger.log(message);
		write(message);
	}
	
	public void warn(String warning)
	{
		write("[WARNING] " + warning);
	}
	
	public void error(String error)
	{
		write("[ERROR] " + error);
	}
	
	public void info(String info)
	{
		write("[INFO] " + info);
	}
	
	private void write(String message)
	{
		System.out.println(message);
	}
}

class ConsoleInput implements Runnable
{
	private Console console;
	private Scanner scanner = new Scanner(System.in);
	private CommandList commandList = StarSector.getServer().getCommandList();
	
	public ConsoleInput(Console console)
	{
		this.console = console;
	}
	
	@Override
	public void run()
	{
		while (true) {
			String input = scanner.nextLine();
			handleInput(input);
		}
	}
	
	private void handleInput(String input)
	{
		String command = input.split(" ")[0];
		
		if (commandList.isCommand(command)) {
			commandList.getCommand(command).use(console, input);
		} else {
			console.sendMessage("Invalid command: \"" + command + "\"");
		}
	}
}
