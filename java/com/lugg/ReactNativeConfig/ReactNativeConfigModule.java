package com.lugg.ReactNativeConfig;

import android.content.res.Resources;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.common.ReactConstants;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReactNativeConfigModule extends ReactContextBaseJavaModule {
    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ReactNativeConfigModule";
    }

    public ReactNativeConfigModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        String str;
        HashMap hashMap = new HashMap();
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            try {
                str = reactApplicationContext.getString(reactApplicationContext.getResources().getIdentifier("build_config_package", "string", reactApplicationContext.getPackageName()));
            } catch (Resources.NotFoundException unused) {
                str = getReactApplicationContext().getApplicationContext().getPackageName();
            }
            Field[] declaredFields = Class.forName(str + ".BuildConfig").getDeclaredFields();
            for (Field field : declaredFields) {
                try {
                    hashMap.put(field.getName(), field.get(null));
                } catch (IllegalAccessException unused2) {
                    Log.d(ReactConstants.TAG, "ReactConfig: Could not access BuildConfig field " + field.getName());
                }
            }
        } catch (ClassNotFoundException unused3) {
            Log.d(ReactConstants.TAG, "ReactConfig: Could not find BuildConfig class");
        }
        return hashMap;
    }
}
