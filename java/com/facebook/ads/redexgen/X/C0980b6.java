package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.b6  reason: case insensitive filesystem */
public final class C0980b6 implements IH {
    public static String[] A05;
    public long A00;
    public long A01;
    public AP A02 = AP.A04;
    public boolean A03;
    public final I4 A04;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"JbcDsPAiqgb9rsViVRKehTXv1iFS9Alt", "AfEyeuF2jCfkWNmIQlP22Iq9vQ5XDBZo", "cIPTiq2qkEqnYzKxb3sH3HOJO6VigB4N", "bIuwftDwBGArWYVN2grLSP1kPnHfbgfq", "1GGMxn0jatOJtlepcpEnLiyqpa0L6Zpp", "dBndgbsmlMbgteIClih73P1Nf1skDdlq", "kMZcBPwOEd1j6nxu2sFbdi5kLjNzhQnH", "M7tzCbQcNsxxyZ9EacAqZIMXmH340eiG"};
    }

    public C0980b6(I4 i4) {
        this.A04 = i4;
    }

    public final void A01() {
        if (!this.A03) {
            this.A00 = this.A04.A4r();
            this.A03 = true;
        }
    }

    public final void A02() {
        if (this.A03) {
            long A6o = A6o();
            if (A05[0].charAt(9) != 'F') {
                String[] strArr = A05;
                strArr[0] = "yV0nDN2yEP24GlsqsYFBRUnmoDIsFkRQ";
                strArr[0] = "yV0nDN2yEP24GlsqsYFBRUnmoDIsFkRQ";
                A03(A6o);
                this.A03 = false;
                return;
            }
            throw new RuntimeException();
        }
    }

    public final void A03(long j) {
        this.A01 = j;
        if (this.A03) {
            this.A00 = this.A04.A4r();
        }
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final AP A6l() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final long A6o() {
        long elapsedSinceBaseMs = this.A01;
        if (!this.A03) {
            return elapsedSinceBaseMs;
        }
        long A4r = this.A04.A4r();
        if (A05[0].charAt(9) != 'F') {
            String[] strArr = A05;
            strArr[1] = "ixlqsHFDPmeKY4bwdkSegalU4BLtdIOn";
            strArr[1] = "ixlqsHFDPmeKY4bwdkSegalU4BLtdIOn";
            long j = A4r - this.A00;
            if (this.A02.A01 != 1.0f) {
                return elapsedSinceBaseMs + this.A02.A00(j);
            }
            long A002 = C02669y.A00(j);
            if (A05[3].charAt(4) != 'j') {
                String[] strArr2 = A05;
                strArr2[0] = "AIwpqv7aDt0R5Z0o8sSBDj22LkfdUh0v";
                strArr2[0] = "AIwpqv7aDt0R5Z0o8sSBDj22LkfdUh0v";
                return elapsedSinceBaseMs + A002;
            }
            String[] strArr3 = A05;
            strArr3[0] = "vgrMGSSY4L8ja71DPmzZRGyrcWnnIJj3";
            strArr3[0] = "vgrMGSSY4L8ja71DPmzZRGyrcWnnIJj3";
            return elapsedSinceBaseMs + A002;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final AP AD3(AP ap) {
        if (this.A03) {
            A03(A6o());
        }
        this.A02 = ap;
        return ap;
    }
}
