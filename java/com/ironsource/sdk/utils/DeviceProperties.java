package com.ironsource.sdk.utils;

import android.content.Context;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.constants.Constants;

public class DeviceProperties {
    private static DeviceProperties mInstance;
    private int mDeviceApiLevel = DeviceStatus.getAndroidAPIVersion();
    private String mDeviceCarrier;
    private String mDeviceModel = DeviceStatus.getDeviceModel();
    private String mDeviceOem = DeviceStatus.getDeviceOEM();
    private String mDeviceOsType = DeviceStatus.getDeviceOs();
    private String mDeviceOsVersion = DeviceStatus.getAndroidOsVersion();

    public static String getSupersonicSdkVersion() {
        return Constants.SDK_VERSION;
    }

    private DeviceProperties(Context context) {
        this.mDeviceCarrier = DeviceStatus.getMobileCarrier(context);
    }

    public static DeviceProperties getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DeviceProperties(context);
        }
        return mInstance;
    }

    public String getDeviceOem() {
        return this.mDeviceOem;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public String getDeviceOsType() {
        return this.mDeviceOsType;
    }

    public String getDeviceOsVersion() {
        return this.mDeviceOsVersion;
    }

    public int getDeviceApiLevel() {
        return this.mDeviceApiLevel;
    }

    public String getDeviceCarrier() {
        return this.mDeviceCarrier;
    }

    public static void release() {
        mInstance = null;
    }

    public float getDeviceVolume(Context context) {
        return DeviceStatus.getSystemVolumePercent(context);
    }
}
