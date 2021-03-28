package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.service.TokenService;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenJSAdapter {
    private static final String GET_TOKEN = "getToken";
    private static final String TAG = TokenJSAdapter.class.getSimpleName();
    private static final String UPDATE_TOKEN = "updateToken";
    private static final String fail = "fail";
    private static final String functionName = "functionName";
    private static final String functionParams = "functionParams";
    private static final String success = "success";
    private Context mContext;
    private TokenService mTokenService;

    public TokenJSAdapter(Context context, TokenService tokenService) {
        this.mTokenService = tokenService;
        this.mContext = context;
    }

    private FunctionCall fetchFunctionCall(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        FunctionCall functionCall = new FunctionCall();
        functionCall.name = jSONObject.optString("functionName");
        functionCall.params = jSONObject.optJSONObject("functionParams");
        functionCall.successCallback = jSONObject.optString("success");
        functionCall.failureCallback = jSONObject.optString("fail");
        return functionCall;
    }

    /* access modifiers changed from: package-private */
    public void call(String str, WebController.NativeAPI.JSCallbackTask jSCallbackTask) throws Exception {
        FunctionCall fetchFunctionCall = fetchFunctionCall(str);
        if (UPDATE_TOKEN.equals(fetchFunctionCall.name)) {
            updateToken(fetchFunctionCall.params, fetchFunctionCall, jSCallbackTask);
        } else if (GET_TOKEN.equals(fetchFunctionCall.name)) {
            getRawToken(fetchFunctionCall, jSCallbackTask);
        } else {
            String str2 = TAG;
            Logger.i(str2, "unhandled API request " + str);
        }
    }

    public void updateToken(JSONObject jSONObject, FunctionCall functionCall, WebController.NativeAPI.JSCallbackTask jSCallbackTask) {
        SSAObj sSAObj = new SSAObj();
        try {
            this.mTokenService.updateData(jSONObject);
            jSCallbackTask.sendMessage(true, functionCall.successCallback, sSAObj);
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            Logger.i(str, "updateToken exception " + e.getMessage());
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
        }
    }

    private void getRawToken(FunctionCall functionCall, WebController.NativeAPI.JSCallbackTask jSCallbackTask) {
        try {
            jSCallbackTask.sendMessage(true, functionCall.successCallback, this.mTokenService.getRawToken(this.mContext));
        } catch (Exception e) {
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static class FunctionCall {
        String failureCallback;
        String name;
        JSONObject params;
        String successCallback;

        private FunctionCall() {
        }
    }
}
