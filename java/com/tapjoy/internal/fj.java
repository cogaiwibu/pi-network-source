package com.tapjoy.internal;

import java.net.URL;
import java.net.URLConnection;

public final class fj {
    private static fj a = new fj();

    public static URLConnection a(URL url) {
        return url.openConnection();
    }
}
