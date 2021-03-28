package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class S9<K, V> extends AnonymousClass2S<K, V> implements Map<K, V> {
    public AnonymousClass2P<K, V> A00;

    private AnonymousClass2P<K, V> A00() {
        if (this.A00 == null) {
            this.A00 = new S8(this);
        }
        return this.A00;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return A00().A0C();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return A00().A0D();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.facebook.ads.redexgen.X.S9<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        A0E(super.A00 + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return A00().A0A();
    }
}
