package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.b;

@Deprecated
public class TTAdManagerFactory {
    private static final TTAdManager a = new p();

    private TTAdManagerFactory() {
    }

    public static TTAdManager getInstance(Context context) {
        return getInstance(context, false);
    }

    public static TTAdManager getInstance(Context context, boolean z) {
        if (z) {
            b.a();
        }
        i.a(context);
        return a;
    }

    static TTAdManager a() {
        return a;
    }
}
