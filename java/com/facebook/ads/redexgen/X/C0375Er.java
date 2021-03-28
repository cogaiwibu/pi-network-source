package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Er  reason: case insensitive filesystem */
public final class C0375Er extends AbstractC0915a2<C0696Rk> {
    public static String[] A00;

    static {
        A00();
    }

    public static void A00() {
        A00 = new String[]{"ByMq6MLqhjUJsdWB3RBIp", "zuOr3", "msyHKBX3wHVeYE5obxbctQprcgEzI02t", "I3sOgeRwcNYGF4oixOV5Q17", "dcB", "ibtCqc8qysdz0E5AMIDmPhuL1XZA", "mNtKCg4kzaH6sXUtb2oDuqx2", "ObFvkEusatMYzjWaq72f4FkWXHrQjerH"};
    }

    public C0375Er(C0696Rk rk) {
        super(rk);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        C0696Rk rk = (C0696Rk) A08();
        if (rk != null) {
            C0820Wh wh = rk.A08;
            String[] strArr = A00;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A00;
                strArr2[5] = "SiVLKh";
                strArr2[5] = "SiVLKh";
                if (C0552Lv.A02(wh)) {
                    rk.A08();
                } else {
                    rk.A05.postDelayed(rk.A0C, 5000);
                }
            } else {
                throw new RuntimeException();
            }
        }
    }
}
