package com.ryanprintup.starsector.command;

public interface CommandSender
{
	public abstract void sendMessage(String message);
	
	public abstract void sendMessage(String[] messages);
}
