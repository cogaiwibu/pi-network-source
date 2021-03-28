package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class FT {
    public static String[] A04;
    public final int A00;
    @Nullable
    public final FG A01;
    public final long A02;
    public final CopyOnWriteArrayList<FS> A03;

    static {
        A01();
    }

    public static void A01() {
        A04 = new String[]{"HGHzNcawqnVFgJx8ceQNwcxcn1SDkpDb", "AD2ta0a", "biSUTEi4nYJndXTTLsT", "38FOXeSW4cnwnxdXp60to", "WtyRCcfaPM", "iLolo35", "fvJAwdggv90DLF", "FbA7S8K"};
    }

    public FT() {
        this(new CopyOnWriteArrayList(), 0, null, 0);
    }

    public FT(CopyOnWriteArrayList<FS> copyOnWriteArrayList, int i, @Nullable FG fg, long j) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i;
        this.A01 = fg;
        this.A02 = j;
    }

    private long A00(long j) {
        long A012 = C02669y.A01(j);
        if (A012 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.A02;
        if (A04[2].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[7] = "vQJR5ZN";
        strArr[7] = "vQJR5ZN";
        return j2 + A012;
    }

    private void A02(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    @CheckResult
    public final FT A03(int i, @Nullable FG fg, long j) {
        return new FT(this.A03, i, fg, j);
    }

    /* JADX INFO: Multiple debug info for r0v6 com.facebook.ads.redexgen.X.FS: [D('listenerAndHandler' com.facebook.ads.redexgen.X.FS), D('listener' com.facebook.ads.redexgen.X.FW)] */
    public final void A04() {
        boolean z;
        if (this.A01 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS listenerAndHandler = it.next();
            A02(listenerAndHandler.A00, new FJ(this, listenerAndHandler.A01));
        }
    }

    /* JADX INFO: Multiple debug info for r0v6 com.facebook.ads.redexgen.X.FS: [D('listenerAndHandler' com.facebook.ads.redexgen.X.FS), D('listener' com.facebook.ads.redexgen.X.FW)] */
    public final void A05() {
        boolean z;
        if (this.A01 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS listenerAndHandler = it.next();
            A02(listenerAndHandler.A00, new FK(this, listenerAndHandler.A01));
        }
    }

    /* JADX INFO: Multiple debug info for r0v11 com.facebook.ads.redexgen.X.FS: [D('listenerAndHandler' com.facebook.ads.redexgen.X.FS), D('listener' com.facebook.ads.redexgen.X.FW)] */
    public final void A06() {
        boolean z;
        if (this.A01 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        Iterator<FS> it = this.A03.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A04[7].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[2] = "JAadAeVCHcunsRCfoQL";
            strArr[2] = "JAadAeVCHcunsRCfoQL";
            if (hasNext) {
                FS listenerAndHandler = it.next();
                A02(listenerAndHandler.A00, new FP(this, listenerAndHandler.A01));
            } else {
                return;
            }
        }
    }

    public final void A07(int i, @Nullable Format format, int i2, @Nullable Object obj, long j) {
        A0D(new FV(1, i, format, i2, obj, A00(j), -9223372036854775807L));
    }

    public final void A08(Handler handler, FW fw) {
        boolean z;
        if (handler == null || fw == null) {
            z = false;
        } else {
            z = true;
        }
        I1.A03(z);
        this.A03.add(new FS(handler, fw));
    }

    public final void A09(FU fu, FV fv) {
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS next = it.next();
            A02(next.A00, new FN(this, next.A01, fu, fv));
        }
    }

    public final void A0A(FU fu, FV fv) {
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS next = it.next();
            A02(next.A00, new FM(this, next.A01, fu, fv));
        }
    }

    public final void A0B(FU fu, FV fv) {
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS next = it.next();
            A02(next.A00, new FL(this, next.A01, fu, fv));
        }
    }

    /* JADX INFO: Multiple debug info for r0v4 com.facebook.ads.redexgen.X.FS: [D('listenerAndHandler' com.facebook.ads.redexgen.X.FS), D('listener' com.facebook.ads.redexgen.X.FW)] */
    public final void A0C(FU fu, FV fv, IOException iOException, boolean z) {
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS listenerAndHandler = it.next();
            A02(listenerAndHandler.A00, new FO(this, listenerAndHandler.A01, fu, fv, iOException, z));
        }
    }

    public final void A0D(FV fv) {
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS next = it.next();
            A02(next.A00, new FR(this, next.A01, fv));
        }
    }

    public final void A0E(FW fw) {
        Iterator<FS> it = this.A03.iterator();
        while (it.hasNext()) {
            FS next = it.next();
            if (next.A01 == fw) {
                this.A03.remove(next);
            }
        }
    }

    public final void A0F(HQ hq, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3) {
        A0B(new FU(hq, j3, 0, 0), new FV(i, i2, format, i3, obj, A00(j), A00(j2)));
    }

    public final void A0G(HQ hq, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        A09(new FU(hq, j3, j4, j5), new FV(i, i2, format, i3, obj, A00(j), A00(j2)));
    }

    public final void A0H(HQ hq, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        A0A(new FU(hq, j3, j4, j5), new FV(i, i2, format, i3, obj, A00(j), A00(j2)));
    }

    public final void A0I(HQ hq, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        A0C(new FU(hq, j3, j4, j5), new FV(i, i2, format, i3, obj, A00(j), A00(j2)), iOException, z);
    }
}
