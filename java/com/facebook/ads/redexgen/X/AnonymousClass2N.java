package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.androidx.support.v4.util.MapCollections;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: com.facebook.ads.redexgen.X.2N  reason: invalid class name */
public final class AnonymousClass2N implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
    public static byte[] A04;
    public static String[] A05;
    public int A00;
    public int A01;
    public boolean A02 = false;
    public final /* synthetic */ AnonymousClass2P A03;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 108);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{28, -40, -20, -19, -9, -92, -25, -13, -14, -8, -27, -19, -14, -23, -10, -92, -24, -13, -23, -9, -92, -14, -13, -8, -92, -9, -7, -12, -12, -13, -10, -8, -92, -10, -23, -8, -27, -19, -14, -19, -14, -21, -92, -47, -27, -12, -78, -55, -14, -8, -10, -3, -92, -13, -26, -18, -23, -25, -8, -9};
    }

    public static void A03() {
        A05 = new String[]{"XqZAhum", "ZDgQMvtBgNrA71zPtdKPERKXDyY", "", "fQnh1QnAdjSL19mcL6hVXdKAmOMxUcoe", "Jl6IPYfhih6t3CzPawLUV", "5ptyQxfboOWL43Tud8kOlHSoYTCJZrHB", "GBGqVCnWWQQidVcjkSktabcuIfs5iNWm", "2xozQVjtj3EM4viJRxfTyERGPuYGzhPM"};
    }

    public AnonymousClass2N(AnonymousClass2P r2) {
        this.A03 = r2;
        this.A00 = r2.A05() - 1;
        this.A01 = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final Map.Entry<K, V> next() {
        if (hasNext()) {
            this.A01++;
            this.A02 = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    public final boolean equals(Object obj) {
        if (!this.A02) {
            throw new IllegalStateException(A00(1, 59, 24));
        } else if (!(obj instanceof Map.Entry)) {
            return false;
        } else {
            MapCollections<K, V>.MapIterator mapIterator = (Map.Entry) obj;
            if (!AnonymousClass2I.A04(mapIterator.getKey(), this.A03.A08(this.A01, 0)) || !AnonymousClass2I.A04(mapIterator.getValue(), this.A03.A08(this.A01, 1))) {
                return false;
            }
            return true;
        }
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        if (this.A02) {
            return (K) this.A03.A08(this.A01, 0);
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        if (this.A02) {
            return (V) this.A03.A08(this.A01, 1);
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    public final boolean hasNext() {
        return this.A01 < this.A00;
    }

    public final int hashCode() {
        int hashCode;
        if (this.A02) {
            int i = 0;
            Object A08 = this.A03.A08(this.A01, 0);
            Object A082 = this.A03.A08(this.A01, 1);
            if (A08 == null) {
                hashCode = 0;
            } else {
                hashCode = A08.hashCode();
            }
            if (A082 != null) {
                i = A082.hashCode();
            }
            int i2 = i ^ hashCode;
            if (A05[4].length() != 21) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[3] = "cWQoJWn94PUAudj4depS9TLvBWA1Kd9i";
            strArr[6] = "6piqOMntm5J7SpM7GaPxMNyHyjGIVV8O";
            return i2;
        }
        throw new IllegalStateException(A00(1, 59, 24));
    }

    public final void remove() {
        if (this.A02) {
            this.A03.A0F(this.A01);
            this.A01--;
            this.A00--;
            this.A02 = false;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        if (this.A02) {
            return (V) this.A03.A09(this.A01, v);
        }
        throw new IllegalStateException((String) A00(1, 59, 24));
    }

    public final String toString() {
        return getKey() + ((String) A00(0, 1, 115)) + getValue();
    }
}
