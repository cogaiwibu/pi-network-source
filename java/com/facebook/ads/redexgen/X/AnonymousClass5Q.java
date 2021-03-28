package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSize;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.5Q  reason: invalid class name */
public final class AnonymousClass5Q implements InstreamVideoAdViewApi {
    public static byte[] A04;
    public static String[] A05;
    public int A00 = 500;
    @Nullable
    public InstreamVideoAdListener A01;
    public String A02;
    public final InstreamVideoAdView A03;

    static {
        A07();
        A06();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A05;
            if (strArr[6].charAt(3) != strArr[3].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[2] = "bYPi2HoIo573ERs6Og";
            strArr2[2] = "bYPi2HoIo573ERs6Og";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            int i5 = (copyOfRange[i4] ^ i3) ^ 77;
            if (A05[7].charAt(27) != 'y') {
                copyOfRange[i4] = (byte) i5;
                i4++;
            } else {
                String[] strArr3 = A05;
                strArr3[4] = "Sq7y2tR8gj3HEmbU4XyPno6pT93W16mH";
                strArr3[1] = "rlsHXzRCfeM7omVYo9FzTVqRdgDeQr7y";
                copyOfRange[i4] = (byte) i5;
                i4++;
            }
        }
    }

    public static void A06() {
        A04 = new byte[]{63, 59, 56, 12, 29, 16, 28, 23, 26, 28, 55, 28, 13, 14, 22, 11, 18, 82, 117, 104, 111, 105, 126, 122, 118, 59, 122, ByteCompanionObject.MAX_VALUE, 104, 59, 115, 122, 109, 126, 59, 121, 126, 126, 117, 59, ByteCompanionObject.MAX_VALUE, 126, 107, 105, 126, 120, 122, 111, 126, ByteCompanionObject.MAX_VALUE, 26, 6, 11, 9, 15, 7, 15, 4, 30, 35, 46};
    }

    public static void A07() {
        A05 = new String[]{"6YpFKdnZeUBeF7WDSrmaBMCe7HfOYc57", "miC7MzRxLOQa8wWv8sWGlou8AtO76hIB", "EJYl55CP9SMopSurFu", "kl7ibQwe1AQrx3uU2dVSWI2DzUKGSgrF", "EFp21MRWMeffSOWLDRlroYRFZ3OkgZhA", "uHVX0UZuCSrp0FEw298Vi8IcCSvhvS7m", "9XwifO049Mr55FVFIGgFeLBRq5lcoRC5", "6c78zY1geKIDJJzmV6tL7kXg2jKyThsy"};
    }

    public AnonymousClass5Q(InstreamVideoAdView instreamVideoAdView, Context context, Bundle bundle) {
        this.A03 = instreamVideoAdView;
        this.A02 = bundle.getString(A03(50, 11, 39), A03(0, 0, 124));
    }

    public AnonymousClass5Q(InstreamVideoAdView instreamVideoAdView, Context context, String str, AdSize adSize) {
        this.A03 = instreamVideoAdView;
        this.A02 = str;
    }

    private void A04() {
        KT.A01(new TE(this), this.A00);
        this.A00 *= 2;
    }

    public static void A05() {
        Log.w(A03(0, 17, 52), A03(17, 33, 86));
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final InstreamVideoAdView.InstreamVideoLoadConfigBuilder buildLoadAdConfig() {
        A05();
        return new AnonymousClass5P(this);
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void destroy() {
        A05();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final String getPlacementId() {
        A05();
        return this.A02;
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    @Nullable
    public final Bundle getSaveInstanceState() {
        A05();
        return null;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        A05();
        return true;
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final boolean isAdLoaded() {
        A05();
        return false;
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void loadAd() {
        A05();
        A04();
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void loadAd(InstreamVideoAdView.InstreamVideoLoadAdConfig instreamVideoLoadAdConfig) {
        A05();
        A04();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void loadAdFromBid(String str) {
        A05();
        A04();
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void setAdListener(@Nullable InstreamVideoAdListener instreamVideoAdListener) {
        A05();
        this.A01 = instreamVideoAdListener;
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void setExtraHints(ExtraHints extraHints) {
        A05();
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final void setIsAdLoaded(boolean z) {
    }

    @Override // com.facebook.ads.internal.api.InstreamVideoAdViewApi
    public final boolean show() {
        A05();
        KT.A00(new TD(this));
        return false;
    }
}
