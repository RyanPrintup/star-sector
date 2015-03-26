package com.ryanprintup.starsector.configuration;

public class StarboundConfig extends Config
{
    public static final String PORT             = "gameServerPort";
    public static final String SERVER_NAME      = "serverName";
    public static final String MAX_PLAYERS      = "maxPlayers";
    public static final String SERVER_PASSWORDS = "serverPasswords";

    public StarboundConfig(String path)
    {
        super(path);
    }

    protected void setDefaults()
    {
        set(PORT,             21025);
        set(SERVER_NAME,      "Star Sector Server");
        set(MAX_PLAYERS,      25);
        set(SERVER_PASSWORDS, null);
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

    public String getServerPasswords()
    {
        return getString(SERVER_PASSWORDS);
    }
}
