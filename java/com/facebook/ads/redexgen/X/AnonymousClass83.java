package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.83  reason: invalid class name */
public final class AnonymousClass83 extends ZY {
    public static byte[] A0E;
    public static String[] A0F;
    public static final int A0G = ((int) (C0535Le.A01 * 48.0f));
    public static final int A0H = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0I = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0J = ((int) (C0535Le.A01 * 12.0f));
    public static final int A0K = ((int) (C0535Le.A01 * 56.0f));
    public int A00;
    public int A01;
    @Nullable
    public LinearLayout A02;
    public RQ A03;
    public AnonymousClass7H A04;
    @Nullable
    public AnonymousClass2R A05;
    @Nullable
    public C0586Ne A06;
    public C0630Ow A07;
    @DoNotStrip
    public AbstractC0640Pg A08;
    public C0641Ph A09;
    public String A0A;
    public List<OQ> A0B;
    public final C0820Wh A0C;
    public final LX A0D = new LX();

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0F;
            if (strArr[0].charAt(22) != strArr[6].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "I427OJiZERIl1pgFYs7VIJxgJMuHqTWY";
            strArr2[4] = "m1VK8a3APoHjuOOKlTc7gi9yCeUy6Tbh";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 74);
            i4++;
        }
    }

    public static void A0A() {
        A0E = new byte[]{118, 115, 72, 115, 118, 99, 118, 72, 117, 98, 121, 115, 123, 114};
    }

    public static void A0B() {
        A0F = new String[]{"hEO5MspmmQwWZDjfO9hYkGtE8t8ljCUN", "895GOd6GqHS2SDNwtQvAqIE", "zBXblOu1CdgXx49mdyV8flA", "GxqIbNjcrUQMSJiuMkyJv1mwkudVYaGP", "be3ZgXhlaup3yXbKLr41yKjcTusIQNjx", "HLi8FTj59ZkYUe8FmXrpO0CEflvtIm0o", "7bereGXxKpIS6kk2UNHV0kt11i4QSfeP", "LRvrjmvhZNKPrr4qRukG9JYrfPQqD7wd"};
    }

    static {
        A0B();
        A0A();
    }

    public AnonymousClass83(C0820Wh wh, JE je, AnonymousClass7H r4, M6 m6, RQ rq) {
        super(wh, je, m6, rq);
        this.A04 = r4;
        this.A0C = wh;
    }

    private final void A0C() {
        LinearLayout linearLayout = this.A02;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.A02 = null;
        }
        AnonymousClass2R r0 = this.A05;
        if (r0 != null) {
            r0.removeAllViews();
            this.A05 = null;
        }
        C0586Ne ne = this.A06;
        if (ne != null) {
            ne.removeAllViews();
            this.A06 = null;
        }
    }

    /* JADX INFO: Multiple debug info for r0v17 com.facebook.ads.redexgen.X.2R: [D('extraSpacing' int), D('width' int)] */
    private final void A0D(int i, @Nullable Bundle bundle) {
        int childSpacing;
        int i2;
        int i3;
        AnonymousClass83 r3;
        this.A02 = new LinearLayout(getContext());
        if (i == 1) {
            this.A02.setGravity(17);
        } else {
            this.A02.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i4 = C0535Le.A02.widthPixels;
        int childSpacing2 = C0535Le.A02.heightPixels;
        if (i == 1) {
            childSpacing = Math.min(i4 - (A0H * 4), childSpacing2 / 2);
            i2 = (i4 - childSpacing) / 8;
            i3 = i2 * 4;
        } else {
            childSpacing = childSpacing2 - ((A0K + A0G) + (A0H * 4));
            i2 = A0H;
            i3 = i2 * 2;
        }
        this.A08 = new C0619Ol(this);
        this.A09 = new C0641Ph(this, 1, new WeakReference(this.A08), this.A0C);
        this.A09.A0Y(this.A00);
        this.A09.A0Z(this.A01);
        this.A05 = new AnonymousClass2R(this.A0C);
        this.A05.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A07 = new C0630Ow(this.A05, i, this.A0B, this.A09, bundle);
        this.A05.setAdapter(new C0629Ov(this.A0C, this.A0B, this.A03, super.A0A, this.A04, this.A09, this.A0D, getAudienceNetworkListener(), this.A0A, childSpacing, i2, i3, i, this.A07));
        if (i == 1) {
            r3 = this;
            r3.A0F(r3.A07);
        } else {
            r3 = this;
        }
        LinearLayout linearLayout = r3.A02;
        AnonymousClass2R r4 = r3.A05;
        if (A0F[7].charAt(26) != 'a') {
            String[] strArr = A0F;
            strArr[0] = "pS0yYjaDPNGuTrfnUmeGhxtdEtLadoEJ";
            strArr[6] = "mwC7eMAbLdHre0yQkkMBVztsNAF33a9m";
            linearLayout.addView(r4);
            C0586Ne ne = r3.A06;
            if (ne != null) {
                LinearLayout linearLayout2 = r3.A02;
                String[] strArr2 = A0F;
                if (strArr2[5].charAt(16) != strArr2[4].charAt(16)) {
                    String[] strArr3 = A0F;
                    strArr3[3] = "7ZjVpxQcOo2BFfYt51qxyVC8jdlns0bj";
                    strArr3[3] = "7ZjVpxQcOo2BFfYt51qxyVC8jdlns0bj";
                    linearLayout2.addView(ne);
                } else {
                    throw new RuntimeException();
                }
            }
            r3.A0R(r3.A02, false, i);
            String[] strArr4 = A0F;
            if (strArr4[0].charAt(22) == strArr4[6].charAt(22)) {
                String[] strArr5 = A0F;
                strArr5[3] = "nKvQ299cRrmi8SltfoUYXILZ1CbfqCSq";
                strArr5[3] = "nKvQ299cRrmi8SltfoUYXILZ1CbfqCSq";
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0E(RQ rq) {
        this.A03 = rq;
        this.A0A = this.A03.A0Q();
        this.A00 = this.A03.A0G();
        this.A01 = this.A03.A0H();
        List<AnonymousClass19> A0W = this.A03.A0W();
        this.A0B = new ArrayList(A0W.size());
        for (int i = 0; i < A0W.size(); i++) {
            this.A0B.add(new OQ(i, A0W.size(), A0W.get(i)));
        }
    }

    private void A0F(C0630Ow ow) {
        new ET().A0I(this.A05);
        ow.A0d(new C0615Oh(this));
        this.A06 = new C0586Ne(this.A0C, super.A05.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0I);
        layoutParams.setMargins(0, A0J, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.ZY
    public final boolean A0X() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A7r(Intent intent, Bundle bundle, AnonymousClass51 r6) {
        super.A0S(r6);
        A0E((RQ) intent.getSerializableExtra(A08(0, 14, 93)));
        A0D(r6.A0I().getResources().getConfiguration().orientation, bundle);
        r6.A0L(new OM(this, r6));
        int A032 = super.A08.A0M().A0E().A03();
        if (A032 > 0) {
            A0Q(A032);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7, com.facebook.ads.redexgen.X.ZY
    public final void AAO(boolean z) {
        super.AAO(z);
        C0630Ow ow = this.A07;
        if (ow != null) {
            ow.A0a();
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7, com.facebook.ads.redexgen.X.ZY
    public final void AAl(boolean z) {
        super.AAl(z);
        this.A07.A0b();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void ACg(Bundle bundle) {
        C0630Ow ow = this.A07;
        if (ow != null) {
            ow.A0c(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ZY
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        ACg(bundle);
        A0C();
        A0D(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.X.M7, com.facebook.ads.redexgen.X.ZY
    public final void onDestroy() {
        super.onDestroy();
        if (!TextUtils.isEmpty(this.A0A)) {
            super.A0A.A80(this.A0A, new NU().A04(this.A09).A03(this.A0D).A06());
        }
        A0C();
        this.A09.A0X();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0D.A07(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
