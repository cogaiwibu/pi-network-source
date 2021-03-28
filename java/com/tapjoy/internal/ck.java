package com.tapjoy.internal;

import android.content.Context;
import android.os.Handler;

public final class ck {
    private static cl a = new cl();

    public static String a() {
        return "1.2.19-Tapjoy";
    }

    public static boolean b() {
        return a.a;
    }

    public static boolean a(Context context) {
        cl clVar = a;
        Context applicationContext = context.getApplicationContext();
        Cdo.a(applicationContext, "Application Context cannot be null");
        if (!clVar.a) {
            clVar.a = true;
            dh a2 = dh.a();
            a2.b = new cp(new Handler(), applicationContext, new cm(), a2);
            de.a().a = applicationContext.getApplicationContext();
            dm.a(applicationContext);
            df.a().a = applicationContext != null ? applicationContext.getApplicationContext() : null;
        }
        return true;
    }
}
