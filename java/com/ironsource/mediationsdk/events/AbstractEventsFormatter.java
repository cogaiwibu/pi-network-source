package com.ironsource.mediationsdk.events;

import android.text.TextUtils;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class AbstractEventsFormatter {
    private final String EVENTS_KEY_DEFAULT = "events";
    private final String EVENTS_KEY_IS = "InterstitialEvents";
    private final String EVENTS_KEY_RV = "events";
    private final String KEY_AD_UNIT = "adUnit";
    private final String KEY_EVENT_ID = "eventId";
    private final String KEY_TIMESTAMP = "timestamp";
    int mAdUnit;
    JSONObject mGeneralProperties;
    private String mServerUrl;

    private String getEventsKey(int i) {
        return i != 2 ? "events" : "InterstitialEvents";
    }

    public abstract String format(ArrayList<EventData> arrayList, JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract String getDefaultEventsUrl();

    public abstract String getFormatterType();

    AbstractEventsFormatter() {
    }

    /* access modifiers changed from: package-private */
    public JSONObject createJSONForEvent(EventData eventData) {
        try {
            JSONObject jSONObject = new JSONObject(eventData.getAdditionalData());
            jSONObject.put("eventId", eventData.getEventId());
            jSONObject.put("timestamp", eventData.getTimeStamp());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String createDataToSend(JSONArray jSONArray) {
        try {
            if (this.mGeneralProperties == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(this.mGeneralProperties.toString());
            jSONObject.put("timestamp", IronSourceUtils.getTimeStamp());
            jSONObject.put("adUnit", this.mAdUnit);
            jSONObject.put(getEventsKey(this.mAdUnit), jSONArray);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public String getEventsServerUrl() {
        return TextUtils.isEmpty(this.mServerUrl) ? getDefaultEventsUrl() : this.mServerUrl;
    }

    /* access modifiers changed from: package-private */
    public void setEventsServerUrl(String str) {
        this.mServerUrl = str;
    }
}
