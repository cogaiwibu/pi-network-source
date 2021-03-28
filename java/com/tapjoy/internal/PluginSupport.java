package com.tapjoy.internal;

import java.util.HashMap;
import java.util.TreeMap;

public final class PluginSupport {
    private PluginSupport() {
    }

    public static void trackUsage(String str, String str2, String str3) {
        TreeMap treeMap;
        try {
            HashMap hashMap = null;
            if (!al.a(str2)) {
                treeMap = new TreeMap();
                bn b = bn.b(str2);
                try {
                    b.a(treeMap);
                } finally {
                    b.close();
                }
            } else {
                treeMap = null;
            }
            if (!al.a(str3)) {
                hashMap = new HashMap();
                bn b2 = bn.b(str3);
                try {
                    b2.h();
                    while (b2.j()) {
                        hashMap.put(b2.l(), Long.valueOf(b2.q()));
                    }
                    b2.i();
                } finally {
                    b2.close();
                }
            }
            gf.a(str, treeMap, hashMap);
        } catch (Exception unused) {
        }
    }
}
