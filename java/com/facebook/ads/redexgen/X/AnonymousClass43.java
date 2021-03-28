package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.facebook.ads.redexgen.X.AnonymousClass4X;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.43  reason: invalid class name */
public abstract class AnonymousClass43<VH extends AnonymousClass4X> {
    public static byte[] A02;
    public static String[] A03;
    public boolean A00 = false;
    public final AnonymousClass44 A01 = new AnonymousClass44();

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[2].charAt(21) != '7') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "WHsKZN6zyncpMK6d";
            strArr[4] = "wlW4";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 32);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{-48, -44, -98, -63, -16, -29, -33, -14, -29, -44, -25, -29, -11, -54, -50, -104, -57, -26, -70, -31, -26, -36, -50, -31, -35, -17};
    }

    public static void A02() {
        A03 = new String[]{"W324oDAhe3QD27ZyNAxx1dE4409WhTwA", "Ikg10MzvREcGgl38", "tAS262iMJzRr57vvpxPoG7SYxewns3xN", "rCt", "3uu7", "cbDGC8uMMSmc1mSYy17nilWnTwttZfvA", "2T", "U5f6pdP97"};
    }

    public abstract VH A07(ViewGroup viewGroup, int i);

    public abstract int A0E();

    public abstract void A0F(VH vh, int i);

    private final void A03(VH holder, int i, List<Object> list) {
        A0F(holder, i);
    }

    public final int A04(int i) {
        return 0;
    }

    public final long A05(int i) {
        return -1;
    }

    public final VH A06(ViewGroup viewGroup, int i) {
        AnonymousClass2H.A01(A00(0, 13, 94));
        VH A07 = A07(viewGroup, i);
        A07.A00 = i;
        AnonymousClass2H.A00();
        return A07;
    }

    public final void A08() {
        this.A01.A00();
    }

    public final void A09(AnonymousClass45 r2) {
        this.A01.registerObserver(r2);
    }

    public final void A0A(AnonymousClass45 r2) {
        this.A01.unregisterObserver(r2);
    }

    public final void A0B(VH vh, int i) {
        vh.A03 = i;
        if (A0C()) {
            long A05 = A05(i);
            RecyclerView.Adapter<VH>[] adapterArr = A03;
            if (adapterArr[7].length() != adapterArr[6].length()) {
                String[] strArr = A03;
                strArr[7] = "OgtetI94x";
                strArr[6] = "QU";
                vh.A05 = A05;
            }
            throw new RuntimeException<>();
        }
        vh.A0V(1, 519);
        AnonymousClass2H.A01(A00(13, 13, 88));
        A03(vh, i, vh.A0M());
        vh.A0O();
        ViewGroup.LayoutParams layoutParams = vh.A0H.getLayoutParams();
        if (layoutParams instanceof AnonymousClass4G) {
            ((AnonymousClass4G) layoutParams).A01 = true;
        }
        AnonymousClass2H.A00();
        String[] strArr2 = A03;
        if (strArr2[5].charAt(31) == strArr2[0].charAt(31)) {
            String[] strArr3 = A03;
            strArr3[7] = "GQKIQ0ZEK";
            strArr3[6] = "Zf";
            return;
        }
        throw new RuntimeException<>();
    }

    public final boolean A0C() {
        return this.A00;
    }

    public final boolean A0D(VH vh) {
        return false;
    }
}
