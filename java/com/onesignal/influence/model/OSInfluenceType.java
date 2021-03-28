package com.onesignal.influence.model;

public enum OSInfluenceType {
    DIRECT,
    INDIRECT,
    UNATTRIBUTED,
    DISABLED;

    public boolean isDirect() {
        return equals(DIRECT);
    }

    public boolean isIndirect() {
        return equals(INDIRECT);
    }

    public boolean isAttributed() {
        return isDirect() || isIndirect();
    }

    public boolean isUnattributed() {
        return equals(UNATTRIBUTED);
    }

    public boolean isDisabled() {
        return equals(DISABLED);
    }

    public static OSInfluenceType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNATTRIBUTED;
        }
        OSInfluenceType[] values = values();
        for (OSInfluenceType oSInfluenceType : values) {
            if (oSInfluenceType.name().equalsIgnoreCase(str)) {
                return oSInfluenceType;
            }
        }
        return UNATTRIBUTED;
    }
}
