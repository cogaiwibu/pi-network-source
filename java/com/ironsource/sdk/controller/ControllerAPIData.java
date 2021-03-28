package com.ironsource.sdk.controller;

import org.json.JSONObject;

public class ControllerAPIData {
    private String mFailCallbackName;
    private String mFunctionName;
    private JSONObject mFunctionParams;
    private String mSuccessCallbackName;

    public ControllerAPIData(String str) {
        this.mFunctionName = str;
    }

    public ControllerAPIData(String str, JSONObject jSONObject) {
        this.mFunctionName = str;
        this.mFunctionParams = jSONObject;
    }

    public ControllerAPIData(String str, String str2, String str3) {
        this.mFunctionName = str;
        this.mSuccessCallbackName = str2;
        this.mFailCallbackName = str3;
    }

    public ControllerAPIData(String str, JSONObject jSONObject, String str2, String str3) {
        this.mFunctionName = str;
        this.mFunctionParams = jSONObject;
        this.mSuccessCallbackName = str2;
        this.mFailCallbackName = str3;
    }

    public String getFunctionName() {
        return this.mFunctionName;
    }

    public JSONObject getFunctionParams() {
        return this.mFunctionParams;
    }

    public String getSuccessCallbackName() {
        return this.mSuccessCallbackName;
    }

    public String getFailCallbackName() {
        return this.mFailCallbackName;
    }
}
