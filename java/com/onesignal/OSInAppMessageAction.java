package com.onesignal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OSInAppMessageAction {
    private static final String CLICK_NAME = "click_name";
    private static final String CLICK_URL = "click_url";
    private static final String CLOSE = "close";
    private static final String CLOSES_MESSAGE = "closes_message";
    private static final String FIRST_CLICK = "first_click";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String OUTCOMES = "outcomes";
    private static final String PROMPTS = "prompts";
    private static final String TAGS = "tags";
    private static final String URL = "url";
    private static final String URL_TARGET = "url_target";
    String clickId;
    public String clickName;
    public String clickUrl;
    public boolean closesMessage;
    public boolean firstClick;
    public List<OSInAppMessageOutcome> outcomes = new ArrayList();
    public List<OSInAppMessagePrompt> prompts = new ArrayList();
    public OSInAppMessageTag tags;
    public OSInAppMessageActionUrlType urlTarget;

    OSInAppMessageAction(JSONObject jSONObject) throws JSONException {
        this.clickId = jSONObject.optString("id", null);
        this.clickName = jSONObject.optString("name", null);
        this.clickUrl = jSONObject.optString("url", null);
        OSInAppMessageActionUrlType fromString = OSInAppMessageActionUrlType.fromString(jSONObject.optString(URL_TARGET, null));
        this.urlTarget = fromString;
        if (fromString == null) {
            this.urlTarget = OSInAppMessageActionUrlType.IN_APP_WEBVIEW;
        }
        this.closesMessage = jSONObject.optBoolean("close", true);
        if (jSONObject.has(OUTCOMES)) {
            parseOutcomes(jSONObject);
        }
        if (jSONObject.has("tags")) {
            this.tags = new OSInAppMessageTag(jSONObject.getJSONObject("tags"));
        }
        if (jSONObject.has(PROMPTS)) {
            parsePrompts(jSONObject);
        }
    }

    private void parseOutcomes(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(OUTCOMES);
        for (int i = 0; i < jSONArray.length(); i++) {
            this.outcomes.add(new OSInAppMessageOutcome((JSONObject) jSONArray.get(i)));
        }
    }

    private void parsePrompts(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(PROMPTS);
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.get(i).equals(FirebaseAnalytics.Param.LOCATION)) {
                this.prompts.add(new OSInAppMessageLocationPrompt());
            }
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CLICK_NAME, this.clickName);
            jSONObject.put("click_url", this.clickUrl);
            jSONObject.put(FIRST_CLICK, this.firstClick);
            jSONObject.put(CLOSES_MESSAGE, this.closesMessage);
            JSONArray jSONArray = new JSONArray();
            for (OSInAppMessageOutcome oSInAppMessageOutcome : this.outcomes) {
                jSONArray.put(oSInAppMessageOutcome.toJSONObject());
            }
            jSONObject.put(OUTCOMES, jSONArray);
            if (this.tags != null) {
                jSONObject.put("tags", this.tags.toJSONObject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public enum OSInAppMessageActionUrlType {
        IN_APP_WEBVIEW(Constants.ParametersKeys.WEB_VIEW),
        BROWSER("browser"),
        REPLACE_CONTENT("replacement");
        
        private String text;

        private OSInAppMessageActionUrlType(String str) {
            this.text = str;
        }

        public String toString() {
            return this.text;
        }

        public static OSInAppMessageActionUrlType fromString(String str) {
            OSInAppMessageActionUrlType[] values = values();
            for (OSInAppMessageActionUrlType oSInAppMessageActionUrlType : values) {
                if (oSInAppMessageActionUrlType.text.equalsIgnoreCase(str)) {
                    return oSInAppMessageActionUrlType;
                }
            }
            return null;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url_type", this.text);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
