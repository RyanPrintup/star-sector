package com.ryanprintup.starsector.configuration;

public class StarSectorConfig extends Config
{
    public static final String PORT           = "serverPort";
    public static final String STARBOUND_PORT = "starboundPort";
    public static final String MAX_PLAYERS    = "maxPlayers";

    public StarSectorConfig(String path)
    {
        super(path);
    }

    protected void setDefaults()
    {
        set(PORT,           21020);
        set(STARBOUND_PORT, 21025);
        set(MAX_PLAYERS,    25);
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
