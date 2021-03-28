package com.facebook.ads.redexgen.X;

import java.util.Map;

public class S8 extends AnonymousClass2P<K, V> {
    public final /* synthetic */ S9 A00;

    public S8(S9 s9) {
        this.A00 = s9;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final int A05() {
        return ((AnonymousClass2S) this.A00).A00;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final int A06(Object obj) {
        return this.A00.A09(obj);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final int A07(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final Object A08(int i, int i2) {
        return this.A00.A02[(i << 1) + i2];
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final V A09(int i, V v) {
        return (V) this.A00.A0D(i, v);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final Map<K, V> A0B() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final void A0E() {
        this.A00.clear();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final void A0F(int i) {
        this.A00.A0B(i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2P
    public final void A0G(K k, V v) {
        this.A00.put(k, v);
    }
}
