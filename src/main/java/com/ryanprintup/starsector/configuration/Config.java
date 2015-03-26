package com.ryanprintup.starsector.configuration;

import com.ryanprintup.starsector.StarSector;
import org.json.simple.JSONObject;
import org.json.simple.JSONWriter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Config
{
    protected String path;

    private JSONObject config = new JSONObject();
    private JSONParser parser = new JSONParser();

    public Config(String path)
    {
        this.path = path;
    }

    public void create()
    {
        config.clear();
        setDefaults();

        try {
            save();
        } catch (IOException e) {
            StarSector.getServer().getConsole().error("Could not create configuration file. Error: " + e);
        }
    }

    protected abstract void setDefaults();

    public void load() throws IOException, ParseException
    {
        File configFile = new File(path);

        if (!exists()) {
            StarSector.getServer().getConsole().error("Could not find configuration file " + configFile.getAbsolutePath() + ".");
        } else {
            config = (JSONObject) parser.parse(new FileReader(configFile));
        }
    }

    public void save() throws IOException
    {
        File configFile = new File(path);
        FileWriter writer = new FileWriter(configFile);
        JSONWriter out = new JSONWriter();

        config.writeJSONString(out);

        writer.write(out.toString());
        writer.flush();
        writer.close();
    }

    public boolean exists()
    {
        return new File(path).exists();
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
        return (String) config.get(key);
    }

    public int getInt(String key) {
        return (int) config.get(key);
    }

    public boolean getBoolean(String key)
    {
        return (boolean) config.get(key);
    }

    public double getDouble(String key)
    {
        return (double) config.get(key);
    }

    public float getFloat(String key)
    {
        return (float) config.get(key);
    }
}
