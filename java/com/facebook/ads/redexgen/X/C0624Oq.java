package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Oq  reason: case insensitive filesystem */
public final class C0624Oq extends RelativeLayout {
    public static String[] A03;
    @Nullable
    public C01997a A00;
    public WeakReference<AbstractC0623Op> A01;
    public final AbstractC0636Pc A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"Z7YDROQZDOzGgLZ6JRzm0VB6SZj4zDor", "PEDxZ1hmcJv2HtokqPZuboN03zqPqfuu", "ZN3aiXgGzfL", "UoQOzdqMFdmvRVk6jZTbQbhJ01APWmUd", "BWydKlRDXGFiivyHlYlBLR13h8bygoZy", "calSGpe10AH6YV6oPZJsWkhcYoOFDSm8", "CqyCvSup05V", "6oqVw1T1HmkJfSZKyFG8rr7XXeYSScI0"};
    }

    public C0624Oq(C0820Wh wh, AbstractC0636Pc pc) {
        super(wh);
        this.A02 = pc;
        C0535Le.A0M((View) this.A02);
        addView(this.A02.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void A01(K6 k6) {
        addView(k6, new RelativeLayout.LayoutParams(-1, -1));
        this.A00 = (C01997a) k6;
    }

    public final void A02(K6 k6) {
        C0535Le.A0M(k6);
        this.A00 = null;
    }

    public final boolean A03() {
        return this.A02.A7M();
    }

    public final boolean A04(int i) {
        return this.A02.getCurrentPosition() > i;
    }

    public int getCurrentPosition() {
        return this.A02.getCurrentPosition();
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ((View) this.A02).layout(0, 0, getWidth(), getHeight());
        C01997a r2 = this.A00;
        if (r2 != null) {
            r2.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b3, code lost:
        if (r6 > r5) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b9, code lost:
        if (r6 > r5) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ef, code lost:
        if (r5 == Integer.MIN_VALUE) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f6, code lost:
        if (r5 == Integer.MIN_VALUE) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0624Oq.onMeasure(int, int):void");
    }

    public void setViewImplInflationListener(AbstractC0623Op op) {
        this.A01 = new WeakReference<>(op);
    }
}
