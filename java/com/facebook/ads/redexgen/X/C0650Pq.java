package com.facebook.ads.redexgen.X;

import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.Pq  reason: case insensitive filesystem */
public class C0650Pq {
    public C0654Pu A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final C0650Pq A00(C0654Pu pu) {
        this.A00 = pu;
        return this;
    }

    public final C0650Pq A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final C0650Pq A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final C0650Pq A03(boolean z) {
        this.A04 = z;
        return this;
    }

    public final C0650Pq A04(boolean z) {
        this.A03 = z;
        return this;
    }

    public final C0651Pr A05() {
        return new C0651Pr(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
