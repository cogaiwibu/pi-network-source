package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Gi  reason: case insensitive filesystem */
public final class C0416Gi implements PE {
    public static String[] A05;
    @Nullable
    public ViewPropertyAnimator A00;
    public PD A01 = PD.A05;
    public final int A02;
    public final View A03;
    public final boolean A04;

    static {
        A04();
    }

    public static void A04() {
        A05 = new String[]{"hBpWhHnhmL5X5T638nUqTTajkmWXq0Jo", "NpDFSQumXtRd9HWL09JYgYkJkV27cWXf", "AxBlHN1IgfTmgBmsQuewVQ8cZkGbRxm7", "auJ8KOWij5XUc2OVh7MwLzJgAA213fGo", "l76sAXRLIUx67IYksgmFi2YoLkAbbgnJ", "1g5g87wiu8KgxwL4MK6lukjj0pQl5xRt", "P6OmLQzTnVk1JPGEjhdY9fnbkCpMcnWe", "QfRSCgXdOTNJYzcBVbNAL0t7GjPIPusf"};
    }

    public C0416Gi(View view, int i, boolean z) {
        this.A02 = i;
        this.A03 = view;
        this.A04 = z;
    }

    private void A05(boolean z) {
        this.A01 = PD.A04;
        if (this.A04) {
            C0535Le.A0O(this.A03);
        }
        String[] strArr = A05;
        if (strArr[4].charAt(27) != strArr[2].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[0] = "iTCONHrR5nymrEIlx0VHUpGctJrwflIU";
        strArr2[0] = "iTCONHrR5nymrEIlx0VHUpGctJrwflIU";
        if (z) {
            this.A00 = this.A03.animate().alpha(1.0f).setDuration((long) this.A02).setListener(new PI(this));
            return;
        }
        this.A03.setAlpha(1.0f);
        this.A01 = PD.A03;
    }

    private void A06(boolean z) {
        this.A01 = PD.A06;
        if (z) {
            this.A00 = this.A03.animate().alpha(0.0f).setDuration((long) this.A02).setListener(new PJ(this));
            return;
        }
        View view = this.A03;
        if (A05[3].charAt(11) != 'U') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[1] = "Va1KnH22vapH99C3A8HUoUYkLtllReKa";
        strArr[1] = "Va1KnH22vapH99C3A8HUoUYkLtllReKa";
        view.setAlpha(0.0f);
        this.A01 = PD.A05;
    }

    @Override // com.facebook.ads.redexgen.X.PE
    public final void A3O(boolean z, boolean z2) {
        if (z2) {
            A06(z);
        } else {
            A05(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PE
    public final PD A71() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.PE
    public final void cancel() {
        this.A03.clearAnimation();
        ViewPropertyAnimator viewPropertyAnimator = this.A00;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }
}
