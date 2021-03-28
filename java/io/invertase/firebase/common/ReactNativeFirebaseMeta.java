package io.invertase.firebase.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.app.ReactNativeFirebaseApp;

public class ReactNativeFirebaseMeta {
    private static final String META_PREFIX = "rnfirebase_";
    private static final String TAG = "RNFBMetaProvider";
    private static ReactNativeFirebaseMeta sharedInstance = new ReactNativeFirebaseMeta();

    public static ReactNativeFirebaseMeta getSharedInstance() {
        return sharedInstance;
    }

    private Bundle getMetaData() {
        ApplicationInfo applicationInfo;
        try {
            Context applicationContext = ReactNativeFirebaseApp.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null) {
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public boolean contains(String str) {
        Bundle metaData = getMetaData();
        if (metaData == null) {
            return false;
        }
        return metaData.containsKey(META_PREFIX + str);
    }

    public boolean getBooleanValue(String str, boolean z) {
        Bundle metaData = getMetaData();
        if (metaData == null) {
            return z;
        }
        return metaData.getBoolean(META_PREFIX + str, z);
    }

    public String getStringValue(String str, String str2) {
        Bundle metaData = getMetaData();
        if (metaData == null) {
            return str2;
        }
        return metaData.getString(META_PREFIX + str, str2);
    }

    public WritableMap getAll() {
        Bundle metaData = getMetaData();
        WritableMap createMap = Arguments.createMap();
        if (metaData == null) {
            return createMap;
        }
        for (String str : metaData.keySet()) {
            if (str.startsWith(META_PREFIX)) {
                Object obj = metaData.get(str);
                if (obj == null) {
                    createMap.putNull(str);
                } else if (obj instanceof String) {
                    createMap.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    createMap.putBoolean(str, ((Boolean) obj).booleanValue());
                }
            }
        }
        return createMap;
    }
}
