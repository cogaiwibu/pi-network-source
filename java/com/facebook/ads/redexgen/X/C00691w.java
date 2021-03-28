package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.1w  reason: invalid class name and case insensitive filesystem */
public final class C00691w {
    public static String[] A0D;
    public int A00 = -1;
    public long A01;
    @Nullable
    public AdExperienceType A02;
    @Nullable
    public RewardData A03;
    @Nullable
    public RewardedVideoAdListener A04;
    @Nullable
    public String A05;
    @Nullable
    public String A06;
    @Nullable
    public String A07;
    public boolean A08;
    @Nullable
    public RewardedVideoAd A09;
    public WeakReference<RewardedVideoAd> A0A;
    public final C0820Wh A0B;
    public final String A0C;

    static {
        A00();
    }

    public static void A00() {
        A0D = new String[]{"pQFQWrff5apwgeDCfICDjWO2FINXUEGY", "Zrlf7mbphLj9aknW7PcFFQ", "n3KJlhWP5Ju2JP4ez23sn5JFnk3TGtqs", "LKe9A2", "QZ6oU5eByjCJaazPOJhmSAWWHc", "bIzEhjdis4s2Gtu6NLj44xIWpvJeHb48", "cSwbeF06gtlZkK5ZI0p5Ev", "223A19fPLhE6SS6l"};
    }

    public C00691w(C0820Wh wh, String str, @Nullable RewardedVideoAd rewardedVideoAd) {
        this.A0B = wh;
        this.A0C = str;
        this.A09 = rewardedVideoAd;
        this.A0A = new WeakReference<>(rewardedVideoAd);
        this.A01 = -1;
    }

    @Nullable
    public final RewardedVideoAd A01() {
        RewardedVideoAd rewardedVideoAd = this.A09;
        return rewardedVideoAd != null ? rewardedVideoAd : this.A0A.get();
    }

    public final void A02(@Nullable RewardedVideoAd rewardedVideoAd) {
        if (rewardedVideoAd != null || J8.A0k(this.A0B)) {
            this.A09 = rewardedVideoAd;
            if (A0D[4].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "GeKQzqug1NPR8FJ6Rbw1ueQ35y";
            strArr[4] = "GeKQzqug1NPR8FJ6Rbw1ueQ35y";
        }
    }
}
