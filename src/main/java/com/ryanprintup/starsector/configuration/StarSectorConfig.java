package com.ryanprintup.starsector.configuration;

public class StarSectorConfig extends Config
{
    public static final String SERVER_NAME    = "serverName";
    public static final String PORT           = "serverPort";
    public static final String STARBOUND_PORT = "starboundPort";
    public static final String MAX_PLAYERS    = "maxPlayers";

    public StarSectorConfig(String path)
    {
        super(path);
    }

    protected void setDefaults()
    {
        set(SERVER_NAME,    "Star Sector");
        set(PORT,           21020);
        set(STARBOUND_PORT, 21025);
        set(MAX_PLAYERS,    25);
    }

    public void setServerName(String value)
    {
        set(SERVER_NAME, value);
    }

    public void setPort(int value)
    {
        set(PORT, value);
    }

    public void setStarboundPort(int value)
    {
        set(STARBOUND_PORT, value);
    }

    public void setMaxPlayers(int value)
    {
        set(MAX_PLAYERS, value);
    }

    public String getServerName()
    {
        return getString(SERVER_NAME);
    }

    public int getPort()
    {
        return getInt(PORT);
    }

    public int getStarboundPort()
    {
        return getInt(STARBOUND_PORT);
    }

    public int getMaxPlayers()
    {
        return getInt(MAX_PLAYERS);
    }
}
