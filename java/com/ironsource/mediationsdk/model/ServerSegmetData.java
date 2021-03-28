package com.ironsource.mediationsdk.model;

import org.json.JSONObject;

public class ServerSegmetData {
    private JSONObject mCustomSegments;
    private String mSegmentId;
    private String mSegmentName;

    public ServerSegmetData(String str, String str2, JSONObject jSONObject) {
        this.mSegmentName = str;
        this.mSegmentId = str2;
        this.mCustomSegments = jSONObject;
    }

    public String getSegmentName() {
        return this.mSegmentName;
    }

    public String getSegmentId() {
        return this.mSegmentId;
    }

    public JSONObject getCustomSegments() {
        return this.mCustomSegments;
    }
}
