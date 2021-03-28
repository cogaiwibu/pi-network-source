package com.tapjoy.internal;

import android.app.Activity;

public abstract class gt {
    protected static gt a;

    public abstract void a(Activity activity);

    public static void b(Activity activity) {
        gt gtVar = a;
        if (gtVar != null) {
            gtVar.a(activity);
        }
    }
}
