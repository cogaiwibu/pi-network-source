package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.5R  reason: invalid class name */
public final class AnonymousClass5R implements RewardedVideoAdApi, Repairable {
    public static byte[] A04;
    public static String[] A05;
    public final RewardedVideoAd A00;
    public final C00691w A01;
    public final C0374Eo A02 = new C0374Eo(this.A01);
    public final C0820Wh A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{115, 123, 123, 116, -91, -89, 120, 120, -93, -47, -96, -95, -42, -90, -42, -93, -126, -81, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, -126, -81, -125, -127, 74, 73, 122, 69, 122, 121, 76, 77, 62, 62, 108, 110, 109, 111, 109, 106, -80, -76, -84, -84, -81, -34, -33, -80, -109, -65, -65, -110, -106, -61, -66, -111, -90, -45, -89, -44, -96, -44, -92, -88, -113, -76, -70, -85, -72, -76, -89, -78, 102, -85, -72, -72, -75, -72, 116, 80, -110, -91, -73, -95, -78, -92, -91, -92, 96, -74, -87, -92, -91, -81, 96, -95, -92, 96, -92, -91, -77, -76, -78, -81, -71, -91, -92, -76, -57, -39, -61, -44, -58, -57, -58, -126, -40, -53, -58, -57, -47, -126, -61, -58, -126, -50, -47, -61, -58, -126, -44, -57, -45, -41, -57, -43, -42, -57, -58, -72, -53, -35, -57, -40, -54, -53, -54, -122, -36, -49, -54, -53, -43, -122, -57, -54, -122, -39, -50, -43, -35, -122, -55, -57, -46, -46, -53, -54, -116, -115, -101, -100, -102, -105, -95, 112, 115, 101, 104, 69, 104, -42, -39, -53, -50, -85, -50, -80, -36, -39, -41, -84, -45, -50, -97, -108, -101, -93};
    }

    public static void A02() {
        A05 = new String[]{"q8F3UYcndC8Ej6EzPObAfC2CDIoe743", "WHSSbjkejcnDJnmz9i28DmVQ7s5doV", "7Ae3C11G9ZnRQnjC1YEsbkjNlyvjMOhJ", "xIErM25UzhDXOZX5lXVK71ghnZu2uIsx", "TpWxEHvEZyAqJcOvGEooXr2tQ3t7MLKT", "CpjtrdZmrEbCE1OZgZlStH8uGVShpb", "AnU5GMoet7ZaRK4jG6aRRqRoHnPXG1EV", "P"};
    }

    public AnonymousClass5R(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        this.A00 = rewardedVideoAd;
        this.A03 = AnonymousClass57.A05(context);
        this.A03.A0A().A2j(AdPlacementType.REWARDED_VIDEO.toString());
        this.A01 = new C00691w(this.A03, str, this.A00);
        this.A03.A0C(this);
    }

    private final void A03(@Nullable String str, boolean z) {
        A04(str, null, z);
    }

    public final void A04(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (str == null) {
            this.A03.A0A().A2g();
        } else {
            C0820Wh wh = this.A03;
            if (A05[1].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "VbNMcinO8suVZXvBDeNnaTURWjAwCx";
            strArr[1] = "VbNMcinO8suVZXvBDeNnaTURWjAwCx";
            wh.A0A().A2f();
        }
        this.A02.A09(this.A00, str, adExperienceType, z);
        this.A03.A0A().A2e();
    }

    @Override // com.facebook.ads.FullScreenAd, com.facebook.ads.internal.api.RewardedVideoAdApi
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return new AnonymousClass5S(this);
    }

    @Override // com.facebook.ads.FullScreenAd, com.facebook.ads.internal.api.RewardedVideoAdApi
    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return new AnonymousClass5T();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void destroy() {
        K0.A05(A00(168, 7, 36), A00(80, 27, 60), A00(24, 8, 17));
        if (!J8.A1E(this.A03)) {
            this.A02.A05();
            this.A03.A0A().A2k();
        }
    }

    public final void finalize() {
        this.A02.A04();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.RewardedVideoAdApi
    public final String getPlacementId() {
        return this.A01.A0C;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final int getVideoDuration() {
        return this.A01.A00;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean A0A = this.A02.A0A();
        this.A03.A0A().A4X(A0A);
        return A0A;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean isAdLoaded() {
        return this.A02.A0B();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAd() {
        K0.A05(A00(175, 6, 0), A00(107, 32, 94), A00(48, 8, 89));
        A03(null, true);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        ((AnonymousClass5S) rewardedVideoLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAd(boolean z) {
        K0.A05(A00(175, 6, 0), A00(107, 32, 94), A00(32, 8, 5));
        A03(null, z);
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.RewardedVideoAdApi
    @Deprecated
    public final void loadAdFromBid(String str) {
        K0.A05(A00(181, 13, 102), A00(107, 32, 94), A00(16, 8, 74));
        A03(str, true);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAdFromBid(String str, boolean z) {
        K0.A05(A00(181, 13, 102), A00(107, 32, 94), A00(56, 8, 107));
        A03(str, z);
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        if (this.A01.A04 != null) {
            RewardedVideoAdListener rewardedVideoAdListener = this.A01.A04;
            RewardedVideoAd rewardedVideoAd = this.A00;
            rewardedVideoAdListener.onError(rewardedVideoAd, new AdError(2001, A00(64, 16, 66) + LN.A03(this.A01.A0B, th)));
        }
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        boolean z;
        this.A01.A04 = rewardedVideoAdListener;
        AnonymousClass0S A0A = this.A03.A0A();
        if (rewardedVideoAdListener != null) {
            z = true;
        } else {
            z = false;
        }
        A0A.A2c(z);
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.RewardedVideoAdApi
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A01.A06 = extraHints.getHints();
        this.A01.A07 = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void setRewardData(RewardData rewardData) {
        this.A02.A08(rewardData);
    }

    @Override // com.facebook.ads.FullScreenAd, com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean show() {
        K0.A05(A00(194, 4, 40), A00(139, 29, 98), A00(8, 8, 108));
        return show(-1);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean show(int i) {
        K0.A05(A00(194, 4, 40), A00(139, 29, 98), A00(40, 8, 119));
        this.A03.A0A().A2p();
        boolean A0C = this.A02.A0C(this.A00, new AnonymousClass5T().withAppOrientation(i).build());
        this.A03.A0A().A2o(A0C);
        return A0C;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        K0.A05(A00(194, 4, 40), A00(139, 29, 98), A00(0, 8, 62));
        this.A03.A0A().A2p();
        boolean A0C = this.A02.A0C(this.A00, rewardedVideoShowAdConfig);
        this.A03.A0A().A2o(A0C);
        return A0C;
    }
}
