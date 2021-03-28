package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class PermissionsJSAdapter {
    private static final String TAG = PermissionsJSAdapter.class.getSimpleName();
    private static final String fail = "fail";
    private static final String getPermissions = "getPermissions";
    private static final String isPermissionGranted = "isPermissionGranted";
    private static final String permissionsFunction = "functionName";
    private static final String permissionsGetPermissionsParam = "permissions";
    private static final String permissionsParameters = "functionParams";
    private static final String permissionsisPermissionGrantedParam = "permission";
    private static final String permissionsisPermissionGrantedStatus = "status";
    private static final String success = "success";
    private static final String unhandled = "unhandledPermission";
    private Context mContext;

    public PermissionsJSAdapter(Context context) {
        this.mContext = context;
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
        if (getPermissions.equals(fetchFunctionCall.name)) {
            getPermissions(fetchFunctionCall.params, fetchFunctionCall, jSCallbackTask);
        } else if (isPermissionGranted.equals(fetchFunctionCall.name)) {
            isPermissionGranted(fetchFunctionCall.params, fetchFunctionCall, jSCallbackTask);
        } else {
            String str2 = TAG;
            Logger.i(str2, "PermissionsJSAdapter unhandled API request " + str);
        }
    }

    public void isPermissionGranted(JSONObject jSONObject, FunctionCall functionCall, WebController.NativeAPI.JSCallbackTask jSCallbackTask) {
        SSAObj sSAObj = new SSAObj();
        try {
            String string = jSONObject.getString(permissionsisPermissionGrantedParam);
            sSAObj.put(permissionsisPermissionGrantedParam, string);
            if (ApplicationContext.isValidPermission(this.mContext, string)) {
                sSAObj.put("status", String.valueOf(ApplicationContext.isPermissionGranted(this.mContext, string)));
                jSCallbackTask.sendMessage(true, functionCall.successCallback, sSAObj);
                return;
            }
            sSAObj.put("status", unhandled);
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
        } catch (Exception e) {
            e.printStackTrace();
            sSAObj.put("errMsg", e.getMessage());
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
        }
    }

    public void getPermissions(JSONObject jSONObject, FunctionCall functionCall, WebController.NativeAPI.JSCallbackTask jSCallbackTask) {
        SSAObj sSAObj = new SSAObj();
        try {
            sSAObj.put("permissions", ApplicationContext.getPermissions(this.mContext, jSONObject.getJSONArray("permissions")));
            jSCallbackTask.sendMessage(true, functionCall.successCallback, sSAObj);
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            Logger.i(str, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e.getMessage());
            sSAObj.put("errMsg", e.getMessage());
            jSCallbackTask.sendMessage(false, functionCall.failureCallback, sSAObj);
        }
    }
}
