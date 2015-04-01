package com.ryanprintup.starsector.utils;

import java.io.IOException;

public class SystemUtils
{
    private static final String OS = System.getProperty("os.name").toLowerCase();

    private SystemUtils()
    {
    }

    public static boolean startProcess(String path)
    {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(path);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean isWin()
    {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac()
    {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix()
    {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0);
    }
}
