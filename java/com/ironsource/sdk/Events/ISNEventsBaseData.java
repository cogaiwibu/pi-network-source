package com.ironsource.sdk.Events;

import android.content.Context;
import com.ironsource.eventsTracker.IBaseData;
import com.ironsource.network.ConnectivityUtils;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.utils.DeviceProperties;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

public class ISNEventsBaseData implements IBaseData {
    private static Map<String, Object> baseData = new HashMap();

    private ISNEventsBaseData(Builder builder) {
        collectPermanentData(builder);
        collectMutableData(builder.context);
    }

    private void collectMutableData(Context context) {
        baseData.put(Events.CONNECTION_TYPE, ConnectivityUtils.getConnectionType(context));
    }

    private void collectPermanentData(Builder builder) {
        Context context = builder.context;
        DeviceProperties instance = DeviceProperties.getInstance(context);
        baseData.put(Events.DEVICE_OS, SDKUtils.encodeString(instance.getDeviceOsType()));
        baseData.put(Events.DEVICE_OS_VERSION, SDKUtils.encodeString(instance.getDeviceOsVersion()));
        baseData.put(Events.DEVICE_API_LEVEL, Integer.valueOf(instance.getDeviceApiLevel()));
        baseData.put(Events.DEVICE_OEM, SDKUtils.encodeString(instance.getDeviceOem()));
        baseData.put(Events.DEVICE_MODEL, SDKUtils.encodeString(instance.getDeviceModel()));
        baseData.put(Events.BUNDLE_ID, SDKUtils.encodeString(context.getPackageName()));
        baseData.put(Events.APPLICATION_KEY, SDKUtils.encodeString(builder.applicationKey));
        baseData.put(Events.SESSION_ID, SDKUtils.encodeString(builder.sessionId));
        baseData.put(Events.SDK_VERSION, SDKUtils.encodeString(DeviceProperties.getSupersonicSdkVersion()));
        baseData.put(Events.APPLICATION_USER_ID, SDKUtils.encodeString(builder.userId));
        baseData.put(Events.ENV, Events.PRODUCTION);
        baseData.put("origin", "n");
    }

    @Override // com.ironsource.eventsTracker.IBaseData
    public Map<String, Object> getData() {
        return baseData;
    }

    public static void setConnectionType(String str) {
        baseData.put(Events.CONNECTION_TYPE, SDKUtils.encodeString(str));
    }

    public static class Builder {
        String applicationKey;
        Context context;
        String integrationType;
        String sessionId;
        String userId;

        /* access modifiers changed from: package-private */
        public Builder setSessionId(String str) {
            this.sessionId = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setIntegrationType(String str) {
            this.integrationType = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setApplicationKey(String str) {
            this.applicationKey = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setContext(Context context2) {
            this.context = context2;
            return this;
        }

        public ISNEventsBaseData build() {
            return new ISNEventsBaseData(this);
        }
    }
}
