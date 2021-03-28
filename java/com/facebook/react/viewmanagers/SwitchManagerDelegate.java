package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SwitchManagerInterface;

public class SwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.SwitchManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SwitchManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        boolean z = false;
        switch (str.hashCode()) {
            case -1742453971:
                if (str.equals("thumbColor")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 111972721:
                if (str.equals("value")) {
                    c = 1;
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
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1296813577:
                if (str.equals("onTintColor")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2113632767:
                if (str.equals("trackColorForTrue")) {
                    c = 7;
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
                SwitchManagerInterface switchManagerInterface = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                switchManagerInterface.setDisabled(t, z);
                return;
            case 1:
                SwitchManagerInterface switchManagerInterface2 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                switchManagerInterface2.setValue(t, z);
                return;
            case 2:
                SwitchManagerInterface switchManagerInterface3 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface3.setTintColor(t, num);
                return;
            case 3:
                SwitchManagerInterface switchManagerInterface4 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface4.setOnTintColor(t, num);
                return;
            case 4:
                SwitchManagerInterface switchManagerInterface5 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface5.setThumbTintColor(t, num);
                return;
            case 5:
                SwitchManagerInterface switchManagerInterface6 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface6.setThumbColor(t, num);
                return;
            case 6:
                SwitchManagerInterface switchManagerInterface7 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface7.setTrackColorForFalse(t, num);
                return;
            case 7:
                SwitchManagerInterface switchManagerInterface8 = (SwitchManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                switchManagerInterface8.setTrackColorForTrue(t, num);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }
}
