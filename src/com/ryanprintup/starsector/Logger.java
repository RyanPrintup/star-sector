package com.ryanprintup.starsector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ryanprintup.starsector.configuration.StarSectorConfig;
import com.ryanprintup.starsector.util.Validate;

public class Logger
{
	private static final DateFormat dateFormat = new SimpleDateFormat(StarSector.getServer().getConfig().getString(StarSectorConfig.DATE_FORMAT));
	
	private boolean directory = false;
	
	private File logDirectory;
	private File logFile;
	private BufferedWriter writer;
	
	public Logger(File logFile)
	{
		this(new File(""), logFile);
	}
	
	public Logger(File logDirectory, File logFile)
	{
		this.logDirectory = logDirectory;
		
		if (!Validate.isNull(logDirectory) || !Validate.isEmpty(logDirectory)) {
			directory = true;
			this.logFile = new File(logDirectory.getPath() + "/" + logFile.getPath());
		} else {
			this.logFile = logFile;
		}
	}
	
	private void checkFile() throws IOException
	{	
		if (directory && !logDirectory.exists()) {
			logDirectory.mkdir();
		}
		
		if (!logFile.exists()) {
			logFile.createNewFile();
		}
	}
	
	public void log(String log)
	{
		String timestamp = "[" + dateFormat.format(new Date()) + "] ";
		
		try {
			checkFile();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			writer = new BufferedWriter(new FileWriter(logFile, true));
			
			writer.write(timestamp+ log + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
