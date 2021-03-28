package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.b.h;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.l;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NetApi */
public interface k<T> {

    /* compiled from: NetApi */
    public interface a {
        void a(int i, String str);

        void a(com.bytedance.sdk.openadsdk.core.c.a aVar);
    }

    /* compiled from: NetApi */
    public interface b {
        void a(int i, String str);

        void a(l.b bVar);
    }

    h a(List<T> list);

    void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.c.h hVar, int i, a aVar);

    void a(g gVar, List<FilterWord> list);

    void a(JSONObject jSONObject, b bVar);

    boolean a(JSONObject jSONObject, int i);
}
