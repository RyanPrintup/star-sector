package com.ryanprintup.starsector.starbound;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONWriter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ryanprintup.starsector.Console;
import com.ryanprintup.starsector.Server;
import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.configuration.Config;
import com.ryanprintup.starsector.configuration.StarSectorConfig;
import com.ryanprintup.starsector.configuration.StarboundConfig;
import com.ryanprintup.starsector.exceptions.StarSectorException;

public class StarboundServer
{
	private final String os = System.getProperty("os.name").toLowerCase();
	private static final File config = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Starbound\\starbound.config");
	private Config starboundConfig = new StarboundConfig(config);
	
	private Server server = StarSector.getServer();
	private Console console = server.getConsole();
	
	private int port;
	private String serverName;
	
	// Used to avoid connecting directly to the Starbound server and bypassing Star Sector
	private String serverPassword;
	
	private Process serverProcess;
	
	public void start() throws StarSectorException
	{
		/**
		 * Set values here so every time the server is restarted
		 * the most recent values are used.
		 */
		port = server.getConfig().getInt(StarSectorConfig.STARBOUND_PORT);
		serverName = server.getConfig().getString(StarSectorConfig.SERVER_NAME);
		serverPassword = generatePassword();
		
		editStarboundConfiguration();
		
		console.info("Starbound configuration successfully modified.");
		
		/*ProcessBuilder pb;
		File starboundServerPath;
		String currentDirectory = System.getProperty("user.dir");
		
		if (isWindows()) {
			starboundServerPath = new File(currentDirectory + "\\win32\\starbound_server.exe");
		} else if (isUnix() || isMac()) {
			starboundServerPath = new File(currentDirectory + "\\linux32\\launch_starbound_server.sh");
		} else {
			console.write("Your operating system isn't supported");
			return false;
		}
		
		if (!starboundServerPath.exists()) {
			console.write("Cannot find Starbound server! Please make sure Star Sector is in the Starbound directory");
			console.write("Attempted to find " + starboundServerPath.getPath());
			return false;
		}
		
		pb = new ProcessBuilder(starboundServerPath.getPath());
		
		try {
			serverProcess = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			serverProcess = new ProcessBuilder("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Starbound\\win32\\starbound_server.exe").start();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void stop()
	{
		killInstances();
	}
	
	private void killInstances()
	{
		
	}
	
	private void editStarboundConfiguration()
	{
		console.info("Modifying Starbound configratuion.");
		
		starboundConfig.load();
		
		starboundConfig.set(StarboundConfig.GAME_PORT, port);
		starboundConfig.set(StarboundConfig.SERVER_NAME, serverName);
		
		JSONArray serverPasswords = new JSONArray();
		//serverPasswords.add(serverPassword);
		serverPasswords.add("");
		
		starboundConfig.set(StarboundConfig.SERVER_PASSWORDS, serverPasswords);
		
		starboundConfig.save();
	}
	
	public String generatePassword()
	{
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz1234567890";
		
		Random random = new Random();
		StringBuilder password = new StringBuilder();

		for (int c = 0; c < 30; c++) {
			password.append(chars.charAt(random.nextInt(chars.length() - 0)));
		}
		
		return password.toString();
	}
	
	private boolean isWindows()
	{
		return os.contains("win");
	}
	
	private boolean isUnix()
	{
		return os.contains("nix") || os.contains("nux") || os.contains("aix");
	}
	
	private boolean isMac()
	{
		return os.contains("mac");
	}
}
