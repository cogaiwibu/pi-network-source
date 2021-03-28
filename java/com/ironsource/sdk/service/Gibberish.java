package com.ironsource.sdk.service;

import android.util.Base64;

public class Gibberish {
    static String encode(String str) {
        return Base64.encodeToString(str.getBytes(), 10);
    }

    public static String decode(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
