package com.bytedance.sdk.openadsdk.h;

import android.content.Context;
import android.os.Environment;
import com.bytedance.sdk.openadsdk.g.l;
import com.ironsource.sdk.constants.Constants;
import java.io.File;

/* access modifiers changed from: package-private */
/* compiled from: StorageUtils */
public final class s {
    public static File a(Context context) {
        return new File(a(context, true), "video-cache");
    }

    private static File a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File b = (!z || !"mounted".equals(str)) ? null : b(context);
        if (b == null) {
            b = context.getCacheDir();
        }
        if (b != null) {
            return b;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        l.d("StorageUtils", "Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), Constants.JAVASCRIPT_INTERFACE_NAME), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        l.d("StorageUtils", "Unable to create external cache directory");
        return null;
    }
}
