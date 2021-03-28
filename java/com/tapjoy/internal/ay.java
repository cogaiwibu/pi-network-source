package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class ay extends AbstractSet implements Serializable, Set {
    transient WeakHashMap a;

    public ay() {
        this(new WeakHashMap());
    }

    private ay(WeakHashMap weakHashMap) {
        this.a = weakHashMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.a.put(obj, this) == null;
    }

    public final void clear() {
        this.a.clear();
    }

    @Override // java.lang.Object
    public final Object clone() {
        try {
            return (ay) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator iterator() {
        return this.a.keySet().iterator();
    }

    public final boolean remove(Object obj) {
        return this.a.remove(obj) != null;
    }

    public final int size() {
        return this.a.size();
    }
}
