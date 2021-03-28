package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import java.util.ArrayList;

public final class MP extends FrameLayout implements AbstractC0616Oi {
    public static String[] A08;
    public static final int A09 = ((int) (C0535Le.A01 * 250.0f));
    public static final int A0A = ((int) (C0535Le.A01 * 350.0f));
    public static final int A0B = ((int) (C0535Le.A01 * 175.0f));
    public static final int A0C = ((int) (C0535Le.A01 * 12.0f));
    public static final int A0D = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0E = ((int) (C0535Le.A01 * 6.0f));
    @Nullable
    public TextView A00;
    @Nullable
    public TextView A01;
    @Nullable
    public TextView A02;
    @Nullable
    public TextView A03;
    public final MediaView A04;
    public final NativeAd A05;
    public final C0617Oj A06;
    public final ArrayList<View> A07 = new ArrayList<>();

    public static void A02() {
        A08 = new String[]{"LrUXeZd5oXG5wJ7", "S6ePTdxfK6c7yhvbHMQjZqIgQsLDz3QO", "YqVXoEdDoNpK3nL0El5", "Exhg7LXIw6HgSAmcccR052cOKtX3WF", "LN", "59F20xOEewuTmZzPatOKMeF6XI6ZvB1j", "IRBrDKvf2o0dBHWjf99N02m12yrR0Bg7", "KZ90h8EmVWfLUNKv0pT"};
    }

    static {
        A02();
    }

    public MP(C0820Wh wh, NativeAd nativeAd, C0485Jb jb, EnumC0486Jc jc, C0587Nf nf, MediaView mediaView, AdOptionsView adOptionsView) {
        super(wh);
        this.A05 = nativeAd;
        this.A04 = mediaView;
        this.A06 = new C0617Oj(wh, this.A05, jb, nf, adOptionsView);
        C0617Oj oj = this.A06;
        int i = A0C;
        oj.setPadding(i, i, i, A0E);
        addView(this.A06, new FrameLayout.LayoutParams(-1, -2));
        if (jc == EnumC0486Jc.A09 || jc == EnumC0486Jc.A0B) {
            A08(jb);
        }
        addView(this.A04, new FrameLayout.LayoutParams(-1, -2));
        if (!(jc == EnumC0486Jc.A0B && this.A05.getAdCreativeType() == NativeAd.AdCreativeType.CAROUSEL)) {
            A07(jb);
            A05(jb);
            A06(jb);
        }
        this.A07.add(nf);
        this.A07.add(mediaView);
    }

    private int A00() {
        int i;
        int i2;
        int i3;
        TextView textView = this.A03;
        int titleHeight = 0;
        if (textView == null || textView.getVisibility() != 0) {
            i = 0;
        } else {
            i = this.A03.getMeasuredHeight();
        }
        TextView textView2 = this.A02;
        if (A08[1].charAt(0) != 'k') {
            String[] strArr = A08;
            strArr[6] = "SrhbzBCrZmwJCsE1GN19GBhRpshhKBl4";
            strArr[5] = "lZXGEU0s5y97LRskCQS4IC0Q6rEMlB8o";
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
            } else {
                i2 = this.A02.getMeasuredHeight();
            }
            TextView textView3 = this.A00;
            if (textView3 == null || textView3.getVisibility() != 0) {
                i3 = 0;
            } else {
                i3 = this.A00.getMeasuredHeight();
            }
            TextView textView4 = this.A01;
            if (A08[1].charAt(0) != 'k') {
                String[] strArr2 = A08;
                strArr2[6] = "nRuc5lutSXPKh9f7kKzdW2kIhLu3nB9m";
                strArr2[5] = "FuxAmHJZMOFMUG38wB3yXnFuBZuRMBRE";
                if (textView4 != null && textView4.getVisibility() == 0) {
                    titleHeight = this.A01.getMeasuredHeight() + A0C + A0D;
                }
                return ((((getMeasuredHeight() - this.A06.getMeasuredHeight()) - i) - i2) - i3) - titleHeight;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    private void A01() {
        TextView textView = this.A03;
        if (textView != null) {
            textView.setLines(1);
        }
        TextView textView2 = this.A02;
        if (textView2 != null) {
            textView2.setLines(1);
        }
        TextView textView3 = this.A00;
        if (textView3 != null) {
            textView3.setLines(1);
        }
    }

    private void A03(int i) {
        int i2;
        int i3;
        MediaView mediaView = this.A04;
        int i4 = 0;
        if (i > A0B) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        C0535Le.A0Q(mediaView, i2);
        TextView textView = this.A03;
        if (i > A0A) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        C0535Le.A0Q(textView, i3);
        TextView textView2 = this.A00;
        if (i <= A09) {
            i4 = 8;
        }
        C0535Le.A0Q(textView2, i4);
    }

    public static void A04(int i, int i2, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null && textView.getVisibility() == 0) {
                int A052 = C0535Le.A05(textView, i2);
                textView.setLines(A052 + 1);
                textView.measure(i, View.MeasureSpec.makeMeasureSpec(textView.getMeasuredHeight() + (textView.getLineHeight() * A052), 1073741824));
                i2 -= textView.getLineHeight() * A052;
            }
        }
    }

