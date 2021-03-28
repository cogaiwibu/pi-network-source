package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        char c;
        int i = 0;
        boolean z = false;
        switch (str.hashCode()) {
            case -1721943862:
                if (str.equals(ViewProps.TRANSLATE_X)) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -1721943861:
                if (str.equals(ViewProps.TRANSLATE_Y)) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1228066334:
                if (str.equals(ViewProps.BORDER_TOP_LEFT_RADIUS)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(ViewProps.SCALE_X)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(ViewProps.SCALE_Y)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -877170387:
                if (str.equals(ViewProps.TEST_ID)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -731417480:
                if (str.equals(ViewProps.Z_INDEX)) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -101663499:
                if (str.equals(ViewProps.ACCESSIBILITY_HINT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -101359900:
                if (str.equals(ViewProps.ACCESSIBILITY_ROLE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -80891667:
                if (str.equals(ViewProps.RENDER_TO_HARDWARE_TEXTURE)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(ViewProps.ROTATION)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals(ViewProps.ELEVATION)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 36255470:
                if (str.equals(ViewProps.ACCESSIBILITY_LIVE_REGION)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 333432965:
                if (str.equals(ViewProps.BORDER_TOP_RIGHT_RADIUS)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 581268560:
                if (str.equals(ViewProps.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 588239831:
                if (str.equals(ViewProps.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 746986311:
                if (str.equals(ViewProps.IMPORTANT_FOR_ACCESSIBILITY)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 1052666732:
                if (str.equals(ViewProps.TRANSFORM)) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1146842694:
                if (str.equals(ViewProps.ACCESSIBILITY_LABEL)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1153872867:
                if (str.equals(ViewProps.ACCESSIBILITY_STATE)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1349188574:
                if (str.equals(ViewProps.BORDER_RADIUS)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1505602511:
                if (str.equals(ViewProps.ACCESSIBILITY_ACTIONS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2045685618:
                if (str.equals(ViewProps.NATIVE_ID)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        float f = 1.0f;
        float f2 = 0.0f;
        float f3 = Float.NaN;
        switch (c) {
            case 0:
                this.mViewManager.setAccessibilityActions(t, (ReadableArray) obj);
                return;
            case 1:
                this.mViewManager.setAccessibilityHint(t, (String) obj);
                return;
            case 2:
                this.mViewManager.setAccessibilityLabel(t, (String) obj);
                return;
            case 3:
                this.mViewManager.setAccessibilityLiveRegion(t, (String) obj);
                return;
            case 4:
                this.mViewManager.setAccessibilityRole(t, (String) obj);
                return;
            case 5:
                this.mViewManager.setViewState(t, (ReadableMap) obj);
                return;
            case 6:
                U u = this.mViewManager;
                if (obj != null) {
                    i = ((Double) obj).intValue();
                }
                u.setBackgroundColor(t, i);
                return;
            case 7:
                U u2 = this.mViewManager;
                if (obj != null) {
                    f3 = ((Double) obj).floatValue();
                }
                u2.setBorderRadius(t, f3);
                return;
            case '\b':
                U u3 = this.mViewManager;
                if (obj != null) {
                    f3 = ((Double) obj).floatValue();
                }
                u3.setBorderBottomLeftRadius(t, f3);
                return;
            case '\t':
                U u4 = this.mViewManager;
                if (obj != null) {
                    f3 = ((Double) obj).floatValue();
                }
                u4.setBorderBottomRightRadius(t, f3);
                return;
            case '\n':
                U u5 = this.mViewManager;
                if (obj != null) {
                    f3 = ((Double) obj).floatValue();
                }
                u5.setBorderTopLeftRadius(t, f3);
                return;
            case 11:
                U u6 = this.mViewManager;
                if (obj != null) {
                    f3 = ((Double) obj).floatValue();
                }
                u6.setBorderTopRightRadius(t, f3);
                return;
            case '\f':
                U u7 = this.mViewManager;
                if (obj != null) {
                    f2 = ((Double) obj).floatValue();
                }
                u7.setElevation(t, f2);
                return;
            case '\r':
                this.mViewManager.setImportantForAccessibility(t, (String) obj);
                return;
            case 14:
                this.mViewManager.setNativeId(t, (String) obj);
                return;
            case 15:
                U u8 = this.mViewManager;
                if (obj != null) {
                    f = ((Double) obj).floatValue();
                }
                u8.setOpacity(t, f);
                return;
            case 16:
                U u9 = this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                u9.setRenderToHardwareTexture(t, z);
                return;
            case 17:
                U u10 = this.mViewManager;
                if (obj != null) {
                    f2 = ((Double) obj).floatValue();
                }
                u10.setRotation(t, f2);
                return;
            case 18:
                U u11 = this.mViewManager;
                if (obj != null) {
                    f = ((Double) obj).floatValue();
                }
                u11.setScaleX(t, f);
                return;
            case 19:
                U u12 = this.mViewManager;
                if (obj != null) {
                    f = ((Double) obj).floatValue();
                }
                u12.setScaleY(t, f);
                return;
            case 20:
                this.mViewManager.setTestId(t, (String) obj);
                return;
            case 21:
                this.mViewManager.setTransform(t, (ReadableArray) obj);
                return;
            case 22:
                U u13 = this.mViewManager;
                if (obj != null) {
                    f2 = ((Double) obj).floatValue();
                }
                u13.setTranslateX(t, f2);
                return;
            case 23:
                U u14 = this.mViewManager;
                if (obj != null) {
                    f2 = ((Double) obj).floatValue();
                }
                u14.setTranslateY(t, f2);
                return;
            case 24:
                U u15 = this.mViewManager;
                if (obj != null) {
                    f2 = ((Double) obj).floatValue();
                }
                u15.setZIndex(t, f2);
                return;
            default:
                return;
        }
    }
}
