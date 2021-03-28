package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Pi  reason: case insensitive filesystem */
public final class C0642Pi {
    public float A00;
    public AnonymousClass0R A01;
    public Map<String, String> A02;

    public C0642Pi(AnonymousClass0R r2) {
        this(r2, 0.0f);
    }

    public C0642Pi(AnonymousClass0R r2, float f) {
        this(r2, f, null);
    }

    public C0642Pi(AnonymousClass0R r2, float f, Map<String, String> map) {
        this.A01 = r2;
        this.A00 = f;
        if (map != null) {
            this.A02 = map;
        } else {
            this.A02 = new HashMap<>();
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A03();
    }

    public final AnonymousClass0R A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A01 == AnonymousClass0R.A0J;
    }
}
