package com.tapjoy.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;

public final class ar extends aq {
    private final LinkedHashMap a = new LinkedHashMap(0, 0.75f, true);
    private int b = 10;

    private void a() {
        int size = this.a.size() - this.b;
        if (size > 0) {
            Iterator it = this.a.entrySet().iterator();
            while (size > 0 && it.hasNext()) {
                size--;
                it.next();
                it.remove();
            }
        }
    }

    @Override // com.tapjoy.internal.an, com.tapjoy.internal.aq
    public final void a(Object obj, Object obj2) {
        super.a(obj, obj2);
        a();
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.aq
    public final ao a(Object obj, boolean z) {
        am amVar = (am) this.a.get(obj);
        if (amVar != null || !z) {
            return amVar;
        }
        am amVar2 = new am(obj);
        this.a.put(obj, amVar2);
        a();
        return amVar2;
    }
}
