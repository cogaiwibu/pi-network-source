package com.facebook.ads.redexgen.X;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.2P  reason: invalid class name */
public abstract class AnonymousClass2P<K, V> {
    public static String[] A03;
    public AnonymousClass2P<K, V>.EntrySet A00;
    public AnonymousClass2P<K, V>.KeySet A01;
    public AnonymousClass2P<K, V>.ValuesCollection A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"cnftN0nKJ399Diaxmn3tb8gwwrPO2aP4", "GD6Q0W3wC2KuP8ibvS2RtWU8XnqZN0Aj", "FY51T4e3CIDMofRfjaJn97HmoXO", "oFsWTCKeXQMPzJkbzzVFh0WI6lr", "sX7ClejzrEImqIfblQB7OY3eSnYyqYGK", "70PxY4sPYcKp4dj9du2NwnU3Lx25y2ig", "AJxY89BB1aRneGLKwVE9Pufkgncldx4M", "HDwbCIFP6XJ1qJgKvPjZQVX8jvQoDt8b"};
    }

    public abstract int A05();

    public abstract int A06(Object obj);

    public abstract int A07(Object obj);

    public abstract Object A08(int i, int i2);

    public abstract V A09(int i, V v);

    public abstract Map<K, V> A0B();

    public abstract void A0E();

    public abstract void A0F(int i);

    public abstract void A0G(K k, V v);

    public static <K, V> boolean A01(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean A02(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean A03(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* JADX INFO: Multiple debug info for r5v1 java.util.Set: [D('s' java.util.Set<?>), D('set' java.util.Set<T>)] */
    public static <T> boolean A04(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set<T> set2 = (Set) obj;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                return false;
            }
            return true;
        } catch (NullPointerException unused) {
            return false;
        } catch (ClassCastException unused2) {
            return false;
        }
    }

    public final Collection<V> A0A() {
        if (this.A02 == null) {
            this.A02 = new AnonymousClass2O(this);
        }
        return this.A02;
    }

    public final Set<Map.Entry<K, V>> A0C() {
        if (this.A00 == null) {
            this.A00 = new AnonymousClass2L(this);
        }
        AnonymousClass2P<K, V>.EntrySet entrySet = this.A00;
        if (A03[1].charAt(12) != 'P') {
            throw new RuntimeException<>();
        }
        String[] strArr = A03;
        strArr[4] = "9ju5liavVqCXLI9PRLJCuH215nhDnaAN";
        strArr[6] = "X1eenRL1zYDBvWo2ZsNSENOyPnB3gIiL";
        return entrySet;
    }

    public final Set<K> A0D() {
        if (this.A01 == null) {
            this.A01 = new AnonymousClass2M(this);
        }
        return this.A01;
    }

    public final Object[] A0H(int i) {
        int i2 = A05();
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = A08(i3, i);
        }
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] A0I(T[] newArray, int i) {
        int A05 = A05();
        if (newArray.length < A05) {
            newArray = (T[]) ((Object[]) Array.newInstance(newArray.getClass().getComponentType(), A05));
        }
        for (int i2 = 0; i2 < A05; i2++) {
            newArray[i2] = A08(i2, i);
        }
        if (newArray.length > A05) {
            newArray[A05] = null;
        }
        return newArray;
    }
}
