package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJConnectListener;
import java.util.Hashtable;

final class et extends es {
    private final gb c = new gb() {
        /* class com.tapjoy.internal.et.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.gb
        public final boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
            return et.super.a((et) context, (Context) str, (String) hashtable, (Hashtable) tJConnectListener);
        }
    };

    et() {
    }

    @Override // com.tapjoy.internal.es, com.tapjoy.internal.er
    public final boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        return this.c.b(context, str, hashtable, tJConnectListener);
    }
}
