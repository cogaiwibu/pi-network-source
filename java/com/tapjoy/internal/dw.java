package com.tapjoy.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class dw {
    final HashMap a = new HashMap();
    final HashMap b = new HashMap();
    final HashMap c = new HashMap();
    final HashSet d = new HashSet();
    final HashSet e = new HashSet();
    final HashSet f = new HashSet();
    final HashMap g = new HashMap();
    boolean h;

    /* access modifiers changed from: package-private */
    public final void a(cz czVar) {
        for (dq dqVar : czVar.b) {
            View view = (View) dqVar.get();
            if (view != null) {
                ArrayList arrayList = (ArrayList) this.c.get(view);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.c.put(view, arrayList);
                }
                arrayList.add(czVar.f);
            }
        }
    }
}
