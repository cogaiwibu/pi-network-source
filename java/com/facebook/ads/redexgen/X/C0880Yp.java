package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Yp  reason: case insensitive filesystem */
public class C0880Yp implements L3 {
    public static String[] A01;
    public final /* synthetic */ YA A00;

    public static void A00() {
        A01 = new String[]{"XQ6pDaA1rZEM", "XoeGOYiSv0w2M1U1qXC2kK0WxpTFbq6C", "goNPtYs5sZFfNSJyOgs171oDuCl7t69H", "IBRmsKraW8ihcuaNuynFKjmRlH", "udOMyB", "k9bLdXox5SSCuqwZoRmzAy5kJm", "rLCACxpviKCtWgunDsmekf59Ef0kXw8R", "IiDilnQTvcIperbA6lCpmy3utrrmGEhT"};
    }

    static {
        A00();
    }

    public C0880Yp(YA ya) {
        this.A00 = ya;
    }

    public /* synthetic */ C0880Yp(YA ya, ZV zv) {
        this(ya);
    }

    @Override // com.facebook.ads.redexgen.X.L3
    public final void A9D() {
        this.A00.A0H();
        if (!(this.A00.A0N) || !(this.A00.A0W())) {
            this.A00.A0P.setToolbarActionMode(0);
        } else {
            this.A00.A0P.setToolbarActionMode(1);
        }
        boolean z = this.A00.A0O;
        if (A01[4].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "RNuzR8";
        strArr[4] = "RNuzR8";
        if (!z) {
            C0535Le.A0Y(this.A00, 500);
            if (this.A00.A05 != null) {
                C0535Le.A0Q(this.A00.A05, 0);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.L3
    public final void AAc(float f) {
        this.A00.A0P.setProgress(100.0f * (1.0f - (f / ((float) this.A00.A0A.A08()))));
        this.A00.A0O((int) f);
    }
}
