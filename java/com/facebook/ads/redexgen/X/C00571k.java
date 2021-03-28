package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.AdSettings;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.1k  reason: invalid class name and case insensitive filesystem */
public final class C00571k {
    public int A00;
    @Nullable
    public RewardData A01;
    @Nullable
    public JU A02;
    @Nullable
    public String A03;
    @Nullable
    public String A04;
    public boolean A05;
    public final EnumC0499Jr A06;
    public final EnumC0500Js A07;
    public final String A08;
    @Nullable
    public final EnumSet<CacheFlag> A09;
    public final int A0A;
    public final AdPlacementType A0B;

    public C00571k(String str, EnumC0500Js js, AdPlacementType adPlacementType, EnumC0499Jr jr, int i) {
        this(str, js, adPlacementType, jr, i, EnumSet.of(CacheFlag.NONE));
    }

    public C00571k(String str, EnumC0500Js js, AdPlacementType adPlacementType, EnumC0499Jr jr, int i, @Nullable EnumSet<CacheFlag> enumSet) {
        this.A08 = str;
        this.A0B = adPlacementType;
        this.A06 = jr;
        this.A0A = i;
        this.A09 = enumSet;
        this.A07 = js;
        this.A00 = -1;
    }

    public final AdPlacementType A00() {
        AdPlacementType adPlacementType = this.A0B;
        if (adPlacementType != null) {
            return adPlacementType;
        }
        EnumC0499Jr jr = this.A06;
        if (jr == null) {
            return AdPlacementType.NATIVE;
        }
        if (jr == EnumC0499Jr.A08) {
            return AdPlacementType.INTERSTITIAL;
        }
        return AdPlacementType.BANNER;
    }

    public final KC A01(C0820Wh wh, C0505Jx jx, @Nullable AdExperienceType adExperienceType) {
        LH lh;
        boolean z;
        String str = this.A08;
        EnumC0499Jr jr = this.A06;
        String str2 = null;
        if (jr != null) {
            lh = new LH(jr.getHeight(), this.A06.getWidth());
        } else {
            lh = null;
        }
        EnumC0500Js js = this.A07;
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            str2 = AdSettings.getTestAdType().getAdTypeString();
        }
        int i = this.A0A;
        boolean isTestMode = AdSettings.isTestMode(wh);
        if (AdSettings.isChildDirected() || AdSettings.isMixedAudience()) {
            z = true;
        } else {
            z = false;
        }
        return new KC(wh, str, lh, js, str2, i, isTestMode, z, jx, LN.A01(J8.A0H(wh)), this.A03, adExperienceType);
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final void A03(@Nullable RewardData rewardData) {
        this.A01 = rewardData;
    }

    public final void A04(@Nullable JU ju) {
        this.A02 = ju;
    }

    public final void A05(@Nullable String str) {
        this.A03 = str;
    }

    public final void A06(@Nullable String str) {
        this.A04 = str;
    }

    public final void A07(boolean z) {
        this.A05 = z;
    }
}
