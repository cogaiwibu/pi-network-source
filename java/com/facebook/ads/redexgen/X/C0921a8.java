package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.facebook.ads.redexgen.X.a8  reason: case insensitive filesystem */
public class C0921a8 implements LL {
    public final Collection<String> A00;

    public C0921a8() {
        this.A00 = new ArrayList();
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void ABm(String str) {
        this.A00.add(str);
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void flush() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : this.A00) {
            sb.append(line);
            sb.append('\n');
        }
        return sb.toString();
    }
}
