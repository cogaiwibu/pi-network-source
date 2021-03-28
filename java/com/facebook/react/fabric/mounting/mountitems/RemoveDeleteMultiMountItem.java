package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;

public class RemoveDeleteMultiMountItem implements MountItem {
    private static final int DELETE_FLAG = 2;
    private static final int FLAGS_INDEX = 3;
    private static final int INSTRUCTION_FIELDS_LEN = 4;
    private static final int PARENT_TAG_INDEX = 1;
    private static final int REMOVE_FLAG = 1;
    private static final int TAG_INDEX = 0;
    private static final int VIEW_INDEX_INDEX = 2;
    private int[] mMetadata;

    public RemoveDeleteMultiMountItem(int[] iArr) {
        this.mMetadata = iArr;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.mMetadata;
            if (i2 >= iArr.length) {
                break;
            }
            if ((iArr[i2 + 3] & 1) != 0) {
                mountingManager.removeViewAt(iArr[i2 + 1], iArr[i2 + 2]);
            }
            i2 += 4;
        }
        while (true) {
            int[] iArr2 = this.mMetadata;
            if (i < iArr2.length) {
                if ((iArr2[i + 3] & 2) != 0) {
                    mountingManager.deleteView(iArr2[i + 0]);
                }
                i += 4;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mMetadata.length; i += 4) {
            if (sb.length() > 0) {
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            sb.append("RemoveDeleteMultiMountItem (");
            sb.append((i / 4) + 1);
            sb.append("/");
            sb.append(this.mMetadata.length / 4);
            sb.append("): [");
            sb.append(this.mMetadata[i + 0]);
            sb.append("] parent [");
            sb.append(this.mMetadata[i + 1]);
            sb.append("] idx ");
            sb.append(this.mMetadata[i + 2]);
            sb.append(" ");
            sb.append(this.mMetadata[i + 3]);
        }
        return sb.toString();
    }
}
