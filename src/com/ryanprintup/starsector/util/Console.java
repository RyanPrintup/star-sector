package com.ryanprintup.starsector.util;

import java.util.Scanner;

public class Console
{
	private static Console INSTANCE;
	
	private Logger logger = new Logger();
	private Thread input = new Thread(new ConsoleInput());
	
	private Console()
	{
		input.start();
	}
	
	public static Console getInstance()
	{
		if (INSTANCE == null) {
			INSTANCE = new Console();
		}
		
		return INSTANCE;
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
	
	public void write(String message)
	{
		System.out.println(message);
	}
}

class ConsoleInput implements Runnable
{
	private Scanner scanner = new Scanner(System.in);
	
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
		// To-do: Parse input for command, use command if valid
	}
}
