package com.onesignal.influence;

import com.onesignal.OSLogger;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.influence.model.OSInfluenceChannel;
import com.onesignal.influence.model.OSInfluenceType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class OSChannelTracker {
    private static final String TIME = "time";
    OSInfluenceDataRepository dataRepository;
    String directId;
    JSONArray indirectIds;
    OSInfluenceType influenceType;
    protected OSLogger logger;

    /* access modifiers changed from: package-private */
    public abstract void addSessionData(JSONObject jSONObject, OSInfluence oSInfluence);

    public abstract void cacheState();

    /* access modifiers changed from: package-private */
    public abstract int getChannelLimit();

    /* access modifiers changed from: package-private */
    public abstract OSInfluenceChannel getChannelType();

    public abstract String getIdTag();

    /* access modifiers changed from: package-private */
    public abstract int getIndirectAttributionWindow();

    /* access modifiers changed from: package-private */
    public abstract JSONArray getLastChannelObjects() throws JSONException;

    /* access modifiers changed from: package-private */
    public abstract JSONArray getLastChannelObjectsReceivedByNewId(String str);

    /* access modifiers changed from: package-private */
    public abstract void initInfluencedTypeFromCache();

    /* access modifiers changed from: package-private */
    public abstract void saveChannelObjects(JSONArray jSONArray);

    OSChannelTracker(OSInfluenceDataRepository oSInfluenceDataRepository, OSLogger oSLogger) {
        this.dataRepository = oSInfluenceDataRepository;
        this.logger = oSLogger;
    }

    public void resetAndInitInfluence() {
        this.directId = null;
        JSONArray lastReceivedIds = getLastReceivedIds();
        this.indirectIds = lastReceivedIds;
        this.influenceType = lastReceivedIds.length() > 0 ? OSInfluenceType.INDIRECT : OSInfluenceType.UNATTRIBUTED;
        cacheState();
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal OSChannelTracker resetAndInitInfluence: " + getIdTag() + " finish with influenceType: " + this.influenceType);
    }

    public JSONArray getLastReceivedIds() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray lastChannelObjects = getLastChannelObjects();
            OSLogger oSLogger = this.logger;
            oSLogger.debug("OneSignal ChannelTracker getLastReceivedIds lastChannelObjectReceived: " + lastChannelObjects);
            long indirectAttributionWindow = ((long) (getIndirectAttributionWindow() * 60)) * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < lastChannelObjects.length(); i++) {
                JSONObject jSONObject = lastChannelObjects.getJSONObject(i);
                if (currentTimeMillis - jSONObject.getLong(TIME) <= indirectAttributionWindow) {
                    jSONArray.put(jSONObject.getString(getIdTag()));
                }
            }
        } catch (JSONException e) {
            this.logger.error("Generating tracker getLastReceivedIds JSONObject ", e);
        }
        return jSONArray;
    }

    public void saveLastId(String str) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal OSChannelTracker for: " + getIdTag() + " saveLastId: " + str);
        if (str != null && !str.isEmpty()) {
            JSONArray lastChannelObjectsReceivedByNewId = getLastChannelObjectsReceivedByNewId(str);
            OSLogger oSLogger2 = this.logger;
            oSLogger2.debug("OneSignal OSChannelTracker for: " + getIdTag() + " saveLastId with lastChannelObjectsReceived: " + lastChannelObjectsReceivedByNewId);
            try {
                lastChannelObjectsReceivedByNewId.put(new JSONObject().put(getIdTag(), str).put(TIME, System.currentTimeMillis()));
                int channelLimit = getChannelLimit();
                if (lastChannelObjectsReceivedByNewId.length() > channelLimit) {
                    JSONArray jSONArray = new JSONArray();
                    for (int length = lastChannelObjectsReceivedByNewId.length() - channelLimit; length < lastChannelObjectsReceivedByNewId.length(); length++) {
                        try {
                            jSONArray.put(lastChannelObjectsReceivedByNewId.get(length));
                        } catch (JSONException e) {
                            this.logger.error("Before KITKAT API, Generating tracker lastChannelObjectsReceived get JSONObject ", e);
                        }
                    }
                    lastChannelObjectsReceivedByNewId = jSONArray;
                }
                OSLogger oSLogger3 = this.logger;
                oSLogger3.debug("OneSignal OSChannelTracker for: " + getIdTag() + " with channelObjectToSave: " + lastChannelObjectsReceivedByNewId);
                saveChannelObjects(lastChannelObjectsReceivedByNewId);
            } catch (JSONException e2) {
                this.logger.error("Generating tracker newInfluenceId JSONObject ", e2);
            }
        }
    }

    public OSInfluence getCurrentSessionInfluence() {
        OSInfluence.Builder influenceType2 = OSInfluence.Builder.newInstance().setInfluenceType(OSInfluenceType.DISABLED);
        if (this.influenceType == null) {
            initInfluencedTypeFromCache();
        }
        if (this.influenceType.isDirect()) {
            if (isDirectSessionEnabled()) {
                influenceType2 = OSInfluence.Builder.newInstance().setIds(new JSONArray().put(this.directId)).setInfluenceType(OSInfluenceType.DIRECT);
            }
        } else if (this.influenceType.isIndirect()) {
            if (isIndirectSessionEnabled()) {
                influenceType2 = OSInfluence.Builder.newInstance().setIds(this.indirectIds).setInfluenceType(OSInfluenceType.INDIRECT);
            }
        } else if (isUnattributedSessionEnabled()) {
            influenceType2 = OSInfluence.Builder.newInstance().setInfluenceType(OSInfluenceType.UNATTRIBUTED);
        }
        return influenceType2.setInfluenceChannel(getChannelType()).build();
    }

    private boolean isDirectSessionEnabled() {
        return this.dataRepository.isDirectInfluenceEnabled();
    }

    private boolean isIndirectSessionEnabled() {
        return this.dataRepository.isIndirectInfluenceEnabled();
    }

    private boolean isUnattributedSessionEnabled() {
        return this.dataRepository.isUnattributedInfluenceEnabled();
    }

    public OSInfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public void setInfluenceType(OSInfluenceType oSInfluenceType) {
        this.influenceType = oSInfluenceType;
    }

    public JSONArray getIndirectIds() {
        return this.indirectIds;
    }

    public void setIndirectIds(JSONArray jSONArray) {
        this.indirectIds = jSONArray;
    }

    public String getDirectId() {
        return this.directId;
    }

    public void setDirectId(String str) {
        this.directId = str;
    }

    public String toString() {
        return "OSChannelTracker{tag=" + getIdTag() + ", influenceType=" + this.influenceType + ", indirectIds=" + this.indirectIds + ", directId='" + this.directId + '\'' + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OSChannelTracker oSChannelTracker = (OSChannelTracker) obj;
        if (this.influenceType != oSChannelTracker.influenceType || !oSChannelTracker.getIdTag().equals(getIdTag())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.influenceType.hashCode() * 31) + getIdTag().hashCode();
    }
}
