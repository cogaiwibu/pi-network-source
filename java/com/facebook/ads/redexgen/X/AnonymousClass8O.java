package com.facebook.ads.redexgen.X;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.facebook.ads.redexgen.X.8O  reason: invalid class name */
public final class AnonymousClass8O {
    public static byte[] A04;
    public static String[] A05;
    public static final String A06;
    public static final Lock A07 = A09.readLock();
    public static final Lock A08 = A09.writeLock();
    public static final ReentrantReadWriteLock A09 = new ReentrantReadWriteLock();
    public SQLiteOpenHelper A00;
    public final C0821Wi A01;
    public final C0826Wn A02 = new C0826Wn(this);
    public final C0828Wp A03 = new C0828Wp(this);

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[3].charAt(0) != '1') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "6YOEgEHO6bjbd5au9bSAefu6W5tI3Dak";
            strArr[6] = "kgOgsYcmlOEy6T8oxoaixHiO6WRSp1D2";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 115);
            i4++;
        }
    }

    public static void A07() {
        A04 = new byte[]{-31, -2, -31, -81, -51, -81, -50, -11, 22, 40, 24, -67, -29, -17, -20, -22, -67, -44, -2, 3, -3, 2, -44, -108, -64, -67, -63, -67, -56, -108, -106, -59, -60, -106, -35, 12, 15, 1, 2, 15, -35, -1, 22, -35, -42, 9, -5, 10, -42, -98, -43, -58, -61, -48, -61, -98, -49, -43, -46, -58, 11, 3, -54, -52, 22, 52, 65, 65, 66, 71, -13, 54, 52, 63, 63, -13, 58, 56, 71, 23, 52, 71, 52, 53, 52, 70, 56, -13, 57, 69, 66, 64, -13, 71, 59, 56, -13, 40, 28, -13, 71, 59, 69, 56, 52, 55, -12, 33, 19, 26, 19, 17, 34, -18, 66, 61, 57, 51, 60, 65, -4, 39, 34, 22, 19, 38, 23, -14, 43, 40, 59, 40, 41, 40, 58, 44, 71, 88, 71, 80, 86, 85, -9, -14, -18, -24, -15, -10};
    }

    public static void A08() {
        A05 = new String[]{"qJOvsPrm5BQkhL6wLJahauzjA45r7dQz", "hfx8x2hkXgxq19RSFkkqiaOe1zMy03Qo", "bV5o7GaQth4ZZOPd4LFtWwXjKNVB8lua", "1EyYFmGpmEhL9EWyl0I1ptwRPtnJxpez", "F", "i", "plO80lk7YnGQvaXazMopbLIwOg8MB0TR", "EzLFA06L6a2SQhX4934tm7serJXXg4XA"};
    }

    static {
        A08();
        A07();
        StringBuilder sb = new StringBuilder();
        sb.append(A05(107, 14, 91));
        sb.append(C0828Wp.A02.A01);
        String A052 = A05(58, 2, 51);
        sb.append(A052);
        String A053 = A05(142, 6, 16);
        sb.append(A053);
        String A054 = A05(60, 1, 106);
        sb.append(A054);
        sb.append(C0828Wp.A01.A01);
        sb.append(A052);
        String A055 = A05(136, 6, 111);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A04.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A05.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A0A.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A08.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A07.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A06.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A03.A01);
        sb.append(A052);
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A02.A01);
        sb.append(A05(11, 6, 42));
        sb.append(A055);
        sb.append(A05(17, 6, 65));
        sb.append(A053);
        sb.append(A05(30, 4, 3));
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A09.A01);
        sb.append(A05(0, 3, 78));
        sb.append(A053);
        sb.append(A054);
        sb.append(C0828Wp.A02.A01);
        sb.append(A05(34, 10, 74));
        sb.append(A055);
        sb.append(A054);
        sb.append(C0826Wn.A08.A01);
        sb.append(A05(7, 4, 98));
        A06 = sb.toString();
    }

    public AnonymousClass8O(C0821Wi wi) {
        this.A01 = wi;
    }

    private synchronized SQLiteDatabase A00() {
        if (this.A00 == null) {
            this.A00 = new AnonymousClass8P(this.A01, this);
        }
        return this.A00.getWritableDatabase();
    }

    private synchronized SQLiteDatabase A01() {
        SQLiteException e = null;
        for (int i = 0; i < 10; i++) {
            try {
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.A01.A04().A82(A05(128, 8, 84), C02248i.A0j, new C02258j(e));
        throw e;
        return A00();
    }

    public final int A09(int i) {
        A08.lock();
        try {
            SQLiteDatabase A0F = A0F();
            String A052 = A05(136, 6, 111);
            return A0F.delete(A052, C0826Wn.A02.A01 + A05(3, 4, 28), new String[]{String.valueOf(i - 1)});
        } finally {
            A08.unlock();
        }
    }

    public final Cursor A0A() {
        A07.lock();
        try {
            return this.A02.A0C();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0B() {
        A07.lock();
        try {
            return this.A02.A0D();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0C() {
        A07.lock();
        try {
            return this.A03.A0C();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0D(int i) {
        A07.lock();
        try {
            SQLiteDatabase A0F = A0F();
            return A0F.rawQuery(A06 + A05(23, 7, 1) + String.valueOf(i), null);
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0E(String str) {
        A07.lock();
        try {
            return this.A02.A0E(str);
        } finally {
            A07.unlock();
        }
    }

    public final SQLiteDatabase A0F() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return A01();
        }
        throw new IllegalStateException(A05(64, 43, 96));
    }

    public final <T> AsyncTask A0G(AnonymousClass8R<T> r4, AnonymousClass9L<T> r5) {
        return C0537Lg.A00(ExecutorC0540Lj.A07, new AnonymousClass8N<>(this.A01, r4, r5), new Void[0]);
    }

    public final AsyncTask A0H(String str, int i, String str2, double d, double d2, String str3, Map<String, String> map, AnonymousClass9L<String> r22) {
        return A0G(new C0320Ck(this, str2, str, i, d, d2, str3, map), r22);
    }

    public final void A0I() {
        A08.lock();
        try {
            this.A02.A0A();
            this.A03.A0A();
        } finally {
            A08.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void A0J() {
        A08.lock();
        try {
            this.A03.A0E();
            A08.unlock();
            if (A05[2].charAt(20) != 'D') {
                String[] strArr = A05;
                strArr[3] = "1xdZaIBKHwxaXlFBCUT9GXbMegb8IQts";
                strArr[3] = "1xdZaIBKHwxaXlFBCUT9GXbMegb8IQts";
                return;
            }
            throw new RuntimeException();
        } catch (Throwable th) {
            A08.unlock();
            throw th;
        }
    }

    public final synchronized void A0K() {
        for (int i = 0; i < A0N().length; i++) {
        }
        if (this.A00 != null) {
            this.A00.close();
            this.A00 = null;
        }
        String[] strArr = A05;
        if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[3] = "1MkhueXc3ojVbbuWv64h1Z2UaaL8Cuya";
        strArr2[3] = "1MkhueXc3ojVbbuWv64h1Z2UaaL8Cuya";
    }

    public final boolean A0L(String str) {
        A08.lock();
        try {
            boolean A0G = this.A02.A0G(str);
            Lock lock = A08;
            String[] strArr = A05;
            if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[4] = "8";
            strArr2[5] = "N";
            lock.unlock();
            return A0G;
        } catch (Throwable th) {
            A08.unlock();
            throw th;
        }
    }

    public final boolean A0M(String str) {
        boolean z;
        A08.lock();
        try {
            A0F().execSQL(A05(121, 7, 95) + A05(136, 6, 111) + A05(44, 5, 67) + C0826Wn.A02.A01 + A05(61, 1, 83) + C0826Wn.A02.A01 + A05(56, 2, 49) + A05(49, 7, 11) + C0826Wn.A04.A01 + A05(62, 2, 26), new String[]{str});
            z = true;
        } catch (SQLiteException unused) {
            z = false;
        }
        A08.unlock();
        String[] strArr = A05;
        if (strArr[0].charAt(2) != strArr[6].charAt(2)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[2] = "LEhHmvsdsEQXOsQ0B1AVwqczGhJrofDk";
        strArr2[2] = "LEhHmvsdsEQXOsQ0B1AVwqczGhJrofDk";
        return z;
    }

    public final AnonymousClass8S[] A0N() {
        return new AnonymousClass8S[]{this.A03, this.A02};
    }
}
