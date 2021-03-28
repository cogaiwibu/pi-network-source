package com.anythink.reactnativejs.utils;

import android.app.Activity;
import com.anythink.reactnativejs.AnythinkReactContextBaseJavaModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class BaseHelper {
    private static final String TAG = BaseHelper.class.getSimpleName();
    private AnythinkReactContextBaseJavaModule mAnythinkReactContextBaseJavaModule;
    private JSONObject mCallbackJsonObject;
    private String mCallbackNameJson;

    public BaseHelper(AnythinkReactContextBaseJavaModule anythinkReactContextBaseJavaModule) {
        this.mAnythinkReactContextBaseJavaModule = anythinkReactContextBaseJavaModule;
    }

    /* access modifiers changed from: protected */
    public void sendEvent(String str, Object obj) {
        AnythinkReactContextBaseJavaModule anythinkReactContextBaseJavaModule = this.mAnythinkReactContextBaseJavaModule;
        if (anythinkReactContextBaseJavaModule != null) {
            anythinkReactContextBaseJavaModule.sendEvent(str, obj);
        } else {
            MsgTools.pirntMsg("AnythinkReactContextBaseJavaModule = null!");
        }
    }

    /* access modifiers changed from: protected */
    public Activity getActivity() {
        AnythinkReactContextBaseJavaModule anythinkReactContextBaseJavaModule = this.mAnythinkReactContextBaseJavaModule;
        if (anythinkReactContextBaseJavaModule != null) {
            return anythinkReactContextBaseJavaModule.getActivity();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        try {
            getActivity().runOnUiThread(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getJsonMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public static void fillMapFromJsonObject(Map<String, Object> map, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            map.put(next, jSONObject.opt(next));
        }
    }
}
