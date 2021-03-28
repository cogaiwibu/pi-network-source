package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.1U  reason: invalid class name */
public final class AnonymousClass1U extends AnonymousClass2A implements ON {
    public static String[] A07;
    public int A00 = 0;
    public int A01 = 0;
    public int A02 = -1;
    public int A03 = -1;
    public MB A04;
    public boolean A05 = false;
    public final C02659x A06;

    static {
        A02();
    }

    public static void A02() {
        A07 = new String[]{"T7MK6mm4Fzbg8PTMnM4kcHpb21LLpIaw", "PTQtUxKdjysMmbj8hCZsGKEwd1IRWqqZ", "Zw8mt4VncD", "79VYCrnrWW", "2MnAMBnkkiKtyd2cP7mHhabJycDYuMiE", "jaMauIT7sdi", "OgIH7ZaBRtH9hoDgrnw", "xZmsCngT77DU5lblEiekqTVKPqNdsast"};
    }

    public AnonymousClass1U(C0820Wh wh) {
        super(wh);
        this.A06 = new C02659x(wh, new OK(), new OJ());
        A01();
    }

    public AnonymousClass1U(C0820Wh wh, AttributeSet attributeSet) {
        super(wh, attributeSet);
        this.A06 = new C02659x(wh, new OK(), new OJ());
        A01();
    }

    public AnonymousClass1U(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        this.A06 = new C02659x(wh, new OK(), new OJ());
        A01();
    }

    private int A00(int availableWidth) {
        int numFullItems = this.A00 * 2;
        int itemSize = (getMeasuredWidth() - getPaddingLeft()) - numFullItems;
        int A0E = getAdapter().A0E();
        int i = 0;
        int numItems = Integer.MAX_VALUE;
        while (numItems > availableWidth) {
            i++;
            if (i >= A0E) {
                return availableWidth;
            }
            numItems = (int) (((float) (itemSize - (i * numFullItems))) / (((float) i) + 0.333f));
        }
        return numItems;
    }

    private void A01() {
        this.A06.A2F(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        C0535Le.A0N(this);
    }

    private void A03(int i, int i2) {
        if (i != this.A03 || i2 != this.A02) {
            this.A03 = i;
            if (A07[1].charAt(11) != 'q') {
                String[] strArr = A07;
                strArr[6] = "hNBaptvkpj";
                strArr[6] = "hNBaptvkpj";
                this.A02 = i2;
                if (this.A04 != null) {
                    throw null;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2A
    public final void A23(int i, boolean z) {
        super.A23(i, z);
        A03(i, 0);
    }

    @Override // com.facebook.ads.redexgen.X.ON
    public final int A6n(int i) {
        int abs = Math.abs(i);
        if (abs <= ((AnonymousClass2A) this).A06) {
            return 0;
        }
        int i2 = this.A01;
        if (i2 == 0) {
            return 1;
        }
        return 1 + (abs / i2);
    }

    public int getChildSpacing() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.ES
    public final void onMeasure(int i, int itemSize) {
        int round;
        int A002;
        super.onMeasure(i, itemSize);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.A05) {
            round = (((int) C0535Le.A01) * J8.A0C(getContext())) + paddingTop;
        } else {
            round = Math.round(((float) getMeasuredWidth()) / 1.91f);
        }
        int mode = View.MeasureSpec.getMode(itemSize);
        if (mode == Integer.MIN_VALUE) {
            round = Math.min(View.MeasureSpec.getSize(itemSize), round);
        } else if (mode == 1073741824) {
            round = View.MeasureSpec.getSize(itemSize);
        }
        int i2 = round - paddingTop;
        if (this.A05) {
            A002 = Math.min(M8.A09, i2);
        } else {
            A002 = A00(i2);
        }
        setMeasuredDimension(getMeasuredWidth(), A002 + paddingTop);
        if (!this.A05) {
            setChildWidth((this.A00 * 2) + A002);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ES
    public void setAdapter(@Nullable AnonymousClass43 r3) {
        int hashCode;
        C02659x r1 = this.A06;
        if (r3 == null) {
            hashCode = -1;
        } else {
            hashCode = r3.hashCode();
        }
        r1.A2M(hashCode);
        super.setAdapter(r3);
    }

    public void setChildSpacing(int i) {
        this.A00 = i;
    }

    public void setChildWidth(int i) {
        this.A01 = i;
        int measuredWidth = getMeasuredWidth();
        this.A06.A2N((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.A01) / 2);
        this.A06.A2L(((double) this.A01) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i) {
        A23(i, false);
    }

    public void setOnPageChangedListener(MB mb) {
        this.A04 = mb;
    }

    public void setShowTextInCarousel(boolean z) {
        this.A05 = z;
    }
}
