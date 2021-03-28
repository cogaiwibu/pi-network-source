package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.androidx.support.v4.util.MapCollections;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.facebook.ads.redexgen.X.2O  reason: invalid class name */
public final class AnonymousClass2O implements Collection<V> {
    public static String[] A01;
    public final /* synthetic */ AnonymousClass2P A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"WaXEENy4Qqf0iZa9rE7K5Tc", "CdcJslr1GuWzD3hgs8KQ2mZhu", "VqX8APEjT5Wjv2WgYqLWWETF9QEoqL89", "1lDdPMX0zjCtSNVsVcyG9UOAfTksMFfY", "Q30AX00aPMLh2Hp2SxjAPSj4hvT3yuLk", "DGZ9hWDjpXQG3w", "JKstht1TU3rAhNk0s2YNIFhF9tCkCvUD", "xnB3F8eRzgUElZJXVWbAPi1tu19rGp71"};
    }

    public AnonymousClass2O(AnonymousClass2P r1) {
        this.A00 = r1;
    }

    @Override // java.util.Collection
    public final boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.A00.A0E();
    }

    public final boolean contains(Object obj) {
        return this.A00.A07(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        MapCollections<K, V>.ValuesCollection it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.A00.A05() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return new AnonymousClass2K(this.A00, 1);
    }

    public final boolean remove(Object obj) {
        int A07 = this.A00.A07(obj);
        if (A07 >= 0) {
            this.A00.A0F(A07);
            return true;
        } else if (A01[6].charAt(4) != 'M') {
            String[] strArr = A01;
            strArr[1] = "JaPNh4sPI8rJ5EjhCFrDgKQsA";
            strArr[5] = "wvLzjGRSTCxgOw";
            return false;
        } else {
            throw new RuntimeException();
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        int A05 = this.A00.A05();
        boolean z = false;
        int i = 0;
        while (i < A05) {
            if (collection.contains(this.A00.A08(i, 1))) {
                this.A00.A0F(i);
                i--;
                A05--;
                z = true;
            }
            i++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        int A05 = this.A00.A05();
        boolean z = false;
        int i = 0;
        while (i < A05) {
            if (!collection.contains(this.A00.A08(i, 1))) {
                this.A00.A0F(i);
                i--;
                A05--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final int size() {
        return this.A00.A05();
    }

    public final Object[] toArray() {
        return this.A00.A0H(1);
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.A00.A0I(tArr, 1);
    }
}
