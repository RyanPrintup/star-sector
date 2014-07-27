package com.ryanprintup.starsector.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONWriter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ryanprintup.starsector.StarSector;

public abstract class Config
{
	private File configFile;
	private JSONObject config = new JSONObject();
	
	private JSONParser parser = new JSONParser();
	
	public Config(File configFile)
	{
		this.configFile = configFile;
	}
	
	protected abstract void setDefaults();
	
	private void generate()
	{
		config.clear();
		setDefaults();
		save();
	}
	
	public void load()
	{
		config.clear();
		
		if (!configFile.exists()) {
			StarSector.getServer().getConsole().info("Could not find configuration file " + configFile.getAbsolutePath() + ". Generating file.");
			
			generate();
		} else {
			try {
				config = (JSONObject) parser.parse(new FileReader(configFile));
			} catch (IOException | ParseException e) {
				StarSector.getServer().getConsole().error("Could not load config file " + configFile.getAbsolutePath() + " : " + e.getMessage());
			}
		}
	}

	public void save()
	{
		try {
			FileWriter writer = new FileWriter(configFile);
			
			JSONWriter out = new JSONWriter();
			config.writeJSONString(out);
			
			writer.write(out.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exists()
	{
		return configFile.exists();
	}
	
	public void set(String key, Object value)
	{
		config.put(key, value);
	}
	
	public Object getObject(String key)
	{
		return (Object) config.get(key);
	}
	
	public String getString(String key)
	{
		return (String) getObject(key);
	}
	
	public int getInt(String key)
	{
		return (int) getObject(key);
	}
	
	public boolean getBoolean(String key)
	{
		return (boolean) getObject(key);
	}
	
	public double getDouble(String key)
	{
		return (double) getObject(key);
	}
	
	public float getFloat(String key)
	{
		return (float) getObject(key);
	}
}