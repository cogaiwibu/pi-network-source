package com.ironsource.sdk.data;

import com.ironsource.sdk.listeners.OnAdProductListener;
import java.util.HashMap;
import java.util.Map;

public class DemandSource {
    public static final int INIT_FAILED = 3;
    public static final int INIT_NOT_STARTED = 0;
    public static final int INIT_PENDING = 1;
    public static final int INIT_SUCCEEDED = 2;
    public static final int MEDIATION_STATE_NOT_SET = -1;
    private boolean mAvailabilityState;
    private Map<String, String> mExtraParams;
    private String mId;
    private int mInitState;
    private OnAdProductListener mListener;
    private int mMediationState = -1;
    private String mName;

    public DemandSource(String str, String str2, Map<String, String> map, OnAdProductListener onAdProductListener) {
        this.mId = str;
        this.mName = str2;
        this.mExtraParams = map;
        this.mListener = onAdProductListener;
        this.mInitState = 0;
        this.mAvailabilityState = false;
    }

    public String getId() {
        return this.mId;
    }

    public String getDemandSourceName() {
        return this.mName;
    }

    public int getDemandSourceInitState() {
        return this.mInitState;
    }

    public boolean getAvailabilityState() {
        return this.mAvailabilityState;
    }

    public void setAvailabilityState(boolean z) {
        this.mAvailabilityState = z;
    }

    public Map<String, String> getExtraParams() {
        return this.mExtraParams;
    }

    public synchronized void setDemandSourceInitState(int i) {
        this.mInitState = i;
    }

    public OnAdProductListener getListener() {
        return this.mListener;
    }

    public int getMediationState() {
        return this.mMediationState;
    }

    public void setMediationState(int i) {
        this.mMediationState = i;
    }

    public boolean isMediationState(int i) {
        return this.mMediationState == i;
    }

    public Map<String, String> convertToMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceId", this.mId);
        hashMap.put("demandSourceName", this.mName);
        Map<String, String> map = this.mExtraParams;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public boolean isRewarded() {
        Map<String, String> map = this.mExtraParams;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.mExtraParams.get("rewarded"));
    }
}
