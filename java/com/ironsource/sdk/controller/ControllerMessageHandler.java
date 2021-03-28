package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class ControllerMessageHandler {
    private static final String ERROR_MESSAGE_KEY_FUNCTION_NAME = "functionName";
    private static final String ERROR_MESSAGE_KEY_HASH = "hash";
    private static final String ERROR_MESSAGE_KEY_PARAMS = "params";
    private static final String TAG = ControllerMessageHandler.class.getCanonicalName();
    private final ControllerAdapter mControllerAdapter;
    private final SecureMessagingService mSecurityService;

    ControllerMessageHandler(ControllerAdapter controllerAdapter, SecureMessagingService secureMessagingService) {
        this.mControllerAdapter = controllerAdapter;
        this.mSecurityService = secureMessagingService;
    }

    private void handleException(Exception exc) {
        exc.printStackTrace();
        String str = TAG;
        Logger.i(str, "messageHandler failed with exception " + exc.getMessage());
    }

    private void handleValidMessage(String str, String str2) throws Exception {
        this.mControllerAdapter.call(str, str2);
    }

    private void handleInvalidMessage(String str, String str2, String str3) {
        this.mControllerAdapter.sendUnauthorizedError(buildErrorMessage(str, str2, str3));
    }

    private String buildErrorMessage(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", SDKUtils.encodeString(str));
            jSONObject.put("params", SDKUtils.encodeString(str2));
            jSONObject.put(ERROR_MESSAGE_KEY_HASH, SDKUtils.encodeString(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void messageHandler(String str, String str2, String str3) {
        try {
            String str4 = TAG;
            Logger.i(str4, "messageHandler(" + str + " " + str3 + ")");
            if (this.mSecurityService.isValidMessage(str, str2, str3)) {
                handleValidMessage(str, str2);
            } else {
                handleInvalidMessage(str, str2, str3);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }
}
