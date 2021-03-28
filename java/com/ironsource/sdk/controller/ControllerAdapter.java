package com.ironsource.sdk.controller;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* access modifiers changed from: package-private */
public class ControllerAdapter {
    private static final String TAG = ControllerAdapter.class.getSimpleName();
    private final WebController.NativeAPI mNativeAPI;

    ControllerAdapter(WebController.NativeAPI nativeAPI) {
        this.mNativeAPI = nativeAPI;
    }

    /* access modifiers changed from: package-private */
    public synchronized void call(String str, String str2) throws Exception {
        if (this.mNativeAPI == null) {
            Logger.e(TAG, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = WebController.NativeAPI.class.getDeclaredMethod(str, String.class);
        if (Build.VERSION.SDK_INT < 17 || declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            declaredMethod.invoke(this.mNativeAPI, str2);
            return;
        }
        throw new AccessControlException("Trying to access a private function: " + str);
    }

    /* access modifiers changed from: package-private */
    public void sendUnauthorizedError(String str) {
        WebController.NativeAPI nativeAPI = this.mNativeAPI;
        if (nativeAPI != null) {
            nativeAPI.sendUnauthorizedError(str);
        }
    }
}
