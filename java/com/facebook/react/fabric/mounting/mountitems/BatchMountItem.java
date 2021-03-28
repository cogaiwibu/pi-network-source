package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.facebook.systrace.Systrace;

public class BatchMountItem implements MountItem {
    private final int mCommitNumber;
    private final MountItem[] mMountItems;
    private final int mSize;

    public BatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        if (mountItemArr == null) {
            throw null;
        } else if (i < 0 || i > mountItemArr.length) {
            throw new IllegalArgumentException("Invalid size received by parameter size: " + i + " items.size = " + mountItemArr.length);
        } else {
            this.mMountItems = mountItemArr;
            this.mSize = i;
            this.mCommitNumber = i2;
        }
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        Systrace.beginSection(0, "FabricUIManager::mountViews - " + this.mSize + " items");
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, null, this.mCommitNumber);
        }
        for (int i = 0; i < this.mSize; i++) {
            this.mMountItems[i].execute(mountingManager);
        }
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, null, this.mCommitNumber);
        }
        Systrace.endSection(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.mSize) {
            if (sb.length() > 0) {
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            sb.append("BatchMountItem (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append("/");
            sb.append(this.mSize);
            sb.append("): ");
            sb.append(this.mMountItems[i]);
            i = i2;
        }
        return sb.toString();
    }
}
