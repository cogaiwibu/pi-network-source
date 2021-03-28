package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.37  reason: invalid class name */
public class AnonymousClass37 implements Comparator<View> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compare(View view, View view2) {
        AnonymousClass31 r3 = (AnonymousClass31) view.getLayoutParams();
        AnonymousClass31 r2 = (AnonymousClass31) view2.getLayoutParams();
        if (r3.A05 != r2.A05) {
            return r3.A05 ? 1 : -1;
        }
        return r3.A02 - r2.A02;
    }
}
