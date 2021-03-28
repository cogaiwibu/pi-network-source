package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import java.util.Locale;

public final class TI implements AnonymousClass5U {
    public static byte[] A02;
    public static final String A03 = TI.class.getSimpleName();
    public final AnonymousClass5X A00;
    public final AnonymousClass7H A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 112);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{50, 84, 71, 78, 81, 67, 70, 75, 80, 73, 2, 7, 70, 2, 67, 85, 85, 71, 86, 85, 58, 92, 79, 86, 89, 75, 78, 83, 88, 81, 10, 83, 87, 75, 81, 79, 36, 10, 15, 93, 35, 69, 56, 63, 66, 52, 55, 60, 65, 58, -13, 64, 52, 69, 62, 72, 67, 13, -13, -8, 70, 25, 59, 46, 53, 56, 42, 45, 50, 55, 48, -23, 63, 50, 45, 46, 56, 3, -23, -18, 60, -33, -82, -31, -31, -79, -78, -81, -81, -88, -35, -77, -82, -83, -88, -84, -84, -32, -76, -88, -36, -83, -36, -82, -88, -83, -36, -83, -36, -32, -83, -33, -35, -34, -34, -32, -81, 58, 60, 47, 48, 47, 62, 45, 50, 19, 12, 9, 12, 13, 21, 12};
    }

    static {
        A02();
    }

    public TI(AnonymousClass5X r3, C0821Wi wi) {
        this.A00 = r3;
        this.A00.A3G(new TG(this));
        this.A01 = new AnonymousClass7H(wi);
        A01();
    }

    /* access modifiers changed from: private */
    public void A01() {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(0, 20, 114), Integer.valueOf(this.A00.A5O().size()));
        }
        for (AbstractC01485a r2 : this.A00.A5O()) {
            int i = AnonymousClass5W.A00[r2.A7B().ordinal()];
            if (i == 1) {
                A04(r2.getUrl());
            } else if (i == 2) {
                A06(r2.getUrl());
            } else if (i == 3) {
                A05(r2.getUrl());
            }
        }
        this.A01.A0Q(new TH(this), new AnonymousClass7A(A00(81, 36, 11), A00(125, 7, 46)));
    }

    private void A04(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(20, 20, 122), str);
        }
        AnonymousClass7E r4 = new AnonymousClass7E(str, -1, -1, A00(81, 36, 11), A00(125, 7, 46));
        r4.A01 = A00(117, 8, 90);
        this.A01.A0R(r4);
    }

    private void A05(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(40, 21, 99), str);
        }
        AnonymousClass7G r4 = new AnonymousClass7G(str, A00(81, 36, 11), A00(125, 7, 46));
        r4.A04 = true;
        r4.A02 = A00(117, 8, 90);
        this.A01.A0T(r4);
    }

    private void A06(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(61, 20, 89), str);
        }
        AnonymousClass7G r4 = new AnonymousClass7G(str, A00(81, 36, 11), A00(125, 7, 46));
        r4.A04 = false;
        r4.A02 = A00(117, 8, 90);
        this.A01.A0W(r4);
    }
}
