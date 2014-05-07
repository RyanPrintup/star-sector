import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public final class Starlog {
	private final DateTimeFormatter dateFormat;
	private final DateTimeFormatter timeFormat;
	private LocalDate date;
	private LocalDate nextDateLog;
	private LocalTime time;
	
	private final File logDir;
	private File log;
	private BufferedWriter out;
	
	public Starlog() {
		this.dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
		this.timeFormat = DateTimeFormat.forPattern("HH:mm:ss");
		this.nextDateLog = new LocalDate().plusDays(1);
		
		this.out = null;
		this.logDir = new File("logs");
		this.log = new File("logs/" + "log(" + getDate() + ").txt");
		this.logDir.mkdir(); // Create directory in case of absence
		
		try {
			// Create a log if we don't have one
			checkForLog(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	 /* If the date changes while Starlog is logging, 
	  * we do not want it to log into the wrong date */
	public void checkIfNextDate() {
		LocalDate currentDateLog = new LocalDate();
		
		if (currentDateLog.isEqual(nextDateLog)) {
			log = new File("logs/" + "log(" + dateFormat.print(nextDateLog) + ").txt");
			
			try {
				checkForLog(log);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				nextDateLog = new LocalDate().plusDays(1);
			}
		}
	}
	
	public void info(String msg) {
		String to_log = getTime() + " INFO: " + msg;
		writeToLog(to_log);
	} 
	
	public void warn(String msg) {
		String to_log = getTime() + " WARN: " + msg;
		writeToLog(to_log);
	}
	
	public void error(String msg) {
		String to_log = getTime() + " ERROR: " + msg;
		writeToLog(to_log);
	}
	
	private void writeToLog(String msg) {
		try {
			out = new BufferedWriter(new FileWriter(log, true));
			out.write(msg + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkForLog(File log) throws IOException {
		if (!log.exists()) {
			log.createNewFile();
		}
	}
	
	private String getDate() {
		checkIfNextDate();
		
		date = new LocalDate();
		return dateFormat.print(date);
	}
	
	private String getTime() {
		checkIfNextDate();
		
		time = new LocalTime();
		return timeFormat.print(time);
	}
}