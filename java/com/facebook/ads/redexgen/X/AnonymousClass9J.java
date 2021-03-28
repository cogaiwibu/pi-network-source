package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.AnonymousClass9I;
import com.facebook.ads.redexgen.X.AnonymousClass9K;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.facebook.ads.redexgen.X.9J  reason: invalid class name */
public final class AnonymousClass9J<T extends AnonymousClass9K, E extends AnonymousClass9I> {
    public static String[] A02;
    public final Map<Class<E>, List<WeakReference<T>>> A00 = new HashMap<>();
    public final Queue<E> A01 = new ArrayDeque<>();

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"WBmgDKUAJnOjRPVdo459bnYJXDnRSoZA", "OZ5TpfWbSmXE", "sC9WLlq1dd0W0qrWeGI0su3O22TcCAEW", "0Ub2X", "5m4s5CvbohnvtMuC", "JEGJTDHJWZGaFE0Bjwe", "ELtjylBnyGpGsAAS3nfDjHYeujv6lcAm", "LzmA2INjpudrbI3uXcOOEdZHAsdjx9ZW"};
    }

    /* JADX INFO: Multiple debug info for r0v5 java.lang.ref.WeakReference: [D('event' E extends com.facebook.ads.redexgen.X.9I), D('subscriberReference' java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.9K>)] */
    private void A01(E e) {
        List<WeakReference<T>> list;
        Map<Class<E>, List<WeakReference<T>>> map = this.A00;
        if (!(map == null || (list = map.get(e.getClass())) == null)) {
            A02(list);
            if (!list.isEmpty()) {
                for (WeakReference<T> subscriberReference : new ArrayList(list)) {
                    T subscriber = subscriberReference.get();
                    if (subscriber != null && subscriber.A00(e)) {
                        subscriber.A04(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: Multiple debug info for r8v0 java.util.List<java.lang.ref.WeakReference<T extends com.facebook.ads.redexgen.X.9K>>: [D('readPtr' int), D('ix' int)] */
    private void A02(List<WeakReference<T>> list) {
        if (list != null) {
            int i = 0;
            for (int writePtr = 0; writePtr < list.size(); writePtr++) {
                WeakReference<T> weakReference = list.get(writePtr);
                T t = weakReference.get();
                if (A02[1].length() != 12) {
                    throw new RuntimeException<>();
                }
                String[] strArr = A02;
                strArr[6] = "MDutMibHR0xfS0kHpIX6qzWASaThPw85";
                strArr[0] = "nvT9JaP2TDwXv3h3yDNvutMp299h55Zc";
                if (t != null) {
                    list.set(i, weakReference);
                    i++;
                }
            }
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
        }
    }

    public final synchronized void A03(E e) {
        if (this.A01.isEmpty()) {
            this.A01.add(e);
            while (!this.A01.isEmpty()) {
                A01(this.A01.peek());
                this.A01.remove();
            }
        } else {
            this.A01.add(e);
        }
    }

    public final synchronized void A04(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                A06(t);
            }
        }
    }

    public final synchronized void A05(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                A07(t);
            }
        }
    }

    public final synchronized boolean A06(T t) {
        if (t == null) {
            return false;
        }
        Class<E> A012 = t.A01();
        if (this.A00.get(A012) == null) {
            this.A00.put(A012, new ArrayList<>());
        }
        List<WeakReference<T>> list = this.A00.get(A012);
        A02(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).get() == t) {
                return false;
            }
        }
        return list.add(new WeakReference<>(t));
    }

    public final synchronized boolean A07(@Nullable T t) {
        if (t == null) {
            return false;
        }
        List<WeakReference<T>> list = this.A00.get(t.A01());
        if (list == null) {
            return false;
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (list.get(i).get() == t) {
                list.get(i).clear();
                return true;
            }
        }
        return false;
    }
}
