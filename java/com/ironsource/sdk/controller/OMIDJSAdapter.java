package com.ironsource.sdk.controller;

import android.content.Context;
import android.webkit.WebView;
import com.ironsource.sdk.analytics.omid.OMIDManager;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class OMIDJSAdapter {
    private static final String ACTIVATE_FUNCTION_NAME = "activate";
    private static final String FAIL_JS_CALLBACK_NAME = "fail";
    private static final String FINISH_SESSION_FUNCTION_NAME = "finishSession";
    private static final String GET_OMID_DATA_FUNCTION_NAME = "getOmidData";
    private static final String IMPRESSION_OCCURRED_FUNCTION_NAME = "impressionOccurred";
    private static final String OMID_FUNCTION_PROPERTY_NAME = "omidFunction";
    private static final String OMID_PARAMS_PROPERTY_NAME = "omidParams";
    private static final String START_SESSION_FUNCTION_NAME = "startSession";
    private static final String SUCCESS_JS_CALLBACK_NAME = "success";
    private static final String TAG = OMIDJSAdapter.class.getSimpleName();
    private static final String UNSUPPORTED_OMID_API_MESSAGE = "%s | unsupported OMID API";
    private Context mContext;

    public OMIDJSAdapter(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public static class FunctionCall {
        String failCallback;
        String name;
        JSONObject params;
        String successCallback;

        private FunctionCall() {
        }
    }

    /* access modifiers changed from: package-private */
    public void call(String str, WebController.NativeAPI.JSCallbackTask jSCallbackTask, WebView webView) throws Exception {
        FunctionCall fetchFunctionCall = fetchFunctionCall(str);
        SSAObj sSAObj = new SSAObj();
        try {
            String str2 = fetchFunctionCall.name;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (str2.equals(ACTIVATE_FUNCTION_NAME)) {
                        c = 0;
                        break;
                    }
                    break;
                case -984459207:
                    if (str2.equals(GET_OMID_DATA_FUNCTION_NAME)) {
                        c = 4;
                        break;
                    }
                    break;
                case 70701699:
                    if (str2.equals(FINISH_SESSION_FUNCTION_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1208109646:
                    if (str2.equals(IMPRESSION_OCCURRED_FUNCTION_NAME)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1850541012:
                    if (str2.equals(START_SESSION_FUNCTION_NAME)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                OMIDManager.activate(this.mContext);
                sSAObj = OMIDManager.getOMIDData();
            } else if (c == 1) {
                OMIDManager.startSession(fetchFunctionCall.params, webView);
            } else if (c == 2) {
                OMIDManager.finishSession();
            } else if (c == 3) {
                OMIDManager.impressionOccurred(fetchFunctionCall.params);
            } else if (c == 4) {
                sSAObj = OMIDManager.getOMIDData();
            } else {
                throw new IllegalArgumentException(String.format(UNSUPPORTED_OMID_API_MESSAGE, fetchFunctionCall.name));
            }
            jSCallbackTask.sendMessage(true, fetchFunctionCall.successCallback, sSAObj);
        } catch (Exception e) {
            sSAObj.put("errMsg", e.getMessage());
            String str3 = TAG;
            Logger.i(str3, "OMIDJSAdapter " + fetchFunctionCall.name + " Exception: " + e.getMessage());
            jSCallbackTask.sendMessage(false, fetchFunctionCall.failCallback, sSAObj);
        }
    }

    private FunctionCall fetchFunctionCall(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        FunctionCall functionCall = new FunctionCall();
        functionCall.name = jSONObject.optString(OMID_FUNCTION_PROPERTY_NAME);
        functionCall.params = jSONObject.optJSONObject(OMID_PARAMS_PROPERTY_NAME);
        functionCall.successCallback = jSONObject.optString("success");
        functionCall.failCallback = jSONObject.optString("fail");
        return functionCall;
    }
}
