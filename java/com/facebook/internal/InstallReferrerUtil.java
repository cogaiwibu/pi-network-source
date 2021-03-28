package com.facebook.internal;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.FacebookSdk;

public class InstallReferrerUtil {
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    public static void tryUpdateReferrerInfo(Callback callback) {
        if (!isUpdated()) {
            tryConnectReferrerInfo(callback);
        }
    }

    private static void tryConnectReferrerInfo(final Callback callback) {
        final InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        build.startConnection(new InstallReferrerStateListener() {
            /* class com.facebook.internal.InstallReferrerUtil.AnonymousClass1 */

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int i) {
                if (i == 0) {
                    try {
                        String installReferrer = build.getInstallReferrer().getInstallReferrer();
                        if (installReferrer != null && (installReferrer.contains("fb") || installReferrer.contains("facebook"))) {
                            callback.onReceiveReferrerUrl(installReferrer);
                        }
                        InstallReferrerUtil.updateReferrer();
                    } catch (Exception unused) {
                    }
                } else if (i == 2) {
                    InstallReferrerUtil.updateReferrer();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }

    private static boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }
}
