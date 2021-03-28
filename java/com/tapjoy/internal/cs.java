package com.tapjoy.internal;

import android.view.View;

public abstract class cs {
    public abstract void a();

    public abstract void a(View view);

    public abstract void b();

    public static cs a(ct ctVar, cu cuVar) {
        if (ck.b()) {
            Cdo.a(ctVar, "AdSessionConfiguration is null");
            Cdo.a(cuVar, "AdSessionContext is null");
            return new cz(ctVar, cuVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
