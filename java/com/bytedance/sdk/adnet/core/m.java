package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;

/* compiled from: Response */
public class m<T> {
    public final T a;
    public final a.C0003a b;
    public final VAdError c;
    public boolean d;
    public long e;
    public long f;

    /* compiled from: Response */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    public static <T> m<T> a(T t, a.C0003a aVar) {
        return new m<>(t, aVar);
    }

    public static <T> m<T> a(VAdError vAdError) {
        return new m<>(vAdError);
    }

    public boolean a() {
        return this.c == null;
    }

    private m(T t, a.C0003a aVar) {
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    private m(VAdError vAdError) {
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.a = null;
        this.b = null;
        this.c = vAdError;
    }
}
