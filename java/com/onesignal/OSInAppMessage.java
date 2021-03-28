package com.onesignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSInAppMessage {
    private static final String DISPLAY_DURATION = "display_duration";
    private static final String IAM_ID = "id";
    private static final String IAM_REDISPLAY_STATS = "redisplay";
    private static final String IAM_TRIGGERS = "triggers";
    private static final String IAM_VARIANTS = "variants";
    private boolean actionTaken;
    private Set<String> clickedClickIds;
    private double displayDuration;
    private boolean displayedInSession = false;
    boolean isPreview;
    public String messageId;
    private OSInAppMessageRedisplayStats redisplayStats = new OSInAppMessageRedisplayStats();
    private boolean triggerChanged = false;
    public ArrayList<ArrayList<OSTrigger>> triggers;
    public HashMap<String, HashMap<String, String>> variants;

    OSInAppMessage(boolean z) {
        this.isPreview = z;
    }

    OSInAppMessage(String str, Set<String> set, boolean z, OSInAppMessageRedisplayStats oSInAppMessageRedisplayStats) {
        this.messageId = str;
        this.clickedClickIds = set;
        this.displayedInSession = z;
        this.redisplayStats = oSInAppMessageRedisplayStats;
    }

    OSInAppMessage(JSONObject jSONObject) throws JSONException {
        this.messageId = jSONObject.getString("id");
        this.variants = parseVariants(jSONObject.getJSONObject(IAM_VARIANTS));
        this.triggers = parseTriggerJson(jSONObject.getJSONArray(IAM_TRIGGERS));
        this.clickedClickIds = new HashSet();
        if (jSONObject.has(IAM_REDISPLAY_STATS)) {
            this.redisplayStats = new OSInAppMessageRedisplayStats(jSONObject.getJSONObject(IAM_REDISPLAY_STATS));
        }
    }

    private HashMap<String, HashMap<String, String>> parseVariants(JSONObject jSONObject) throws JSONException {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            HashMap<String, String> hashMap2 = new HashMap<>();
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                hashMap2.put(next2, jSONObject2.getString(next2));
            }
            hashMap.put(next, hashMap2);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public ArrayList<ArrayList<OSTrigger>> parseTriggerJson(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<OSTrigger>> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            ArrayList<OSTrigger> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(new OSTrigger(jSONArray2.getJSONObject(i2)));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.messageId);
            JSONObject jSONObject2 = new JSONObject();
            for (String str : this.variants.keySet()) {
                HashMap<String, String> hashMap = this.variants.get(str);
                JSONObject jSONObject3 = new JSONObject();
                for (String str2 : hashMap.keySet()) {
                    jSONObject3.put(str2, hashMap.get(str2));
                }
                jSONObject2.put(str, jSONObject3);
            }
            jSONObject.put(IAM_VARIANTS, jSONObject2);
            jSONObject.put(DISPLAY_DURATION, this.displayDuration);
            jSONObject.put(IAM_REDISPLAY_STATS, this.redisplayStats.toJSONObject());
            JSONArray jSONArray = new JSONArray();
            Iterator<ArrayList<OSTrigger>> it = this.triggers.iterator();
            while (it.hasNext()) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<OSTrigger> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next().toJSONObject());
                }
                jSONArray.put(jSONArray2);
            }
            jSONObject.put(IAM_TRIGGERS, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public boolean takeActionAsUnique() {
        if (this.actionTaken) {
            return false;
        }
        this.actionTaken = true;
        return true;
    }

    /* access modifiers changed from: package-private */
    public double getDisplayDuration() {
        return this.displayDuration;
    }

    /* access modifiers changed from: package-private */
    public void setDisplayDuration(double d) {
        this.displayDuration = d;
    }

    /* access modifiers changed from: package-private */
    public boolean isTriggerChanged() {
        return this.triggerChanged;
    }

    /* access modifiers changed from: package-private */
    public void setTriggerChanged(boolean z) {
        this.triggerChanged = z;
    }

    public boolean isDisplayedInSession() {
        return this.displayedInSession;
    }

    public void setDisplayedInSession(boolean z) {
        this.displayedInSession = z;
    }

    /* access modifiers changed from: package-private */
    public Set<String> getClickedClickIds() {
        return this.clickedClickIds;
    }

    /* access modifiers changed from: package-private */
    public boolean isClickAvailable(String str) {
        return !this.clickedClickIds.contains(str);
    }

    /* access modifiers changed from: package-private */
    public void clearClickIds() {
        this.clickedClickIds.clear();
    }

    /* access modifiers changed from: package-private */
    public void addClickId(String str) {
        this.clickedClickIds.add(str);
    }

    /* access modifiers changed from: package-private */
    public OSInAppMessageRedisplayStats getRedisplayStats() {
        return this.redisplayStats;
    }

    /* access modifiers changed from: package-private */
    public void setRedisplayStats(int i, long j) {
        this.redisplayStats = new OSInAppMessageRedisplayStats(i, j);
    }

    public String toString() {
        return "OSInAppMessage{messageId='" + this.messageId + '\'' + ", triggers=" + this.triggers + ", clickedClickIds=" + this.clickedClickIds + ", displayStats=" + this.redisplayStats + ", actionTaken=" + this.actionTaken + ", isPreview=" + this.isPreview + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.messageId.equals(((OSInAppMessage) obj).messageId);
    }

    public int hashCode() {
        return this.messageId.hashCode();
    }
}
