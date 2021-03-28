package com.learnium.RNDeviceInfo;

public enum DeviceType {
    HANDSET("Handset"),
    TABLET("Tablet"),
    TV("Tv"),
    UNKNOWN("unknown");
    
    private final String value;

    private DeviceType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
