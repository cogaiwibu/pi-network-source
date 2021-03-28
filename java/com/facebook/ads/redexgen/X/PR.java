package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

@TargetApi(14)
public final class PR {
    public static byte[] A02;
    public static String[] A03;
    public final CI A00;
    public final C0948aZ A01 = new C0948aZ();

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-114, -104, -116, -114, -49, -51, -31, -33, -47, -114, -116, -90, -116, -114, -96, -86, -98, -96, -16, -29, -20, -30, -29, -16, -29, -16, -57, -20, -30, -29, -10, -96, -98, -72, -98, -96, -114, -23, 111, 114, -127, -68, 99, -75, -70, -79, -90, 99, 97, 123, 97, 99};
    }

    public static void A03() {
        A03 = new String[]{"WzijvlAd9RP1HJzMxCKzeYHnMs2QP54v", "kfrqpsiELz0FvZTPYg", "hAwPDz", "OryCsPOoCbEZ1Kjw18", "JoqBI6chV", "rfkFyJ13DXugB3RLj6H", "rQvj", "kthZXjW83"};
    }

    public PR(C0820Wh wh) {
        this.A00 = A6.A00(new C0839Xa(wh), new AR(new C0937aO(this.A01)), new XY());
    }

    @VisibleForTesting
    public static String A01(A4 a4) {
        return A00(41, 11, 55) + a4.A01 + A00(14, 22, 116) + a4.A00 + A00(0, 14, 98) + a4.getCause() + A00(36, 2, 98);
    }

    public static boolean A04() {
        if (A03[0].charAt(3) != 'z') {
            String[] strArr = A03;
            strArr[6] = "p35x";
            strArr[6] = "p35x";
            return true;
        }
        throw new RuntimeException();
    }

    public final int A05() {
        return this.A00.A0K();
    }

    public final int A06() {
        return this.A00.A5W();
    }

    public final long A07() {
        return this.A00.A5t();
    }

    public final long A08() {
        return this.A00.A64();
    }

    @Nullable
    public final PP A09() {
        Format A0M = this.A00.A0M();
        if (A0M == null) {
            return null;
        }
        return new PP(A0M.A0F, A0M.A08);
    }

    public final void A0A() {
        this.A00.ACD();
    }

    public final void A0B() {
        this.A00.ACm();
    }

    public final void A0C() {
        this.A00.A0N();
    }

    public final void A0D(float f) {
        this.A00.A0O(f);
    }

    public final void A0E(long j) {
        this.A00.ACl(j);
    }

    /* JADX INFO: Multiple debug info for r4v0 'this'  com.facebook.ads.redexgen.X.PR: [D('dataSourceFactory' com.facebook.ads.redexgen.X.HL), D('cacheManager' com.facebook.ads.redexgen.X.PV)] */
    public final void A0F(Context context, Uri uri) {
        if (J8.A1c(context)) {
            this.A00.A0Q(new Zr(PV.A05(context).A0E(context)).A00(uri));
            return;
        }
        this.A00.A0Q(new Zr(new C0950ab(context, C0466Ig.A0K(context, A00(38, 3, 4)), this.A01)).A00(uri));
    }

    public final void A0G(@Nullable Surface surface) {
        this.A00.A0P(surface);
    }

    public final void A0H(PO po) {
        this.A00.A3H(new GE(this, po));
    }

    public final void A0I(PQ pq) {
        this.A00.A0R(new GK(this, pq));
    }

    public final void A0J(boolean z) {
        this.A00.AD2(z);
    }

    public final boolean A0K() {
        return this.A00.A6k();
    }

    public final boolean A0L() {
        return this.A00.A0L() != null;
    }
}
