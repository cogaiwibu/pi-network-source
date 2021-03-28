package com.facebook.ads.redexgen.X;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.facebook.ads.redexgen.X.0O  reason: invalid class name */
public final class AnonymousClass0O extends BufferedInputStream {
    public static String[] A03;
    public int A00 = Integer.MAX_VALUE;
    public int A01;
    public boolean A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"hHZOxXwAkKvoKhhBaEkDET3K9Dqf", "5rJSRpPdF8KF8uXWImzbaIQKFcw1ndDO", "6QZm8Ah", "xZscB3eTttYWUeptNSmdVwNeb0ugkTew", "aaCt8fo", "HFDxsqP", "jqG6j3VzD3iXGVjyym9gTZpwoM0I", "1czQANy8yDzooPN28ziBSeiajns8goae"};
    }

    public AnonymousClass0O(InputStream inputStream) {
        super(inputStream);
    }

    public final boolean A01() {
        return this.A02;
    }

    public final synchronized void mark(int i) {
        this.A00 = i;
        super.mark(i);
    }

    @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = this.A01;
        if (i + 1 > this.A00) {
            this.A02 = true;
            return -1;
        }
        this.A01 = i + 1;
        return super.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        if (this.A01 + bArr.length <= this.A00) {
            return super.read(bArr);
        }
        this.A02 = true;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.A01 + i2 > this.A00) {
            this.A02 = true;
            return -1;
        }
        int read = super.read(bArr, i, i2);
        this.A01 += read;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.A00 = Integer.MAX_VALUE;
        super.reset();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (com.facebook.ads.redexgen.X.AnonymousClass0O.A03[5].length() == 7) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass0O.A03;
        r2[4] = "3ofKHV0";
        r2[2] = "cjaCIpO";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass0O.A03;
        r2[4] = "nrvpyz2";
        r2[2] = "1Ep1yQ1";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        return r3;
     */
    @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long skip(long r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass0O.skip(long):long");
    }
}
