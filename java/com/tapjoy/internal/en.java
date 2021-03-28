package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
public final class en extends AbstractList implements Serializable, RandomAccess {
    private final ArrayList a;

    en(List list) {
        this.a = new ArrayList(list);
    }

    public final int size() {
        return this.a.size();
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        return this.a.get(i);
    }

    public final Object[] toArray() {
        return this.a.toArray();
    }
}
