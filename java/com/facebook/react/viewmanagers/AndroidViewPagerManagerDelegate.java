package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface;

public class AndroidViewPagerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidViewPagerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: U extends com.facebook.react.uimanager.BaseViewManagerInterface<T> & com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidViewPagerManagerDelegate(U u) {
        super(u);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate, com.facebook.react.uimanager.BaseViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        boolean z = true;
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        switch (str.hashCode()) {
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1233251315:
                if (str.equals("initialPage")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1919780198:
                if (str.equals("peekEnabled")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            AndroidViewPagerManagerInterface androidViewPagerManagerInterface = (AndroidViewPagerManagerInterface) this.mViewManager;
            if (obj != null) {
                i = ((Double) obj).intValue();
            }
            androidViewPagerManagerInterface.setInitialPage(t, i);
        } else if (c == 1) {
            AndroidViewPagerManagerInterface androidViewPagerManagerInterface2 = (AndroidViewPagerManagerInterface) this.mViewManager;
            if (obj != null) {
                i2 = ((Double) obj).intValue();
            }
            androidViewPagerManagerInterface2.setPageMargin(t, i2);
        } else if (c == 2) {
            AndroidViewPagerManagerInterface androidViewPagerManagerInterface3 = (AndroidViewPagerManagerInterface) this.mViewManager;
            if (obj != null) {
                z2 = ((Boolean) obj).booleanValue();
            }
            androidViewPagerManagerInterface3.setPeekEnabled(t, z2);
        } else if (c == 3) {
            ((AndroidViewPagerManagerInterface) this.mViewManager).setKeyboardDismissMode(t, (String) obj);
        } else if (c != 4) {
            super.setProperty(t, str, obj);
        } else {
            AndroidViewPagerManagerInterface androidViewPagerManagerInterface4 = (AndroidViewPagerManagerInterface) this.mViewManager;
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            }
            androidViewPagerManagerInterface4.setScrollEnabled(t, z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface<T> r5, T r6, java.lang.String r7, com.facebook.react.bridge.ReadableArray r8) {
        /*
            r4 = this;
            int r0 = r7.hashCode()
            r1 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x001b
            r1 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "setPage"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0025
            r7 = 0
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "setPageWithoutAnimation"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0025
            r7 = 1
            goto L_0x0026
        L_0x0025:
            r7 = -1
        L_0x0026:
            if (r7 == 0) goto L_0x0033
            if (r7 == r2) goto L_0x002b
            goto L_0x003a
        L_0x002b:
            int r7 = r8.getInt(r3)
            r5.setPageWithoutAnimation(r6, r7)
            goto L_0x003a
        L_0x0033:
            int r7 = r8.getInt(r3)
            r5.setPage(r6, r7)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate.receiveCommand(com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface, android.view.View, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
