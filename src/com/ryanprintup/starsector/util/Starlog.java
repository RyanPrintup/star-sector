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
	private LocalTime time;
	
	private final File logDir;
	private final File log;
	private BufferedWriter out;
	
	public Starlog() {
		this.dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
		this.timeFormat = DateTimeFormat.forPattern("HH:mm:ss");
		this.out = null;
		
		String fileDate = getDate();
		this.logDir = new File("logs");
		this.log = new File("logs/" + "log(" + fileDate + ").txt");
		this.logDir.mkdir(); // to create dir in case of absence
		
		try {
			checkForLog(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void info(String msg) {
		String to_log = getDate() + " " + getTime() + " INFO: " + msg;
		writeToLog(to_log);
	} 
	
	public void warn(String msg) {
		String to_log = getDate() + " " + getTime() + " WARN: " + msg;
		writeToLog(to_log);
	}
	
	public void error(String msg) {
		String to_log = getDate() + " " + getTime() + " ERROR: " + msg;
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
		if (!this.log.exists()) {
			this.log.createNewFile();
		}
	}
	
	private String getDate() {
		date = new LocalDate();
		return dateFormat.print(date);
	}
	
	private String getTime() {
		time = new LocalTime();
		return timeFormat.print(time);
	}
}
