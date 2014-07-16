package com.ryanprintup.starsector.util;

public final class Validate
{
	/**
	 * Avoid instantiation of a static class
	 */
	private Validate()
	{
	}
	
	public static <T> boolean isNull(T field)
	{
		return field == null;
	}
	
	public static <T> boolean isEmpty(T field)
	{
		if (!isNull(field)) {
			return (field instanceof String && field.equals("")) || field == "";
		}
		
		return true;
	}
}
