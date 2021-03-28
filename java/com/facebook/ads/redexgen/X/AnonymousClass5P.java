package com.facebook.ads.redexgen.X;

import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;

/* renamed from: com.facebook.ads.redexgen.X.5P  reason: invalid class name */
public class AnonymousClass5P implements InstreamVideoAdView.InstreamVideoLoadConfigBuilder {
    public final /* synthetic */ AnonymousClass5Q A00;

    public AnonymousClass5P(AnonymousClass5Q r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadConfigBuilder, com.facebook.ads.Ad.LoadConfigBuilder
    public final InstreamVideoAdView.InstreamVideoLoadAdConfig build() {
        return new AnonymousClass5O(this);
    }

    @Override // com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadConfigBuilder
    public final InstreamVideoAdView.InstreamVideoLoadConfigBuilder withAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.A00.A01 = instreamVideoAdListener;
        return this;
    }

    @Override // com.facebook.ads.InstreamVideoAdView.InstreamVideoLoadConfigBuilder, com.facebook.ads.Ad.LoadConfigBuilder
    public final InstreamVideoAdView.InstreamVideoLoadConfigBuilder withBid(String str) {
        return this;
    }
}
