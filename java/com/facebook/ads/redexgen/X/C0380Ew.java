package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ew  reason: case insensitive filesystem */
public final class C0380Ew extends RP {
    public static byte[] A02;
    public final C0820Wh A00;
    public final C0485Jb A01;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-33, -35, -24, -24, -37, -16, -21, -37, -35, -33, -16, -27, -21, -22, 3, 0, -4, -1, 7, 4, 9, 0, -61, -64, -59, -62, -74, -69, -68, -54, -70, -55, -64, -57, -53, -64, -58, -59};
    }

    public C0380Ew(C0820Wh wh, AnonymousClass1U r2, List<C1007bZ> list, @Nullable C0485Jb jb) {
        super(r2, list, wh);
        this.A00 = wh;
        this.A01 = jb == null ? new C0485Jb() : jb;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0895Zf A07(ViewGroup viewGroup, int i) {
        return new C0895Zf(new M8(this.A00, this.A01));
    }

    @Override // com.facebook.ads.redexgen.X.RP
    /* renamed from: A0I */
    public final void A0F(C0895Zf zf, int i) {
        super.A0F(zf, i);
        M8 m8 = (M8) zf.A0m();
        A0G(m8.getImageCardView(), i);
        m8.setTitle(((RP) this).A01.get(i).A1B(A02(14, 8, 98)));
        m8.setSubtitle(((RP) this).A01.get(i).A1B(A02(22, 16, 30)));
        m8.setButtonText(((RP) this).A01.get(i).A1B(A02(0, 14, 67)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(m8);
        ((RP) this).A01.get(i).A1I(m8, m8, arrayList);
    }
}
