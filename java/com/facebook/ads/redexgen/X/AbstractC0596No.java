package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.No  reason: case insensitive filesystem */
public abstract class AbstractC0596No extends RelativeLayout {
    public static byte[] A08;
    public static final int A09 = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0A = ((int) (C0535Le.A01 * 28.0f));
    public AnonymousClass1H A00;
    public boolean A01 = false;
    public boolean A02;
    public final C0820Wh A03;
    public final JE A04;
    public final View$OnClickListenerC0827Wo A05;
    public final C0593Nl A06;
    public final C0600Ns A07;

    public static String A0I(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 9);
        }
        return new String(copyOfRange);
    }

    public static void A0J() {
        A08 = new byte[]{81, 93, 95, 28, 84, 83, 81, 87, 80, 93, 93, 89, 28, 83, 86, 65, 28, 91, 92, 70, 87, 64, 65, 70, 91, 70, 91, 83, 94, 28, 81, 94, 91, 81, 89, 87, 86};
    }

    public abstract boolean A0c();

    static {
        A0J();
    }

    public AbstractC0596No(C0600Ns ns, boolean z) {
        super(ns.A05());
        AnonymousClass1H A002;
        this.A07 = ns;
        this.A03 = ns.A05();
        this.A04 = ns.A06();
        if (ns.A00() == 1) {
            A002 = ns.A04().A0L().A01();
        } else {
            A002 = ns.A04().A0L().A00();
        }
        this.A00 = A002;
        this.A02 = z;
        this.A05 = new View$OnClickListenerC0827Wo(ns.A05(), A0I(0, 37, 59), this.A00, ns.A06(), ns.A09(), ns.A0B(), ns.A07());
        this.A05.setRoundedCornersEnabled(A0N());
        this.A05.setViewShowsOverMedia(A0M());
        C0535Le.A0J(1001, this.A05);
        this.A06 = new C0593Nl(this.A03, this.A00, this.A02, A0O(), A0P());
        C0535Le.A0N(this.A06);
        if (J8.A1L(this.A03)) {
            this.A06.setDescriptionVisibility(8);
        }
    }

    public void A0K(AnonymousClass7v r2) {
        this.A01 = true;
    }

    public void A0L(C02137s r1) {
    }

    public boolean A0M() {
        return true;
    }

    public boolean A0N() {
        return true;
    }

    public boolean A0O() {
        return true;
    }

    public boolean A0P() {
        return true;
    }

    public void A0W() {
    }

    public void A0X() {
    }

    public void A0Y() {
    }

    public void A0Z() {
    }

    public void A0a() {
    }

    public void A0b(AnonymousClass19 r10, String str, double d, @Nullable Bundle bundle) {
        boolean z;
        C0593Nl nl = this.A06;
        String A052 = r10.A0F().A05();
        String A012 = r10.A0F().A01();
        if (A0c() || d <= 0.0d || d >= 1.0d) {
            z = false;
        } else {
            z = true;
        }
        nl.A02(A052, A012, null, false, z);
        this.A05.setCta(r10.A0G(), str, new HashMap());
    }

    public boolean A0d(boolean z) {
        return false;
    }

    public C0820Wh getAdContextWrapper() {
        return this.A03;
    }

    public JE getAdEventManager() {
        return this.A04;
    }

    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    public AnonymousClass1H getColors() {
        return this.A00;
    }

    public View$OnClickListenerC0827Wo getCtaButton() {
        return this.A05;
    }

    public C0593Nl getTitleDescContainer() {
        return this.A06;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AnonymousClass1H A002;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            A002 = this.A07.A04().A0L().A01();
        } else {
            A002 = this.A07.A04().A0L().A00();
        }
        this.A00 = A002;
        this.A05.setViewShowsOverMedia(A0M());
        this.A05.setUpButtonColors(this.A00);
        this.A06.A01(this.A00, this.A02);
    }
}
