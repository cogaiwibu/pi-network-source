package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.26  reason: invalid class name */
public final class AnonymousClass26 implements Serializable {
    public static final long serialVersionUID = -3209129042070173126L;
    public AnonymousClass26 A00;
    public final int A01;
    public final String A02;
    @Nullable
    public final String A03;
    public final List<AnonymousClass26> A04;

    public AnonymousClass26(int i, @Nullable String str, String str2) {
        this.A04 = new ArrayList();
        this.A01 = i;
        this.A03 = str;
        this.A02 = str2;
    }

    public AnonymousClass26(String str) {
        this(0, null, str);
    }

    private void A00(AnonymousClass26 r1) {
        this.A00 = r1;
    }

    public final int A01() {
        return this.A01;
    }

    public final AnonymousClass26 A02() {
        return this.A00;
    }

    @Nullable
    public final String A03() {
        return this.A02;
    }

    public final String A04() {
        return this.A03;
    }

    public final List<AnonymousClass26> A05() {
        return this.A04;
    }

    public final void A06(AnonymousClass26 r2) {
        r2.A00(this);
        this.A04.add(r2);
    }
}
