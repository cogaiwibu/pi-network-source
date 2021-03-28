package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;

public class PreAllocateViewMountItem implements MountItem {
    private final String mComponent;
    private final ThemedReactContext mContext;
    private final boolean mIsLayoutable;
    private final ReadableMap mProps;
    private final int mReactTag;
    private final int mRootTag;
    private final StateWrapper mStateWrapper;

    public PreAllocateViewMountItem(ThemedReactContext themedReactContext, int i, int i2, String str, ReadableMap readableMap, StateWrapper stateWrapper, boolean z) {
        this.mContext = themedReactContext;
        this.mComponent = str;
        this.mRootTag = i;
        this.mProps = readableMap;
        this.mStateWrapper = stateWrapper;
        this.mReactTag = i2;
        this.mIsLayoutable = z;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        if (FabricUIManager.ENABLE_FABRIC_LOGS) {
            FLog.d(FabricUIManager.TAG, "Executing pre-allocation of: " + toString());
        }
        mountingManager.preallocateView(this.mContext, this.mComponent, this.mReactTag, this.mProps, this.mStateWrapper, this.mIsLayoutable);
    }

    public String toString() {
        return "PreAllocateViewMountItem [" + this.mReactTag + "] - component: " + this.mComponent + " rootTag: " + this.mRootTag + " isLayoutable: " + this.mIsLayoutable;
    }
}
