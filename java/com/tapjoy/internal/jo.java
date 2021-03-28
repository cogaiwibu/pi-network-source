package com.tapjoy.internal;

import javax.annotation.Nullable;

public final class jo {
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object b(@Nullable Object obj, @Nullable Object obj2) {
        return obj != null ? obj : jp.a(obj2);
    }
}
