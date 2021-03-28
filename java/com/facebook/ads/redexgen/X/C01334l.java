package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.facebook.ads.redexgen.X.4l  reason: invalid class name and case insensitive filesystem */
public class C01334l implements InvocationHandler {
    public final /* synthetic */ ClassLoader A00;

    public C01334l(ClassLoader classLoader) {
        this.A00 = classLoader;
    }

    @Override // java.lang.reflect.InvocationHandler
    @Nullable
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return C01344m.A00(this.A00, method);
    }
}
