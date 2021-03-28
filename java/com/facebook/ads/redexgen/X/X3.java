package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

public class X3 extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0821Wi A00;

    public X3(C0821Wi wi) {
        this.A00 = wi;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null) {
            dynamicLoader.createBidderTokenProviderApi().getBidderToken(this.A00);
        }
    }
}
