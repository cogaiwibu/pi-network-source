package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.7w */
public final class AnonymousClass7w extends K7 {
    public int A00;
    public boolean A01;
    public final AnonymousClass9K<AnonymousClass7v> A02;
    public final AnonymousClass9K<C02147t> A03;
    public final AnonymousClass9K<C0501Jt> A04;
    public final AnonymousClass9K<C02137s> A05;
    public final AnonymousClass9K<IW> A06;
    public final AnonymousClass9K<IO> A07;
    public final AnonymousClass9K<IN> A08;
    public final AnonymousClass9K<C0459Hz> A09;
    public final AnonymousClass9K<C0454Hu> A0A;
    public final C0532Lb A0B;
    public final JH A0C;
    public final I0 A0D;

    public AnonymousClass7w(C0820Wh wh, JE je, C0532Lb lb, String str) {
        this(wh, je, lb, new ArrayList(), str);
    }

    public AnonymousClass7w(C0820Wh wh, JE je, C0532Lb lb, String str, Bundle bundle) {
        this(wh, je, lb, new ArrayList(), str, bundle, null);
    }

    public AnonymousClass7w(C0820Wh wh, JE je, C0532Lb lb, String str, Map<String, String> extraParams) {
        this(wh, je, lb, new ArrayList(), str, null, extraParams);
    }

    public AnonymousClass7w(C0820Wh wh, JE je, C0532Lb lb, List<AnonymousClass20> list, String str) {
        super(wh, je, lb, list, str, !lb.A0e());
        this.A0D = new C02167z(this);
        this.A07 = new C0518Kk(this);
        this.A03 = new KY(this);
        this.A04 = new KX(this);
        this.A05 = new KV(this);
        this.A02 = new KR(this);
        this.A06 = new KO(this);
        this.A09 = new KM(this);
        this.A0A = new KK(this);
        this.A08 = new LY(this);
        this.A0C = new AnonymousClass80(this);
        this.A01 = false;
        this.A0B = lb;
        this.A0B.getEventBus().A04(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A0C, this.A08);
    }

    public AnonymousClass7w(C0820Wh wh, JE je, C0532Lb lb, List<AnonymousClass20> list, String str, Bundle bundle, Map<String, String> map) {
        super(wh, je, lb, list, str, !lb.A0e(), bundle, map);
        this.A0D = new C02167z(this);
        this.A07 = new C0518Kk(this);
        this.A03 = new KY(this);
        this.A04 = new KX(this);
        this.A05 = new KV(this);
        this.A02 = new KR(this);
        this.A06 = new KO(this);
        this.A09 = new KM(this);
        this.A0A = new KK(this);
        this.A08 = new LY(this);
        this.A0C = new AnonymousClass80(this);
        this.A01 = false;
        this.A0B = lb;
        this.A0B.getEventBus().A04(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A08);
    }

    public final void A0h() {
        this.A0B.getStateHandler().post(new L2(this));
    }
}
