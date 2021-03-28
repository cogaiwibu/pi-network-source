package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.4y */
public class C01464y {
    public static byte[] A04;
    public final Intent A00;
    public final AnonymousClass51 A01;
    public final C0820Wh A02;
    public final JE A03;

    static {
        A0N();
    }

    public static String A0M(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A0N() {
        A04 = new byte[]{51, 54, 13, 54, 51, 38, 51, 13, 48, 39, 60, 54, 62, 55, 14, 25, 11, 29, 14, 24, 25, 24, 42, 21, 24, 25, 19, 61, 24, 56, 29, 8, 29, 62, 9, 18, 24, 16, 25, 77, 82, 95, 94, 84, 100, 79, 82, 86, 94, 100, 75, 84, 87, 87, 82, 85, 92, 100, 82, 85, 79, 94, 73, 77, 90, 87};
    }

    public C01464y(AnonymousClass51 r1, Intent intent, JE je, C0820Wh wh) {
        this.A01 = r1;
        this.A00 = intent;
        this.A03 = je;
        this.A02 = wh;
    }

    public /* synthetic */ C01464y(AnonymousClass51 r1, Intent intent, JE je, C0820Wh wh, C01454x r5) {
        this(r1, intent, je, wh);
    }

    private RQ A00() {
        return (RQ) this.A00.getSerializableExtra(A0M(0, 14, 29));
    }

    /* access modifiers changed from: public */
    private M7 A02() {
        AnonymousClass51 r4 = this.A01;
        return new C0898Zi(r4, this.A02, this.A03, new C0725Sq(r4, null));
    }

    /* access modifiers changed from: public */
    private M7 A03() {
        return new C0664Qe(this.A02, this.A03, new C0725Sq(this.A01, null), A00(), new C0843Xe(), 1);
    }

    /* access modifiers changed from: public */
    private M7 A04() {
        return new C0664Qe(this.A02, this.A03, new C0725Sq(this.A01, null), (RR) this.A00.getSerializableExtra(A0M(14, 25, 51)), new C0841Xc(), 0);
    }

    /* access modifiers changed from: public */
    private M7 A05() {
        C0820Wh wh = this.A02;
        return new AnonymousClass83(wh, this.A03, new AnonymousClass7H(wh), new C0725Sq(this.A01, null), A00());
    }

    /* access modifiers changed from: public */
    private M7 A06() {
        return new C02278l(this.A02, new C0843Xe(), this.A03, A00(), new AnonymousClass7H(this.A02), new C0725Sq(this.A01, null));
    }

    /* access modifiers changed from: public */
    private M7 A07() {
        return new YA(this.A02, this.A03, new C0725Sq(this.A01, null), A00(), null, new C0843Xe());
    }

    /* access modifiers changed from: public */
    private M7 A08() {
        return new AnonymousClass85(this.A02, new C0843Xe(), this.A03, A00(), new AnonymousClass7H(this.A02), new C0725Sq(this.A01, null));
    }

    /* access modifiers changed from: public */
    private M7 A09() {
        RR rr = (RR) this.A00.getSerializableExtra(A0M(14, 25, 51));
        if (rr.A0f()) {
            return new AnonymousClass85(this.A02, new C0841Xc(), this.A03, rr, new AnonymousClass7H(this.A02), new C0349Dn(this.A01, null));
        }
        C0820Wh wh = this.A02;
        return new C0858Xt(wh, this.A03, new C0532Lb(wh), new C0349Dn(this.A01, null), rr);
    }

    /* access modifiers changed from: public */
    private M7 A0A() {
        RR rr = (RR) this.A00.getSerializableExtra(A0M(14, 25, 51));
        return new YA(this.A02, this.A03, new C0349Dn(this.A01, null), rr, rr.A0V(), new C0841Xc());
    }

    /* access modifiers changed from: public */
    private M7 A0B(RelativeLayout relativeLayout) {
        C0846Xh xh = new C0846Xh(this.A02, new C0726Sr(this), this.A03, new C0725Sq(this.A01, null));
        xh.A05(relativeLayout);
        xh.A04(this.A00.getIntExtra(A0M(39, 27, 116), 200));
        C0535Le.A0P(relativeLayout, ViewCompat.MEASURED_STATE_MASK);
        return xh;
    }
}
