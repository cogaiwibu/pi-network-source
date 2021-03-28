package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* renamed from: com.facebook.ads.redexgen.X.4H  reason: invalid class name */
public final class AnonymousClass4H extends AbstractC0915a2<C0641Ph> implements AnonymousClass8F {
    public static String[] A02;
    public C0820Wh A00;
    public boolean A01 = false;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"iVby5wy6H7l4dzY0Hld0xs9tuHtnGk", "Nr0U5YnFPaRVMsCPPiWFbDdqiRS3TX59", "NmHEOi9mcJk9OQjZmIqLk3AYwOx5ICK3", "j6OxXppfxNxejmkkIb10P2S2ED13bfax", "YxA", "okdCTGqDBxOQkU", "XAA3rxsPdfTGxXL8JCFSxOB2RupP9g", "Mu"};
    }

    public AnonymousClass4H(C0641Ph ph, C0820Wh wh) {
        super(ph);
        this.A00 = wh;
    }

    private void A01(int i) {
        if (!this.A01) {
            this.A00.A0A().A3C(i);
        }
        String[] strArr = A02;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "k6Oe58jhR2JQ133LIP7LsY5lW6eco9l5";
        strArr2[1] = "k6Oe58jhR2JQ133LIP7LsY5lW6eco9l5";
        this.A01 = true;
    }

    /* JADX INFO: Multiple debug info for r4v1 com.facebook.ads.redexgen.X.Ph: [D('adView' android.view.View), D('historicalCount' int), D('animation' android.view.animation.Animation)] */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        boolean z;
        boolean z2;
        boolean z3;
        C0641Ph ph = (C0641Ph) A08();
        int i = 0;
        if (ph == null) {
            A01(0);
            return;
        }
        View view = ph.A0C;
        AbstractC0640Pg pg = (AbstractC0640Pg) ph.A0E.get();
        int i2 = 1;
        if (view == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z && pg != null) {
            C0642Pi A0E = C0641Ph.A0E(view, ph.A0A, this.A00);
            if (A0E.A04()) {
                C0641Ph.A05(ph);
            } else {
                ph.A00 = 0;
            }
            if (ph.A00 > ph.A09) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (ph.A05 == null || !ph.A05.A04()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z2 || !A0E.A04()) {
                ph.A05 = A0E;
            }
            String valueOf = String.valueOf(A0E.A01());
            synchronized (ph) {
                if (ph.A06.containsKey(valueOf)) {
                    i = ((Integer) ph.A06.get(valueOf)).intValue();
                }
                ph.A06.put(valueOf, Integer.valueOf(i + 1));
            }
            if (z2 && !z3) {
                this.A01 = true;
                ph.A03 = System.currentTimeMillis();
                if (ph.A07) {
                    this.A00.A0A().A3D();
                }
                pg.A04();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500);
                    view.startAnimation(alphaAnimation);
                }
                if (!(ph.A0F)) {
                    return;
                }
            } else if (z2 || !z3) {
                pg.A03();
                if (!this.A01 && (ph.A07)) {
                    this.A00.A0A().A3B(A0E.A02());
                }
                this.A01 = true;
            } else {
                this.A01 = true;
                if (ph.A07) {
                    AnonymousClass0S A0A = this.A00.A0A();
                    AnonymousClass0R A022 = A0E.A02();
                    if (A02[1].charAt(31) != 'Y') {
                        String[] strArr = A02;
                        strArr[0] = "aqGg3VLISO1RonzxWpaMuFcsA6T1VU";
                        strArr[6] = "xPzVxhTd5JHIqZhWukTWbX9dZKpXQ5";
                        A0A.A2i(A022);
                    } else {
                        throw new RuntimeException();
                    }
                }
                pg.A02();
            }
            if (!(ph.A08) && ph.A04 != null) {
                ph.A0B.postDelayed(ph.A04, (long) ph.A02);
            }
        } else if (ph.A07) {
            if (!z) {
                i2 = 2;
            }
            A01(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8F
    public final C0820Wh A5G() {
        return this.A00;
    }
}
