package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class Sets {
    private Sets() {
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> newHashSetWithCapacity = newHashSetWithCapacity(eArr.length);
        Collections.addAll(newHashSetWithCapacity, eArr);
        return newHashSetWithCapacity;
    }

    public static <E> HashSet<E> newHashSetWithCapacity(int i) {
        return new HashSet<>(i);
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<>((Collection) iterable);
        }
        return newHashSet(iterable.iterator());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        HashSet<E> hashSet = (HashSet<E>) newHashSet();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet;
    }

    public static <E> Set<E> newIdentityHashSet() {
        return newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }
}
