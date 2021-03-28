package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class S6 implements LO<Bundle> {
    public static byte[] A04;
    public AnonymousClass22 A00;
    public final View A01;
    public final C0820Wh A02;
    public final List<S7> A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{126, 121, 108, 121, 100, 126, 121, 100, 110, 126, 106, 123, 109, 106, 109};
    }

    public S6(View view, List<AnonymousClass20> list, Bundle bundle, C0820Wh wh) {
        this.A02 = wh;
        this.A01 = view;
        this.A03 = new ArrayList<>(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 15));
        for (int i = 0; i < list.size(); i++) {
            this.A03.add(new S7(list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.A00 = (AnonymousClass22) LI.A00(bundle.getByteArray(A00(0, 10, 28)));
    }

    public S6(View view, List<AnonymousClass20> list, C0820Wh wh) {
        this.A02 = wh;
        this.A01 = view;
        this.A03 = new ArrayList(list.size());
        for (AnonymousClass20 r2 : list) {
            this.A03.add(new S7(r2));
        }
        this.A00 = new AnonymousClass22();
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 28), LI.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A03.size());
        for (S7 s7 : this.A03) {
            arrayList.add(s7.A06());
        }
        bundle.putParcelableArrayList(A00(10, 5, 15), arrayList);
        return bundle;
    }

    public final AnonymousClass22 A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        for (S7 test : this.A03) {
            test.A07();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double viewableRatio, double d) {
        if (d >= 0.0d) {
            this.A00.A05(viewableRatio, d);
        }
        double A002 = (double) C0641Ph.A0E(this.A01, 0, this.A02).A00();
        this.A00.A04(viewableRatio, A002);
        for (S7 s7 : this.A03) {
            s7.A08(viewableRatio, A002);
        }
    }
}
