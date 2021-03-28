package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.5s  reason: invalid class name and case insensitive filesystem */
public final class C01655s {
    public static boolean A04;
    public static byte[] A05;
    public static final String A06 = C01655s.class.getSimpleName();
    public final C01665t A00;
    public final C01675u A01;
    public final C0821Wi A02;
    public final QB A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{46, 56, 19, 41, 52, 56, 62, 45, 63};
    }

    static {
        A01();
    }

    public C01655s(C0821Wi wi, QN qn, C01665t r5, C01675u r6) {
        this.A02 = wi;
        this.A03 = qn.A4N(QC.A06);
        this.A00 = r5;
        this.A01 = r6;
        this.A03.A3I(new TO(this));
        A02();
    }

    /* JADX INFO: Multiple debug info for r5v0 'this'  com.facebook.ads.redexgen.X.5s: [D('this' com.facebook.ads.redexgen.X.5s), D('btExtras' java.lang.String)] */
    /* access modifiers changed from: private */
    public synchronized void A02() {
        if (!KU.A02(this)) {
            try {
                if (!this.A03.A7i()) {
                    BuildConfigApi.isDebug();
                    return;
                }
                String optString = this.A03.A5x().optString(A00(0, 9, 62));
                if (!TextUtils.isEmpty(optString)) {
                    this.A00.A04(this.A02, optString);
                    if (!A04 || J8.A0e(this.A02)) {
                        A04 = true;
                        this.A01.A05();
                    }
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
