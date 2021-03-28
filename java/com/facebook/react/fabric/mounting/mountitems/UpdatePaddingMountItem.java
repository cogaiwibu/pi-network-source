package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class UpdatePaddingMountItem implements MountItem {
    private final int mBottom;
    private final int mLeft;
    private final int mReactTag;
    private final int mRight;
    private final int mTop;

    public UpdatePaddingMountItem(int i, int i2, int i3, int i4, int i5) {
        this.mReactTag = i;
        this.mLeft = i2;
        this.mTop = i3;
        this.mRight = i4;
        this.mBottom = i5;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.updatePadding(this.mReactTag, this.mLeft, this.mTop, this.mRight, this.mBottom);
    }

    public String toString() {
        return "UpdatePaddingMountItem [" + this.mReactTag + "] - left: " + this.mLeft + " - top: " + this.mTop + " - right: " + this.mRight + " - bottom: " + this.mBottom;
    }
}
