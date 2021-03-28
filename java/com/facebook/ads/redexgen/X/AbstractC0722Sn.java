package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Sn  reason: case insensitive filesystem */
public abstract class AbstractC0722Sn extends AnonymousClass4I {
    public static byte[] A03;
    public static String[] A04;
    public ES A00;
    public Scroller A01;
    public final AnonymousClass4K A02 = new C0721Sm(this);

    static {
        A0B();
        A0A();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        byte[] bArr = {-35, 10, -68, 5, 10, 15, 16, -3, 10, -1, 1, -68, 11, 2, -68, -21, 10, -30, 8, 5, 10, 3, -24, 5, 15, 16, 1, 10, 1, 14, -68, -3, 8, 14, 1, -3, 0, 21, -68, 15, 1, 16, -54};
        if (A04[2].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[3] = "Gfsvb5V6ZkZ1EjPhJmDEOg0wCX37AMGK";
        strArr[5] = "BogmwpJuEiSgKohE6B9VLJKkNQC2pxlX";
        A03 = bArr;
    }

    public static void A0B() {
        A04 = new String[]{"WP5CpU5dCfM1vj2iCgRczyLeS833jqA7", "f0t6mABNpir4NiI1IJBR", "VMSqLwjWc3fXvu7D9B7JwatTJSWiKmSt", "2kGOlvpEajHcc9JJ5BV7kSrV8Uhb9VDh", "BGGgbgkg4NpzKA2XjpG6Q8iHB2GG9zH0", "ziOTckvigWpUqNYWulExTvMWDfbzI1Sq", "WkLWBkQ13lLgYVln8HDaQ7gYbGPRUWfj", "hZJ2tRP2pGaevCKAXmW2Fr9GhnOGACBf"};
    }

    public abstract int A0E(AnonymousClass4F v, int i, int i2);

    @Nullable
    public abstract View A0F(AnonymousClass4F v);

    @Nullable
    public abstract int[] A0J(@NonNull AnonymousClass4F v, @NonNull View view);

    @Nullable
    private final AnonymousClass4S A06(AnonymousClass4F r2) {
        return A0G(r2);
    }

    private void A08() {
        this.A00.A1l(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A09() throws IllegalStateException {
        if (this.A00.getOnFlingListener() == null) {
            this.A00.A1k(this.A02);
            this.A00.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException(A07(0, 43, 103));
    }

    private boolean A0C(@NonNull AnonymousClass4F r8, int i, int i2) {
        AnonymousClass4S A06;
        if (!(r8 instanceof AnonymousClass4R) || (A06 = A06(r8)) == null) {
            return false;
        }
        int A0E = A0E(r8, i, i2);
        String[] strArr = A04;
        if (strArr[0].charAt(25) != strArr[7].charAt(25)) {
            String[] strArr2 = A04;
            strArr2[0] = "3QNQgzU1MIdfo8xP0zEWa1SfaSPVi8u7";
            strArr2[7] = "BhxrOivCOMjMD1hwED78TbVHZR3oyoMb";
            if (A0E == -1) {
                return false;
            }
            A06.A0B(A0E);
            r8.A1M(A06);
            return true;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4I
    public final boolean A0D(int i, int i2) {
        AnonymousClass4F layoutManager = this.A00.getLayoutManager();
        if (layoutManager == null || this.A00.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.A00.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && A0C(layoutManager, i, i2)) {
            return true;
        }
        return false;
    }

    @Nullable
    @Deprecated
    public SX A0G(AnonymousClass4F r3) {
        if (!(r3 instanceof AnonymousClass4R)) {
            return null;
        }
        return new E3(this, this.A00.getContext());
    }

    public final void A0H() {
        AnonymousClass4F layoutManager;
        View snapView;
        ES es = this.A00;
        if (es != null && (layoutManager = es.getLayoutManager()) != null && (snapView = A0F(layoutManager)) != null) {
            int[] A0J = A0J(layoutManager, snapView);
            if (A0J[0] != 0 || A0J[1] != 0) {
                this.A00.A1f(A0J[0], A0J[1]);
            }
        }
    }

    public final void A0I(@Nullable ES es) throws IllegalStateException {
        ES es2 = this.A00;
        if (es2 != es) {
            if (es2 != null) {
                A08();
            }
            this.A00 = es;
            if (this.A00 != null) {
                A09();
                this.A01 = new Scroller(this.A00.getContext(), new DecelerateInterpolator());
                A0H();
            }
        }
    }
}
