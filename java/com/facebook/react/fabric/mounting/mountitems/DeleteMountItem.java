package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.ironsource.sdk.constants.Constants;

public class DeleteMountItem implements MountItem {
    private int mReactTag;

    public DeleteMountItem(int i) {
        this.mReactTag = i;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.deleteView(this.mReactTag);
    }

    public String toString() {
        return "DeleteMountItem [" + this.mReactTag + Constants.RequestParameters.RIGHT_BRACKETS;
    }
}
