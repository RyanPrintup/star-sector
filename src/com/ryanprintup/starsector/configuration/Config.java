package com.ryanprintup.starsector.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.ryanprintup.starsector.StarSector;

public abstract class Config
{
	private File configFile;
	protected Map<String, Object> config = new HashMap<String, Object>();
	
	private DumperOptions yamlOptions = new DumperOptions();
	private Yaml yaml;
	
	public Config(File configFile)
	{
		this.configFile = configFile;
		
		yamlOptions.setIndent(2);
		yamlOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		
		yaml = new Yaml(yamlOptions);
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
			StarSector.getServer().getConsole().info("Could not find configuration file. Generating file.");
			
			generate();
		} else {
			Map data = (Map) yaml.load(configFile.getAbsolutePath());
			System.out.println(data);
		}
	}
	
	public void save()
	{
		String data = yaml.dump(config);
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(configFile, "UTF-8");
			writer.println(data);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exists()
	{
		return configFile.exists();
	}
	
	public Object getObject(String key)
	{
		return config.get(key);
	}
	
	public String getString(String key)
	{
		return (String) getObject(key);
	}
	
	public int getInt(String key)
	{
		return (int) getObject(key);
	}
	
	public double getDouble(String key)
	{
		return (double) getObject(key);
	}
}