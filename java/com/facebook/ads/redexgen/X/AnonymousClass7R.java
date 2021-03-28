package com.facebook.ads.redexgen.X;

import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.7R  reason: invalid class name */
public final class AnonymousClass7R extends K6 {
    public static String[] A01;
    public final AnonymousClass9K<JJ> A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"4h8fvEACfo1aNbNL", "KiY64Fil", "L", "TPcthrsJz3ToBiwYAQ4xewU", "cWfSExW1cmjdZd3Ek8eXqqhjC3VFU", "NINEnIjXlG8iO8hrf55I2V2lHb1VufX", "CO", "8GF4DU4RrtKBXlYvExHV9F2Nh74lSozH"};
    }

    public AnonymousClass7R(C0820Wh wh) {
        this(wh, null);
    }

    public AnonymousClass7R(C0820Wh wh, AttributeSet attributeSet) {
        this(wh, attributeSet, 0);
    }

    public AnonymousClass7R(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        this.A00 = new H5(this);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(progressBar, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A07() {
        super.A07();
        setVisibility(0);
        if (getVideoView() != null) {
            C0532Lb videoView = getVideoView();
            String[] strArr = A01;
            if (strArr[2].length() != strArr[5].length()) {
                String[] strArr2 = A01;
                strArr2[7] = "LLc1CvKTLQ71W60sfu5S1t2gX7MmeGtJ";
                strArr2[7] = "LLc1CvKTLQ71W60sfu5S1t2gX7MmeGtJ";
                videoView.getEventBus().A06(this.A00);
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A08() {
        if (getVideoView() != null) {
            AnonymousClass9J<AnonymousClass9K, AnonymousClass9I> eventBus = getVideoView().getEventBus();
            AnonymousClass9K<JJ> r3 = this.A00;
            String[] strArr = A01;
            if (strArr[2].length() != strArr[5].length()) {
                String[] strArr2 = A01;
                strArr2[3] = "4Zu3PRCBzV1MZjgNBq7KORh";
                strArr2[1] = "VnRIjxfO";
                eventBus.A07(r3);
            } else {
                throw new RuntimeException();
            }
        }
        setVisibility(8);
        super.A08();
    }
}
