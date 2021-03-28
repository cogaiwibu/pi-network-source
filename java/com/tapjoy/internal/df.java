package com.tapjoy.internal;

import android.content.Context;

public final class df {
    private static df b = new df();
    public Context a;

    private df() {
    }

    public static df a() {
        return b;
    }
}
