package com.ironsource.mediationsdk.model;

public class OfferwallPlacement {
    private boolean mIsDefault;
    private int mPlacementId;
    private String mPlacementName;

    public OfferwallPlacement(int i, String str, boolean z) {
        this.mPlacementId = i;
        this.mPlacementName = str;
        this.mIsDefault = z;
    }

    public int getPlacementId() {
        return this.mPlacementId;
    }

    public String getPlacementName() {
        return this.mPlacementName;
    }

    public boolean isDefault() {
        return this.mIsDefault;
    }

    public String toString() {
        return "placement name: " + this.mPlacementName + ", placement id: " + this.mPlacementId;
    }
}
