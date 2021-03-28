package com.ironsource.mediationsdk.model;

public enum PlacementCappingType {
    PER_DAY("d"),
    PER_HOUR("h");
    
    public String value;

    private PlacementCappingType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
