package com.ironsource.sdk.utils;

import com.ironsource.sdk.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class WPADUtils {
    public static final String ERR_MSG = "errMsg";

    public static JSONObject buildErrorObject(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str);
            jSONObject.put(Constants.ParametersKeys.AD_VIEW_ID, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
