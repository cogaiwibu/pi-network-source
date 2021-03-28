package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;

public class T4 extends AnonymousClass56 implements NativeAdLayoutApi {
    public int A00 = 0;
    public int A01 = 0;
    @Nullable
    public View A02;
    public NativeAdLayout A03;

    public final void A03() {
        C0535Le.A0X(this.A03);
        this.A03.removeView(this.A02);
        this.A02 = null;
    }

    public final void A04(AbstractC0563Mg mg) {
        this.A02 = mg;
        mg.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        C0535Le.A0X(this.A03);
        this.A03.addView(this.A02);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void initialize(NativeAdLayout nativeAdLayout) {
        this.A03 = nativeAdLayout;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (this.A00 <= 0 || this.A03.getMeasuredWidth() <= (i3 = this.A00)) {
            int measuredWidth = this.A03.getMeasuredWidth();
            int i4 = this.A01;
            if (measuredWidth < i4) {
                setMeasuredDimension(i4, this.A03.getMeasuredHeight());
                return;
            }
            return;
        }
        setMeasuredDimension(i3, this.A03.getMeasuredHeight());
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMaxWidth(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMinWidth(int i) {
        this.A01 = i;
    }
}