    private void A05(C0485Jb jb) {
        if (this.A05.getAdBodyText() != null && !this.A05.getAdBodyText().trim().isEmpty()) {
            this.A00 = new TextView(getContext());
            jb.A06(this.A00);
            this.A00.setText(this.A05.getAdBodyText());
            TextView textView = this.A00;
            int i = A0C;
            textView.setPadding(i, 0, i, 0);
            addView(this.A00, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private void A06(C0485Jb jb) {
        if (this.A05.hasCallToAction()) {
            this.A01 = new TextView(getContext());
            C0535Le.A0N(this.A01);
            jb.A05(this.A01);
            this.A01.setText(this.A05.getAdCallToAction());
            TextView textView = this.A01;
            int i = A0D;
            textView.setPadding(i, i, i, i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i2 = A0D;
            layoutParams.setMargins(i2, 0, i2, 0);
            addView(this.A01, layoutParams);
            this.A07.add(this.A01);
        }
    }

    private void A07(C0485Jb jb) {
        if (this.A05.getAdHeadline() != null && !this.A05.getAdHeadline().trim().isEmpty()) {
            this.A02 = new TextView(getContext());
            jb.A07(this.A02);
            this.A02.setText(this.A05.getAdHeadline());
            TextView textView = this.A02;
            int i = A0C;
            textView.setPadding(i, A0D, i, 0);
            addView(this.A02, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private void A08(C0485Jb jb) {
        if (this.A05.getAdLinkDescription() != null && !this.A05.getAdLinkDescription().trim().isEmpty()) {
            this.A03 = new TextView(getContext());
            jb.A06(this.A03);
            this.A03.setText(this.A05.getAdLinkDescription());
            TextView textView = this.A03;
            int i = A0C;
            textView.setPadding(i, 0, i, A0D);
            addView(this.A03, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0616Oi
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0616Oi
    public ArrayList<View> getViewsForInteraction() {
        return this.A07;
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0617Oj oj = this.A06;
        oj.layout(i, i2, i3, oj.getMeasuredHeight() + i2);
        int measuredHeight = i2 + this.A06.getMeasuredHeight();
        TextView textView = this.A03;
        if (textView != null && textView.getVisibility() == 0) {
            int measuredHeight2 = this.A03.getMeasuredHeight();
            this.A03.layout(i, measuredHeight, i3, measuredHeight + measuredHeight2);
            measuredHeight += measuredHeight2;
        }
        MediaView mediaView = this.A04;
        mediaView.layout(i, measuredHeight, i3, mediaView.getMeasuredHeight() + measuredHeight);
        int measuredHeight3 = measuredHeight + this.A04.getMeasuredHeight();
        TextView textView2 = this.A02;
        if (textView2 != null) {
            textView2.layout(i, measuredHeight3, i3, textView2.getMeasuredHeight() + measuredHeight3);
            measuredHeight3 += this.A02.getMeasuredHeight();
        }
        TextView textView3 = this.A00;
        if (textView3 != null && textView3.getVisibility() == 0) {
            TextView textView4 = this.A00;
            if (A08[1].charAt(0) != 'k') {
                String[] strArr = A08;
                strArr[3] = "gjv6mmFqHT0";
                strArr[3] = "gjv6mmFqHT0";
                textView4.layout(i, measuredHeight3, i3, textView4.getMeasuredHeight() + measuredHeight3);
            } else {
                throw new RuntimeException();
            }
        }
        TextView textView5 = this.A01;
        if (textView5 != null) {
            int measuredHeight4 = i4 - textView5.getMeasuredHeight();
            int i5 = A0C;
            textView5.layout(A0C + i, measuredHeight4 - i5, i3 - i5, i4 - i5);
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3;
        A03(View.MeasureSpec.getSize(i2));
        A01();
        super.onMeasure(i, i2);
        int A002 = A00();
        if (this.A04.getMediaWidth() == 0 || this.A04.getMediaHeight() == 0) {
            i3 = A002;
        } else if (((T3) this.A04.getMediaViewApi()).A0K()) {
            i3 = A002;
        } else {
            i3 = Math.min((int) (((float) this.A04.getMeasuredWidth()) * (((float) this.A04.getMediaHeight()) / ((float) this.A04.getMediaWidth()))), A002);
        }
        this.A04.measure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        if (i3 < A002) {
            A04(i, A002 - i3, this.A02, this.A00, this.A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0616Oi
    public final void unregisterView() {
        this.A05.unregisterView();
    }
}
