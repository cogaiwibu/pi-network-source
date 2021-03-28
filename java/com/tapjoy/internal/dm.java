package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.anythink.reactnativejs.utils.Const;
import com.ironsource.sdk.constants.Constants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dm {
    static float a = Resources.getSystem().getDisplayMetrics().density;
    private static WindowManager b;
    private static String[] c = {Const.X, Const.Y, "width", "height"};

    static class a {
        final float a;
        final float b;

        a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
            b = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            dn.a("Error with setting ad session id", e);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            dn.a("JSONException during JSONObject.put for name [" + str + Constants.RequestParameters.RIGHT_BRACKETS, e);
        }
    }

    public static void a(JSONObject jSONObject, List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            dn.a("Error with setting friendly obstruction", e);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            dn.a("Error with setting not visible reason", e);
        }
    }

    public static JSONObject a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Const.X, (double) (((float) i) / a));
            jSONObject.put(Const.Y, (double) (((float) i2) / a));
            jSONObject.put("width", (double) (((float) i3) / a));
            jSONObject.put("height", (double) (((float) i4) / a));
        } catch (JSONException e) {
            dn.a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble(Const.X);
                        double optDouble2 = optJSONObject.optDouble(Const.Y);
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                a aVar = new a(f2, f);
                jSONObject.put("width", (double) aVar.a);
                jSONObject.put("height", (double) aVar.b);
            }
        } else if (b != null) {
            Point point = new Point(0, 0);
            b.getDefaultDisplay().getRealSize(point);
            f2 = ((float) point.x) / a;
            f = ((float) point.y) / a;
            a aVar2 = new a(f2, f);
            jSONObject.put("width", (double) aVar2.a);
            jSONObject.put("height", (double) aVar2.b);
        }
        f = 0.0f;
        a aVar22 = new a(f2, f);
        try {
            jSONObject.put("width", (double) aVar22.a);
            jSONObject.put("height", (double) aVar22.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(org.json.JSONObject r10, org.json.JSONObject r11) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.dm.b(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
