package io.invertase.firebase.common;

import android.content.Context;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class RCTConvertFirebase {
    private static String TAG = "RCTConvertFirebase";

    public static Map<String, Object> firebaseAppToMap(FirebaseApp firebaseApp) {
        String name = firebaseApp.getName();
        FirebaseOptions options = firebaseApp.getOptions();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("name", name);
        hashMap3.put("automaticDataCollectionEnabled", Boolean.valueOf(firebaseApp.isDataCollectionDefaultEnabled()));
        hashMap2.put("apiKey", options.getApiKey());
        hashMap2.put("appId", options.getApplicationId());
        hashMap2.put("projectId", options.getProjectId());
        hashMap2.put("databaseURL", options.getDatabaseUrl());
        hashMap2.put("gaTrackingId", options.getGaTrackingId());
        hashMap2.put("messagingSenderId", options.getGcmSenderId());
        hashMap2.put("storageBucket", options.getStorageBucket());
        hashMap.put("options", hashMap2);
        hashMap.put("appConfig", hashMap3);
        return hashMap;
    }

    public static WritableMap firebaseAppToWritableMap(FirebaseApp firebaseApp) {
        return Arguments.makeNativeMap(firebaseAppToMap(firebaseApp));
    }

    public static FirebaseApp readableMapToFirebaseApp(ReadableMap readableMap, ReadableMap readableMap2, Context context) {
        FirebaseApp firebaseApp;
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
        String string = readableMap2.getString("name");
        builder.setApiKey(readableMap.getString("apiKey"));
        builder.setApplicationId(readableMap.getString("appId"));
        builder.setProjectId(readableMap.getString("projectId"));
        builder.setDatabaseUrl(readableMap.getString("databaseURL"));
        if (readableMap.hasKey("gaTrackingId")) {
            builder.setGaTrackingId(readableMap.getString("gaTrackingId"));
        }
        builder.setStorageBucket(readableMap.getString("storageBucket"));
        builder.setGcmSenderId(readableMap.getString("messagingSenderId"));
        if (string.equals(FirebaseApp.DEFAULT_APP_NAME)) {
            firebaseApp = FirebaseApp.initializeApp(context, builder.build());
        } else {
            firebaseApp = FirebaseApp.initializeApp(context, builder.build(), string);
        }
        if (readableMap2.hasKey("automaticDataCollectionEnabled")) {
            firebaseApp.setDataCollectionDefaultEnabled(readableMap2.getBoolean("automaticDataCollectionEnabled"));
        }
        if (readableMap2.hasKey("automaticResourceManagement")) {
            firebaseApp.setAutomaticResourceManagementEnabled(readableMap2.getBoolean("automaticResourceManagement"));
        }
        return firebaseApp;
    }

    public static WritableMap mapPutValue(String str, @Nullable Object obj, WritableMap writableMap) {
        if (obj == null) {
            writableMap.putNull(str);
            return writableMap;
        }
        String name = obj.getClass().getName();
        char c = 65535;
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    c = 4;
                    break;
                }
                break;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    c = 2;
                    break;
                }
                break;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    c = 0;
                    break;
                }
                break;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    c = 1;
                    break;
                }
                break;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    c = 3;
                    break;
                }
                break;
            case 1195259493:
                if (name.equals("java.lang.String")) {
                    c = 5;
                    break;
                }
                break;
            case 1614941136:
                if (name.equals("org.json.JSONObject$1")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
                break;
            case 1:
                writableMap.putDouble(str, (double) ((Long) obj).longValue());
                break;
            case 2:
                writableMap.putDouble(str, (double) ((Float) obj).floatValue());
                break;
            case 3:
                writableMap.putDouble(str, ((Double) obj).doubleValue());
                break;
            case 4:
                writableMap.putInt(str, ((Integer) obj).intValue());
                break;
            case 5:
                writableMap.putString(str, (String) obj);
                break;
            case 6:
                writableMap.putString(str, obj.toString());
                break;
            default:
                if (!List.class.isAssignableFrom(obj.getClass())) {
                    if (Map.class.isAssignableFrom(obj.getClass())) {
                        WritableMap createMap = Arguments.createMap();
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            mapPutValue((String) entry.getKey(), entry.getValue(), createMap);
                        }
                        writableMap.putMap(str, createMap);
                        break;
                    } else {
                        String str2 = TAG;
                        Log.d(str2, "utils:mapPutValue:unknownType:" + name);
                        writableMap.putNull(str);
                        break;
                    }
                } else {
                    writableMap.putArray(str, Arguments.makeNativeArray((List) obj));
                    break;
                }
        }
        return writableMap;
    }

    public static WritableMap readableMapToWritableMap(ReadableMap readableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        return createMap;
    }

    public static Map<String, Object> toHashMap(ReadableMap readableMap) {
        return readableMap.toHashMap();
    }

    public static List<Object> toArrayList(ReadableArray readableArray) {
        return readableArray.toArrayList();
    }
}
