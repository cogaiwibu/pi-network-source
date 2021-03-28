package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Mg  reason: case insensitive filesystem */
public abstract class AbstractC0563Mg extends FrameLayout {
    public int A00;
    public AnonymousClass24 A01;
    public AnonymousClass25 A02;
    @Nullable
    public AnonymousClass26 A03;
    public final C0820Wh A04;
    public final JE A05;
    @Nullable
    public final M6 A06;
    @Nullable
    public final M7 A07;
    public final String A08;
    @Nullable
    public final AnonymousClass1Q A09;
    public final AbstractC0565Mi A0A;

    public abstract void A0K();

    public abstract void A0L();

    public abstract void A0M(AnonymousClass26 v, AnonymousClass24 v2);

    public abstract void A0N(AnonymousClass26 v, AnonymousClass24 v2);

    public abstract boolean A0O();

    public AbstractC0563Mg(C0820Wh wh, JE je, String str) {
        this(wh, je, str, null, null, null);
    }

    public AbstractC0563Mg(C0820Wh wh, JE je, String str, @Nullable AnonymousClass1Q r5, @Nullable M7 m7, @Nullable M6 m6) {
        super(wh);
        this.A00 = 0;
        this.A01 = AnonymousClass24.A04;
        this.A03 = null;
        this.A0A = new C0840Xb(this);
        this.A04 = wh;
        this.A05 = je;
        this.A07 = m7;
        this.A06 = m6;
        this.A08 = str;
        this.A09 = r5;
    }

    public static /* synthetic */ int A00(AbstractC0563Mg mg) {
        int i = mg.A00;
        mg.A00 = i + 1;
        return i;
    }

    public static /* synthetic */ int A01(AbstractC0563Mg mg) {
        int i = mg.A00;
        mg.A00 = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void A0A() {
        if (this.A02.A0B()) {
            this.A05.A7v(this.A08, this.A02.A03());
            this.A02.A04();
        }
    }

    /* access modifiers changed from: private */
    public void A0B() {
        this.A03 = null;
        this.A02.A06();
        A0K();
    }

    /* access modifiers changed from: private */
    public void A0C(AnonymousClass26 r3) {
        this.A02.A09(this.A01);
        A0M(r3, this.A01);
        C00410u.A03();
        if (A0O()) {
            A0A();
        }
    }

    /* access modifiers changed from: private */
    public void A0D(AnonymousClass26 r4) {
        this.A03 = r4;
        this.A02.A0A(this.A01, this.A00);
        A0N(r4, this.A01);
    }

    public final void A0I() {
        A0A();
    }

    public final void A0J() {
        this.A02 = new AnonymousClass25(new JL(this.A08, this.A05));
        M7 m7 = this.A07;
        if (m7 != null) {
            m7.AAO(true);
        }
        A0B();
    }
}
