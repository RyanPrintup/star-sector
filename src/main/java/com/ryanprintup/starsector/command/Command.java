package com.ryanprintup.starsector.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ryanprintup.starsector.Console;
import com.ryanprintup.starsector.Player;
import com.ryanprintup.starsector.Server;
import com.ryanprintup.starsector.StarSector;

public abstract class Command
{
	protected static final Server server = StarSector.getServer();
	protected static final Console console = server.getConsole();
	
	private String name;
	private List<String> aliases;
	private boolean allowConsole;
	private boolean allowPlayer;
	private String usage;
	private String description;
	
	public Command(String name, String description, String usage, boolean allowConsole, boolean allowPlayer, List<String> aliases)
	{
		this.name = name;
		this.description = description;
		this.usage = usage;
		this.allowConsole = allowConsole;
		this.allowPlayer = allowPlayer;
		this.aliases = new ArrayList<String>(aliases);
	}
	
	public final void execute(CommandSender sender, String command) {
		if (sender instanceof Console) {
			if (!allowConsole) {
				sender.sendMessage("This command can't be used in the console!");
				return;
			}
		} else {
			if (!allowPlayer) {
				sender.sendMessage("This command can't be used by a player!");
				return;
			}
		}
		
		
		// Split up arguments
		List<String> splitArgs = new ArrayList<String>();
		String args[];
		
		if (command.indexOf(" ") != -1) {
			// Remove command name
			String argsString = command.substring(command.indexOf(" ") + 1, command.length());
			
			// Split string based on spaces, but converse string
			// if surronded in double quotes
			Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(argsString);
			
			while (m.find()) {
				// Add the splited arguments to the array and remove any quotes
				splitArgs.add(m.group(1).replace("\"", ""));
			}
			
			args = splitArgs.toArray(new String[splitArgs.size()]);
		} else {
			args = null;
		}
		
		onCommand(sender, args);
	}
	
	public abstract void onCommand(CommandSender sender, String args[]);
	
	public final void help(CommandSender sender) {
		String prefix = "";
		
		if (sender instanceof Player) {
			prefix = "/";
		}
		
		sender.sendMessage(prefix + name + ": " + description);
		sender.sendMessage("Usage: " + prefix + usage);
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<String> getAliases()
	{
		return aliases;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getUsage()
	{
		return usage;
	}
	
	public boolean getAllowConsole()
	{
		return allowConsole;
	}
	
	public boolean getAllowPlayer()
	{
		return allowPlayer;
	}
}
