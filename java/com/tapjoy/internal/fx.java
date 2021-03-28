package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.hk;
import java.util.Observer;

public final class fx extends hk {
    private final fz b = new fz() {
        /* class com.tapjoy.internal.fx.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final boolean a() {
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            hk.a aVar = (hk.a) obj;
            TJPlacement createPlacement = TJPlacementManager.createPlacement(TapjoyConnectCore.getContext(), aVar.b, false, tJPlacementListener);
            createPlacement.pushId = aVar.a;
            return createPlacement;
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* bridge */ /* synthetic */ String a(Object obj) {
            hk.a aVar = (hk.a) obj;
            if (aVar != null) {
                return aVar.b;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* synthetic */ fz.a b(Object obj) {
            hk.a aVar = (hk.a) obj;
            return new fz.a(aVar, aVar.d);
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final boolean a(Observer observer) {
            if (TapjoyConnectCore.isViewOpen()) {
                TJPlacementManager.dismissContentShowing(true);
            }
            return super.a(observer);
        }
    };

    public static void a() {
    }

    static {
        hk.a(new fx());
    }

    private fx() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.hk
    public final boolean b() {
        return this.b.b != null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.hk
    public final void a(hk.a aVar) {
        this.b.c(aVar);
    }
}
