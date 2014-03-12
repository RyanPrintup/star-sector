package com.ryanprintup.starsector.starbound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.ryanprintup.starsector.Server;
import com.ryanprintup.starsector.util.Config;
import com.ryanprintup.starsector.util.Console;

public class StarboundServer
{
	private final String os = System.getProperty("os.name").toLowerCase();
	private static final File config = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Starbound\\starbound.config");
	
	private Console console = Console.getInstance();
	private Server server = Config.getServerInstance();
	
	private int port = server.getConfig().getStarboundPort();
	private Process serverProcess;
	
	public boolean start()
	{
		editStarboundPort();
		
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
	
	private void editStarboundPort()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(config));
			StringBuilder sb = new StringBuilder();
			
			String line = br.readLine();
			while (line != null) {
				if (line.contains("gamePort")) {
					sb.append("  \"gamePort\" : " + port + ",\r\n");
				} else {
					sb.append(line + "\r\n");
				}
				
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
