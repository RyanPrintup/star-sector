package com.ryanprintup.starsector.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.ryanprintup.starsector.util.StringUtils;

public class Config {
	
	private static final File configFile = new File("star_sector.config");
	private final Properties config = new Properties();
	
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
			config.setProperty("server-name", ConfigDefaults.SERVER_NAME.getValue());
			rewrite = true;
		} else {
			config.setProperty("server-name", config.getProperty("server-name"));
		}
		
		if (config.getProperty("console-name") == null) {
			config.setProperty("console-name", ConfigDefaults.CONSOLE_NAME.getValue());
			rewrite = true;
		} else {
			config.setProperty("console-name", config.getProperty("console-name"));
		}
		
		if (config.getProperty("star-sector-port") == null) {
			config.setProperty("star-sector-port", ConfigDefaults.SERVER_PORT.getValue());
			rewrite = true;
		} else {
			config.setProperty("star-sector-port", config.getProperty("star-sector-port"));
		}
		
		if (config.getProperty("starbound-port") == null) {
			config.setProperty("starbound-port", ConfigDefaults.STARBOUND_PORT.getValue());
			rewrite = true;
		} else {
			config.setProperty("starbound-port", config.getProperty("starbound-port"));
		}
		
		if (config.getProperty("max-clients") == null) {
			config.setProperty("max-clients", ConfigDefaults.MAX_CLIENTS.getValue());
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
		
		serverPort = StringUtils.parseInt(config.getProperty("star-sector-port"));
		starboundPort = StringUtils.parseInt(config.getProperty("starbound-port"));
		maxClients = StringUtils.parseInt(config.getProperty("max-clients"));
	}
	
	public void generate() throws IOException
	{
		config.setProperty("server-name", ConfigDefaults.SERVER_NAME.getValue());
		config.setProperty("console-name", ConfigDefaults.CONSOLE_NAME.getValue());
		config.setProperty("motd", ConfigDefaults.MOTD.getValue());
		config.setProperty("star-sector-port", ConfigDefaults.SERVER_PORT.getValue());
		config.setProperty("starbound-port", ConfigDefaults.STARBOUND_PORT.getValue());
		config.setProperty("max-clients", ConfigDefaults.MAX_CLIENTS.getValue());
		
		config.store(new FileOutputStream(configFile), null);
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
