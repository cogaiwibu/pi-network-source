package com.bytedance.sdk.openadsdk.h;

/* compiled from: ProxyCacheException */
public class n extends Exception {
    public n(String str) {
        super(str + ". Version: ");
    }

    public n(String str, Throwable th) {
        super(str + ". Version: ", th);
    }
}
