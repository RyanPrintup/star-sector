package com.ryanprintup.starsector;

/**
 * Core class of the software that handles
 * Singleton instance of the server class
 * and software version.
 */
public final class StarSector
{
    public static final String MAJOR_VERSION = "0";
    public static final String MINOR_VERSION = "1";
    public static final String PATCH_VERSION = "0";
    public static final String DEV_VERSION   = "A";
    public static final String VERSION       = MAJOR_VERSION + "." +
                                               MINOR_VERSION + "." +
                                               PATCH_VERSION + " " +
                                               DEV_VERSION;

    public static final String STARBOUND_VERSION = "Upbeat Giraffe";
    public static final String STARBOUND_BRANCH  = "Stable";

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
			throw new UnsupportedOperationException("Cannot redefine singleton server instance.");
		}
		
		StarSector.server = server;
	}

	public static Server getServer()
	{
		return server;
	}
}
