package com.ryanprintup.starsector.exceptions;

public class InvalidFilePathException extends Exception
{
	public InvalidFilePathException()
	{
		super();
	}
	
	public InvalidFilePathException(String message)
	{
		super(message);
	}
	
	public InvalidFilePathException(Throwable throwable)
	{
		super(throwable);
	}
	
	public InvalidFilePathException(String message, Throwable throwable)
	{
		super(message, throwable);
	}
}
