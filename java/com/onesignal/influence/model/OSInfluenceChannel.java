package com.onesignal.influence.model;

import com.onesignal.OneSignalDbContract;

public enum OSInfluenceChannel {
    IAM("iam"),
    NOTIFICATION(OneSignalDbContract.NotificationTable.TABLE_NAME);
    
    private final String name;

    private OSInfluenceChannel(String str) {
        this.name = str;
    }

    public boolean equalsName(String str) {
        return this.name.equals(str);
    }

    public String toString() {
        return this.name;
    }

    public static OSInfluenceChannel fromString(String str) {
        if (str == null || str.isEmpty()) {
            return NOTIFICATION;
        }
        OSInfluenceChannel[] values = values();
        for (OSInfluenceChannel oSInfluenceChannel : values) {
            if (oSInfluenceChannel.equalsName(str)) {
                return oSInfluenceChannel;
            }
        }
        return NOTIFICATION;
    }
}
