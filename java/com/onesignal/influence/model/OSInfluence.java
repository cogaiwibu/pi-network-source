package com.onesignal.influence.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OSInfluence {
    private static final String INFLUENCE_CHANNEL = "influence_channel";
    private static final String INFLUENCE_IDS = "influence_ids";
    private static final String INFLUENCE_TYPE = "influence_type";
    private JSONArray ids;
    private OSInfluenceChannel influenceChannel;
    private OSInfluenceType influenceType;

    private OSInfluence() {
    }

    public OSInfluence(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString(INFLUENCE_CHANNEL);
        String string2 = jSONObject.getString(INFLUENCE_TYPE);
        String string3 = jSONObject.getString(INFLUENCE_IDS);
        this.influenceChannel = OSInfluenceChannel.fromString(string);
        this.influenceType = OSInfluenceType.fromString(string2);
        this.ids = string3.isEmpty() ? null : new JSONArray(string3);
    }

    OSInfluence(Builder builder) {
        this.ids = builder.ids;
        this.influenceType = builder.influenceType;
        this.influenceChannel = builder.influenceChannel;
    }

    public OSInfluenceChannel getInfluenceChannel() {
        return this.influenceChannel;
    }

    public OSInfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public JSONArray getIds() {
        return this.ids;
    }

    public String getDirectId() throws JSONException {
        JSONArray jSONArray = this.ids;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        return this.ids.getString(0);
    }

    public void setIds(JSONArray jSONArray) {
        this.ids = jSONArray;
    }

    public static class Builder {
        private JSONArray ids;
        private OSInfluenceChannel influenceChannel;
        private OSInfluenceType influenceType;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {
        }

        public Builder setIds(JSONArray jSONArray) {
            this.ids = jSONArray;
            return this;
        }

        public Builder setInfluenceType(OSInfluenceType oSInfluenceType) {
            this.influenceType = oSInfluenceType;
            return this;
        }

        public Builder setInfluenceChannel(OSInfluenceChannel oSInfluenceChannel) {
            this.influenceChannel = oSInfluenceChannel;
            return this;
        }

        public OSInfluence build() {
            return new OSInfluence(this);
        }
    }

    public OSInfluence copy() {
        OSInfluence oSInfluence = new OSInfluence();
        oSInfluence.ids = this.ids;
        oSInfluence.influenceType = this.influenceType;
        oSInfluence.influenceChannel = this.influenceChannel;
        return oSInfluence;
    }

    public String toJSONString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(INFLUENCE_CHANNEL, this.influenceChannel.toString());
        jSONObject.put(INFLUENCE_TYPE, this.influenceType.toString());
        JSONArray jSONArray = this.ids;
        jSONObject.put(INFLUENCE_IDS, jSONArray != null ? jSONArray.toString() : "");
        return jSONObject.toString();
    }

    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.influenceChannel + ", influenceType=" + this.influenceType + ", ids=" + this.ids + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OSInfluence oSInfluence = (OSInfluence) obj;
        if (this.influenceChannel == oSInfluence.influenceChannel && this.influenceType == oSInfluence.influenceType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.influenceChannel.hashCode() * 31) + this.influenceType.hashCode();
    }
}
