package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.9c  reason: invalid class name and case insensitive filesystem */
public final class C02449c {
    @VisibleForTesting
    public static int A03 = 1000;
    public static byte[] A04;
    @Nullable
    public C02439b A00;
    public boolean A01;
    public final File A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 93);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{27, 54, 62, 65, 58, 57, -11, 73, 68, -11, 57, 58, 65, 58, 73, 58, -11, 59, 62, 65, 58, -11, -4, -6, 72, -63, -28, -25, -32, -101, -94, -96, -18, -94, -101, -28, -18, -101, -23, -22, -17, -101, -36, -101, -19, -32, -36, -33, -36, -35, -25, -32, -101, -31, -28, -25, -32, 24, 61, 69, 48, 59, 56, 51, -17, 53, 52, 67, 50, 55, -17, 66, 67, 48, 65, 67, -17, 56, 61, 51, 52, 71, 9, -17, -12, 51, -66, -47, -49, -37, -34, -48, -116, -46, -43, -40, -47, -116, -51, -40, -34, -47, -51, -48, -27, -116, -48, -43, -33, -36, -37, -33, -47, -48};
    }

    /* JADX WARNING: Error to parse debug info: 24 in method: com.facebook.ads.redexgen.X.9c.A06(int, byte[], int, int[], int):com.facebook.ads.redexgen.X.9T, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:149)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public final synchronized AnonymousClass9T A06(int i, byte[] bArr, int i2, int[] iArr, int i3) throws IOException {
        C02439b A002 = A00();
        boolean z = false;
        int i4 = 1;
        if (i >= 0) {
            int i5 = i;
            int i6 = 0;
            long j = -1;
            while (true) {
                if (i5 >= A002.A00) {
                    break;
                } else if ((i5 - i) + i3 >= iArr.length) {
                    z = true;
                    break;
                } else {
                    long j2 = A002.A03[i5];
                    long j3 = (i5 == A002.A00 - i4 ? A002.A01 : A002.A03[i5 + 1]) - j2;
                    if (j == -1) {
                        j = j2;
                    }
                    if (((int) j3) + i6 + i2 > bArr.length) {
                        z = true;
                        break;
                    }
                    i6 += (int) j3;
                    iArr[(i5 - i) + i3] = (int) j3;
                    i5++;
                    i4 = 1;
                }
            }
            if (i5 > i) {
                A002.A02.seek(j);
                A002.A02.read(bArr, i2, i6);
                return new AnonymousClass9T(AnonymousClass9S.A02, i, i5, i6);
            }
            return new AnonymousClass9T(z ? AnonymousClass9S.A03 : AnonymousClass9S.A04, i, i, 0);
        }
        throw new IOException(String.format(Locale.US, A01(57, 29, 114), Integer.valueOf(i)));
    }

    /* JADX WARNING: Error to parse debug info: 8 in method: com.facebook.ads.redexgen.X.9c.A09(byte[]):boolean, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:149)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public final synchronized boolean A09(byte[] bArr) throws IOException {
        C02439b A002 = A00();
        if (A05() == A03) {
            return false;
        }
        A03(A002.A00, A002.A01);
        A04(A002.A01, bArr);
        A002.A02.getFD().sync();
        A002.A00++;
        A002.A01 += (long) bArr.length;
        return true;
    }

    static {
        A02();
    }

    public C02449c(File file) throws IOException {
        this.A02 = file;
        if (!file.exists()) {
            this.A00 = C02439b.A03(file);
        } else if (!file.isFile()) {
            throw new IOException(String.format(Locale.US, A01(25, 32, 30), file.getCanonicalPath()));
        }
    }

    private C02439b A00() throws IOException {
        if (!this.A01) {
            if (this.A00 == null) {
                this.A00 = C02439b.A04(this.A02);
            }
            return this.A00;
        }
        throw new IOException(A01(86, 28, 15));
    }

    private void A03(int i, long j) throws IOException {
        this.A00.A03[i] = j;
        this.A00.A02.seek(C02439b.A02(i));
        this.A00.A02.writeLong(j);
    }

    private void A04(long j, byte[] bArr) throws IOException {
        this.A00.A02.seek(j);
        this.A00.A02.write(bArr);
    }

    public final synchronized int A05() throws IOException {
        return A00().A00;
    }

    public final synchronized void A07() throws IOException {
        this.A01 = true;
        if (this.A00 != null) {
            RandomAccessFile randomAccessFile = this.A00.A02;
            this.A00 = null;
            randomAccessFile.close();
        }
    }

    public final synchronized void A08() throws IOException {
        if (!this.A01) {
            A07();
            if (!this.A02.delete()) {
                throw new IOException(String.format(Locale.US, A01(0, 25, 120), this.A02.getCanonicalPath()));
            }
        } else {
            throw new IOException(A01(86, 28, 15));
        }
    }
}
