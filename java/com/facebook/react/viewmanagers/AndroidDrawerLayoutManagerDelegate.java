package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface;

public class AndroidDrawerLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidDrawerLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidDrawerLayoutManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        switch (str.hashCode()) {
            case -2082382380:
                if (str.equals("statusBarBackgroundColor")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1233873500:
                if (str.equals("drawerBackgroundColor")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 268251989:
                if (str.equals("drawerWidth")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 695891258:
                if (str.equals("drawerPosition")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1857208703:
                if (str.equals("drawerLockMode")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            Integer num = null;
            Integer num2 = null;
            Float f = null;
            if (c == 1) {
                AndroidDrawerLayoutManagerInterface androidDrawerLayoutManagerInterface = (AndroidDrawerLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    num = Integer.valueOf(((Double) obj).intValue());
                }
                androidDrawerLayoutManagerInterface.setDrawerBackgroundColor(t, num);
            } else if (c == 2) {
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerPosition(t, (String) obj);
            } else if (c == 3) {
                AndroidDrawerLayoutManagerInterface androidDrawerLayoutManagerInterface2 = (AndroidDrawerLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    f = Float.valueOf(((Double) obj).floatValue());
                }
                androidDrawerLayoutManagerInterface2.setDrawerWidth(t, f);
            } else if (c == 4) {
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerLockMode(t, (String) obj);
            } else if (c != 5) {
                super.setProperty(t, str, obj);
            } else {
                AndroidDrawerLayoutManagerInterface androidDrawerLayoutManagerInterface3 = (AndroidDrawerLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    num2 = Integer.valueOf(((Double) obj).intValue());
                }
                androidDrawerLayoutManagerInterface3.setStatusBarBackgroundColor(t, num2);
            }
        } else {
            ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setKeyboardDismissMode(t, (String) obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface<T> r3, T r4, java.lang.String r5, com.facebook.react.bridge.ReadableArray r6) {
        /*
            r2 = this;
            int r6 = r5.hashCode()
            r0 = -258774775(0xfffffffff0936909, float:-3.649702E29)
            r1 = 1
            if (r6 == r0) goto L_0x001a
            r0 = -83186725(0xfffffffffb0aabdb, float:-7.200226E35)
            if (r6 == r0) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r6 = "openDrawer"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0024
            r5 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r6 = "closeDrawer"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = -1
        L_0x0025:
            if (r5 == 0) goto L_0x002e
            if (r5 == r1) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r3.closeDrawer(r4)
            goto L_0x0031
        L_0x002e:
            r3.openDrawer(r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate.receiveCommand(com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface, android.view.View, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
