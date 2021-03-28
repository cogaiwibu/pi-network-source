package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.NativeAdViewTypeApi;

/* renamed from: com.facebook.ads.redexgen.X.5G  reason: invalid class name */
public final class AnonymousClass5G implements NativeAdViewTypeApi {
    public final EnumC0486Jc A00;

    public AnonymousClass5G(int i) {
        this.A00 = EnumC0486Jc.A00(i);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
    public final int getHeight() {
        return this.A00.A03();
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
    public final int getValue() {
        return this.A00.A04();
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
    public final int getWidth() {
        return this.A00.A05();
    }
}
