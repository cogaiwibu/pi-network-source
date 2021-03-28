package com.ironsource.environment;

import java.util.Locale;

public class StringUtils {
    public static String toUpperCase(String str) {
        return str.toUpperCase(Locale.ENGLISH);
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }
}
