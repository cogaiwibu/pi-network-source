package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;

public class CreateMountItem implements MountItem {
    private final String mComponent;
    private final ThemedReactContext mContext;
    private final boolean mIsLayoutable;
    private final ReadableMap mProps;
    private final int mReactTag;
    private final int mRootTag;
    private final StateWrapper mStateWrapper;

    public CreateMountItem(ThemedReactContext themedReactContext, int i, int i2, String str, ReadableMap readableMap, StateWrapper stateWrapper, boolean z) {
        this.mContext = themedReactContext;
        this.mComponent = str;
        this.mRootTag = i;
        this.mReactTag = i2;
        this.mProps = readableMap;
        this.mStateWrapper = stateWrapper;
        this.mIsLayoutable = z;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.createView(this.mContext, this.mComponent, this.mReactTag, this.mProps, this.mStateWrapper, this.mIsLayoutable);
    }

    public String toString() {
        return "CreateMountItem [" + this.mReactTag + "] - component: " + this.mComponent + " - rootTag: " + this.mRootTag + " - isLayoutable: " + this.mIsLayoutable;
    }
}
