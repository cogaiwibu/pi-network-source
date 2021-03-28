package com.onesignal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;

/* access modifiers changed from: package-private */
public class AdvertisingIdProviderGPS implements AdvertisingIdentifierProvider {
    private static String lastValue;

    AdvertisingIdProviderGPS() {
    }

    static String getLastValue() {
        return lastValue;
    }

    @Override // com.onesignal.AdvertisingIdentifierProvider
    public String getIdentifier(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                lastValue = "OptedOut";
            } else {
                lastValue = advertisingIdInfo.getId();
            }
            return lastValue;
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "Error getting Google Ad id: ", th);
            return null;
        }
    }
}
