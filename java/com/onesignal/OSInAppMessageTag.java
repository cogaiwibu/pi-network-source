package com.onesignal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OSInAppMessageTag {
    private static final String ADD_TAGS = "adds";
    private static final String REMOVE_TAGS = "removes";
    private JSONObject tagsToAdd;
    private JSONArray tagsToRemove;

    OSInAppMessageTag(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = null;
        this.tagsToAdd = jSONObject.has(ADD_TAGS) ? jSONObject.getJSONObject(ADD_TAGS) : null;
        this.tagsToRemove = jSONObject.has(REMOVE_TAGS) ? jSONObject.getJSONArray(REMOVE_TAGS) : jSONArray;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.tagsToAdd != null) {
                jSONObject.put(ADD_TAGS, this.tagsToAdd);
            }
            if (this.tagsToRemove != null) {
                jSONObject.put(REMOVE_TAGS, this.tagsToRemove);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject getTagsToAdd() {
        return this.tagsToAdd;
    }

    public void setTagsToAdd(JSONObject jSONObject) {
        this.tagsToAdd = jSONObject;
    }

    public JSONArray getTagsToRemove() {
        return this.tagsToRemove;
    }

    public void setTagsToRemove(JSONArray jSONArray) {
        this.tagsToRemove = jSONArray;
    }

    public String toString() {
        return "OSInAppMessageTag{adds=" + this.tagsToAdd + ", removes=" + this.tagsToRemove + '}';
    }
}
