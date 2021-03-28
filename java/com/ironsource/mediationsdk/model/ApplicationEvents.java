package com.ironsource.mediationsdk.model;

public class ApplicationEvents {
    private int mBackupThreshold;
    private String mEventsType;
    private int mMaxEventsPerBatch;
    private int mMaxNumberOfEvents;
    private int[] mNonConnectivityEvents;
    private int[] mOptInEvents;
    private int[] mOptOutEvents;
    private boolean mSendEventsToggle;
    private boolean mSendUltraEvents;
    private String mServerEventsURL;
    private int[] mTriggerEvents;

    public ApplicationEvents() {
    }

    public ApplicationEvents(boolean z, boolean z2, String str, String str2, int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        this.mSendUltraEvents = z;
        this.mSendEventsToggle = z2;
        this.mServerEventsURL = str;
        this.mEventsType = str2;
        this.mBackupThreshold = i;
        this.mMaxNumberOfEvents = i2;
        this.mMaxEventsPerBatch = i3;
        this.mOptOutEvents = iArr;
        this.mOptInEvents = iArr2;
        this.mTriggerEvents = iArr3;
        this.mNonConnectivityEvents = iArr4;
    }

    public boolean isUltraEventsEnabled() {
        return this.mSendUltraEvents;
    }

    public boolean isEventsEnabled() {
        return this.mSendEventsToggle;
    }

    public String getEventsURL() {
        return this.mServerEventsURL;
    }

    public String getEventsType() {
        return this.mEventsType;
    }

    public int getEventsBackupThreshold() {
        return this.mBackupThreshold;
    }

    public int getMaxNumberOfEvents() {
        return this.mMaxNumberOfEvents;
    }

    public int getMaxEventsPerBatch() {
        return this.mMaxEventsPerBatch;
    }

    public int[] getOptOutEvents() {
        return this.mOptOutEvents;
    }

    public int[] getOptInEvents() {
        return this.mOptInEvents;
    }

    public int[] getTriggerEvents() {
        return this.mTriggerEvents;
    }

    public int[] getNonConnectivityEvents() {
        return this.mNonConnectivityEvents;
    }
}
