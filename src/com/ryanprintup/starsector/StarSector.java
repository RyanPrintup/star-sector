package com.ryanprintup.starsector;


/**
 * Core class of the software that handles
 * Singleton instance of the server class
 * and software version.
 */
public final class StarSector
{
	private static final String STAR_SECTOR_VERSION = "1.0.0";
	private static Server server;
	
	/**
	 * Avoid instantiation of a static class
	 */
	private StarSector()
	{
	}
	
	public static Server getServer()
	{
		if (server == null) {
			server = new Server();
		}
		
		return server;
	}
	
	public static String getVersion()
	{
		return STAR_SECTOR_VERSION;
	}
}
