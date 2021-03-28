package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public class TokenSettings {
    private JSONObject tokenGenericParams = null;
    private ArrayList<String> tokenOptInKeyParams = new ArrayList<>();

    TokenSettings() {
    }

    public ArrayList<String> getOptInKeyParamsTokenArray() {
        return this.tokenOptInKeyParams;
    }

    public void addOptInKeyParam(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.tokenOptInKeyParams.add(str);
        }
    }

    public void setGenericParams(JSONObject jSONObject) {
        this.tokenGenericParams = jSONObject;
    }

    public JSONObject getGenericParams() {
        return this.tokenGenericParams;
    }
}
