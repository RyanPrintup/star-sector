package com.ryanprintup.starsector.starbound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import com.ryanprintup.starsector.Server;
import com.ryanprintup.starsector.StarSector;
import com.ryanprintup.starsector.util.Console;

public class StarboundServer
{
	private final String os = System.getProperty("os.name").toLowerCase();
	private static final File config = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Starbound\\starbound.config");
	
	private Server server = StarSector.getServer();
	private Console console = server.getConsole();
	
	private int port;
	private String serverName;
	
	// Used to avoid connecting directly to the Starbound server and bypassing Star Sector
	private String serverPassword;
	
	private Process serverProcess;
	
	public boolean start()
	{
		port = server.getConfig().getStarboundPort();
		serverName = server.getConfig().getServerName();
		serverPassword = generatePassword();
		
		editStarboundSettings();
		
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
		}*/
		
		try {
			serverProcess = new ProcessBuilder("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Starbound\\win32\\starbound_server.exe").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void stop()
	{
		killInstances();
	}
	
	private void killInstances()
	{
		
	}
	
	private void editStarboundSettings()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(config));
			StringBuilder sb = new StringBuilder();
			
			String line = br.readLine();
			while (line != null) {
				if (line.contains("gamePort")) {
					sb.append("  \"gamePort\" : " + port + ",");
				} else if (line.contains("serverName")) {
					sb.append("  \"serverName\" : \"" + serverName + "\",");
				} else if (line.contains("serverPasswords")) {
					//sb.append("  \"serverPasswords\" : [ \"" + serverPassword + "\" ],");
				} else {
					sb.append(line);
				}
				
				sb.append("\r\n");
				line = br.readLine();
			}
			
			br.close();
			PrintWriter pw = new PrintWriter(config);
			pw.write(sb.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void setPort(int port)
	{
		this.port = port;
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
