package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.gj;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public final class fy extends gj {
    static final Map a = Collections.unmodifiableMap(new HashMap());
    private final gj.a c = a("BuildConfig");
    private final gj.a d = a("ServerFinal");
    private final gj.a e;
    private final gj.a f;
    private final gj.a g;

    fy() {
        gj.a a2 = a("AppRuntime");
        this.e = a2;
        a2.b = new ConcurrentHashMap();
        this.f = a("ConnectFlags");
        this.g = a("ServerDefault");
        gj.a a3 = a("SDKDefault");
        HashMap hashMap = new HashMap();
        hashMap.put("placement_request_content_retry_timeout", -1);
        hashMap.put("placement_request_content_retry_backoff", Arrays.asList(0L, 500L, Long.valueOf((long) TapjoyConstants.TIMER_INCREMENT), Double.valueOf(2.0d)));
        a3.b = hashMap;
    }

    public final void a(@Nullable Map map) {
        Map map2;
        Map map3 = null;
        if (map != null) {
            map3 = (Map) map.get("final");
            map2 = (Map) map.get("default");
        } else {
            map2 = null;
        }
        this.d.b = map3;
        this.g.b = map2;
        setChanged();
    }

    public final void a(Hashtable hashtable) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : hashtable.entrySet()) {
            String str = (String) a.get(entry.getKey());
            if (str == null) {
                str = (String) entry.getKey();
            }
            this.e.b.remove(str);
            hashMap.put(str, entry.getValue());
        }
        this.f.b = hashMap;
        setChanged();
    }
}
