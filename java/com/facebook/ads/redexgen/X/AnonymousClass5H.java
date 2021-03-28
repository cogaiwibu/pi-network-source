package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.5H  reason: invalid class name */
public final class AnonymousClass5H implements NativeAdsManagerApi {
    public static byte[] A0A;
    public static final String A0B = NativeAdsManager.class.getSimpleName();
    public int A00 = -1;
    public NativeAdsManager.Listener A01;
    public C0696Rk A02;
    public String A03;
    public boolean A04 = false;
    public boolean A05 = false;
    public final int A06;
    public final C0820Wh A07;
    public final String A08;
    public final List<NativeAd> A09;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{27, 60, 52, 49, 56, 57, 125, 41, 50, 125, 52, 51, 52, 41, 52, 60, 49, 52, 39, 56, 125, 30, 50, 50, 54, 52, 56, 16, 60, 51, 60, 58, 56, 47, 115};
    }

    static {
        A01();
    }

    @SuppressLint({"CatchGeneralException"})
    public AnonymousClass5H(Context context, String str, int i) {
        this.A07 = AnonymousClass57.A02(context);
        this.A08 = str;
        this.A06 = Math.max(i, 0);
        this.A09 = new ArrayList(i);
        try {
            CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Exception e) {
            Log.w(A0B, A00(0, 35, 89), e);
        }
    }

    public final NativeAdsManager.Listener A02() {
        return this.A01;
    }

    public final C0696Rk A03() {
        return this.A02;
    }

    public final void A04() {
        this.A09.clear();
    }

    public final void A05(int i) {
        this.A00 = i;
    }

    public final void A06(NativeAd nativeAd) {
        this.A09.add(nativeAd);
    }

    public final void A07(boolean z) {
        this.A04 = z;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void disableAutoRefresh() {
        this.A05 = true;
        C0696Rk rk = this.A02;
        if (rk != null) {
            rk.A07();
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final int getUniqueNativeAdCount() {
        return this.A09.size();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final boolean isLoaded() {
        return this.A04;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds() {
        loadAds(NativeAdBase.MediaCacheFlag.ALL);
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        EnumC0500Js js = EnumC0500Js.A06;
        int i = this.A06;
        C0696Rk rk = this.A02;
        this.A02 = new C0696Rk(this.A07, this.A08, js, null, i);
        if (this.A05) {
            this.A02.A07();
        }
        this.A02.A0A(this.A03);
        this.A02.A09(new TA(this, this.A07, mediaCacheFlag));
        this.A02.A08();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final NativeAd nextNativeAd() {
        if (this.A09.size() == 0) {
            return null;
        }
        int i = this.A00;
        this.A00 = i + 1;
        List<NativeAd> list = this.A09;
        NativeAd nativeAd = list.get(i % list.size());
        if (i >= this.A09.size()) {
            return new NativeAd(this.A07, nativeAd);
        }
        return nativeAd;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setExtraHints(String str) {
        this.A03 = str;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setListener(NativeAdsManager.Listener listener) {
        this.A01 = listener;
    }
}
