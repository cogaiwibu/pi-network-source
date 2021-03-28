package com.tapjoy;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCachedAssetData implements Serializable {
    private long a;
    private long b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;

    public TapjoyCachedAssetData(String str, String str2, long j) {
        this(str, str2, j, System.currentTimeMillis() / 1000);
    }

    public TapjoyCachedAssetData(String str, String str2, long j, long j2) {
        setAssetURL(str);
        setLocalFilePath(str2);
        this.b = j;
        this.a = j2;
        this.f = j2 + j;
    }

    public void setAssetURL(String str) {
        this.c = str;
        this.g = TapjoyUtil.determineMimeType(str);
    }

    public void setLocalFilePath(String str) {
        this.d = str;
        this.e = "file://" + str;
    }

    public void resetTimeToLive(long j) {
        this.b = j;
        this.f = (System.currentTimeMillis() / 1000) + j;
    }

    public void setOfferID(String str) {
        this.h = str;
    }

    public long getTimestampInSeconds() {
        return this.a;
    }

    public long getTimeToLiveInSeconds() {
        return this.b;
    }

    public long getTimeOfDeathInSeconds() {
        return this.f;
    }

    public String getAssetURL() {
        return this.c;
    }

    public String getLocalFilePath() {
        return this.d;
    }

    public String getLocalURL() {
        return this.e;
    }

    public String getMimeType() {
        return this.g;
    }

    public String getOfferId() {
        return this.h;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", getTimestampInSeconds());
            jSONObject.put(TapjoyConstants.TJC_TIME_TO_LIVE, getTimeToLiveInSeconds());
            jSONObject.put("assetURL", getAssetURL());
            jSONObject.put("localFilePath", getLocalFilePath());
            jSONObject.put("offerID", getOfferId());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toRawJSONString() {
        return toJSON().toString();
    }

    public static TapjoyCachedAssetData fromRawJSONString(String str) {
        try {
            return fromJSONObject(new JSONObject(str));
        } catch (JSONException unused) {
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
    }

    public static TapjoyCachedAssetData fromJSONObject(JSONObject jSONObject) {
        TapjoyCachedAssetData tapjoyCachedAssetData;
        try {
            tapjoyCachedAssetData = new TapjoyCachedAssetData(jSONObject.getString("assetURL"), jSONObject.getString("localFilePath"), jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE), jSONObject.getLong("timestamp"));
            try {
                tapjoyCachedAssetData.setOfferID(jSONObject.optString("offerID"));
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            tapjoyCachedAssetData = null;
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
            return tapjoyCachedAssetData;
        }
        return tapjoyCachedAssetData;
    }

    public String toString() {
        return "\nURL=" + this.e + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "AssetURL=" + this.c + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "MimeType=" + this.g + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "Timestamp=" + getTimestampInSeconds() + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "TimeOfDeath=" + this.f + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + "TimeToLive=" + this.b + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
    }
}
