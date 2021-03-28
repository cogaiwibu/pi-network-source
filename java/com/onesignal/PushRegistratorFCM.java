package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.util.Base64;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/* access modifiers changed from: package-private */
public class PushRegistratorFCM extends PushRegistratorAbstractGoogle {
    private static final String FCM_APP_NAME = "ONESIGNAL_SDK_FCM_APP_NAME";
    private static final String FCM_DEFAULT_API_KEY_BASE64 = "QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV";
    private static final String FCM_DEFAULT_APP_ID = "1:754795614042:android:c682b8144a8dd52bc1ad63";
    private static final String FCM_DEFAULT_PROJECT_ID = "onesignal-shared-public";
    private FirebaseApp firebaseApp;

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.PushRegistratorAbstractGoogle
    public String getProviderName() {
        return FirebaseMessaging.INSTANCE_ID_SCOPE;
    }

    PushRegistratorFCM() {
    }

    static void disableFirebaseInstanceIdService(Context context) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, FirebaseInstanceIdService.class), OSUtils.getResourceString(context, "gcm_defaultSenderId", null) == null ? 2 : 1, 1);
        } catch (IllegalArgumentException | NoClassDefFoundError unused) {
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.PushRegistratorAbstractGoogle
    public String getToken(String str) throws Throwable {
        initFirebaseApp(str);
        return FirebaseInstanceId.getInstance(this.firebaseApp).getToken(str, FirebaseMessaging.INSTANCE_ID_SCOPE);
    }

    private void initFirebaseApp(String str) {
        if (this.firebaseApp == null) {
            this.firebaseApp = FirebaseApp.initializeApp(OneSignal.appContext, new FirebaseOptions.Builder().setGcmSenderId(str).setApplicationId(getAppId()).setApiKey(getApiKey()).setProjectId(getProjectId()).build(), FCM_APP_NAME);
        }
    }

    private static String getAppId() {
        return OneSignal.remoteParams.fcmParams.appId != null ? OneSignal.remoteParams.fcmParams.appId : FCM_DEFAULT_APP_ID;
    }

    private static String getApiKey() {
        if (OneSignal.remoteParams.fcmParams.apiKey != null) {
            return OneSignal.remoteParams.fcmParams.apiKey;
        }
        return new String(Base64.decode(FCM_DEFAULT_API_KEY_BASE64, 0));
    }

    private static String getProjectId() {
        return OneSignal.remoteParams.fcmParams.projectId != null ? OneSignal.remoteParams.fcmParams.projectId : FCM_DEFAULT_PROJECT_ID;
    }
}
