package com.facebook.ads.internal.api;

import android.content.Context;

public interface AdSettingsApi {
    boolean isTestMode(Context context);

    void turnOnDebugger();
}
