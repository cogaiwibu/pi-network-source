package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* renamed from: com.facebook.ads.redexgen.X.7a  reason: invalid class name and case insensitive filesystem */
public final class C01997a extends K6 {
    public static String[] A04;
    public final ImageView A00;
    public final C0820Wh A01;
    public final AnonymousClass9K<AnonymousClass7v> A02 = new HO(this);
    public final AnonymousClass9K<C0501Jt> A03 = new HP(this);

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"t7nWMgaAgPrF08nCpsue0KJ0bXYxildh", "6KdtKMmtzfHYFwbGu3Z1Ir1zVfPvm0mZ", "4a3tRJ2Sc2HJRD7iGLBoGFg5dIAFXATk", "UpueiF5Mlf4qFrRwKkN0oaj1wZcm2sVE", "2I2trXzlQyfCpDc0SWIB9I9l1xDqUCt2", "pVCp6f81Bxfp7pGgyLuO3QWY2ZOI1Rz7", "JWrnXr9CYPwxDsxVPLOhiB9OxQPOAEin", "O346HS8RGmqKBjl58VTWQBGWIRLrpgc9"};
    }

    public C01997a(C0820Wh wh) {
        super(wh);
        this.A01 = wh;
        this.A00 = new ImageView(wh);
        this.A00.setScaleType(ImageView.ScaleType.FIT_CENTER);
        C0535Le.A0P(this.A00, ViewCompat.MEASURED_STATE_MASK);
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A03, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A02, this.A03);
        }
        super.A08();
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.A00.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setImage(@Nullable String str) {
        setImage(str, null);
    }

    public void setImage(@Nullable String str, @Nullable NT nt) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        AsyncTaskC0831Ws A05 = new AsyncTaskC0831Ws(this.A00, this.A01).A05();
        if (nt != null) {
            A05.A07(nt);
        }
        A05.A08(str);
        String[] strArr = A04;
        if (strArr[0].charAt(21) != strArr[6].charAt(21)) {
            String[] strArr2 = A04;
            strArr2[0] = "kA5c9xFlh2VnhKEqDnwhhyQ6vC8xp51l";
            strArr2[6] = "v6NK46wFN1tyoiPUrV3jpTAezqYTXUDI";
            return;
        }
        throw new RuntimeException();
    }
}
