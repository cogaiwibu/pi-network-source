package com.ironsource.mediationsdk.model;

public class Placement {
    private boolean mIsDefault;
    private PlacementAvailabilitySettings mPlacementAvailabilitySettings;
    private int mPlacementId;
    private String mPlacementName;
    private int mRewardAmount;
    private String mRewardName;

    public Placement(int i, String str, boolean z, String str2, int i2, PlacementAvailabilitySettings placementAvailabilitySettings) {
        this.mPlacementId = i;
        this.mPlacementName = str;
        this.mIsDefault = z;
        this.mRewardName = str2;
        this.mRewardAmount = i2;
        this.mPlacementAvailabilitySettings = placementAvailabilitySettings;
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

    public String getRewardName() {
        return this.mRewardName;
    }

    public int getRewardAmount() {
        return this.mRewardAmount;
    }

    public String toString() {
        return "placement name: " + this.mPlacementName + ", reward name: " + this.mRewardName + " , amount: " + this.mRewardAmount;
    }

    public PlacementAvailabilitySettings getPlacementAvailabilitySettings() {
        return this.mPlacementAvailabilitySettings;
    }
}
