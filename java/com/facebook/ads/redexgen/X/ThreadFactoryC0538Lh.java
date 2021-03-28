package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.facebook.ads.redexgen.X.Lh  reason: case insensitive filesystem */
public final class ThreadFactoryC0538Lh implements ThreadFactory {
    public static byte[] A02;
    public int A00 = Thread.currentThread().getPriority();
    public final AtomicLong A01 = new AtomicLong();

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 103);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{94, 82, 80, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 92, 89, 78, 29, 73, 85, 79, 88, 92, 89, 16, 24, 89, 29, 24, 73, 123, 29, 24, 1, 73, 105};
    }

    private final String A00() {
        return String.format(Locale.US, A01(0, 35, 90), Long.valueOf(this.A01.incrementAndGet()), Long.valueOf(System.currentTimeMillis()));
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(null, runnable, A00(), 0);
        thread.setPriority(this.A00);
        return thread;
    }
}
