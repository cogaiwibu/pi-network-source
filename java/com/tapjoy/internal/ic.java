package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kotlin.UByte;

public class ic {
    private static final String d = ic.class.getSimpleName();
    int a;
    int b;
    ie c;
    private int[] e;
    private final int[] f;
    private ByteBuffer g;
    private byte[] h;
    @Nullable
    private byte[] i;
    private int j;
    private int k;
    private Cif l;
    private short[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;
    private int[] q;
    private a r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;

    /* access modifiers changed from: package-private */
    public interface a {
        @Nonnull
        Bitmap a(int i, int i2, Bitmap.Config config);

        byte[] a(int i);

        int[] b(int i);
    }

    ic(a aVar, ie ieVar, ByteBuffer byteBuffer) {
        this(aVar, ieVar, byteBuffer, (byte) 0);
    }

    private ic(a aVar, ie ieVar, ByteBuffer byteBuffer, byte b2) {
        this(aVar);
        b(ieVar, byteBuffer);
    }

    private ic(a aVar) {
        this.f = new int[256];
        this.j = 0;
        this.k = 0;
        this.r = aVar;
        this.c = new ie();
    }

    ic() {
        this(new ih());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:217:0x01ca */
    /* JADX DEBUG: Multi-variable search result rejected for r8v33, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v29, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009a, code lost:
        if (r29.c.j == r5.h) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0214 A[LOOP:4: B:113:0x0212->B:114:0x0214, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Bitmap a() {
        /*
        // Method dump skipped, instructions count: 1009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ic.a():android.graphics.Bitmap");
    }

    private synchronized void a(ie ieVar, byte[] bArr) {
        a(ieVar, ByteBuffer.wrap(bArr));
    }

    private synchronized void a(ie ieVar, ByteBuffer byteBuffer) {
        b(ieVar, byteBuffer);
    }

    private synchronized void b(ie ieVar, ByteBuffer byteBuffer) {
        int highestOneBit = Integer.highestOneBit(1);
        this.u = 0;
        this.c = ieVar;
        this.y = false;
        this.a = -1;
        this.b = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.g = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.g.order(ByteOrder.LITTLE_ENDIAN);
        this.t = false;
        Iterator it = ieVar.e.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((id) it.next()).g == 3) {
                    this.t = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.v = highestOneBit;
        this.x = ieVar.f / highestOneBit;
        this.w = ieVar.g / highestOneBit;
        this.p = this.r.a(ieVar.f * ieVar.g);
        this.q = this.r.b(this.x * this.w);
    }

    private void a(int[] iArr, id idVar, int i2) {
        int i3 = idVar.d / this.v;
        int i4 = idVar.b / this.v;
        int i5 = idVar.c / this.v;
        int i6 = idVar.a / this.v;
        int i7 = this.x;
        int i8 = (i4 * i7) + i6;
        int i9 = (i3 * i7) + i8;
        while (i8 < i9) {
            int i10 = i8 + i5;
            for (int i11 = i8; i11 < i10; i11++) {
                iArr[i11] = i2;
            }
            i8 += this.x;
        }
    }

    private void b() {
        if (this.j <= this.k) {
            if (this.i == null) {
                this.i = this.r.a(16384);
            }
            this.k = 0;
            int min = Math.min(this.g.remaining(), 16384);
            this.j = min;
            this.g.get(this.i, 0, min);
        }
    }

    private int c() {
        try {
            b();
            byte[] bArr = this.i;
            int i2 = this.k;
            this.k = i2 + 1;
            return bArr[i2] & UByte.MAX_VALUE;
        } catch (Exception unused) {
            this.u = 1;
            return 0;
        }
    }

    private int d() {
        int c2 = c();
        if (c2 > 0) {
            try {
                if (this.h == null) {
                    this.h = this.r.a(255);
                }
                int i2 = this.j - this.k;
                if (i2 >= c2) {
                    System.arraycopy(this.i, this.k, this.h, 0, c2);
                    this.k += c2;
                } else if (this.g.remaining() + i2 >= c2) {
                    System.arraycopy(this.i, this.k, this.h, 0, i2);
                    this.k = this.j;
                    b();
                    int i3 = c2 - i2;
                    System.arraycopy(this.i, 0, this.h, i2, i3);
                    this.k += i3;
                } else {
                    this.u = 1;
                }
            } catch (Exception unused) {
                this.u = 1;
            }
        }
        return c2;
    }

    private Bitmap e() {
        Bitmap a2 = this.r.a(this.x, this.w, this.y ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565);
        if (Build.VERSION.SDK_INT >= 12) {
            a2.setHasAlpha(true);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int a(byte[] bArr) {
        if (this.l == null) {
            this.l = new Cif();
        }
        ie a2 = this.l.a(bArr).a();
        this.c = a2;
        if (bArr != null) {
            a(a2, bArr);
        }
        return this.u;
    }
}
