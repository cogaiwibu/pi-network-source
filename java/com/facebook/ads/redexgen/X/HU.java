package com.facebook.ads.redexgen.X;

import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;

@TargetApi(12)
public final class HU implements AbstractC0627Ot {
    public static String[] A0B;
    public View A00;
    @Nullable
    public C0532Lb A01;
    @Nullable
    public P4 A02;
    public boolean A03;
    public final Handler A04;
    public final K4 A05;
    public final AbstractC0506Jy A06;
    public final AbstractC0494Jk A07;
    public final IC A08;
    public final boolean A09;
    public final boolean A0A;

    static {
        A06();
    }

    public static void A06() {
        A0B = new String[]{"82Zz8oCZg8zkkbzw8opl2Yz4CtrF2SDp", "9Qv", "sj5N5SmrmBRQmWue5o8rJw6ys3alFtJa", "lBA7odrZYL425", "CSSBUKaIJSWMhqfJuWGnuyX4cipoTk5I", "IDQP5gLMbSSnC18VVbdsGZXvkzghwpNg", "Yf1MSxzKxHs57zUlY7hI2xykX4pHUq1P", "T3bn0lMwtbok5v0PvXD6574OGDOrX6LS"};
    }

    public HU(View view, P4 p4, boolean z) {
        this(view, p4, z, false);
    }

    public HU(View view, @Nullable P4 p4, boolean z, boolean z2) {
        this.A06 = new C02047h(this);
        this.A07 = new C02037e(this);
        this.A05 = new C02027d(this);
        this.A08 = new C02017c(this);
        this.A03 = true;
        this.A04 = new Handler();
        this.A09 = z;
        this.A0A = z2;
        A09(view, p4);
    }

    /* access modifiers changed from: private */
    public void A05() {
        this.A00.animate().alpha(0.0f).setDuration(500).setListener(new P3(this));
    }

    /* access modifiers changed from: private */
    public void A07(int i, int i2) {
        this.A04.removeCallbacksAndMessages(null);
        this.A00.clearAnimation();
        this.A00.setAlpha((float) i);
        this.A00.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public void A08(AnimatorListenerAdapter animatorListenerAdapter) {
        this.A00.setVisibility(0);
        this.A00.animate().alpha(1.0f).setDuration(500).setListener(animatorListenerAdapter);
    }

    private final void A09(View view, P4 p4) {
        this.A02 = p4;
        this.A00 = view;
        this.A00.clearAnimation();
        if (p4 == P4.A04) {
            this.A00.setAlpha(0.0f);
            String[] strArr = A0B;
            if (strArr[5].charAt(26) != strArr[0].charAt(26)) {
                String[] strArr2 = A0B;
                strArr2[5] = "3OWa54Sl5zOXBo6RskK22JrE4LW5JWKj";
                strArr2[0] = "lt7hksMEFpJVhV2333OBcIopOVPW9bfy";
                this.A00.setVisibility(8);
                return;
            }
            throw new RuntimeException();
        }
        this.A00.setAlpha(1.0f);
        this.A00.setVisibility(0);
    }

    public final void A0G() {
        this.A03 = false;
        A08(null);
    }

    public final boolean A0H() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void A7s(C0532Lb lb) {
        this.A01 = lb;
        lb.getEventBus().A04(this.A06, this.A07, this.A08, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void ADa(C0532Lb lb) {
        A07(1, 0);
        lb.getEventBus().A05(this.A05, this.A08, this.A07, this.A06);
        this.A01 = null;
    }
}
