package com.ryanprintup.starsector.util;

import com.ryanprintup.starsector.StarSector;

public final class StringUtils
{
	/**
	 * Avoid instantiation of static class
	 */
	private StringUtils()
	{
	}
	
	public static int parseInt(String text)
	{
		int number;
		
		try {
			number = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			StarSector.getServer().getConsole().error("Invalid config value, using default");
			
			number = (Integer) null;
		}
		
		return number;
	}
}
