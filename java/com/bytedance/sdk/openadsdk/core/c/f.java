package com.bytedance.sdk.openadsdk.core.c;

import android.text.TextUtils;

/* compiled from: Image */
public class f {
    private String a;
    private int b;
    private int c;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.a) && this.b > 0 && this.c > 0;
    }
}
