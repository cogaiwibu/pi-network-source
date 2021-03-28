package com.tapjoy.internal;

import android.text.TextUtils;

/* renamed from: com.tapjoy.internal.do  reason: invalid class name */
public final class Cdo {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(cz czVar) {
        if (czVar.e) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void b(cz czVar) {
        if (czVar.d) {
            a(czVar);
            return;
        }
        throw new IllegalStateException("AdSession is not started");
    }
}
