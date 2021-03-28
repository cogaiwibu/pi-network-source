package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class SO implements AnonymousClass3Q {
    public final /* synthetic */ EW A00;
    public final /* synthetic */ AnonymousClass3L A01;

    public SO(EW ew, AnonymousClass3L r2) {
        this.A00 = ew;
        this.A01 = r2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Q
    public final Object A4C(int i) {
        AnonymousClass3J A002 = this.A01.A00(i);
        if (A002 == null) {
            return null;
        }
        return A002.A0N();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Q
    public final List<Object> A55(String str, int i) {
        List<AnonymousClass3J> A03 = this.A01.A03(str, i);
        if (A03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = A03.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(A03.get(i2).A0N());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Q
    public final Object A56(int i) {
        AnonymousClass3J A012 = this.A01.A01(i);
        if (A012 == null) {
            return null;
        }
        return A012.A0N();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3Q
    public final boolean ABb(int i, int i2, Bundle bundle) {
        return this.A01.A04(i, i2, bundle);
    }
}
