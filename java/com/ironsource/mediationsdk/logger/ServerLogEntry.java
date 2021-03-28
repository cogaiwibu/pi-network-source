package com.ironsource.mediationsdk.logger;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import org.json.JSONException;
import org.json.JSONObject;

class ServerLogEntry {
    private int mLogLevel;
    private String mMessage;
    private IronSourceLogger.IronSourceTag mTag;
    private String mTimetamp;

    public ServerLogEntry(IronSourceLogger.IronSourceTag ironSourceTag, String str, String str2, int i) {
        this.mTag = ironSourceTag;
        this.mTimetamp = str;
        this.mMessage = str2;
        this.mLogLevel = i;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.mTimetamp);
            jSONObject.put(ViewHierarchyConstants.TAG_KEY, this.mTag);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.mLogLevel);
            jSONObject.put("message", this.mMessage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }
}
