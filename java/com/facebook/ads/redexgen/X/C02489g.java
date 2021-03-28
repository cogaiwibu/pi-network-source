package com.facebook.ads.redexgen.X;

import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.9g  reason: invalid class name and case insensitive filesystem */
public final class C02489g implements Closeable {
    public static byte[] A03;
    public static String[] A04;
    public boolean A00 = false;
    public final AnonymousClass9W A01;
    public final Deque<C02479f> A02 = new LinkedList();

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] ^ i3;
            if (A04[5].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "u097qyCEcqL0dCUFF3RqUSqj";
            strArr[6] = "TBb0mUAcLDsBFXHpNBOq9rzF";
            copyOfRange[i4] = (byte) (i5 ^ 113);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        byte[] bArr = {5, 41, 51, 42, 34, 102, 40, 41, 50, 102, 39, 34, 34, 102, 52, 35, 37, 41, 52, 34, 102, 50, 41, 102, 40, 35, 49, 42, 63, 102, 39, 34, 34, 35, 34, 102, 32, 47, 42, 35, 42, 13, 5, 0, 9, 8, 76, 24, 3, 76, 8, 9, 0, 9, 24, 9, 76, 10, 5, 0, 9, 76, 75, 73, 31, 75, 106, 77, 69, 64, 73, 72, 12, 88, 67, 12, 64, 69, 95, 88, 12, 74, 69, 64, 73, 72, 12, 69, 66, 12, 72, 69, 94, 73, 79, 88, 67, 94, 85, 12, 11, 9, 95, 11, 28, 59, 51, 54, 63, 62, 122, 46, 53, 122, 54, 53, 59, 62, 122, 60, 51, 54, 63, 122, 125, ByteCompanionObject.MAX_VALUE, 41, 125, 118, 122, 41, 49, 51, 42, 42, 51, 52, 61, 122, 59, 54, 54, 122, 42, 40, 63, 44, 51, 53, 47, 41, 122, 60, 51, 54, 63, 41, 122, 47, 52, 46, 51, 54, 122, ByteCompanionObject.MAX_VALUE, 62, 61, 28, 29, 94, 16, 28, 29, 7, 26, 20, 6, 28, 6, 0, 83, 29, 18, 30, 22, 23, 83, 21, 26, 31, 22, 83, 26, 29, 83, 31, 28, 20, 20, 26, 29, 20, 83, 23, 26, 1, 22, 16, 7, 28, 1, 10, 73, 83, 86, 23, 95, 83, 30, 26, 29, 83, 26, 0, 83, 86, 23, 29, 42, 44, 32, 61, 43, 9, 38, 35, 42, 28, 42, 62, 58, 42, 33, 44, 42, 111, 46, 35, 61, 42, 46, 43, 54, 111, 44, 35, 32, 60, 42, 43, 107, 80, 85, 80, 81, 73, 80, 30, 88, 87, 82, 91, 30, 87, 80, 30, 82, 81, 89, 89, 87, 80, 89, 30, 90, 87, 76, 91, 93, 74, 81, 76, 71, 4, 30, 25, 27, 77, 25};
        String[] strArr = A04;
        if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "rXUNYUFSY3Wwjf0Rt9wI3pKgcM0mrVi5";
        strArr2[2] = "NbfmFkvRWQfztm8Xt0wszzyUhHEjBSFU";
        A03 = bArr;
    }

    public static void A04() {
        A04 = new String[]{"Gii7pzXwK3MpiHC8B9NJqbzL", "8Pqq6WSNf8vKrPOx7XSY9C7", "LI4waC8pDZc7B2Ob9Mw4umyD0YVp7Iep", "HQVOS1q9k5iJuCSZxlwiHtDpSPIo2CAf", "0wBrPWYDPAFL7IDgbo0bQ8s", "e5cW7wYXRGqKaYX8", "aNUR51q123XM3tsFczjtkJvp", "F8bzMC9kGkJ5CLi2olbpsia5Bq7Sq0"};
    }

    public C02489g(AnonymousClass9W r2, AbstractC02469e r3) throws IOException {
        this.A01 = r2;
        A06(r2, r3);
        if (this.A02.isEmpty()) {
            A00();
        }
    }

    private C02479f A00() throws IOException {
        int i = -1;
        if (!this.A02.isEmpty()) {
            i = this.A02.getLast().A00();
        }
        int i2 = i + 1;
        this.A02.add(new C02479f(i2, new C02449c(new File(this.A01.A05(), A01(i2)))));
        return this.A02.getLast();
    }

    @VisibleForTesting
    public static String A01(int i) {
        return Integer.toString(i);
    }

    private void A05(int i, File file) throws IOException {
        C02449c r2 = new C02449c(file);
        r2.A05();
        this.A02.addFirst(new C02479f(i, r2));
    }

    /* JADX INFO: Multiple debug info for r7v0 java.util.HashSet: [D('file' java.io.File), D('fileToLoad' java.io.File), D('fileNumber' int)] */
    private void A06(AnonymousClass9W r14, AbstractC02469e r15) throws IOException {
        File[] listFiles = r14.A05().listFiles();
        if (listFiles != null) {
            HashMap hashMap = new HashMap();
            HashSet<File> hashSet = new HashSet();
            int i = -1;
            for (File file : listFiles) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    hashMap.put(Integer.valueOf(parseInt), file);
                    if (parseInt > i) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    hashSet.add(file);
                    r15.ACV(String.format(Locale.US, A02(260, 39, 79), file.getCanonicalPath()));
                }
            }
            if (!hashMap.isEmpty()) {
                int i2 = i;
                while (hashMap.containsKey(Integer.valueOf(i2 - 1))) {
                    i2--;
                }
                Iterator it = new HashSet(hashMap.keySet()).iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (intValue < i2) {
                        r15.ACV(String.format(Locale.US, A02(166, 61, 2), Integer.valueOf(intValue), Integer.valueOf(i2)));
                        hashSet.add(hashMap.remove(Integer.valueOf(intValue)));
                    }
                }
                while (i >= i2) {
                    Integer valueOf = Integer.valueOf(i);
                    if (A04[7].length() != 23) {
                        String[] strArr = A04;
                        strArr[5] = "fmCLvQkSN3nY4ZJN";
                        strArr[5] = "fmCLvQkSN3nY4ZJN";
                        File file2 = (File) hashMap.get(valueOf);
                        try {
                            A05(i, file2);
                            hashMap.remove(Integer.valueOf(i));
                            i--;
                        } catch (IOException e) {
                            r15.ACW(String.format(Locale.US, A02(104, 62, 43), file2.getCanonicalPath(), Integer.valueOf(i)), e);
                            hashSet.addAll(hashMap.values());
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
            for (File file3 : hashSet) {
                if (!file3.delete()) {
                    r15.ACV(String.format(Locale.US, A02(40, 26, 29), file3.getCanonicalPath()));
                }
            }
            return;
        }
        throw new IOException(String.format(Locale.US, A02(66, 38, 93), r14.A05().getCanonicalPath()));
    }

    public final synchronized int A07() throws IOException {
        if (this.A00) {
            throw new IOException(A02(227, 33, 62));
        } else if (this.A02.isEmpty()) {
            return -1;
        } else {
            return this.A02.getFirst().A00();
        }
    }

    public final synchronized int A08() throws IOException {
        if (this.A00) {
            throw new IOException(A02(227, 33, 62));
        } else if (this.A02.isEmpty()) {
            return 0;
        } else {
            return this.A02.getFirst().A01();
        }
    }

    public final synchronized int A09() throws IOException {
        if (!this.A00) {
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        return this.A02.size();
    }

    public final synchronized int A0A() throws IOException {
        int i;
        if (!this.A00) {
            i = 0;
            for (C02479f r0 : this.A02) {
                i += r0.A01();
            }
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        return i;
    }

    public final synchronized AnonymousClass9U A0B(int i, int i2, byte[] bArr, int i3, int[] iArr, int i4) throws IOException {
        if (!this.A00) {
            for (C02479f r2 : this.A02) {
                if (r2.A00() == i) {
                    return new AnonymousClass9U(i, r2.A02(i2, bArr, i3, iArr, i4));
                }
            }
            return new AnonymousClass9U(-1, new AnonymousClass9T(AnonymousClass9S.A04, -1, -1, 0));
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized void A0C() throws IOException {
        if (!this.A00) {
            for (C02479f file : this.A02) {
                file.A04();
            }
            this.A02.clear();
            A00();
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        String[] strArr = A04;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "Q8tRgYQjLjZu9wWv5pfP6FNK";
        strArr2[6] = "ZBO8PuR7N2UupXyTknUyfTWg";
    }

    public final synchronized void A0D(byte[] bArr) throws IOException {
        if (this.A00) {
            throw new IOException(A02(227, 33, 62));
        } else if (this.A02.isEmpty() || !this.A02.getLast().A05(bArr)) {
            if (!A00().A05(bArr)) {
                throw new IOException(A02(0, 40, 55));
            }
        }
    }

    public final synchronized boolean A0E() throws IOException {
        if (this.A00) {
            throw new IOException(A02(227, 33, 62));
        } else if (this.A02.size() <= 1) {
            return false;
        } else {
            this.A02.removeFirst();
            this.A02.getFirst().A04();
            return true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (!this.A00) {
            this.A00 = true;
            for (C02479f file : this.A02) {
                file.A03();
            }
        }
    }
}
