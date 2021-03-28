package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import java.util.EnumSet;

public final class Ep extends AbstractC0702Rq {
    public static String[] A03;
    @VisibleForTesting
    public static final AbstractC00661t A04 = new S0();
    @Nullable
    public C0707Rv A00;
    public final C00651s A01;
    public final C0820Wh A02;

    public static void A00() {
        A03 = new String[]{"Wdifh5HSN4RyvogFUrIVqQJQULlKdEei", "S34yOHPbjBOZXrhEKXqsFwPvtnd1qciy", "vu9eRI", "x0OqZ", "VYF0eZRg0jpnLcLhIoRoBnoO3djZf6SI", "33GTCt01Ki3rQT8tpwoWMPFpMqFvVQrj", "pa13jV0ykdfTm6Oo414mEZE7qu5xzGka", "tj8XsVszyFe6dIsjKXzcwTwgC3z6jHVp"};
    }

    static {
        A00();
    }

    public Ep(C00651s r3) {
        super(r3.A05(), A04.A4M(r3));
        this.A01 = r3;
        this.A02 = r3.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0702Rq
    public final void A05() {
        C0707Rv rv = this.A00;
        if (rv != null) {
            rv.A0A();
        }
        AbstractC00621p r4 = super.A00;
        EnumC00611o r3 = EnumC00611o.A04;
        if (A03[1].charAt(8) != 'f') {
            String[] strArr = A03;
            strArr[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
            strArr[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
            r4.ACt(r3);
            return;
        }
        throw new RuntimeException();
    }

    public final void A07() {
        this.A00 = new C0707Rv(this.A01, this, super.A02);
        this.A00.A0B(this.A01.A0A(), this.A01.A06());
    }

    public final void A08(InterstitialAd interstitialAd, EnumSet<CacheFlag> enumSet, @Nullable String str) {
        if (!super.A00.A51()) {
            this.A01.A0C(interstitialAd);
            C0707Rv rv = this.A00;
            if (rv != null) {
                rv.A0B(enumSet, str);
                return;
            }
            this.A01.A0J(enumSet);
            this.A01.A0G(str);
            A07();
        }
    }

    public final boolean A09() {
        C0707Rv rv = this.A00;
        if (rv != null) {
            return rv.A0C();
        }
        if (this.A01.A00() > 0) {
            int i = (LW.A00() > this.A01.A00() ? 1 : (LW.A00() == this.A01.A00() ? 0 : -1));
            if (A03[0].charAt(6) != 'y') {
                String[] strArr = A03;
                strArr[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
                strArr[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
                if (i > 0) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    public final boolean A0A() {
        C0707Rv rv = this.A00;
        if (rv != null) {
            return rv.A0D();
        }
        return super.A00.A5I() == EnumC00611o.A06;
    }

    public final boolean A0B(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A52()) {
            return false;
        }
        this.A01.A0C(interstitialAd);
        C0707Rv rv = this.A00;
        if (rv != null) {
            return rv.A0E();
        }
        this.A00 = new C0707Rv(this.A01, this, super.A02);
        this.A00.A0E();
        return false;
    }
}
