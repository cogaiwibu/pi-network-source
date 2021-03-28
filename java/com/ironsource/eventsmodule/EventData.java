package com.ironsource.eventsmodule;

import org.json.JSONException;
import org.json.JSONObject;

public class EventData {
    private JSONObject mAdditionalData;
    private int mEventId = -1;
    private long mTimeStamp = -1;

    public EventData(int i, long j, JSONObject jSONObject) {
        this.mEventId = i;
        this.mTimeStamp = j;
        if (jSONObject == null) {
            this.mAdditionalData = new JSONObject();
        } else {
            this.mAdditionalData = jSONObject;
        }
    }

    public EventData(int i, JSONObject jSONObject) {
        this.mEventId = i;
        this.mTimeStamp = System.currentTimeMillis();
        if (jSONObject == null) {
            this.mAdditionalData = new JSONObject();
        } else {
            this.mAdditionalData = jSONObject;
        }
    }

    public int getEventId() {
        return this.mEventId;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getAdditionalData() {
        return this.mAdditionalData.toString();
    }

    public JSONObject getAdditionalDataJSON() {
        return this.mAdditionalData;
    }

    public void setEventId(int i) {
        this.mEventId = i;
    }

    public void addToAdditionalData(String str, Object obj) {
        try {
            this.mAdditionalData.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
