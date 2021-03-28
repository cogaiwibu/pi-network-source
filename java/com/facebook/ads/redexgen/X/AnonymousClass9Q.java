package com.facebook.ads.redexgen.X;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.9Q  reason: invalid class name */
public final class AnonymousClass9Q implements Closeable {
    public static byte[] A03;
    public static String[] A04;
    public AnonymousClass9R A00;
    public boolean A01;
    public final RandomAccessFile A02;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A04[5].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "pH7cradwiFTKLrbheOx3UovjSmwH9sX8";
            strArr[6] = "pH7cradwiFTKLrbheOx3UovjSmwH9sX8";
            copyOfRange[i4] = (byte) ((b ^ i3) ^ 38);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{95, 105, 110, 111, 115, 110, 90, 117, 112, 121, 60, 117, 111, 60, 125, 112, 110, 121, 125, 120, 101, 60, ByteCompanionObject.MAX_VALUE, 112, 115, 111, 121, 120, 15, 40, 48, 39, 42, 47, 34, 102, 54, 41, 53, 47, 50, 47, 41, 40, 124, 102, 110, 99, 34, 106, 99, 34, 111, 94, 91, 95};
    }

    public static void A03() {
        A04 = new String[]{"SDO1JVQRVztc05U6wH4HJTiF5V86WLZV", "JUkWBi3mNnUEcI1zFAO0icxdG8wRWdD7", "QP9Vd5zf9OYRCERvVtyUemXpYBL6EKiE", "xOOYiIXMxQksUvny4QEKcKXl4UDniIsU", "x87Ktc1IWjLpjjicmuhI7Z2IzrOHGBC3", "WGZ", "wfI1QUU7hCcnQ3hBelCxr5juQnjBiotI", "E2gfbhu1TU9ChELgnqQ3ne7CNBbav8TU"};
    }

    public AnonymousClass9Q(File file) throws IOException {
        this.A02 = new RandomAccessFile(file, A00(53, 3, 10));
        if (this.A02.length() != 8) {
            this.A02.setLength(8);
            this.A00 = new AnonymousClass9R(0, 0);
            A01();
            return;
        }
        int readInt = this.A02.readInt();
        int readInt2 = this.A02.readInt();
        if (readInt < 0 || readInt2 < 0) {
            readInt = 0;
            readInt2 = 0;
        }
        this.A00 = new AnonymousClass9R(readInt, readInt2);
    }

    private void A01() throws IOException {
        this.A02.seek(0);
        this.A02.writeInt(this.A00.A03());
        this.A02.writeInt(this.A00.A04());
        this.A02.getFD().sync();
    }

    public final AnonymousClass9R A04() throws IOException {
        if (!this.A01) {
            return this.A00;
        }
        throw new IOException(A00(0, 28, 58));
    }

    public final void A05(AnonymousClass9R r7) throws IOException {
        if (this.A01) {
            throw new IOException(A00(0, 28, 58));
        } else if (r7.A03() < 0 || r7.A04() < 0) {
            throw new IOException(String.format(Locale.US, A00(28, 25, 96), Integer.valueOf(r7.A03()), Integer.valueOf(r7.A04())));
        } else {
            this.A00 = r7;
            A01();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.A01) {
            this.A01 = true;
            this.A02.close();
        }
    }
}
