package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.tapjoy.TapjoyConstants;

/* access modifiers changed from: package-private */
public class GoogleApiClientCompatProxy {
    private final GoogleApiClient googleApiClient;
    private final Class googleApiClientListenerClass;

    GoogleApiClientCompatProxy(GoogleApiClient googleApiClient2) {
        this.googleApiClient = googleApiClient2;
        this.googleApiClientListenerClass = googleApiClient2.getClass();
    }

    /* access modifiers changed from: package-private */
    public void connect() {
        try {
            this.googleApiClientListenerClass.getMethod(TapjoyConstants.TJC_SDK_TYPE_CONNECT, new Class[0]).invoke(this.googleApiClient, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void disconnect() {
        try {
            this.googleApiClientListenerClass.getMethod("disconnect", new Class[0]).invoke(this.googleApiClient, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public GoogleApiClient realInstance() {
        return this.googleApiClient;
    }
}
