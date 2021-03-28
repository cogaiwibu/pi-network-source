package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface;

public class PullToRefreshViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & PullToRefreshViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public PullToRefreshViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        boolean z = false;
        switch (str.hashCode()) {
            case -1799367701:
                if (str.equals("titleColor")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -321826009:
                if (str.equals("refreshing")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 110371416:
                if (str.equals("title")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        Integer num = null;
        String str2 = null;
        Integer num2 = null;
        if (c == 0) {
            PullToRefreshViewManagerInterface pullToRefreshViewManagerInterface = (PullToRefreshViewManagerInterface) this.mViewManager;
            if (obj != null) {
                num = Integer.valueOf(((Double) obj).intValue());
            }
            pullToRefreshViewManagerInterface.setTintColor(t, num);
        } else if (c == 1) {
            PullToRefreshViewManagerInterface pullToRefreshViewManagerInterface2 = (PullToRefreshViewManagerInterface) this.mViewManager;
            if (obj != null) {
                num2 = Integer.valueOf(((Double) obj).intValue());
            }
            pullToRefreshViewManagerInterface2.setTitleColor(t, num2);
        } else if (c == 2) {
            PullToRefreshViewManagerInterface pullToRefreshViewManagerInterface3 = (PullToRefreshViewManagerInterface) this.mViewManager;
            if (obj != null) {
                str2 = (String) obj;
            }
            pullToRefreshViewManagerInterface3.setTitle(t, str2);
        } else if (c != 3) {
            super.setProperty(t, str, obj);
        } else {
            PullToRefreshViewManagerInterface pullToRefreshViewManagerInterface4 = (PullToRefreshViewManagerInterface) this.mViewManager;
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
            pullToRefreshViewManagerInterface4.setRefreshing(t, z);
        }
    }

    public void receiveCommand(PullToRefreshViewManagerInterface<T> pullToRefreshViewManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == 513968928 && str.equals("setNativeRefreshing")) ? (char) 0 : 65535) == 0) {
            pullToRefreshViewManagerInterface.setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
