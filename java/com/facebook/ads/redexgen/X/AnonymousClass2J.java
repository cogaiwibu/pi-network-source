package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray;
import com.ironsource.sdk.constants.Events;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.2J  reason: invalid class name */
public final class AnonymousClass2J<E> implements Cloneable {
    public static byte[] A04;
    public static final Object A05 = new Object();
    public int A00;
    public boolean A01;
    public long[] A02;
    public Object[] A03;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{19, 79, 83, 82, 72, 27, 118, 90, 75, 18, 91, 87, 51, 53};
    }

    static {
        A05();
    }

    public AnonymousClass2J() {
        this(10);
    }

    public AnonymousClass2J(int i) {
        this.A01 = false;
        if (i == 0) {
            this.A02 = AnonymousClass2I.A01;
            this.A03 = AnonymousClass2I.A02;
        } else {
            int A002 = AnonymousClass2I.A00(i);
            this.A02 = new long[A002];
            this.A03 = new Object[A002];
        }
        this.A00 = 0;
    }

    private final long A00(int i) {
        if (this.A01) {
            A04();
        }
        return this.A02[i];
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final AnonymousClass2J<E> clone() {
        LongSparseArray<E> longSparseArray = null;
        try {
            longSparseArray = (AnonymousClass2J) super.clone();
            longSparseArray.A02 = (long[]) this.A02.clone();
            longSparseArray.A03 = (Object[]) this.A03.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException unused) {
            return longSparseArray;
        }
    }

    private final E A02(long j, E e) {
        int A032 = AnonymousClass2I.A03(this.A02, this.A00, j);
        if (A032 >= 0) {
            Object[] objArr = this.A03;
            if (objArr[A032] != A05) {
                return (E) objArr[A032];
            }
        }
        return e;
    }

    private void A04() {
        int o = this.A00;
        int i = 0;
        long[] jArr = this.A02;
        Object[] objArr = this.A03;
        for (int i2 = 0; i2 < o; i2++) {
            Object obj = objArr[i2];
            if (obj != A05) {
                if (i2 != i) {
                    jArr[i] = jArr[i2];
                    objArr[i] = obj;
                    objArr[i2] = null;
                }
                i++;
            }
        }
        this.A01 = false;
        this.A00 = i;
    }

    public final int A06() {
        if (this.A01) {
            A04();
        }
        return this.A00;
    }

    public final E A07(int i) {
        if (this.A01) {
            A04();
        }
        return (E) this.A03[i];
    }

    public final E A08(long j) {
        return A02(j, null);
    }

    public final void A09() {
        int i = this.A00;
        Object[] objArr = this.A03;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.A00 = 0;
        this.A01 = false;
    }

    public final void A0A(int i) {
        Object[] objArr = this.A03;
        Object obj = objArr[i];
        Object obj2 = A05;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.A01 = true;
        }
    }

    public final void A0B(long j, E e) {
        int A032 = AnonymousClass2I.A03(this.A02, this.A00, j);
        if (A032 >= 0) {
            this.A03[A032] = e;
            return;
        }
        int i = A032 ^ -1;
        if (i < this.A00) {
            Object[] objArr = this.A03;
            if (objArr[i] == A05) {
                this.A02[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.A01 && this.A00 >= this.A02.length) {
            A04();
            i = AnonymousClass2I.A03(this.A02, this.A00, j) ^ -1;
        }
        int i2 = this.A00;
        if (i2 >= this.A02.length) {
            int A002 = AnonymousClass2I.A00(i2 + 1);
            long[] jArr = new long[A002];
            Object[] objArr2 = new Object[A002];
            long[] jArr2 = this.A02;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.A03;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.A02 = jArr;
            this.A03 = objArr2;
        }
        int i3 = this.A00;
        if (i3 - i != 0) {
            long[] jArr3 = this.A02;
            System.arraycopy(jArr3, i, jArr3, i + 1, i3 - i);
            Object[] objArr4 = this.A03;
            System.arraycopy(objArr4, i, objArr4, i + 1, this.A00 - i);
        }
        this.A02[i] = j;
        this.A03[i] = e;
        this.A00++;
    }

    /* JADX INFO: Multiple debug info for r0v9 java.lang.Object: [D('i' int), D('value' java.lang.Object)] */
    public final String toString() {
        if (A06() <= 0) {
            return A03(12, 2, 126);
        }
        LongSparseArray<E> sb = new StringBuilder<>(this.A00 * 28);
        sb.append('{');
        for (int i = 0; i < this.A00; i++) {
            if (i > 0) {
                sb.append(A03(10, 2, 65));
            }
            sb.append(A00(i));
            sb.append(Events.EQUAL);
            Object value = A07(i);
            if (value != this) {
                sb.append(value);
            } else {
                sb.append(A03(0, 10, 13));
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
