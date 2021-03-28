package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;

public abstract class RM implements AbstractC00340n {
    public int A00;
    public RewardData A01;

    public abstract int A0B();

    public abstract boolean A0C();

    public final void A00(int i) {
        this.A00 = i;
    }

    public final void A01(RewardData rewardData) {
        this.A01 = rewardData;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final AdPlacementType A6i() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}
