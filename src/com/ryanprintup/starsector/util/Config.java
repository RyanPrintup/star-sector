package com.ryanprintup.starsector.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.ryanprintup.starsector.Server;

public class Config {
	
	private static final File configFile = new File("star_sector.config");
	private final Properties config = new Properties();
	
	private static final String SERVER_NAME_DEFAULT = "Star Sector Server";
	private static final String CONSOLE_NAME_DEFAULT = "Console";
	private static final String MOTD_DEFAULT = "Welcome to a Star Sector Server!";
	private static final String SERVER_PORT_DEFAULT = "21025";
	private static final String STARBOUND_PORT_DEFAULT = "21020";
	private static final String MAX_CLIENTS_DEFAULT = "20";
	
	private static Server server;
	
	private String serverName;
	private String consoleName;
	private String motd;
	private int serverPort;
	private int starboundPort;
	private int maxClients;
	
	public boolean exists()
	{
		return configFile.exists();
	}
	
	private void check() throws IOException
	{
		boolean rewrite = false;
		
		if (config.getProperty("server-name") == null) {
			config.setProperty("server-name", SERVER_NAME_DEFAULT);
			rewrite = true;
		} else {
			config.setProperty("server-name", config.getProperty("server-name"));
		}
		
		if (config.getProperty("console-name") == null) {
			config.setProperty("console-name", CONSOLE_NAME_DEFAULT);
			rewrite = true;
		} else {
			config.setProperty("console-name", config.getProperty("console-name"));
		}
		
		if (config.getProperty("star-sector-port") == null) {
			config.setProperty("star-sector-port", SERVER_PORT_DEFAULT);
			rewrite = true;
		} else {
			config.setProperty("star-sector-port", config.getProperty("star-sector-port"));
		}
		
		if (config.getProperty("starbound-port") == null) {
			config.setProperty("starbound-port", STARBOUND_PORT_DEFAULT);
			rewrite = true;
		} else {
			config.setProperty("starbound-port", config.getProperty("starbound-port"));
		}
		
		if (config.getProperty("max-clients") == null) {
			config.setProperty("max-clients", MAX_CLIENTS_DEFAULT);
			rewrite = true;
		} else {
			config.setProperty("max-clients", config.getProperty("max-clients"));
		}
		
		if (rewrite) {
			config.store(new FileOutputStream(configFile), null);
		}
	}
	
	public void load() throws IOException, NumberFormatException
	{
		if (!exists()) {
			generate();
		} else {
			check();
		}
		
		config.load(new FileInputStream(configFile));
		
		serverName = config.getProperty("server-name");
		consoleName = config.getProperty("console-name");
		motd = config.getProperty("motd");
		
		serverPort = Integer.parseInt(config.getProperty("star-sector-port"));
		starboundPort = Integer.parseInt(config.getProperty("starbound-port"));
		maxClients = Integer.parseInt(config.getProperty("max-clients"));
	}
	
	public void generate() throws IOException
	{
		config.setProperty("server-name", SERVER_NAME_DEFAULT);
		config.setProperty("console-name", CONSOLE_NAME_DEFAULT);
		config.setProperty("motd", MOTD_DEFAULT);
		config.setProperty("star-sector-port", SERVER_PORT_DEFAULT);
		config.setProperty("starbound-port", STARBOUND_PORT_DEFAULT);
		config.setProperty("max-clients", MAX_CLIENTS_DEFAULT);
		
		config.store(new FileOutputStream(configFile), null);
	}
	
	public void setServerInstance(Server server)
	{
		this.server = server;
	}
	
	public static Server getServerInstance()
	{
		return server;
	}
	
	public String getServerName()
	{
		return serverName;
	}
	
	public String getConsoleName()
	{
		return consoleName;
	}
	
	public String getMotd() {
		return motd;
	}
	
	public int getServerPort() {
		return serverPort;
	}
	
	public int getStarboundPort() {
		return starboundPort;
	}
	
	public int getMaxClients() {
		return maxClients;
	}
}
