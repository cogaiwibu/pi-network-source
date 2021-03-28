package com.onesignal;

import com.anythink.reactnativejs.utils.Const;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OSNotificationPayload {
    public List<ActionButton> actionButtons;
    public JSONObject additionalData;
    public BackgroundImageLayout backgroundImageLayout;
    public String bigPicture;
    public String body;
    public String collapseId;
    public String fromProjectNumber;
    public String groupKey;
    public String groupMessage;
    public String largeIcon;
    public String launchURL;
    public String ledColor;
    public int lockScreenVisibility = 1;
    public String notificationID;
    public int priority;
    public String rawPayload;
    public String smallIcon;
    public String smallIconAccentColor;
    public String sound;
    public String templateId;
    public String templateName;
    public String title;

    public static class BackgroundImageLayout {
        public String bodyTextColor;
        public String image;
        public String titleTextColor;
    }

    public OSNotificationPayload() {
    }

    public OSNotificationPayload(JSONObject jSONObject) {
        this.notificationID = jSONObject.optString("notificationID");
        this.title = jSONObject.optString("title");
        this.body = jSONObject.optString("body");
        this.additionalData = jSONObject.optJSONObject("additionalData");
        this.smallIcon = jSONObject.optString("smallIcon");
        this.largeIcon = jSONObject.optString("largeIcon");
        this.bigPicture = jSONObject.optString("bigPicture");
        this.smallIconAccentColor = jSONObject.optString("smallIconAccentColor");
        this.launchURL = jSONObject.optString("launchURL");
        this.sound = jSONObject.optString("sound");
        this.ledColor = jSONObject.optString("ledColor");
        this.lockScreenVisibility = jSONObject.optInt("lockScreenVisibility");
        this.groupKey = jSONObject.optString("groupKey");
        this.groupMessage = jSONObject.optString("groupMessage");
        if (jSONObject.has("actionButtons")) {
            this.actionButtons = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("actionButtons");
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.actionButtons.add(new ActionButton(optJSONArray.optJSONObject(i)));
            }
        }
        this.fromProjectNumber = jSONObject.optString("fromProjectNumber");
        this.collapseId = jSONObject.optString("collapseId");
        this.priority = jSONObject.optInt(Constants.FirelogAnalytics.PARAM_PRIORITY);
        this.rawPayload = jSONObject.optString("rawPayload");
    }

    public static class ActionButton {
        public String icon;
        public String id;
        public String text;

        public ActionButton() {
        }

        public ActionButton(JSONObject jSONObject) {
            this.id = jSONObject.optString("id");
            this.text = jSONObject.optString("text");
            this.icon = jSONObject.optString(Const.icon);
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.id);
                jSONObject.put("text", this.text);
                jSONObject.put(Const.icon, this.icon);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notificationID", this.notificationID);
            jSONObject.put("title", this.title);
            jSONObject.put("body", this.body);
            if (this.additionalData != null) {
                jSONObject.put("additionalData", this.additionalData);
            }
            jSONObject.put("smallIcon", this.smallIcon);
            jSONObject.put("largeIcon", this.largeIcon);
            jSONObject.put("bigPicture", this.bigPicture);
            jSONObject.put("smallIconAccentColor", this.smallIconAccentColor);
            jSONObject.put("launchURL", this.launchURL);
            jSONObject.put("sound", this.sound);
            jSONObject.put("ledColor", this.ledColor);
            jSONObject.put("lockScreenVisibility", this.lockScreenVisibility);
            jSONObject.put("groupKey", this.groupKey);
            jSONObject.put("groupMessage", this.groupMessage);
            if (this.actionButtons != null) {
                JSONArray jSONArray = new JSONArray();
                for (ActionButton actionButton : this.actionButtons) {
                    jSONArray.put(actionButton.toJSONObject());
                }
                jSONObject.put("actionButtons", jSONArray);
            }
            jSONObject.put("fromProjectNumber", this.fromProjectNumber);
            jSONObject.put("collapseId", this.collapseId);
            jSONObject.put(Constants.FirelogAnalytics.PARAM_PRIORITY, this.priority);
            jSONObject.put("rawPayload", this.rawPayload);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
