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
	
	public static <T> boolean isEmpty(T field)
	{
		if (!isNull(field)) {
			if (field instanceof String && field.equals("") || field == "") {
				return true;
			}
		}
		
		return true;
	}
}
