package com.anythink.reactnativejs.utils;

import android.util.Log;

public class MsgTools {
    private static final String TAG = "ATReactNativeBridge";
    static boolean isDebug = true;

    public static void pirntMsg(String str) {
        if (isDebug) {
            Log.e(TAG, str);
        }
    }

    public static void setLogDebug(boolean z) {
        isDebug = z;
    }
}
