package com.ryanprintup.starsector.exceptions;

/**
 * The general exception for when something
 * goes wrong in Star Sector
 */
public class StarSectorException extends Exception
{
	public StarSectorException()
	{
		super();
	}

	public StarSectorException(String message)
	{
		super(message);
	}
	
	public StarSectorException(Throwable throwable)
	{
		super(throwable);
	}
	
	public StarSectorException(String message, Throwable throwable)
	{
		super(message, throwable);
	}
}
