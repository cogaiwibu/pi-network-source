package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public final class az extends AbstractMap {
    private final HashMap a = new HashMap();
    private final bx b = new bx();

    public final int size() {
        b();
        return this.a.size();
    }

    public final void clear() {
        this.a.clear();
        do {
        } while (this.b.a() != null);
    }

    public final boolean containsKey(Object obj) {
        b();
        return this.a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        b();
        for (bw bwVar : this.a.values()) {
            if (obj.equals(bwVar.get())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        b();
        return a((bw) this.a.get(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        return a((bw) this.a.put(obj, new bw(obj, obj2, this.b)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        return a((bw) this.a.remove(obj));
    }

    private static Object a(bw bwVar) {
        if (bwVar != null) {
            return bwVar.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        b();
        return this.a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        b();
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        b();
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        b();
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        b();
        throw new UnsupportedOperationException();
    }

    private void b() {
        while (true) {
            bw a2 = this.b.a();
            if (a2 != null) {
                this.a.remove(a2.a);
            } else {
                return;
            }
        }
    }

    public static az a() {
        return new az();
    }
}
