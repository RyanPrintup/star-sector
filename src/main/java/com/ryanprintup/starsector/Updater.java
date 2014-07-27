package com.ryanprintup.starsector;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Updater
{
	private static final String versionUrl = "http://www.ryanprintup.com/star-sector-version.txt";
	
	public void check() {
		try {
			URL url = new URL(versionUrl);
			Scanner scanner = new Scanner(url.openStream());
			
			if (!scanner.hasNext()) {
				throw new IOException("Could not get version from website."); 
			}
			
			String version = scanner.nextLine();
			
			if (version.equals(StarSector.getVersion())) {
				StarSector.getServer().getConsole().info("Star Sector is up-to-date.");
			} else {
				StarSector.getServer().getConsole().warn("Your Star Sector version is outdated. Download the latest version on the Starbound Forums.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
