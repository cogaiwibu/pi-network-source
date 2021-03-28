package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;

public class F0 extends XQ {
    public static byte[] A02;
    public final /* synthetic */ RD A00;
    public final /* synthetic */ RI A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{21, 34, 34, 63, 34, 112, 53, 40, 53, 51, 37, 36, 57, 62, 55, 112, 49, 51, 36, 57, 63, 62, 17, 21, 22, 19};
    }

    public F0(RD rd, RI ri) {
        this.A00 = rd;
        this.A01 = ri;
    }

    @Override // com.facebook.ads.redexgen.X.NN
    public final void A8t() {
        this.A00.A09 = true;
        if (this.A00.A0A) {
            this.A00.A06();
        }
    }

    @Override // com.facebook.ads.redexgen.X.XQ, com.facebook.ads.redexgen.X.NN
    public final void A99(String str, Map<String, String> map) {
        this.A00.A02.A0A().A3Z();
        Uri parse = Uri.parse(str);
        if (A00(22, 4, 12).equals(parse.getScheme()) && C00270g.A04(parse.getAuthority()) && this.A00.A00 != null) {
            this.A00.A00.A91(this.A00);
        }
        AbstractC00260f A002 = C00270g.A00(this.A00.A02, this.A00.A03, this.A01.A5j(), parse, map);
        if (A002 != null) {
            try {
                this.A00.A02.A0A().A3W();
                A002.A0D();
            } catch (Exception e) {
                Log.e(RD.A0D, A00(0, 22, 43), e);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.XQ, com.facebook.ads.redexgen.X.NN
    public final void A9i() {
        boolean z;
        AbstractC0685Qz A0F = this.A00.A02.A0A();
        if (this.A00.A01 != null) {
            z = true;
        } else {
            z = false;
        }
        A0F.A3a(z);
        if (this.A00.A01 != null) {
            this.A00.A01.A03();
        }
    }

    @Override // com.facebook.ads.redexgen.X.XQ, com.facebook.ads.redexgen.X.NN
    public final void AAM() {
        this.A00.A02.A0A().A3c();
        this.A00.A01.A08();
    }
}
