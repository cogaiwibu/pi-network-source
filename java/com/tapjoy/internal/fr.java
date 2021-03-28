package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;

public final class fr {
    private static final fz a = new fz() {
        /* class com.tapjoy.internal.fr.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* bridge */ /* synthetic */ String a(Object obj) {
            return "InsufficientCurrency";
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "InsufficientCurrency", true, tJPlacementListener);
        }
    };

    public static void a() {
        a.c(null);
    }
}
