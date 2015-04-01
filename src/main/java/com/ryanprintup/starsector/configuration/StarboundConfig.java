package com.ryanprintup.starsector.configuration;

public class StarboundConfig extends Config
{
    public static final String PORT             = "gameServerPort";
    public static final String SERVER_NAME      = "serverName";
    public static final String MAX_PLAYERS      = "maxPlayers";

    public StarboundConfig(String path)
    {
        super(path);
    }

    protected void setDefaults()
    {
        set(PORT,             21025);
        set(SERVER_NAME,      "Star Sector Server");
        set(MAX_PLAYERS,      25);
    }

    public void setPort(int value)
    {
        set(PORT, value);
    }

    public void setServerName(String value)
    {
        set(SERVER_NAME, value);
    }

    public void setMaxPlayers(int value)
    {
        set(MAX_PLAYERS, value);
    }

    public int getPort()
    {
        return getInt(PORT);
    }

    public String getServerName()
    {
        return getString(SERVER_NAME);
    }

    public int getMaxPlayers()
    {
        return getInt(MAX_PLAYERS);
    }
}
