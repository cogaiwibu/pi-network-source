package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import java.lang.ref.WeakReference;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.1s  reason: invalid class name and case insensitive filesystem */
public final class C00651s {
    public long A00 = -1;
    @Nullable
    public InterstitialAd A01;
    @Nullable
    public InterstitialAdListener A02;
    @Nullable
    public RewardData A03;
    @Nullable
    public RewardedAdListener A04;
    @Nullable
    public String A05;
    @Nullable
    public String A06;
    @Nullable
    public String A07;
    @Nullable
    public EnumSet<CacheFlag> A08;
    public final C0820Wh A09;
    public final String A0A;
    public final WeakReference<InterstitialAd> A0B;

    public C00651s(C0820Wh wh, @Nullable InterstitialAd interstitialAd, String str) {
        this.A09 = wh;
        this.A0A = str;
        this.A01 = interstitialAd;
        this.A0B = new WeakReference<>(interstitialAd);
    }

    public final long A00() {
        return this.A00;
    }

    @Nullable
    public final InterstitialAd A01() {
        InterstitialAd interstitialAd = this.A01;
        return interstitialAd != null ? interstitialAd : this.A0B.get();
    }

    @Nullable
    public final InterstitialAdListener A02() {
        return this.A02;
    }

    @Nullable
    public final RewardData A03() {
        return this.A03;
    }

    @Nullable
    public final RewardedAdListener A04() {
        return this.A04;
    }

    public final C0820Wh A05() {
        return this.A09;
    }

    @Nullable
    public final String A06() {
        return this.A05;
    }

    @Nullable
    public final String A07() {
        return this.A06;
    }

    @Nullable
    public final String A08() {
        return this.A07;
    }

    public final String A09() {
        return this.A0A;
    }

    @Nullable
    public final EnumSet<CacheFlag> A0A() {
        return this.A08;
    }

    public final void A0B(long j) {
        this.A00 = j;
    }

    public final void A0C(@Nullable InterstitialAd interstitialAd) {
        if (interstitialAd != null || J8.A0k(this.A09)) {
            this.A01 = interstitialAd;
        }
    }

    public final void A0D(@Nullable InterstitialAdListener interstitialAdListener) {
        this.A02 = interstitialAdListener;
    }

    public final void A0E(RewardData rewardData) {
        this.A03 = rewardData;
    }

    public final void A0F(@Nullable RewardedAdListener rewardedAdListener) {
        this.A04 = rewardedAdListener;
    }

    public final void A0G(@Nullable String str) {
        this.A05 = str;
    }

    public final void A0H(@Nullable String str) {
        this.A06 = str;
    }

    public final void A0I(@Nullable String str) {
        this.A07 = str;
    }

    public final void A0J(@Nullable EnumSet<CacheFlag> flags) {
        this.A08 = flags;
    }
}
