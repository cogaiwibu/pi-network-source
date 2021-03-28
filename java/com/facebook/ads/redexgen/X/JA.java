package com.facebook.ads.redexgen.X;

import java.util.Map;

public class JA {
    public double A00;
    public JF A01;
    public JG A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final JA A00(double d) {
        this.A00 = d;
        return this;
    }

    public final JA A01(JF jf) {
        this.A01 = jf;
        return this;
    }

    public final JA A02(JG jg) {
        this.A02 = jg;
        return this;
    }

    public final JA A03(String str) {
        this.A03 = str;
        return this;
    }

    public final JA A04(String str) {
        this.A04 = str;
        return this;
    }

    public final JA A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final JA A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final JB A07(AnonymousClass8H r11) {
        return new JB(r11, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
