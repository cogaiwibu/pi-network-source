package com.ironsource.sdk.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SSAObj {
    private JSONObject mJsonObject;

    public SSAObj() {
        this.mJsonObject = new JSONObject();
    }

    public SSAObj(String str) {
        setJsonObject(str);
    }

    private void setJsonObject(String str) {
        try {
            this.mJsonObject = new JSONObject(str);
        } catch (Exception unused) {
            this.mJsonObject = new JSONObject();
        }
    }

    public JSONObject getJsonObject() {
        return this.mJsonObject;
    }

    public boolean containsKey(String str) {
        return getJsonObject().has(str);
    }

    public boolean isNull(String str) {
        return getJsonObject().isNull(str);
    }

    public Object get(String str) {
        try {
            return getJsonObject().get(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getString(String str) {
        try {
            return this.mJsonObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getString(String str, String str2) {
        return this.mJsonObject.optString(str, str2);
    }

    public boolean getBoolean(String str) {
        try {
            return this.mJsonObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static Object toJSON(Object obj) throws JSONException {
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                if (obj2 != null) {
                    jSONObject.put(obj2.toString(), toJSON(map.get(obj2)));
                }
            }
            return jSONObject;
        } else if (!(obj instanceof Iterable)) {
            return obj;
        } else {
            JSONArray jSONArray = new JSONArray();
            for (Object obj3 : (Iterable) obj) {
                jSONArray.put(obj3);
            }
            return jSONArray;
        }
    }

    public static boolean isEmptyObject(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }

    public List toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(fromJson(jSONArray.get(i)));
        }
        return arrayList;
    }

    public void put(String str, String str2) {
        try {
            this.mJsonObject.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public void put(String str, JSONObject jSONObject) {
        try {
            this.mJsonObject.put(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    public String toString() {
        JSONObject jSONObject = this.mJsonObject;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }

    private Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, fromJson(jSONObject.get(next)));
        }
        return hashMap;
    }

    private Object fromJson(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return toMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? toList((JSONArray) obj) : obj;
    }
}
