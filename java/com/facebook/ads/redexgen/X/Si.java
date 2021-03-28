package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.common.statfs.StatFsHelper;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;

public abstract class Si extends AbstractC0596No {
    public static byte[] A06;
    public static String[] A07;
    public static final int A08 = ((int) (C0535Le.A01 * 4.0f));
    public static final int A09 = AnonymousClass2G.A01(-1, 77);
    public static final int A0A = AnonymousClass2G.A01(A09, 90);
    public static final int A0B = ((int) (C0535Le.A01 * 48.0f));
    public static final int A0C = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0D = ((int) (C0535Le.A01 * 12.0f));
    public static final int A0E = ((int) (C0535Le.A01 * 44.0f));
    public static final int A0F = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0G = ((int) (C0535Le.A01 * 26.0f));
    public static final int A0H = ((int) (C0535Le.A01 * 12.0f));
    public C0442Hi A00;
    @Nullable
    public C0419Gl A01;
    public C0414Gg A02;
    public final AnonymousClass16 A03;
    public final AnonymousClass19 A04 = this.A03.A0M();
    public final NX A05;

    public static String A0K(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(copyOfRange);
    }

    public static void A0L() {
        A06 = new byte[]{9, 5, 7, 68, 12, 11, 9, 15, 8, 5, 5, 1, 68, 11, 14, 25, 68, 3, 4, 30, 15, 24, 25, 30, 3, 30, 3, 11, 6, 68, 9, 6, 3, 9, 1, 15, 14, 92, 75, 89, 79, 92, 74, 75, 74, 113, 88, 71, 74, 75, 65};
    }

    public static void A0M() {
        A07 = new String[]{"1qM0UqBuKeNFs4931PZdKXfB5ZchECK5", "3ZSmcCEAG5Dz0dWrJNlp2MNszP7YT25A", "Vrvau7r1HMpQKQXhvyVkTfJZAsfHOW4A", "oVRoE2FdK0le1s2SfNIozg00Kc9sH4MP", "npYoVlwUwM4clRwIxvjz9nauDkw8jySV", "7Yuh663Y", "kkRlGGIMUj7iwn7pYEfT9Vq54HRzcbQk", "UynwTjbvMY6JmtelA"};
    }

    static {
        A0M();
        A0L();
    }

    public Si(C0600Ns ns, boolean z) {
        super(ns, z);
        this.A03 = ns.A04();
        this.A05 = A0J(ns);
        M1 A082 = ns.A08();
        if (A082 != null) {
            A082.setLayoutParams(new RelativeLayout.LayoutParams(-1, A082.getToolbarHeight()));
            A082.setPageDetailsVisible(false);
        }
    }

    private NX A0J(C0600Ns ns) {
        String A0K;
        NX wj;
        boolean z;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (ns.A04().A0T().equals(A0K(37, 14, 56))) {
            A0K = EnumC0628Ou.A04.A02();
        } else if (A07[3].charAt(14) != '2') {
            throw new RuntimeException();
        } else {
            String[] strArr = A07;
            strArr[5] = "WUaGuSp4tuIpD6iTfwLrbbBI";
            strArr[5] = "WUaGuSp4tuIpD6iTfwLrbbBI";
            A0K = A0K(0, 37, 124);
        }
        if (J8.A1M(ns.A05())) {
            wj = new C0905Zs(ns.A05(), A0B, getColors(), A0K, ns.A06(), ns.A09(), ns.A0B(), ns.A07());
            layoutParams.setMargins(AbstractC0596No.A09, 0, AbstractC0596No.A09, AbstractC0596No.A09);
        } else {
            C0820Wh A052 = ns.A05();
            int i = A0B;
            if (this.A04.A0F().A00() == AnonymousClass1E.A05) {
                z = true;
            } else {
                z = false;
            }
            wj = new C0822Wj(A052, i, z, getColors(), A0K, ns.A06(), ns.A09(), ns.A0B(), ns.A07());
            this.A02 = new C0414Gg(wj, StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, 100, 0);
        }
        C0535Le.A0N(wj);
        wj.A0D(ns.A00());
        addView(wj, layoutParams);
        return wj;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public void A0b(AnonymousClass19 r8, String str, double d, @Nullable Bundle bundle) {
        super.A0b(r8, str, d, bundle);
        this.A05.setInfo(r8.A0F(), r8.A0G(), str, this.A03.A0O().A01(), null);
    }

    public final int A0e(@Nullable M1 m1) {
        return m1 == null ? M1.A00 : m1.getToolbarHeight();
    }

    public void A0f() {
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null) {
            this.A00 = new C0442Hi(true);
            C0419Gl gl = this.A01;
            if (gl != null) {
                C0442Hi hi = this.A00;
                if (A07[0].charAt(30) != 'l') {
                    String[] strArr = A07;
                    strArr[7] = "KTvg88bTO6HmKn15GgbH1";
                    strArr[7] = "KTvg88bTO6HmKn15GgbH1";
                    hi.A0J(gl);
                } else {
                    throw new RuntimeException();
                }
            }
            AnonymousClass1H A012 = this.A03.A0L().A01();
            this.A00.A0J(new C0415Gh(getAdDetailsView().getCTAButton(), 300, -1, A012.A09(true)));
            this.A00.A0J(new C0420Gm(getAdDetailsView().getCTAButton(), 300, C0535Le.A09(A09, A0A, A08), C0535Le.A06(A012.A08(true), A08)));
            this.A00.A0J(new C0416Gi(expandableLayout, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, false));
            this.A00.A0I(IronSourceConstants.IS_AUCTION_FAILED);
        }
    }

    public AnonymousClass16 getAdDataBundle() {
        return this.A03;
    }

    public C0414Gg getAdDetailsAnimation() {
        return this.A02;
    }

    public NX getAdDetailsView() {
        return this.A05;
    }

    public AnonymousClass19 getAdInfo() {
        return this.A04;
    }

    public C0442Hi getAnimationPlugin() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A0D(configuration.orientation);
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null && z) {
            C0419Gl gl = this.A01;
            if (A07[2].charAt(30) != '4') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
            strArr[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
            if (gl == null) {
                this.A01 = new C0419Gl(expandableLayout, 300, expandableLayout.getHeight(), 0);
                this.A00.A0J(this.A01);
                this.A00.A0H();
            }
        }
    }
}
