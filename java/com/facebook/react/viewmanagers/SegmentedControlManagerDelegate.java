package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SegmentedControlManagerInterface;
import com.tapjoy.TJAdUnitConstants;

public class SegmentedControlManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SegmentedControlManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.SegmentedControlManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SegmentedControlManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals("enabled")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -823812830:
                if (str.equals(TJAdUnitConstants.String.USAGE_TRACKER_VALUES)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1436069623:
                if (str.equals("selectedIndex")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1684715624:
                if (str.equals("momentary")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            ((SegmentedControlManagerInterface) this.mViewManager).setValues(t, (ReadableArray) obj);
        } else if (c == 1) {
            SegmentedControlManagerInterface segmentedControlManagerInterface = (SegmentedControlManagerInterface) this.mViewManager;
            if (obj != null) {
                i = ((Double) obj).intValue();
            }
            segmentedControlManagerInterface.setSelectedIndex(t, i);
        } else if (c == 2) {
            SegmentedControlManagerInterface segmentedControlManagerInterface2 = (SegmentedControlManagerInterface) this.mViewManager;
            if (obj != null) {
                z2 = ((Boolean) obj).booleanValue();
            }
            segmentedControlManagerInterface2.setEnabled(t, z2);
        } else if (c == 3) {
            ((SegmentedControlManagerInterface) this.mViewManager).setTintColor(t, obj == null ? null : Integer.valueOf(((Double) obj).intValue()));
        } else if (c != 4) {
            super.setProperty(t, str, obj);
        } else {
            SegmentedControlManagerInterface segmentedControlManagerInterface3 = (SegmentedControlManagerInterface) this.mViewManager;
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
            segmentedControlManagerInterface3.setMomentary(t, z);
        }
    }
}
