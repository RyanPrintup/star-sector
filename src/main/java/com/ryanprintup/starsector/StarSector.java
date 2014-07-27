package com.ryanprintup.starsector;


/**
 * Core class of the software that handles
 * Singleton instance of the server class
 * and software version.
 */
public final class StarSector
{
	private static final String STAR_SECTOR_VERSION = "0.1.0 A";
	private static Server server;
	
	/**
	 * Avoid instantiation of a static class
	 */
	private StarSector()
	{
	}
	
	public static void setServer(Server server)
	{
		if (StarSector.server != null) {
			throw new UnsupportedOperationException("Cannot redifine singleton server instance.");
		}
		
		StarSector.server = server;
	}
	public static Server getServer()
	{
		return server;
	}
	
	public static String getVersion()
	{
		return STAR_SECTOR_VERSION;
	}
}
