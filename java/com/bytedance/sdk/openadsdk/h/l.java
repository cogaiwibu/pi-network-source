package com.bytedance.sdk.openadsdk.h;

/* compiled from: Preconditions */
public final class l {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw null;
            }
        }
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
