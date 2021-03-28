package com.bytedance.sdk.openadsdk.b;

/* compiled from: AdEventUploadResult */
public class h {
    final boolean a;
    final int b;
    final String c;
    final boolean d;

    public h(boolean z, int i, String str, boolean z2) {
        this.a = z;
        this.b = i;
        this.c = str;
        this.d = z2;
    }

    public String toString() {
        return "AdEventUploadResult{mSuccess=" + this.a + ", mStatusCode=" + this.b + ", mMsg='" + this.c + '\'' + ", mIsDataError=" + this.d + '}';
    }
}
