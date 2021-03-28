package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.8j  reason: invalid class name and case insensitive filesystem */
public final class C02258j extends Exception {
    public int A00 = 0;
    public int A01 = -1;
    @Nullable
    public JSONObject A02;
    public boolean A03 = true;
    public boolean A04 = true;

    public C02258j(String str) {
        super(str);
    }

    public C02258j(String str, String str2) {
        super(str + '\n' + str2);
    }

    public C02258j(Throwable th) {
        super(th);
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    @Nullable
    public final JSONObject A02() {
        return this.A02;
    }

    public final void A03(int i) {
        this.A00 = i;
    }

    public final void A04(int i) {
        this.A01 = i;
    }

    public final void A05(@Nullable JSONObject jSONObject) {
        this.A02 = jSONObject;
    }

    public final void A06(boolean z) {
        this.A03 = z;
    }

    public final void A07(boolean z) {
        this.A04 = z;
    }

    public final boolean A08() {
        return this.A03;
    }

    public final boolean A09() {
        return this.A04;
    }
}
