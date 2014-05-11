package com.ryanprintup.starsector;

import java.util.Scanner;

import com.ryanprintup.starsector.command.CommandSender;

public class Console implements CommandSender
{	
	private Thread input = new Thread(new ConsoleInput(this));
	
	public Console()
	{
		input.start();
	}
	
	@Override
	public void sendMessage(String message)
	{
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
	//private CommandList commandList = new CommandList();
	
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
		
		/*if (commandList.isCommand(command)) {
			commandList.getCommand(command).use(null, input);
		} else {
			//console.sendMessage("Invalid command: \"" + command + "\"");
		}*/
	}
}
