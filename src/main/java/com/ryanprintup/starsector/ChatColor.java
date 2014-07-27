package com.ryanprintup.starsector;

/**
 * Star Sector's default list of chat colors
 * to be used by plugin and command authors.
 * 
 * Based on HTML 4.01 specifications.
 */
public enum ChatColor
{
	WHITE("^#FFFFFF;"),
	SILVER("^#C0C0C0"),
	GRAY("^#808080;"),
	BLACK("^#000000;"),
	RED("^#FF0000;"),
	MAROON("^#800000;"),
	YELLOW("^#FFFF00;"),
	OLIVE("^#808000;"),
	LIME("^#00FF00;"),
	GREEN("^#008000;"),
	AQUA("^#00FFFF;"),
	TEAL("^#008080;"),
	BLUE("^#0000FF;"),
	NAVY("^#000080;"),
	FUCHSIA("^#FF00FF;"),
	PURPLE("^#800080;");
	
	private final String hexCode;
	
	private ChatColor(String hexCode)
	{
		this.hexCode = hexCode;
	}
	
	public String getHexCode()
	{
		return hexCode;
	}
	
	@Override
	public String toString()
	{
		return hexCode;
	}
}
