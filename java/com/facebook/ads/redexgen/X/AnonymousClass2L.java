package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.androidx.support.v4.util.MapCollections;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.2L  reason: invalid class name */
public final class AnonymousClass2L implements Set<Map.Entry<K, V>> {
    public final /* synthetic */ AnonymousClass2P A00;

    public AnonymousClass2L(AnonymousClass2P r1) {
        this.A00 = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final boolean add(Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Multiple debug info for r0v7 java.util.Map$Entry: [D('collection' java.util.Collection<? extends java.util.Map$Entry<K, V>>), D('entry' java.util.Map$Entry<K, V>)] */
    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        int A05 = this.A00.A05();
        for (Map.Entry<K, V> entry : collection) {
            this.A00.A0G(entry.getKey(), entry.getValue());
        }
        return A05 != this.A00.A05();
    }

    public final void clear() {
        this.A00.A0E();
    }

    /* JADX INFO: Multiple debug info for r5v1 java.util.Map$Entry: [D('foundVal' java.lang.Object), D('this' com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet)] */
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        MapCollections<K, V>.EntrySet entrySet = (Map.Entry) obj;
        int A06 = this.A00.A06(entrySet.getKey());
        if (A06 < 0) {
            return false;
        }
        return AnonymousClass2I.A04(this.A00.A08(A06, 1), entrySet.getValue());
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        MapCollections<K, V>.EntrySet it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return AnonymousClass2P.A04(this, obj);
    }

    /* JADX INFO: Multiple debug info for r5v2 int: [D('key' java.lang.Object), D('value' java.lang.Object)] */
    public final int hashCode() {
        int hashCode;
        int i = 0;
        for (int A05 = this.A00.A05() - 1; A05 >= 0; A05--) {
            int i2 = 0;
            Object A08 = this.A00.A08(A05, 0);
            Object A082 = this.A00.A08(A05, 1);
            if (A08 == null) {
                hashCode = 0;
            } else {
                hashCode = A08.hashCode();
            }
            if (A082 != null) {
                i2 = A082.hashCode();
            }
            i += i2 ^ hashCode;
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.A00.A05() == 0;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new AnonymousClass2N(this.A00);
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.A00.A05();
    }

    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
