package com.facebook.infer.annotation;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class Assertions {
    public static void assumeCondition(boolean z) {
    }

    public static void assumeCondition(boolean z, String str) {
    }

    public static <T> T assumeNotNull(@Nullable T t) {
        return t;
    }

    public static <T> T assumeNotNull(@Nullable T t, String str) {
        return t;
    }

    public static <T> T assertNotNull(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new AssertionError();
    }

    public static <T> T assertNotNull(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new AssertionError(str);
    }

    public static <T> T getAssumingNotNull(List<T> list, int i) {
        return list.get(i);
    }

    public static <T> T getAssertingNotNull(List<T> list, int i) {
        assertCondition(i >= 0 && i < list.size());
        return (T) assertNotNull(list.get(i));
    }

    public static <K, V> V getAssumingNotNull(Map<K, V> map, K k) {
        return map.get(k);
    }

    public static <K, V> V getAssertingNotNull(Map<K, V> map, K k) {
        assertCondition(map.containsKey(k));
        return (V) assertNotNull(map.get(k));
    }

    public static void assertCondition(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static void assertCondition(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static AssertionError assertUnreachable() {
        throw new AssertionError();
    }

    public static AssertionError assertUnreachable(String str) {
        throw new AssertionError(str);
    }

    public static AssertionError assertUnreachable(Exception exc) {
        throw new AssertionError(exc);
    }
}
