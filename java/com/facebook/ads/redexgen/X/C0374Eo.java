package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;

/* renamed from: com.facebook.ads.redexgen.X.Eo  reason: case insensitive filesystem */
public final class C0374Eo extends AbstractC0702Rq {
    @Nullable
    public C0710Ry A00;
    public final C00691w A01;

    public C0374Eo(C00691w r3) {
        super(r3.A0B, A00(r3));
        this.A01 = r3;
    }

    public static AbstractC00681v A00(C00691w r1) {
        return new S3(r1);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0702Rq
    public final void A05() {
        C0710Ry ry = this.A00;
        if (ry != null) {
            ry.A0D();
        }
        super.A00.ACt(EnumC00611o.A04);
    }

    public final void A07() {
        this.A00 = new C0710Ry(this.A01, this, this.A02);
        this.A00.A0F(this.A01.A05, this.A01.A02, this.A01.A08);
    }

    public final void A08(RewardData rewardData) {
        this.A01.A03 = rewardData;
        C0710Ry ry = this.A00;
        if (ry != null) {
            ry.A0E(rewardData);
        }
    }

    public final void A09(RewardedVideoAd rewardedVideoAd, @Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (!super.A00.A51()) {
            this.A01.A02(rewardedVideoAd);
            C0710Ry ry = this.A00;
            if (ry != null) {
                ry.A0F(str, adExperienceType, z);
                return;
            }
            C00691w r0 = this.A01;
            r0.A05 = str;
            r0.A02 = adExperienceType;
            r0.A08 = z;
            A07();
        }
    }

    public final boolean A0A() {
        C0710Ry ry = this.A00;
        if (ry != null) {
            return ry.A0G();
        }
        return this.A01.A01 > 0 && LW.A00() > this.A01.A01;
    }

    public final boolean A0B() {
        C0710Ry ry = this.A00;
        if (ry != null) {
            return ry.A0H();
        }
        return super.A00.A5I() == EnumC00611o.A06;
    }

    public final boolean A0C(RewardedVideoAd rewardedVideoAd, RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        int A002 = ((AnonymousClass5T) rewardedVideoShowAdConfig).A00();
        if (super.A00.A52()) {
            return false;
        }
        this.A01.A02(rewardedVideoAd);
        C0710Ry ry = this.A00;
        if (ry != null) {
            return ry.A0I(A002);
        }
        this.A00 = new C0710Ry(this.A01, this, this.A02);
        this.A00.A0I(A002);
        return false;
    }
}
