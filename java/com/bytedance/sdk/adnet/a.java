package com.bytedance.sdk.adnet;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.File;

/* compiled from: AdNetSdk */
public class a {
    private static String a;

    public static l a(Context context, IHttpStack iHttpStack) {
        return k.a(context, iHttpStack);
    }

    public static String a(Context context) {
        try {
            if (TextUtils.isEmpty(a)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                a = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            n.a(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return a;
    }
}
