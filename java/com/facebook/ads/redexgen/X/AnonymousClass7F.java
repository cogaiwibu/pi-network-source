package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.7F  reason: invalid class name */
public class AnonymousClass7F implements Callable<Boolean> {
    public static byte[] A02;
    public static String[] A03;
    public final AnonymousClass7E A00;
    public final /* synthetic */ AnonymousClass7H A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[1].length() != 32) {
                String[] strArr = A03;
                strArr[3] = "";
                strArr[3] = "";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 48);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A02() {
        A02 = new byte[]{-20, -16, -28, -22, -24};
    }

    public static void A03() {
        A03 = new String[]{"jwTNBF52XqMGgcVEiQTwvXvSBsl43Bcu", "zl9XISU", "9LwyCiCzMXmNgkxTRjX8XUqiNT4UlidW", "Jar4Zz8ck96tLH67JFbLbWmYESMeU49V", "Yd8bjyjazIom6Oxe2tnjIAJyfdSlHwWG", "VgUZ5KaBAYbzt3oMIew8EQ4BA2c", "hXTgBapwd4emagenALPcDOSBW5zmdf3H", "17k"};
    }

    public AnonymousClass7F(AnonymousClass7H r1, AnonymousClass7E r2) {
        this.A01 = r1;
        this.A00 = r2;
    }

    private final Boolean A00() {
        if (KU.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            AnonymousClass06 r7 = new AnonymousClass06(this.A00.A07, this.A00.A06, this.A00.A05, A01(0, 5, 83), this.A00.A01, this.A00.A02);
            r7.A01 = this.A00.A04;
            r7.A00 = this.A00.A03;
            if (AnonymousClass7K.A06(this.A01.A04)) {
                AnonymousClass7H.A0E.put(this.A00.A07, r7);
            }
            boolean z = this.A01.A08;
            boolean z2 = false;
            if (A03[3].length() != 5) {
                String[] strArr = A03;
                strArr[4] = "CZcPy1KhLDdCOlGcBT5xxsnRB32IUDMD";
                strArr[4] = "CZcPy1KhLDdCOlGcBT5xxsnRB32IUDMD";
                if (z) {
                    z2 = AnonymousClass7H.A02(this.A01.A04.A00()).ACX(r7, false).A01();
                } else if (this.A01.A03.A0D(this.A00) != null) {
                    z2 = true;
                }
                AnonymousClass7M r1 = this.A00.A00;
                if (r1 != null && r1.A02()) {
                    int A002 = r1.A00();
                    int A012 = r1.A01();
                    if (A002 <= 0 || A012 <= 0) {
                        if (this.A01.A08) {
                            A05(this.A00.A07, r7);
                        } else {
                            A04(this.A00.A03, this.A00.A04);
                        }
                    } else if (this.A01.A08) {
                        r7.A00 = A002;
                        r7.A01 = A012;
                        A05(this.A00.A07, r7);
                    } else {
                        A04(A002, A012);
                    }
                }
                return Boolean.valueOf(z2);
            }
            throw new RuntimeException();
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }

    private void A04(int i, int i2) {
        Bitmap A0E = this.A01.A03.A0E(this.A01.A04, this.A00.A07, i, i2, this.A00.A01);
        if (A0E != null) {
            this.A01.A07.put(this.A00.A07, A0E);
        }
    }

    private void A05(String str, AnonymousClass06 r4) {
        Bitmap A002 = AnonymousClass7H.A02(this.A01.A04.A00()).ACX(r4, true).A00();
        if (A002 != null) {
            this.A01.A07.put(str, A002);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        if (KU.A02(this)) {
            return null;
        }
        try {
            return A00();
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }
}
