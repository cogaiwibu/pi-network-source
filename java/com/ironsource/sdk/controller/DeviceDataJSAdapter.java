package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceDataJSAdapter {
    private static final String DEVICE_DATA_FUNCTION_PROPERTY_NAME = "deviceDataFunction";
    private static final String DEVICE_DATA_PARAMS_PROPERTY_NAME = "deviceDataParams";
    private static final String FAIL_JS_CALLBACK_NAME = "fail";
    private static final String GET_DEVICE_DATA = "getDeviceData";
    private static final String SUCCESS_JS_CALLBACK_NAME = "success";
    private static final String TAG = DeviceDataJSAdapter.class.getSimpleName();
    private Context mContext;

    public DeviceDataJSAdapter(Context context) {
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
    public void call(String str, WebController.NativeAPI.JSCallbackTask jSCallbackTask) throws Exception {
        FunctionCall fetchFunctionCall = fetchFunctionCall(str);
        if (GET_DEVICE_DATA.equals(fetchFunctionCall.name)) {
            jSCallbackTask.sendMessage(true, fetchFunctionCall.successCallback, getDeviceData());
            return;
        }
        String str2 = TAG;
        Logger.i(str2, "unhandled API request " + str);
    }

    private SSAObj getDeviceData() {
        SSAObj sSAObj = new SSAObj();
        sSAObj.put(SDKUtils.encodeString("sdCardAvailable"), SDKUtils.encodeString(String.valueOf(DeviceStatus.isExternalMemoryAvailableWritable())));
        sSAObj.put(SDKUtils.encodeString("totalDeviceRAM"), SDKUtils.encodeString(String.valueOf(DeviceStatus.getTotalDeviceRAM(this.mContext))));
        sSAObj.put(SDKUtils.encodeString("isCharging"), SDKUtils.encodeString(String.valueOf(DeviceStatus.isCharging(this.mContext))));
        sSAObj.put(SDKUtils.encodeString("chargingType"), SDKUtils.encodeString(String.valueOf(DeviceStatus.chargingType(this.mContext))));
        sSAObj.put(SDKUtils.encodeString("airplaneMode"), SDKUtils.encodeString(String.valueOf(DeviceStatus.isAirplaneMode(this.mContext))));
        sSAObj.put(SDKUtils.encodeString("stayOnWhenPluggedIn"), SDKUtils.encodeString(String.valueOf(DeviceStatus.isStayOnWhenPluggedIn(this.mContext))));
        return sSAObj;
    }

    private FunctionCall fetchFunctionCall(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        FunctionCall functionCall = new FunctionCall();
        functionCall.name = jSONObject.optString(DEVICE_DATA_FUNCTION_PROPERTY_NAME);
        functionCall.params = jSONObject.optJSONObject(DEVICE_DATA_PARAMS_PROPERTY_NAME);
        functionCall.successCallback = jSONObject.optString("success");
        functionCall.failCallback = jSONObject.optString("fail");
        return functionCall;
    }
}
