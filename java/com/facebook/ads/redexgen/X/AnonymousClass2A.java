package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.2A  reason: invalid class name */
public class AnonymousClass2A extends ES implements View.OnTouchListener {
    public static byte[] A07;
    public static String[] A08;
    public int A00 = 0;
    public SW A01;
    public ON A02;
    public boolean A03 = true;
    public boolean A04 = false;
    public int A05 = 0;
    public final int A06 = A04();

    static {
        A0A();
        A09();
    }

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 62);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A07 = new byte[]{-53, -26, -39, -24, -54, -35, -37, -15, -37, -28, -35, -22, -50, -31, -35, -17, -104, -25, -26, -28, -15, -104, -21, -19, -24, -24, -25, -22, -20, -21, -104, -60, -31, -26, -35, -39, -22, -60, -39, -15, -25, -19, -20, -59, -39, -26, -39, -33, -35, -22};
    }

    public static void A0A() {
        A08 = new String[]{"y4Urxqcv9RCHCbRsxOihNkmZ9cqKDFdZ", "LGqXjwU2H5uaBf0UptGCT7ZDInUwl5IV", "fkBbKznr2zH2OwfKJXQ1DdYWN1N", "HFNULQ3MobNCNeOVkX9dtbi8574Dr14V", "KPqvTm6ScHx6bbBibk9kuRT9nwj9YcDc", "WIY3Unb14PjE3ayNyWd6XWPIVw0Az9uS", "ZZL8YXP6wYj9", "tbuIO4j0iRDkkCNXzrivmX4Au5offJfR"};
    }

    public AnonymousClass2A(C0820Wh wh) {
        super(wh);
        setOnTouchListener(this);
    }

    public AnonymousClass2A(C0820Wh wh, AttributeSet attributeSet) {
        super(wh, attributeSet);
        setOnTouchListener(this);
    }

    public AnonymousClass2A(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        setOnTouchListener(this);
    }

    private int A04() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    private int A05(int i) {
        int i2 = this.A00 - i;
        int A6n = this.A02.A6n(i2);
        int i3 = this.A06;
        if (i2 > i3) {
            return A07(this.A05, A6n);
        }
        if (i2 < (-i3)) {
            return A06(this.A05, A6n);
        }
        return this.A05;
    }

    private int A06(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int A07(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    public void A23(int i, boolean z) {
        if (getAdapter() != null) {
            this.A05 = i;
            if (z) {
                A1X(i);
            } else {
                A1W(i);
            }
        }
    }

    public int getCurrentPosition() {
        return this.A05;
    }

    private int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().A0E();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.A04) {
                A23(A05(rawX), true);
            }
            this.A03 = true;
            this.A04 = false;
            return true;
        }
        if (actionMasked == 0 || actionMasked == 5 || (this.A03 && actionMasked == 2)) {
            this.A00 = rawX;
            String[] strArr = A08;
            if (strArr[5].charAt(14) != strArr[4].charAt(14)) {
                String[] strArr2 = A08;
                strArr2[5] = "MxKeEan5PHYt2nmJnSz3xsZ38eI3mGgL";
                strArr2[4] = "utg9fSYK4sdWKYxBX5KGIJ2pCeKuK2tx";
                if (this.A03) {
                    this.A03 = false;
                }
                this.A04 = true;
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.ES
    public void setLayoutManager(AnonymousClass4F r5) {
        if (r5 instanceof SW) {
            super.setLayoutManager(r5);
            this.A01 = (SW) r5;
            return;
        }
        throw new IllegalArgumentException(A08(0, 50, 58));
    }

    public void setSnapDelegate(ON on) {
        this.A02 = on;
    }
}
