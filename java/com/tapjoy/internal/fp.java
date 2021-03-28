package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.internal.fs;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public final class fp extends gt implements Observer {
    private final Map b = new HashMap();
    private final fi c = new fi();
    private boolean d;
    private final fz e = new fz() {
        /* class com.tapjoy.internal.fp.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* bridge */ /* synthetic */ String a(Object obj) {
            return "AppLaunch";
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final boolean a() {
            return super.a() && !hk.c();
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "AppLaunch", true, tJPlacementListener);
        }
    };

    public static void a() {
    }

    static {
        gt.a = new fp();
    }

    private fp() {
    }

    public final void update(Observable observable, Object obj) {
        fs.a aVar = fs.d;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r3 == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        if (r5.c.a() != false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        r5.e.c(null);
     */
    @Override // com.tapjoy.internal.gt
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r6) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.fp.a(android.app.Activity):void");
    }
}
