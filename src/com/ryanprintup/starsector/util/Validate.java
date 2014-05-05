package com.ryanprintup.starsector.util;


public final class Validate
{
	/**
	 * Avoid instantiation of static class
	 */
	private Validate()
	{
	}
	
	public static <T> boolean isNull(T field)
	{
		if (field == null) {
			return true;
		}
		
		return false;
	}
}
