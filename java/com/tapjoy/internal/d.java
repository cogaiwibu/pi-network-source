package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TapjoyConstants;
import javax.annotation.Nullable;

public final class d extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        String a = a(intent);
        if (a != null) {
            a(context, "install_referrer", a);
        }
    }

    @Nullable
    public static String a(Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            return intent.getStringExtra(TapjoyConstants.TJC_REFERRER);
        }
        return null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r1, java.lang.String r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r2 = r1.openFileOutput(r2, r0)     // Catch:{ FileNotFoundException -> 0x0016, IOException -> 0x000d }
            com.tapjoy.internal.bg.a(r2, r3)     // Catch:{ FileNotFoundException -> 0x0016, IOException -> 0x000e }
            r2.close()     // Catch:{ FileNotFoundException -> 0x0016, IOException -> 0x000e }
            r1 = 1
            return r1
        L_0x000d:
            r2 = 0
        L_0x000e:
            com.tapjoy.internal.jz.a(r2)
            java.lang.String r2 = "install_referrer"
            r1.deleteFile(r2)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.d.a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }
}
