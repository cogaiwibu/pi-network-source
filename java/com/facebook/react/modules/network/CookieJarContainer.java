package com.facebook.react.modules.network;

import okhttp3.CookieJar;

public interface CookieJarContainer extends CookieJar {
    void removeCookieJar();

    void setCookieJar(CookieJar cookieJar);
}
