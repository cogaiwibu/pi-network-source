package com.facebook.ads.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;

public class AdSharedPreferences {
    public static final String PREFS_NAME = "FBAdPrefs";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(ProcessUtils.getProcessSpecificName(PREFS_NAME, context), 0);
    }
}
