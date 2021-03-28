package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class SendAccessibilityEvent implements MountItem {
    private final int mEventType;
    private final int mReactTag;

    public SendAccessibilityEvent(int i, int i2) {
        this.mReactTag = i;
        this.mEventType = i2;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.sendAccessibilityEvent(this.mReactTag, this.mEventType);
    }

    public String toString() {
        return "SendAccessibilityEvent [" + this.mReactTag + "] " + this.mEventType;
    }
}
