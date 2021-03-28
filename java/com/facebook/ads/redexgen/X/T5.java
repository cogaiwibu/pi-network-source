package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import java.util.ArrayList;
import java.util.List;

public class T5 extends AbstractC00782f {
    public static String[] A02;
    public List<NativeAd> A00 = new ArrayList();
    public final /* synthetic */ AnonymousClass5E A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"f2MNSWDlL1YMuTPGOAjONPZtO", "cmMTh0pUaJ1RDNo0mFNR3IJYAK2Mf6gB", "4dFqjoT4qnH4w96CQtkjoCAuJyqtgp11", "6XB3g70NG5Gd02gyy8Ab40YcxuzvQEqb", "wwGHlt0jZwPrQfekoFOvLm8zPwbBrmxC", "1Rqxvwj8Vs8GuK5", "NKSqZWGd9qA279w", "7JvmemziLS26U2JKZlqSRSAl5nA0imSt"};
    }

    public T5(AnonymousClass5E r2) {
        this.A01 = r2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00782f
    public final int A05() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00782f
    public final int A06(Object obj) {
        int indexOf = this.A00.indexOf(obj);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00782f
    public final Object A08(ViewGroup viewGroup, int i) {
        View render;
        if (this.A01.A01 != null) {
            NativeAdScrollView.AdViewProvider adViewProvider = this.A01.A01;
            List<NativeAd> list = this.A00;
            String[] strArr = A02;
            if (strArr[7].charAt(19) != strArr[4].charAt(19)) {
                String[] strArr2 = A02;
                strArr2[2] = "d9x9bMDlXKa90r8XaToMTFuUxNqAoP43";
                strArr2[2] = "d9x9bMDlXKa90r8XaToMTFuUxNqAoP43";
                render = adViewProvider.createView(list.get(i), i);
            } else {
                throw new RuntimeException();
            }
        } else if (this.A01.A02 != null) {
            render = NativeAdView.render(this.A01.A06, this.A00.get(i), this.A01.A02, this.A01.A03);
        } else {
            render = NativeAdView.render(this.A01.A06, this.A00.get(i), this.A01.A03);
        }
        viewGroup.addView(render);
        return render;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00782f
    public final void A0B(ViewGroup viewGroup, int i, Object obj) {
        if (i < this.A00.size()) {
            if (this.A01.A01 != null) {
                this.A01.A01.destroyView(this.A00.get(i), (View) obj);
            } else {
                List<NativeAd> list = this.A00;
                if (A02[0].length() != 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[0] = "BErMlyrXrYPfhoDWoAGZwiXdk";
                strArr[0] = "BErMlyrXrYPfhoDWoAGZwiXdk";
                list.get(i).unregisterView();
            }
        }
        viewGroup.removeView((View) obj);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00782f
    public final boolean A0C(View view, Object obj) {
        return view == obj;
    }

    public final void A0D() {
        this.A00.clear();
        int min = Math.min(this.A01.A00, this.A01.A04.getUniqueNativeAdCount());
        for (int i = 0; i < min; i++) {
            NativeAd nextNativeAd = this.A01.A04.nextNativeAd();
            C1007bZ.A0J(nextNativeAd.getInternalNativeAd()).A1S(true);
            this.A00.add(nextNativeAd);
        }
        A09();
    }
}
