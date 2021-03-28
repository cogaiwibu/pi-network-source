package com.ironsource.sdk.controller;

import org.json.JSONObject;

public class ControllerAPICommandBuilder {
    public static final String RUN_FUNCTION_PREFIX = "SSA_CORE.SDKController.runFunction";

    public static String buildCommand(ControllerAPIData controllerAPIData) {
        return String.format("%1$s('%2$s%3$s'%4$s)", RUN_FUNCTION_PREFIX, controllerAPIData.getFunctionName(), formatFunctionParams(controllerAPIData.getFunctionParams()), formatCallbacks(controllerAPIData));
    }

    private static String formatFunctionParams(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? "" : jSONObject.toString();
    }

    private static String formatCallbacks(ControllerAPIData controllerAPIData) {
        if (controllerAPIData.getSuccessCallbackName() == null || controllerAPIData.getFailCallbackName() == null) {
            return "";
        }
        return String.format(", '%1$s', '%2$s'", controllerAPIData.getSuccessCallbackName(), controllerAPIData.getFailCallbackName());
    }
}
