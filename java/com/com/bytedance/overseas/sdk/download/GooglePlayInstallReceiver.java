package com.com.bytedance.overseas.sdk.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.g.l;
import com.tapjoy.TapjoyConstants;

public class GooglePlayInstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        l.c("GooglePlayInstallReceiver", "Referer onReceive: onReceive : onReceive");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String string = extras.getString(TapjoyConstants.TJC_REFERRER);
            l.c("GooglePlayInstallReceiver", "Referer is: " + string);
        }
    }
}
