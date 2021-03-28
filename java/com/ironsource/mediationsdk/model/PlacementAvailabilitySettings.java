package com.ironsource.mediationsdk.model;

public class PlacementAvailabilitySettings {
    private PlacementCappingType cappingType;
    private int cappingValue;
    private boolean isCappingEnabled;
    private boolean isDeliveryEnabled;
    private boolean isPacingEnabled;
    private int pacingValue;

    private PlacementAvailabilitySettings(boolean z, boolean z2, boolean z3, PlacementCappingType placementCappingType, int i, int i2) {
        this.isDeliveryEnabled = z;
        this.isCappingEnabled = z2;
        this.isPacingEnabled = z3;
        this.cappingType = placementCappingType;
        this.cappingValue = i;
        this.pacingValue = i2;
    }

    public boolean isDeliveryEnabled() {
        return this.isDeliveryEnabled;
    }

    public boolean isCappingEnabled() {
        return this.isCappingEnabled;
    }

    public boolean isPacingEnabled() {
        return this.isPacingEnabled;
    }

    public PlacementCappingType getCappingType() {
        return this.cappingType;
    }

    public int getCappingValue() {
        return this.cappingValue;
    }

    public int getPacingValue() {
        return this.pacingValue;
    }

    public static class PlacementAvailabilitySettingsBuilder {
        private PlacementCappingType cappingType = null;
        private int cappingValue = 0;
        private boolean isCappingEnabled = false;
        private boolean isDeliveryEnabled = true;
        private boolean isPacingEnabled = false;
        private int pacingValue = 0;

        public PlacementAvailabilitySettingsBuilder delivery(boolean z) {
            this.isDeliveryEnabled = z;
            return this;
        }

        public PlacementAvailabilitySettingsBuilder capping(boolean z, PlacementCappingType placementCappingType, int i) {
            this.isCappingEnabled = z;
            if (placementCappingType == null) {
                placementCappingType = PlacementCappingType.PER_DAY;
            }
            this.cappingType = placementCappingType;
            this.cappingValue = i;
            return this;
        }

        public PlacementAvailabilitySettingsBuilder pacing(boolean z, int i) {
            this.isPacingEnabled = z;
            this.pacingValue = i;
            return this;
        }

        public PlacementAvailabilitySettings build() {
            return new PlacementAvailabilitySettings(this.isDeliveryEnabled, this.isCappingEnabled, this.isPacingEnabled, this.cappingType, this.cappingValue, this.pacingValue);
        }
    }
}
