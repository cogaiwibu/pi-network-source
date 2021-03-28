package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class InsertMountItem implements MountItem {
    private int mIndex;
    private int mParentReactTag;
    private int mReactTag;

    public InsertMountItem(int i, int i2, int i3) {
        this.mReactTag = i;
        this.mParentReactTag = i2;
        this.mIndex = i3;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.addViewAt(this.mParentReactTag, this.mReactTag, this.mIndex);
    }

    public int getParentReactTag() {
        return this.mParentReactTag;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String toString() {
        return "InsertMountItem [" + this.mReactTag + "] - parentTag: " + this.mParentReactTag + " - index: " + this.mIndex;
    }
}
