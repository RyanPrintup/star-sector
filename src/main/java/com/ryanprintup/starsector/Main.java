package com.ryanprintup.starsector;

import com.ryanprintup.starsector.configuration.StarSectorConfig;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
        StarSectorConfig config = new StarSectorConfig("starsector.config");
        try {
            config.load();
            System.out.println(config.getMaxPlayers() + " " + config.getPort());
        } catch (IOException | ParseException e) {

        }
        // new Server().start();
	}
}