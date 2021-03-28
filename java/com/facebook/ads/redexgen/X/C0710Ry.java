package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ry  reason: case insensitive filesystem */
public final class C0710Ry implements AbstractC00641r {
    public static byte[] A07;
    public static String[] A08;
    public static final String A09 = C0710Ry.class.getSimpleName();
    public int A00 = 0;
    public long A01 = -1;
    public Eq A02;
    @Nullable
    public String A03;
    public boolean A04 = false;
    public final S2SRewardedVideoAdExtendedListener A05;
    public final C00691w A06;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{120, 87, 25, 88, 93, 25, 85, 86, 88, 93, 25, 80, 74, 25, 88, 85, 75, 92, 88, 93, 64, 25, 80, 87, 25, 73, 75, 86, 94, 75, 92, 74, 74, 23, 25, 96, 86, 76, 25, 74, 81, 86, 76, 85, 93, 25, 78, 88, 80, 77, 25, 95, 86, 75, 25, 88, 93, 117, 86, 88, 93, 92, 93, 17, 16, 25, 77, 86, 25, 91, 92, 25, 90, 88, 85, 85, 92, 93, 47, 24, 24, 5, 24, 74, 6, 5, 11, 14, 3, 4, 13, 74, 24, 15, 29, 11, 24, 14, 15, 14, 74, 28, 3, 14, 15, 5, 74, 11, 14, 92, 77, 84};
        if (A08[6].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[4] = "OGOVhUIoezz1oHK";
        strArr[0] = "xl2MkcRK0CWEWUY";
    }

    public static void A07() {
        A08 = new String[]{"gd6Snq8TqC5qGLc", "5Vo8FrFWo5Fl4YG5W1yHT6ZfMsOXSACT", "HYpFHiAeuVvng5d4eXQK0awgijL0SEef", "zgL9OdntC9Jt", "c4pha1QVXZPHNWU", "oPtBq8V8zceab2K03f0YSkruz1vfGvQp", "tGZii7gSURWSZ1CI0FSKqsks", "YmWpveYB3lCv"};
    }

    static {
        A07();
        A06();
    }

    public C0710Ry(C00691w r3, AbstractC00721z r4, String str) {
        this.A06 = r3;
        this.A05 = new S5(str, r4, this, r3);
    }

    private void A09(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (!this.A04 && this.A02 != null) {
            Log.w(A09, A04(0, 78, 100));
        }
        A0A(false);
        this.A04 = false;
        C00571k r2 = new C00571k(this.A06.A0C, EnumC0500Js.A07, AdPlacementType.REWARDED_VIDEO, EnumC0499Jr.A08, 1);
        r2.A07(z);
        r2.A05(this.A06.A06);
        r2.A06(this.A06.A07);
        this.A02 = new Eq(this.A06.A0B, r2);
        this.A02.A0R(new C0708Rw(this));
        this.A02.A0U(str, adExperienceType);
    }

    /* access modifiers changed from: private */
    public void A0A(boolean z) {
        Eq eq = this.A02;
        if (eq != null) {
            eq.A0R(new C0709Rx(this));
            this.A02.A0W(z);
            this.A02 = null;
        }
    }

    public final long A0C() {
        Eq eq = this.A02;
        if (eq != null) {
            return eq.A0F();
        }
        return -1;
    }

    public final void A0D() {
        A0A(true);
    }

    public final void A0E(RewardData rewardData) {
        this.A06.A03 = rewardData;
        if (this.A04) {
            this.A02.A0Y(rewardData);
        }
    }

    public final void A0F(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        this.A01 = System.currentTimeMillis();
        try {
            A09(str, adExperienceType, z);
        } catch (Exception e) {
            Log.e(A09, A04(78, 31, 55), e);
            this.A06.A0B.A04().A82(A04(109, 3, 96), C02248i.A0Q, new C02258j(e));
            AdError internalError = AdError.internalError(2004);
            this.A06.A0B.A0A().A2d(LW.A01(this.A01), internalError.getErrorCode(), internalError.getErrorMessage());
            this.A05.onError(this.A06.A01(), internalError);
        }
    }

    public final boolean A0G() {
        Eq eq = this.A02;
        return eq == null || eq.A0X();
    }

    public final boolean A0H() {
        return this.A04;
    }

    public final boolean A0I(int i) {
        if (!this.A04) {
            this.A05.onError(this.A06.A01(), AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            String[] strArr = A08;
            if (strArr[4].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[2] = "i4TgsteijYTgF3ZXWgh52CAoLdUIST6S";
            strArr2[1] = "KfQZimx5EO3wO5BoFkpX8kIEmrokSzla";
            return false;
        }
        Eq eq = this.A02;
        if (eq != null) {
            eq.A08.A02(i);
            this.A02.A0K();
            this.A04 = false;
            return true;
        }
        this.A04 = false;
        return false;
    }
}
