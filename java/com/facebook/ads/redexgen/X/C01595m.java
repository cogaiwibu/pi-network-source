package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* renamed from: com.facebook.ads.redexgen.X.5m  reason: invalid class name and case insensitive filesystem */
public final class C01595m {
    @Nullable
    public static Object A00(@Nullable Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static Method A01(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Multiple debug info for r0v2 java.lang.Class<?>: [D('clazz' java.lang.Class<?>), D('parameterTypes' java.lang.Class<?>[])] */
    @Nullable
    public static Method A02(String str, String str2, Class<?>... clsArr) {
        try {
            return A01(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
