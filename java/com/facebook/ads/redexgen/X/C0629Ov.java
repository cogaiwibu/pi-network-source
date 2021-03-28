package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ov  reason: case insensitive filesystem */
public final class C0629Ov extends AnonymousClass43<C0592Nk> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    @Nullable
    public M6 A04;
    public String A05;
    public List<OQ> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AnonymousClass16 A08;
    public final AnonymousClass7H A09;
    public final C0820Wh A0A;
    public final JE A0B;
    public final LX A0C;
    public final C0630Ow A0D;
    public final C0641Ph A0E;

    public C0629Ov(C0820Wh wh, List<OQ> list, AnonymousClass16 r4, JE je, AnonymousClass7H r6, C0641Ph ph, LX lx, M6 m6, String str, int i, int i2, int i3, int i4, C0630Ow ow) {
        this.A0A = wh;
        this.A0B = je;
        this.A09 = r6;
        this.A0E = ph;
        this.A0C = lx;
        this.A04 = m6;
        this.A08 = r4;
        this.A06 = list;
        this.A00 = i;
        this.A03 = i4;
        this.A05 = str;
        this.A01 = i3;
        this.A02 = i2;
        this.A0D = ow;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0592Nk A07(ViewGroup viewGroup, int i) {
        return new C0592Nk(O6.A00(new C0599Nr(this.A0A, this.A0B, this.A04, this.A08, null, this.A0E, this.A0C).A0H(), this.A03, this.A05, this.A0D), this.A07, this.A0E, this.A00, this.A01, this.A02, this.A06.size(), this.A0A);
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A0F(C0592Nk nk, int i) {
        nk.A0m(this.A06.get(i), this.A0B, this.A09, this.A0C, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass43
    public final int A0E() {
        return this.A06.size();
    }
}
