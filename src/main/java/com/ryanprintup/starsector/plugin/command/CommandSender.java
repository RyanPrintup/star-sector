package com.ryanprintup.starsector.plugin.command;

public interface CommandSender
{
	public abstract void sendMessage(String message);
	
	public abstract void sendMessage(String[] messages);
}
