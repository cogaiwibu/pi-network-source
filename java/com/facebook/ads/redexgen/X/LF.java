package com.facebook.ads.redexgen.X;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;

public class LF extends Thread implements Closeable {
    public static String[] A02;
    public boolean A00 = false;
    public final /* synthetic */ LG A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"TlcI8clPy2cAxmBQLm6V1herqnmAITse", "yZ5kpCkqR1osI6zLxCntBCQkuWvFDLL5", "q2c", "jrNyDVk0HDDQUaPHkyGFAgSqoyhAwgQL", "WhGkB9GwGiTJZue6wwGhsu4RprprQOI3", "P0d", "2ZYrdgfLM", "x3INJ1jAMxJto"};
    }

    public LF(LG lg) {
        this.A01 = lg;
        start();
    }

    public final synchronized void A01() {
        this.A01.A02.A02();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            this.A00 = true;
            this.A01.A02.A02();
        }
        try {
            join();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r1 == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r5.A01.A03.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0058, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5.A01.A02.A03();
        r5.A01.A00 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0071, code lost:
        monitor-enter(r5.A01);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r5.A01.A02.A03();
        r5.A01.A00 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x005c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:5:0x0009] */
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LF.run():void");
    }
}
