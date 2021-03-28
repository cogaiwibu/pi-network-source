package com.onesignal;

import java.security.SecureRandom;

/* access modifiers changed from: package-private */
public class OneSignalChromeTabAndroidFrame extends OneSignalChromeTab {
    private static boolean opened;

    OneSignalChromeTabAndroidFrame() {
    }

    static void setup(String str, String str2, String str3) {
        if (!opened && OneSignal.remoteParams != null && !OneSignal.remoteParams.enterprise && str != null && str2 != null) {
            String str4 = "?app_id=" + str + "&user_id=" + str2;
            if (str3 != null) {
                str4 = str4 + "&ad_id=" + str3;
            }
            opened = open("https://onesignal.com/android_frame.html" + (str4 + "&cbs_id=" + new SecureRandom().nextInt(Integer.MAX_VALUE)), false);
        }
    }
}
