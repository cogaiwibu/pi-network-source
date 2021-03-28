package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.List;

/* compiled from: DislikeDispatcher */
public class a {
    private static volatile a a;
    private final k<com.bytedance.sdk.openadsdk.b.a> b = j.c();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(g gVar, List<FilterWord> list) {
        this.b.a(gVar, list);
    }
}
