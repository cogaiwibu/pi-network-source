package com.tapjoy;

import android.net.Uri;

public class TapjoyUrlFormatter {
    public static String getDomain(String str) {
        String host = Uri.parse(str).getHost();
        if (host != null) {
            str = host;
        }
        return str.replace("www.", "");
    }
}
