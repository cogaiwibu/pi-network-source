package com.tapjoy.internal;

import java.net.URL;

public final class cy {
    public final String a;
    public final URL b;
    public final String c;

    private cy(String str, URL url, String str2) {
        this.a = str;
        this.b = url;
        this.c = str2;
    }

    public static cy a(String str, URL url, String str2) {
        Cdo.a(str, "VendorKey is null or empty");
        Cdo.a(url, "ResourceURL is null");
        Cdo.a(str2, "VerificationParameters is null or empty");
        return new cy(str, url, str2);
    }

    public static cy a(URL url) {
        Cdo.a(url, "ResourceURL is null");
        return new cy(null, url, null);
    }
}
