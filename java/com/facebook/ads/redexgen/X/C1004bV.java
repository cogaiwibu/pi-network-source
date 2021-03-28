package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;

/* renamed from: com.facebook.ads.redexgen.X.bV  reason: case insensitive filesystem */
public class C1004bV extends AbstractC0640Pg {
    public static String[] A04;
    public final /* synthetic */ View A00;
    public final /* synthetic */ RG A01;
    public final /* synthetic */ C1007bZ A02;
    public final /* synthetic */ boolean A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"GAoEIcB27NxBQq2JilxmgvZ", "N3uA7bVXcBxYB", "KVc1", "Ty0ubyi0O", "aKccOd3zXPku8XZmrzh", "TnCBFIxn", "RWUalmqogpnzugTp0dpef0CjO7Qk", "Qg3VhAoh"};
    }

    public C1004bV(C1007bZ bZVar, View view, boolean z, RG rg) {
        this.A02 = bZVar;
        this.A00 = view;
        this.A03 = z;
        this.A01 = rg;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A02() {
        this.A02.A0a.A06();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A03() {
        this.A02.A0a.A0B();
    }

    /* JADX INFO: Multiple debug info for r4v0 'this'  com.facebook.ads.redexgen.X.bV: [D('iv' android.widget.ImageView), D('videoView' android.view.View)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A04() {
        this.A02.A0a.A0C();
        if (J8.A1C(this.A02.A0x())) {
            View view = this.A00;
            if (view instanceof AdNativeComponentView) {
                View adContentsView = ((AdNativeComponentView) view).getAdContentsView();
                if ((adContentsView instanceof C0624Oq) && !((C0624Oq) adContentsView).A04(1)) {
                    this.A02.A0N.A0V();
                    this.A02.A0a.A08();
                    return;
                }
            }
        }
        if (J8.A1D(this.A02.A0x())) {
            View view2 = this.A00;
            if (view2 instanceof AdNativeComponentView) {
                View adContentsView2 = ((AdNativeComponentView) view2).getAdContentsView();
                if ((adContentsView2 instanceof C0624Oq) && !((C0624Oq) adContentsView2).A03()) {
                    this.A02.A0N.A0V();
                    this.A02.A0a.A09();
                    return;
                }
            }
        }
        if (this.A03) {
            ImageView imageView = (ImageView) this.A00;
            Drawable loadedNativeBannerIconDrawable = this.A02.A01;
            if (loadedNativeBannerIconDrawable != null) {
                C1007bZ.A0Z(loadedNativeBannerIconDrawable, imageView);
            } else {
                this.A02.A0N.A0V();
                this.A02.A0a.A07();
                return;
            }
        }
        this.A02.A0a.A0D(this.A02.A0Y, this.A01.A0R());
        this.A02.A0N.A0X();
        if (!(this.A02.A0R == null || this.A02.A0R.get() == null)) {
            ((AbstractC0640Pg) this.A02.A0R.get()).A04();
        }
        boolean A08 = this.A02.A0b.A08();
        String[] strArr = A04;
        if (strArr[7].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "ObY5yVnvL";
        strArr2[6] = "nKkzkW33vKK1X7mwQY6aSKGZ9X8E";
        if (!A08) {
            this.A02.A0b.A06();
            this.A02.A0a.A05();
            if (this.A02.A08 != null && this.A02.A03 != null) {
                View view3 = this.A02.A05;
                String[] strArr3 = A04;
                if (strArr3[7].length() != strArr3[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A04;
                strArr4[1] = "Gfe1v0LlPkpmg";
                strArr4[1] = "Gfe1v0LlPkpmg";
                if (view3 != null) {
                    this.A02.A08.A09(this.A02.A03);
                    this.A02.A08.A08(this.A02.A05);
                    this.A02.A08.A0C(this.A02.A0H);
                    this.A02.A08.A0F(this.A02.A0S);
                    this.A02.A08.A0J(this.A02.A0V);
                    this.A02.A08.A0I(this.A02.A0U);
                    this.A02.A08.A0G(this.A02.A0m());
                    this.A02.A08.A0A(this.A02.A07);
                    this.A02.A08.A0H(this.A02.A0T);
                    this.A02.A08.A0B(C0564Mh.A00(this.A02.A06));
                    this.A02.A08.A0D(this.A02.A0O);
                    this.A02.A08.A0K(this.A03);
                    this.A02.A08.A03();
                    return;
                }
                return;
            }
            return;
        }
        this.A02.A0a.A04();
    }
}
