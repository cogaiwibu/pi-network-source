package com.bytedance.sdk.openadsdk.core.c;

import org.json.JSONObject;

/* compiled from: ClickEventModel */
public class c {
    private final int[] a;
    private final int[] b;
    private final int[] c;
    private final int[] d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final long i;
    private final long j;
    private final int k;
    private final int l;
    private final int m;

    private c(a aVar) {
        this.a = aVar.h;
        this.b = aVar.i;
        this.d = aVar.j;
        this.c = aVar.g;
        this.e = aVar.f;
        this.f = aVar.e;
        this.g = aVar.d;
        this.h = aVar.c;
        this.i = aVar.b;
        this.j = aVar.a;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a != null && this.a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.a[0])).putOpt("ad_y", Integer.valueOf(this.a[1]));
            }
            if (this.b != null && this.b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.b[0])).putOpt("height", Integer.valueOf(this.b[1]));
            }
            if (this.c != null && this.c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.c[0])).putOpt("button_y", Integer.valueOf(this.c[1]));
            }
            if (this.d != null && this.d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.d[0])).putOpt("button_height", Integer.valueOf(this.d[1]));
            }
            jSONObject.putOpt("down_x", Integer.valueOf(this.e)).putOpt("down_y", Integer.valueOf(this.f)).putOpt("up_x", Integer.valueOf(this.g)).putOpt("up_y", Integer.valueOf(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* compiled from: ClickEventModel */
    public static class a {
        private long a;
        private long b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int[] g;
        private int[] h;
        private int[] i;
        private int[] j;
        private int k;
        private int l;
        private int m;

        public a a(long j2) {
            this.a = j2;
            return this;
        }

        public a b(long j2) {
            this.b = j2;
            return this;
        }

        public a a(int i2) {
            this.c = i2;
            return this;
        }

        public a b(int i2) {
            this.d = i2;
            return this;
        }

        public a c(int i2) {
            this.e = i2;
            return this;
        }

        public a d(int i2) {
            this.f = i2;
            return this;
        }

        public a a(int[] iArr) {
            this.g = iArr;
            return this;
        }

        public a b(int[] iArr) {
            this.h = iArr;
            return this;
        }

        public a c(int[] iArr) {
            this.i = iArr;
            return this;
        }

        public a d(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public a e(int i2) {
            this.k = i2;
            return this;
        }

        public a f(int i2) {
            this.l = i2;
            return this;
        }

        public a g(int i2) {
            this.m = i2;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
