package com.tapjoy.internal;

import com.ironsource.sdk.constants.Events;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class bz extends ca {
    public abstract Object a(bn bnVar);

    @Override // com.tapjoy.internal.ca
    public final Map a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Accept", Events.APP_JSON);
        return linkedHashMap;
    }

    @Override // com.tapjoy.internal.ca
    public final Object a(URI uri, InputStream inputStream) {
        bn a = bn.a(inputStream);
        a.a("BASE_URI", uri);
        int i = 0;
        try {
            a.h();
            Object obj = null;
            String str = null;
            while (a.j()) {
                String l = a.l();
                if ("status".equals(l)) {
                    i = a.r();
                } else if ("message".equals(l)) {
                    str = a.m();
                } else if ("data".equals(l)) {
                    obj = a(a);
                } else {
                    a.s();
                }
            }
            a.i();
            if (i == 200) {
                return obj;
            }
            throw new cb(i, str);
        } finally {
            a.close();
        }
    }
}
