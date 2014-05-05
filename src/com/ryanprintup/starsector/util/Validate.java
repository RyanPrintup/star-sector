package com.ryanprintup.starsector.util;

import java.io.File;

import com.ryanprintup.starsector.exceptions.InvalidFilePathException;

public final class Validate
{
	/**
	 * Avoid instantiation of static class
	 */
	private Validate()
	{
	}
	
	public void validFilePath(File file) throws InvalidFilePathException
	{
		if (file.exists()) {
			
		}
	}
}
