package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;

public final class N4 extends ViewGroup {
    public static final int A01 = ((int) (C0535Le.A01 * 8.0f));
    public int A00;

    public N4(C0820Wh wh) {
        super(wh);
        setMotionEventSplittingEnabled(false);
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childHeight = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (paddingLeft + measuredWidth > childHeight) {
                paddingLeft = getPaddingLeft();
                paddingTop += this.A00;
            }
            childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
            paddingLeft += A01 + measuredWidth;
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = 0;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom(), Integer.MIN_VALUE);
        if (getChildCount() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View child = getChildAt(i6);
            child.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = child.getMeasuredWidth();
            i5 = Math.max(i5, child.getMeasuredHeight() + A01);
            if (paddingLeft + measuredWidth > i4) {
                i3++;
                paddingLeft = getPaddingLeft();
            }
            paddingLeft += A01 + measuredWidth;
        }
        this.A00 = i5;
        setMeasuredDimension(i4, (this.A00 * i3) + A01);
    }
}
