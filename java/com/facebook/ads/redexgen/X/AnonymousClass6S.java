package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Arrays;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: com.facebook.ads.redexgen.X.6S  reason: invalid class name */
public final class AnonymousClass6S extends Enum<AnonymousClass6S> {
    public static byte[] A01;
    public static String[] A02;
    public static final /* synthetic */ AnonymousClass6S[] A03 = {A04, A08, A0A, A07, A0B, A0C, A0E, A09, A06, A05, A0D};
    public static final AnonymousClass6S A04 = new AnonymousClass6S(A00(0, 20, 13), 0, 1);
    public static final AnonymousClass6S A05 = new AnonymousClass6S(A00(20, 26, 4), 9, 13);
    public static final AnonymousClass6S A06 = new AnonymousClass6S(A00(46, 16, 17), 8, 6);
    public static final AnonymousClass6S A07;
    public static final AnonymousClass6S A08 = new AnonymousClass6S(A00(89, 16, 108), 1, 4);
    public static final AnonymousClass6S A09 = new AnonymousClass6S(A00(105, 12, 72), 7, 5);
    public static final AnonymousClass6S A0A = new AnonymousClass6S(A00(117, 19, 5), 2, 2);
    public static final AnonymousClass6S A0B = new AnonymousClass6S(A00(136, 18, 126), 4, 0);
    public static final AnonymousClass6S A0C = new AnonymousClass6S(A00(154, 16, 38), 5, 8);
    public static final AnonymousClass6S A0D = new AnonymousClass6S(A00(170, 24, 107), 10, 12);
    public static final AnonymousClass6S A0E;
    public int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 121);
            String[] strArr = A02;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "Nmo5M96rPCfUDrZsYva5XI4ZsWtaAuQf";
            strArr2[3] = "Nmo5M96rPCfUDrZsYva5XI4ZsWtaAuQf";
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-57, -55, -55, -53, -46, -53, -40, -43, -45, -53, -38, -53, -40, -27, -39, -53, -44, -39, -43, -40, -66, -54, -65, -58, -62, -53, -47, -36, -47, -62, -54, -51, -62, -49, -66, -47, -46, -49, -62, -36, -48, -62, -53, -48, -52, -49, -52, -53, -36, -39, -41, -49, -34, -49, -36, -23, -35, -49, -40, -35, -39, -36, 18, 16, 26, 24, 12, 18, 25, 16, 31, 20, 14, 42, 29, 26, 31, 12, 31, 20, 26, 25, 42, 30, 16, 25, 30, 26, 29, 44, 62, 55, 52, 56, 40, 52, 53, 42, 68, 56, 42, 51, 56, 52, 55, 13, 10, 8, 9, 21, 32, 20, 6, 15, 20, 16, 19, -53, -65, -59, -52, -61, -46, -51, -53, -61, -46, -61, -48, -35, -47, -61, -52, -47, -51, -48, 70, 73, 64, 60, 69, 75, 56, 75, 64, 70, 69, 86, 74, 60, 69, 74, 70, 73, -17, -15, -18, -9, -24, -20, -24, -13, -8, -2, -14, -28, -19, -14, -18, -15, 54, 41, 48, 37, 56, 45, 58, 41, 67, 44, 57, 49, 45, 40, 45, 56, 61, 67, 55, 41, 50, 55, 51, 54, 6, 7, -8, 3, 18, -9, -8, 7, -8, -10, 7, 2, 5, 18, 6, -8, 1, 6, 2, 5};
    }

    public static void A02() {
        A02 = new String[]{"Q9z0ZbrjVYihKEpPZo", "nHeBQw", "ufhBztUadH", "XQstpsz58GIAm7RXEZkDYWBkGRBRqqVa", "vkoIrw2eH1SjUMjyxylQQX8SriJ39jtP", "twWVBvXll74W3M8pa6", "XnmvrLeMI93IRtZgUGg2fGmgShQWmbLW", "5DNdaWhzklLDGcFmvcoxBU5JueDBtSej"};
    }

    static {
        int i;
        A02();
        A01();
        int i2 = -1;
        if (Build.VERSION.SDK_INT >= 19) {
            i = 20;
        } else {
            i = -1;
        }
        A07 = new AnonymousClass6S(A00(62, 27, 82), 3, i);
        if (Build.VERSION.SDK_INT >= 19) {
            i2 = 18;
        }
        A0E = new AnonymousClass6S(A00(194, 20, 58), 6, i2);
    }

    public AnonymousClass6S(String str, int i, int i2) {
        this.A00 = i2;
    }

    public final int A03() {
        return this.A00;
    }

    public static AnonymousClass6S valueOf(String str) {
        return (AnonymousClass6S) Enum.valueOf(AnonymousClass6S.class, str);
    }

    public static AnonymousClass6S[] values() {
        return (AnonymousClass6S[]) A03.clone();
    }
}
