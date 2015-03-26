package com.ryanprintup.starsector.utils;

import java.util.Random;

public final class StringUtils
{
    private StringUtils()
    {
    }

    public static String randString(int length)
    {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz1234567890";

        Random random = new Random();
        StringBuilder string = new StringBuilder();

        for (int c = 0; c < length; c++) {
            string.append(chars.charAt(random.nextInt(chars.length())));
        }

        return string.toString();
    }
}
