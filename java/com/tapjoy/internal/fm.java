package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.gf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class fm extends fq {
    private static final String c = fm.class.getSimpleName();

    public fm(String str, String str2) {
        super(str, str2, "ad");
    }

    public final gf.a a(String str, JSONObject jSONObject) {
        return a(str, a(jSONObject), b(jSONObject));
    }

    public final gf.a b(String str, JSONObject jSONObject) {
        return b(str, a(jSONObject), b(jSONObject));
    }

    public static Map a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
            } catch (JSONException e) {
                String str = c;
                TapjoyLog.d(str, "Unable to getAdUnitDimensions. Invalid params: " + e);
            }
        }
        return hashMap;
    }

    public static Map b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(TJAdUnitConstants.String.USAGE_TRACKER_VALUES);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Long.valueOf(jSONObject2.getLong(next)));
                }
            } catch (JSONException e) {
                String str = c;
                TapjoyLog.d(str, "Unable to getAdUnitValues. Invalid params: " + e);
            }
        }
        return hashMap;
    }
}
