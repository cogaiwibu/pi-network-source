package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ProgressViewManagerInterface;

public class ProgressViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ProgressViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.ProgressViewManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProgressViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        switch (str.hashCode()) {
            case -1948954017:
                if (str.equals("progressViewStyle")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -287374307:
                if (str.equals("trackTintColor")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 760630062:
                if (str.equals("progressImage")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 962728315:
                if (str.equals("progressTintColor")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            ((ProgressViewManagerInterface) this.mViewManager).setProgressViewStyle(t, (String) obj);
        } else if (c != 1) {
            Integer num = null;
            if (c == 2) {
                ProgressViewManagerInterface progressViewManagerInterface = (ProgressViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                progressViewManagerInterface.setProgressTintColor(t, num);
            } else if (c == 3) {
                ProgressViewManagerInterface progressViewManagerInterface2 = (ProgressViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                progressViewManagerInterface2.setTrackTintColor(t, num);
            } else if (c == 4) {
                ((ProgressViewManagerInterface) this.mViewManager).setProgressImage(t, (ReadableMap) obj);
            } else if (c != 5) {
                super.setProperty(t, str, obj);
            } else {
                ((ProgressViewManagerInterface) this.mViewManager).setTrackImage(t, (ReadableMap) obj);
            }
        } else {
            ((ProgressViewManagerInterface) this.mViewManager).setProgress(t, obj == null ? 0.0f : ((Double) obj).floatValue());
        }
    }
}
