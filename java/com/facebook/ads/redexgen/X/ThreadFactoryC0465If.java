package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.facebook.ads.redexgen.X.If  reason: case insensitive filesystem */
public class ThreadFactoryC0465If implements ThreadFactory {
    public final /* synthetic */ String A00;

    public ThreadFactoryC0465If(String str) {
        this.A00 = str;
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.A00);
    }
}
