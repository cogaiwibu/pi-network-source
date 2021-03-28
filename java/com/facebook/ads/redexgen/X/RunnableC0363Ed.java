package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ed  reason: case insensitive filesystem */
public class RunnableC0363Ed implements Runnable {
    public static String[] A02;
    public final /* synthetic */ RunnableC0365Ef A00;
    public final /* synthetic */ Throwable A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"PHglGL4XjX34Q6IxLVPE9YioC0GgMwVu", "C2v6p3cvqb8VeZJmls5VVCvxLYipHy3t", "B1N0Tyuu9FQ6QTrTU7ijuANEMG", "iuv0k0UwV2hxTLPIE5sOwikENKEW9q70", "E2s9cNULSafngvXq", "pcZveafGMpvyt6r1oEwZuN", "WTgfgYLlZCoaxL5kkJP8NMEH1L99huZD", "JeTmk3Th2rZrNzRyDKokFPK9mdehXDhr"};
    }

    public RunnableC0363Ed(RunnableC0365Ef ef, Throwable th) {
        this.A00 = ef;
        this.A01 = th;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                if (!(this.A00.A0H(1, this.A01 != null ? 4 : 2, this.A01)) && !(this.A00.A0G(6, 3))) {
                    if (!(this.A00.A0G(7, 0))) {
                        throw new IllegalStateException();
                    }
                }
            } catch (Throwable th) {
                KU.A00(th, this);
                String[] strArr = A02;
                if (strArr[3].charAt(4) != strArr[7].charAt(4)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[3] = "RKKtkNHXa9KnDNNutMsCnoFR2DmhfaHg";
                strArr2[7] = "GRntkGfXke7q4gy1a5nBcYrAffQzlmQw";
            }
        }
    }
}
