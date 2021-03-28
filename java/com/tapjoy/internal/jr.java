package com.tapjoy.internal;

import javax.annotation.Nullable;

public final class jr {
    private static void a(@Nullable Throwable th, Class cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static RuntimeException a(Throwable th) {
        Throwable th2 = (Throwable) jp.a(th);
        a(th2, Error.class);
        a(th2, RuntimeException.class);
        throw new RuntimeException(th);
    }
}
