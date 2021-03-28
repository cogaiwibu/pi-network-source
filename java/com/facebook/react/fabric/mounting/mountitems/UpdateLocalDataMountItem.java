package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;
import com.ironsource.sdk.constants.Constants;

public class UpdateLocalDataMountItem implements MountItem {
    private final ReadableMap mNewLocalData;
    private final int mReactTag;

    public UpdateLocalDataMountItem(int i, ReadableMap readableMap) {
        this.mReactTag = i;
        this.mNewLocalData = readableMap;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.updateLocalData(this.mReactTag, this.mNewLocalData);
    }

    public ReadableMap getNewLocalData() {
        return this.mNewLocalData;
    }

    public String toString() {
        return "UpdateLocalDataMountItem [" + this.mReactTag + Constants.RequestParameters.RIGHT_BRACKETS;
    }
}
