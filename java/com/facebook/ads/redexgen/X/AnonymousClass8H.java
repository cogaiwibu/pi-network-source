package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.8H  reason: invalid class name */
public class AnonymousClass8H extends ContextWrapper {
    public final AnonymousClass8J A00;
    public final AtomicReference<String> A01 = new AtomicReference<>();

    public AnonymousClass8H(Context context, AnonymousClass8J r3) {
        super(context.getApplicationContext());
        this.A00 = r3;
    }

    public final C0821Wi A00() {
        C0821Wi A002 = AnonymousClass8G.A00();
        if (A002 != null) {
            return A002;
        }
        C0821Wi wi = new C0821Wi(this, this.A00);
        AnonymousClass8G.A01(wi);
        return wi;
    }

    public final AnonymousClass8I A01() {
        return this.A00.A5V(this);
    }

    public final AnonymousClass8K A02() {
        return this.A00.A68(this);
    }

    public final AnonymousClass8L A03() {
        return this.A00.A6r(this);
    }

    public final AbstractC02238h A04() {
        return this.A00.A5z(this);
    }

    public final AnonymousClass97 A05() {
        return this.A00.A6x();
    }

    public final JE A06() {
        return this.A00.A5H(A00());
    }

    @Nullable
    public final String A07() {
        return this.A01.get();
    }

    public final void A08(@Nullable String str) {
        this.A01.set(str);
    }
}
