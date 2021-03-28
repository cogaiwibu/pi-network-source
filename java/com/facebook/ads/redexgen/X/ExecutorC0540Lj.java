package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Lj  reason: case insensitive filesystem */
public final class ExecutorC0540Lj implements Executor {
    public static int A03 = 32;
    public static byte[] A04;
    public static String[] A05;
    public static final Executor A06 = new ExecutorC0540Lj(A00(0, 5, 91), 0);
    public static final Executor A07 = new ExecutorC0540Lj(A00(5, 2, 3), 0);
    public static final Executor A08 = new ExecutorC0540Lj(A00(7, 7, 8), 0);
    public static final Executor A09 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public static final ExecutorService A0A = Executors.newCachedThreadPool(new ThreadFactoryC0538Lh());
    public static final ExecutorService A0B = Executors.newFixedThreadPool(5);
    public static final ExecutorService A0C = Executors.newSingleThreadExecutor();
    public static final AtomicBoolean A0D = new AtomicBoolean();
    public static final AtomicBoolean A0E = new AtomicBoolean();
    @Nullable
    public Executor A00;
    public ThreadPoolExecutor A01;
    public final int A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{32, 50, 56, 47, 34, 125, 123, 124, 119, 102, 101, 125, 96, 121, 112, 74, 89, 70, 3, 30, 3, 64, 117, 103, ByteCompanionObject.MAX_VALUE, 103, 52, 101, 97, 113, 97, 113, 52, 96, 123, 123, 52, 120, 123, 122, 115, 58, 70, 68, 79, 68, 83, 72, 66};
    }

    public static void A05() {
        A05 = new String[]{"dqRa11pwCIxD9G", "Prl4kldBaiKkX", "x63WXgOLaV3", "ISgeAY0wdrDCT1ale0N91K8aXfWfv0tW", "LCKhovWaUpSA3noBlHvNtEEMnkYTagBf", "4iBL7X4rSmnE5Q6mVAm5IE9McxSQzo1J", "Gaojjwe04e5jqq3nowZJFAyYK", "ekobvqODjhkADWqsAO3q6OJDBrcRvo3h"};
    }

    static {
        A05();
        A04();
    }

    @VisibleForTesting
    public ExecutorC0540Lj(String str, int i) {
        this.A02 = i;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.A01 = new ThreadPoolExecutor(Math.max(2, Math.min(availableProcessors - 1, 4)), (availableProcessors * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0539Li(this, str));
        this.A01.allowCoreThreadTimeOut(true);
    }

    public static Executor A01() {
        AtomicBoolean atomicBoolean = A0E;
        if (A05[6].length() != 10) {
            String[] strArr = A05;
            strArr[7] = "uTbwdcOZXJtEr7HfAL7lQlSS6oe88jWw";
            strArr[7] = "uTbwdcOZXJtEr7HfAL7lQlSS6oe88jWw";
            if (atomicBoolean.get()) {
                return A0A;
            }
            return A09;
        }
        throw new RuntimeException();
    }

    public static ExecutorService A02() {
        if (A0D.get()) {
            return A0A;
        }
        ExecutorService executorService = A0B;
        if (A05[7].charAt(6) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[1] = "2M7uNo";
        strArr[1] = "2M7uNo";
        return executorService;
    }

    public static ExecutorService A03() {
        if (A0D.get()) {
            return A0A;
        }
        return A0C;
    }

    public static void A06(Context context) {
        A0D.set(J8.A1b(context));
        A0E.set(J8.A1a(context));
    }

    public final void execute(Runnable runnable) {
        if (this.A00 == null && Looper.myLooper() == Looper.getMainLooper()) {
            this.A00 = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        Executor executor = this.A00;
        if (!(executor instanceof ThreadPoolExecutor) || ((ThreadPoolExecutor) executor).getQueue().size() >= this.A02) {
            int size = this.A01.getQueue().size();
            synchronized (ExecutorC0540Lj.class) {
                int i = A03;
                if (size == A03) {
                    A03 *= 2;
                    C0821Wi A002 = AnonymousClass8G.A00();
                    if (A002 != null) {
                        A002.A04().A82(A00(42, 7, 27), C02248i.A1J, new C02258j(A00(21, 21, 46), A00(14, 7, 25) + i));
                    }
                }
            }
            this.A01.execute(runnable);
            return;
        }
        this.A00.execute(runnable);
    }
}
