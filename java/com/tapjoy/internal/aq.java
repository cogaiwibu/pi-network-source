package com.tapjoy.internal;

import javax.annotation.Nullable;

public abstract class aq implements an {
    /* access modifiers changed from: protected */
    @Nullable
    public abstract ao a(Object obj, boolean z);

    @Override // com.tapjoy.internal.an
    public final Object a(Object obj) {
        ao a = a(obj, false);
        if (a != null) {
            return a.a();
        }
        return null;
    }

    @Override // com.tapjoy.internal.an
    public void a(Object obj, Object obj2) {
        a(obj, true).a(obj2);
    }
}
