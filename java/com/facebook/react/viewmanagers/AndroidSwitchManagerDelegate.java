package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;

public class AndroidSwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.AndroidSwitchManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidSwitchManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        boolean z = true;
        boolean z2 = false;
        switch (str.hashCode()) {
            case -1742453971:
                if (str.equals("thumbColor")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1609594047:
                if (str.equals("enabled")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -287374307:
                if (str.equals("trackTintColor")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3551:
                if (str.equals("on")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 111972721:
                if (str.equals("value")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1084662482:
                if (str.equals("trackColorForFalse")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2113632767:
                if (str.equals("trackColorForTrue")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        Integer num = null;
        switch (c) {
            case 0:
                AndroidSwitchManagerInterface androidSwitchManagerInterface = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface.setDisabled(t, z2);
                return;
            case 1:
                AndroidSwitchManagerInterface androidSwitchManagerInterface2 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface2.setEnabled(t, z);
                return;
            case 2:
                AndroidSwitchManagerInterface androidSwitchManagerInterface3 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                androidSwitchManagerInterface3.setThumbColor(t, num);
                return;
            case 3:
                AndroidSwitchManagerInterface androidSwitchManagerInterface4 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                androidSwitchManagerInterface4.setTrackColorForFalse(t, num);
                return;
            case 4:
                AndroidSwitchManagerInterface androidSwitchManagerInterface5 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                androidSwitchManagerInterface5.setTrackColorForTrue(t, num);
                return;
            case 5:
                AndroidSwitchManagerInterface androidSwitchManagerInterface6 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface6.setValue(t, z2);
                return;
            case 6:
                AndroidSwitchManagerInterface androidSwitchManagerInterface7 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidSwitchManagerInterface7.setOn(t, z2);
                return;
            case 7:
                AndroidSwitchManagerInterface androidSwitchManagerInterface8 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                androidSwitchManagerInterface8.setThumbTintColor(t, num);
                return;
            case '\b':
                AndroidSwitchManagerInterface androidSwitchManagerInterface9 = (AndroidSwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                androidSwitchManagerInterface9.setTrackTintColor(t, num);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }

    public void receiveCommand(AndroidSwitchManagerInterface<T> androidSwitchManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -669744680 && str.equals("setNativeValue")) ? (char) 0 : 65535) == 0) {
            androidSwitchManagerInterface.setNativeValue(t, readableArray.getBoolean(0));
        }
    }
}
