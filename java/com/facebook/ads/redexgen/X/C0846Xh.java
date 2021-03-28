package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Xh  reason: case insensitive filesystem */
public final class C0846Xh implements M7 {
    public static byte[] A0B;
    public int A00;
    public AnonymousClass7w A01;
    public final C0820Wh A02;
    public final JE A03;
    public final M6 A04;
    public final MW A05;
    public final C0532Lb A06;
    public final K4 A07 = new C02529k(this);
    public final K2 A08 = new C02519j(this);
    public final AbstractC0506Jy A09 = new C02539l(this);
    public final AbstractC0494Jk A0A = new C02549m(this);

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 38);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0B = new byte[]{-49, -29, -30, -35, -34, -38, -49, -25, -17, -8, -11, -15, -6, 0, -32, -5, -9, -15, -6, -68, -70, -84, -107, -88, -69, -80, -67, -84, -118, -69, -88, -119, -68, -69, -69, -74, -75, -73, -86, -91, -90, -80, -118, -81, -75, -90, -77, -76, -75, -86, -75, -94, -83, -122, -73, -90, -81, -75, -99, -112, -117, -116, -106, 115, -106, -114, -114, -116, -103, -2, -15, -20, -19, -9, -43, -40, -52, 24, 11, 6, 7, 17, -11, 7, 7, 13, -10, 11, 15, 7, -66, -79, -84, -83, -73, -99, -102, -108};
    }

    public C0846Xh(C0820Wh wh, MW mw, JE je, M6 m6) {
        this.A02 = wh;
        this.A03 = je;
        this.A05 = mw;
        this.A06 = new C0532Lb(wh);
        this.A06.A0Z(new C02057i(wh));
        this.A06.getEventBus().A04(this.A0A, this.A09, this.A07, this.A08);
        this.A04 = m6;
        this.A06.setIsFullScreen(true);
        this.A06.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        m6.A3L(this.A06, layoutParams);
        M9 m9 = new M9(wh);
        m9.setOnClickListener(new MU(this));
        m6.A3L(m9, m9.getDefaultLayoutParams());
    }

    public final void A04(int i) {
        this.A06.setVideoProgressReportIntervalMs(i);
    }

    public final void A05(View view) {
        this.A06.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A7r(Intent intent, Bundle bundle, AnonymousClass51 r13) {
        String stringExtra = intent.getStringExtra(A02(19, 18, 33));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            OO oo = new OO(this.A02, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = (int) (16.0f * C0535Le.A01);
            layoutParams.setMargins(i, i, i, i);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            oo.setOnClickListener(new MV(this));
            this.A04.A3L(oo, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, 124), 0);
        this.A01 = new AnonymousClass7w(this.A02, this.A03, this.A06, intent.getStringExtra(A02(8, 11, 102)), intent.getBundleExtra(A02(58, 11, 1)));
        this.A06.setVideoMPD(intent.getStringExtra(A02(69, 8, 98)));
        this.A06.setVideoURI(intent.getStringExtra(A02(90, 8, 34)));
        int i2 = this.A00;
        if (i2 > 0) {
            this.A06.A0V(i2);
        }
        if (intent.getBooleanExtra(A02(0, 8, 72), false)) {
            this.A06.A0Y(EnumC0626Os.A05, 17);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAO(boolean z) {
        this.A04.A3t(A02(37, 21, 27), new K1());
        this.A06.A0T();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAl(boolean z) {
        this.A04.A3t(A02(37, 21, 27), new C0507Jz());
        if (!this.A06.A0g()) {
            this.A06.A0Y(EnumC0626Os.A05, 18);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void ACg(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void onDestroy() {
        this.A04.A3t(A02(37, 21, 27), new IW(this.A00, this.A06.getCurrentPositionInMillis()));
        this.A01.A0e(this.A06.getCurrentPositionInMillis());
        this.A06.A0W(1);
        this.A06.A0S();
    }
}
