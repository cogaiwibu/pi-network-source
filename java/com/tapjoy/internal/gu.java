package com.tapjoy.internal;

public final class gu {
    public static String a(String str) {
        String trim;
        if (str == null || str.length() == 0 || (trim = str.trim()) == null || trim.length() == 0) {
            return null;
        }
        return trim;
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    public static String a(String str, String str2, String str3) {
        if (str == null) {
            gw.a(str2, str3, "must not be null");
            return null;
        } else if (str.length() == 0) {
            gw.a(str2, str3, "must not be empty");
            return null;
        } else {
            String trim = str.trim();
            if (trim.length() != 0) {
                return trim;
            }
            gw.a(str2, str3, "must not be blank");
            return null;
        }
    }
}
