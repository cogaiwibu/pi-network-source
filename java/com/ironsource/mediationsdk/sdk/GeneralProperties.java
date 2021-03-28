package com.ironsource.mediationsdk.sdk;

import java.util.Map;
import org.json.JSONObject;

public class GeneralProperties {
    public static final String USER_ID = "userId";
    public static final String USER_ID_TYPE = "userIdType";
    private static GeneralProperties mInstance;
    private JSONObject mProperties = new JSONObject();

    private GeneralProperties() {
    }

    public static synchronized GeneralProperties getProperties() {
        GeneralProperties generalProperties;
        synchronized (GeneralProperties.class) {
            if (mInstance == null) {
                mInstance = new GeneralProperties();
            }
            generalProperties = mInstance;
        }
        return generalProperties;
    }

    public synchronized void putKeys(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                putKey(str, map.get(str));
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putKey(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            org.json.JSONObject r0 = r1.mProperties     // Catch:{ Exception -> 0x000a, all -> 0x0007 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x000a, all -> 0x0007 }
            goto L_0x000a
        L_0x0007:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x000a:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.sdk.GeneralProperties.putKey(java.lang.String, java.lang.Object):void");
    }

    public synchronized String get(String str) {
        return this.mProperties.optString(str);
    }

    public synchronized JSONObject toJSON() {
        return this.mProperties;
    }
}
