package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.Rv  reason: case insensitive filesystem */
public final class C0707Rv implements AbstractC00641r {
    public static byte[] A07;
    public static final String A08 = C0707Rv.class.getSimpleName();
    public long A00 = -1;
    public C0377Et A01;
    public boolean A02;
    public boolean A03;
    public final C0820Wh A04;
    public final InterstitialAdExtendedListener A05;
    public final C00651s A06;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 110);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{-59, -14, -92, -27, -24, -92, -16, -13, -27, -24, -92, -19, -9, -92, -27, -16, -10, -23, -27, -24, -3, -92, -19, -14, -92, -12, -10, -13, -21, -10, -23, -9, -9, -78, -92, -35, -13, -7, -92, -9, -20, -13, -7, -16, -24, -92, -5, -27, -19, -8, -92, -22, -13, -10, -92, -27, -24, -48, -13, -27, -24, -23, -24, -84, -83, -92, -8, -13, -92, -26, -23, -92, -25, -27, -16, -16, -23, -24, -4, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -45, 31, 34, 20, 23, -45, 22, 20, 31, 31, 24, 23, -45, 42, 27, 28, 31, 24, -45, 38, 27, 34, 42, 28, 33, 26, -45, 28, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -31, 13, 28, 21};
    }

    static {
        A06();
    }

    public C0707Rv(C00651s r3, AbstractC00721z r4, String str) {
        this.A06 = r3;
        this.A04 = r3.A05();
        this.A05 = new S4(str, r4, this);
    }

    public final long A09() {
        C0377Et et = this.A01;
        if (et != null) {
            return et.A0F();
        }
        return -1;
    }

    public final void A0A() {
        C0377Et et = this.A01;
        if (et != null) {
            et.A0R(new C0706Ru(this));
            this.A01.A0W(true);
            this.A01 = null;
            this.A03 = false;
            this.A02 = false;
        }
    }

    /* JADX INFO: Multiple debug info for r9v0 'this'  com.facebook.ads.redexgen.X.Rv: [D('metrics' android.util.DisplayMetrics), D('error' com.facebook.ads.internal.protocol.AdErrorType)] */
    public final void A0B(@Nullable EnumSet<CacheFlag> enumSet, @Nullable String str) {
        this.A00 = System.currentTimeMillis();
        if (!this.A03 && this.A01 != null) {
            Log.w(A08, A05(0, 78, 22));
        }
        this.A03 = false;
        if (!this.A02 || J8.A0d(this.A04)) {
            C0377Et et = this.A01;
            if (et != null) {
                et.A0R(new C0703Rr(this));
                this.A01.A0L();
                this.A01 = null;
            }
            C00571k r2 = new C00571k(this.A06.A09(), C0502Ju.A01(this.A04.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, EnumC0499Jr.A08, 1, enumSet);
            r2.A05(this.A06.A07());
            r2.A06(this.A06.A08());
            r2.A03(this.A06.A03());
            this.A01 = new C0377Et(this.A04, r2);
            this.A01.A0R(new C0705Rt(this));
            this.A01.A0T(str);
            return;
        }
        this.A04.A04().A82(A05(130, 3, 62), C02248i.A0B, new C02258j(A05(78, 52, 69)));
        AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
        this.A04.A0A().A2d(LW.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        this.A05.onError(this.A06.A01(), new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
    }

    public final boolean A0C() {
        C0377Et et = this.A01;
        return et == null || et.A0X();
    }

    public final boolean A0D() {
        return this.A03;
    }

    public final boolean A0E() {
        AdError adError = AdError.SHOW_CALLED_BEFORE_LOAD_ERROR;
        if (!this.A03) {
            this.A04.A0A().A2d(LW.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A05.onError(this.A06.A01(), adError);
            return false;
        }
        C0377Et et = this.A01;
        if (et == null) {
            this.A04.A04().A82(A05(130, 3, 62), C02248i.A0H, new C02258j(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
            this.A04.A0A().A2d(LW.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A05.onError(this.A06.A01(), adError);
            return false;
        }
        et.A0K();
        this.A02 = true;
        this.A03 = false;
        return true;
    }
}
