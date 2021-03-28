package com.bytedance.sdk.adnet.b;

import android.util.Log;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

@Deprecated
/* compiled from: HTTPSTrustManager */
public class a {
    @Deprecated
    public static void a() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                /* class com.bytedance.sdk.adnet.b.a.AnonymousClass1 */

                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            HttpsURLConnection.setDefaultSSLSocketFactory(new c());
        } catch (Throwable th) {
            Log.e("HTTPSTrustManager", "allowAllSSL error: ", th);
        }
    }
}
