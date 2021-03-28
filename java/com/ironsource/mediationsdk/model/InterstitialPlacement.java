package com.ironsource.mediationsdk.model;

public class InterstitialPlacement {
    private boolean mIsDefault;
    private PlacementAvailabilitySettings mPlacementAvailabilitySettings;
    private int mPlacementId;
    private String mPlacementName;

    public InterstitialPlacement(int i, String str, boolean z, PlacementAvailabilitySettings placementAvailabilitySettings) {
        this.mPlacementId = i;
        this.mPlacementName = str;
        this.mIsDefault = z;
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

    public String toString() {
        return "placement name: " + this.mPlacementName;
    }

    public PlacementAvailabilitySettings getPlacementAvailabilitySettings() {
        return this.mPlacementAvailabilitySettings;
    }
}
