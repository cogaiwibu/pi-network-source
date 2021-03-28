package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

abstract class gc {
    private static final gc a;
    private static gc b;

    public abstract Object a(Context context, String str, TJPlacementListener tJPlacementListener);

    gc() {
    }

    static {
        gd gdVar = new gd();
        a = gdVar;
        b = gdVar;
    }

    static gc a() {
        return b;
    }
}
