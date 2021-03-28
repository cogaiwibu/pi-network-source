package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.ISNAdView.ISNAdViewDelegate;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.WPADUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class BannerJSAdapter implements ISNAdViewDelegate {
    public static final String FAIL = "fail";
    public static final String FUNCTION_NAME = "functionName";
    public static final String FUNCTION_PARAMS = "functionParams";
    public static final String SUCCESS = "success";
    private static final String TAG = BannerJSAdapter.class.getSimpleName();
    private WebViewMessagingMediator mControllerMessageMediator;
    private ISNAdView mIsnAdView;

    public void setCommunicationWithController(WebViewMessagingMediator webViewMessagingMediator) {
        this.mControllerMessageMediator = webViewMessagingMediator;
    }

    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
        this.mIsnAdView = iSNAdView;
        iSNAdView.setControllerDelegate(this);
    }

    @Override // com.ironsource.sdk.ISNAdView.ISNAdViewDelegate
    public void sendMessageToController(String str, JSONObject jSONObject) {
        if (this.mControllerMessageMediator != null && !TextUtils.isEmpty(str)) {
            this.mControllerMessageMediator.sendMessageToController(str, jSONObject);
        }
    }

    @Override // com.ironsource.sdk.ISNAdView.ISNAdViewDelegate
    public void sendErrorMessageToController(String str, String str2, String str3) {
        sendMessageToController(str, WPADUtils.buildErrorObject(str2, str3));
    }

    /* access modifiers changed from: package-private */
    public void sendMessageToISNAdView(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(FUNCTION_NAME);
            JSONObject optJSONObject = jSONObject.optJSONObject(FUNCTION_PARAMS);
            String optString2 = jSONObject.optString("success");
            String optString3 = jSONObject.optString(FAIL);
            if (TextUtils.isEmpty(optString)) {
                String str2 = TAG;
                Logger.i(str2, "BannerJSAdapter | sendMessageToISNAdView | Invalid message format: " + str);
            } else if (this.mIsnAdView == null) {
                sendErrorMessageToController(optString3, "Send message to ISNAdView failed", "");
            } else {
                this.mIsnAdView.receiveMessageFromController(optString, optJSONObject, optString2, optString3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
