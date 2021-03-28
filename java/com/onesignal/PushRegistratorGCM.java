package com.onesignal;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.stats.CodePackage;

/* access modifiers changed from: package-private */
public class PushRegistratorGCM extends PushRegistratorAbstractGoogle {
    /* access modifiers changed from: package-private */
    @Override // com.onesignal.PushRegistratorAbstractGoogle
    public String getProviderName() {
        return CodePackage.GCM;
    }

    PushRegistratorGCM() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.PushRegistratorAbstractGoogle
    public String getToken(String str) throws Throwable {
        return GoogleCloudMessaging.getInstance(OneSignal.appContext).register(new String[]{str});
    }
}
