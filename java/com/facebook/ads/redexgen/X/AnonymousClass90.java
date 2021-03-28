package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.90  reason: invalid class name */
public final class AnonymousClass90 {
    public static byte[] A05;
    public int A00 = 0;
    public AnonymousClass91 A01;
    @Nullable
    public String A02;
    @Nullable
    public String A03;
    public List<C02408y> A04 = new ArrayList();

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 109);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{79, 88};
    }

    public AnonymousClass90(AnonymousClass91 r2, @Nullable String str, @Nullable String str2) {
        this.A01 = r2;
        this.A03 = str;
        this.A02 = str2;
    }

    public final int A02() {
        return this.A04.size();
    }

    public final long A03() {
        AnonymousClass91 r0 = this.A01;
        if (r0 != null) {
            return r0.A0C() + ((long) this.A01.A03());
        }
        return -1;
    }

    public final C02408y A04() {
        if (this.A00 >= this.A04.size()) {
            return null;
        }
        this.A00++;
        return this.A04.get(this.A00 - 1);
    }

    public final AnonymousClass91 A05() {
        return this.A01;
    }

    @Nullable
    public final String A06() {
        return this.A02;
    }

    @Nullable
    public final String A07() {
        int i = this.A00;
        if (i <= 0 || i > this.A04.size()) {
            return null;
        }
        return this.A04.get(this.A00 - 1).A06().optString(A00(0, 2, 65));
    }

    @Nullable
    public final String A08() {
        return this.A03;
    }

    public final void A09(C02408y r2) {
        this.A04.add(r2);
    }

    public final boolean A0A() {
        return this.A01 == null || LW.A00() > this.A01.A0C() + ((long) this.A01.A03());
    }
}
