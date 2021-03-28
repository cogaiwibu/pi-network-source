package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AndroidDialogPickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidDialogPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.AndroidDialogPickerManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidDialogPickerManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        int i = 0;
        boolean z = true;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals("enabled")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -979805852:
                if (str.equals("prompt")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 100526016:
                if (str.equals(FirebaseAnalytics.Param.ITEMS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1191572123:
                if (str.equals("selected")) {
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
            ((AndroidDialogPickerManagerInterface) this.mViewManager).setColor(t, obj == null ? null : Integer.valueOf(((Double) obj).intValue()));
        } else if (c == 1) {
            AndroidDialogPickerManagerInterface androidDialogPickerManagerInterface = (AndroidDialogPickerManagerInterface) this.mViewManager;
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
            androidDialogPickerManagerInterface.setEnabled(t, z);
        } else if (c == 2) {
            ((AndroidDialogPickerManagerInterface) this.mViewManager).setItems(t, (ReadableArray) obj);
        } else if (c == 3) {
            ((AndroidDialogPickerManagerInterface) this.mViewManager).setPrompt(t, obj == null ? "" : (String) obj);
        } else if (c != 4) {
            super.setProperty(t, str, obj);
        } else {
            AndroidDialogPickerManagerInterface androidDialogPickerManagerInterface2 = (AndroidDialogPickerManagerInterface) this.mViewManager;
            if (obj != null) {
                i = ((Double) obj).intValue();
            }
            androidDialogPickerManagerInterface2.setSelected(t, i);
        }
    }
}
