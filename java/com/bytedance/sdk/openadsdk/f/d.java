package com.bytedance.sdk.openadsdk.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.f;
import com.bytedance.sdk.openadsdk.g.t;
import com.com.bytedance.overseas.sdk.a.a;
import com.facebook.appevents.AppEventsConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: TrackAdUrlUtils */
public class d {
    private static int a(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    i2 = 5;
                    if (i == 5 || i == 15) {
                        return i2;
                    }
                    return -1;
                }
            }
        }
        return i2;
    }

    public static List<String> a(List<String> list, boolean z) {
        String a = h.a(j.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(a)) {
                next = next.replace("{UID}", a).replace("__UID__", a);
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static List<String> a(List<String> list, boolean z, g gVar) {
        String a = h.a(j.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(a)) {
                next = next.replace("{UID}", a).replace("__UID__", a);
            }
            if (next.contains("__CID__") && gVar != null && !TextUtils.isEmpty(gVar.r())) {
                next = next.replace("__CID__", gVar.r());
            }
            if (next.contains("__CTYPE__") && gVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(a(gVar.v())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", a.a().c());
            }
            if (next.contains("__ANDROIDID1__")) {
                next = next.replace("__ANDROIDID1__", h.c(j.a()));
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            if (next.contains("__IP__")) {
                next = next.replace("__IP__", f.a(true));
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(t.c()));
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
