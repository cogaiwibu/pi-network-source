package com.learnium.RNDeviceInfo.resolver;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.learnium.RNDeviceInfo.DeviceType;

public class DeviceTypeResolver {
    private final Context context;

    public DeviceTypeResolver(Context context2) {
        this.context = context2;
    }

    public boolean isTablet() {
        return getDeviceType() == DeviceType.TABLET;
    }

    public DeviceType getDeviceType() {
        if (this.context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv")) {
            return DeviceType.TV;
        }
        UiModeManager uiModeManager = (UiModeManager) this.context.getSystemService("uimode");
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            return DeviceType.TV;
        }
        DeviceType deviceTypeFromResourceConfiguration = getDeviceTypeFromResourceConfiguration();
        if (deviceTypeFromResourceConfiguration == null || deviceTypeFromResourceConfiguration == DeviceType.UNKNOWN) {
            return getDeviceTypeFromPhysicalSize();
        }
        return deviceTypeFromResourceConfiguration;
    }

    private DeviceType getDeviceTypeFromResourceConfiguration() {
        int i = this.context.getResources().getConfiguration().smallestScreenWidthDp;
        if (i == 0) {
            return DeviceType.UNKNOWN;
        }
        return i >= 600 ? DeviceType.TABLET : DeviceType.HANDSET;
    }

    private DeviceType getDeviceTypeFromPhysicalSize() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        if (windowManager == null) {
            return DeviceType.UNKNOWN;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        double d = (double) displayMetrics.widthPixels;
        double d2 = (double) displayMetrics.xdpi;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) displayMetrics.heightPixels;
        double d5 = (double) displayMetrics.ydpi;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double sqrt = Math.sqrt(Math.pow(d3, 2.0d) + Math.pow(d4 / d5, 2.0d));
        if (sqrt >= 3.0d && sqrt <= 6.9d) {
            return DeviceType.HANDSET;
        }
        if (sqrt <= 6.9d || sqrt > 18.0d) {
            return DeviceType.UNKNOWN;
        }
        return DeviceType.TABLET;
    }
}
