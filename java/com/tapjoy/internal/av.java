package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class av implements ax {
    private final List a;

    public av(List list) {
        this.a = list;
    }

    @Override // java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        return this.a.add(obj);
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        return this.a.addAll(collection);
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        return this.a.equals(obj);
    }

    @Override // com.tapjoy.internal.ax
    public final Object a(int i) {
        return this.a.get(i);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.a.iterator();
    }

    public final boolean remove(Object obj) {
        return this.a.remove(obj);
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.a.removeAll(collection);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        return this.a.retainAll(collection);
    }

    public final int size() {
        return this.a.size();
    }

    public final Object[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.a.toArray(objArr);
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        return this.a.add(obj);
    }

    @Override // java.util.Queue
    public final Object remove() {
        Object poll = poll();
        if (poll != null) {
            return poll;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.remove(0);
    }

    @Override // java.util.Queue
    public final Object element() {
        Object peek = peek();
        if (peek != null) {
            return peek;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(0);
    }

    @Override // com.tapjoy.internal.ax
    public final void b(int i) {
        aw.a(this.a, i);
    }
}
