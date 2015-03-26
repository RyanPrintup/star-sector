package com.ryanprintup.starsector;

import com.ryanprintup.starsector.command.CommandSender;

public class Console implements CommandSender
{
	@Override
	public void sendMessage(String message)
	{
		write(message);
	}
	
	@Override
	public void sendMessage(String[] messages) {
		for (String message : messages) {
			sendMessage(message);
		}
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