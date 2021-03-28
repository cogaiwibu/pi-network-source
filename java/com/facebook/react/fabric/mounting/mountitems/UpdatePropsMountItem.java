package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;
import com.ironsource.sdk.constants.Constants;

public class UpdatePropsMountItem implements MountItem {
    private final int mReactTag;
    private final ReadableMap mUpdatedProps;

    public UpdatePropsMountItem(int i, ReadableMap readableMap) {
        this.mReactTag = i;
        this.mUpdatedProps = readableMap;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.updateProps(this.mReactTag, this.mUpdatedProps);
    }

    public String toString() {
        return "UpdatePropsMountItem [" + this.mReactTag + Constants.RequestParameters.RIGHT_BRACKETS;
    }
}
