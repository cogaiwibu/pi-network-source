package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.Al  reason: case insensitive filesystem */
public final class C0278Al {
    public static String[] A06;
    public AbstractC0276Aj A00 = AbstractC0276Aj.A01;
    public C0279Am A01;
    public C0279Am A02;
    public boolean A03;
    public final C0274Ah A04 = new C0274Ah();
    public final ArrayList<C0279Am> A05 = new ArrayList<>();

    static {
        A03();
    }

    public static void A03() {
        A06 = new String[]{"KiEP2P9b6TLdkEYwaN5ndNVtk9NQ5Y9p", "yrQkoPMIPCp0FUw5bDslSTdDJuyK", "OV0qCkDU4pR0s48LAW0LoXOWDo4ZunO9", "CNzCLbPvty9jTQMUswZxpqZWQtb7JEv9", "Vf", "ol3MR5ayifXszMqJK7WjfrE4Lr8bJhi8", "Hh8EscwfVF04VFT3j4sJSJqD2SmetI3K", "DN3PdRai96zSFxDytd4qNigxYecPuw8S"};
    }

    private C0279Am A00(C0279Am am, AbstractC0276Aj aj) {
        int A052;
        if (aj.A0F() || this.A00.A0F() || (A052 = aj.A05(this.A00.A0B(am.A01.A02, this.A04, true).A03)) == -1) {
            return am;
        }
        return new C0279Am(aj.A0A(A052, this.A04).A00, am.A01.A01(A052));
    }

    private void A02() {
        if (!this.A05.isEmpty()) {
            this.A01 = this.A05.get(0);
        }
    }

    @Nullable
    public final C0279Am A04() {
        return this.A01;
    }

    @Nullable
    public final C0279Am A05() {
        if (this.A05.isEmpty()) {
            return null;
        }
        ArrayList<C0279Am> arrayList = this.A05;
        return arrayList.get(arrayList.size() - 1);
    }

    @Nullable
    public final C0279Am A06() {
        if (this.A05.isEmpty() || this.A00.A0F() || this.A03) {
            return null;
        }
        return this.A05.get(0);
    }

    @Nullable
    public final C0279Am A07() {
        return this.A02;
    }

    @Nullable
    public final FG A08(int timelinePeriodCount) {
        FG fg = null;
        AbstractC0276Aj aj = this.A00;
        if (aj != null) {
            int periodIndex = aj.A01();
            for (int i = 0; i < this.A05.size(); i++) {
                C0279Am am = this.A05.get(i);
                int i2 = am.A01.A02;
                if (i2 < periodIndex && this.A00.A0A(i2, this.A04).A00 == timelinePeriodCount) {
                    if (fg != null) {
                        return null;
                    }
                    fg = am.A01;
                }
            }
        }
        return fg;
    }

    public final void A09() {
        this.A03 = false;
        A02();
    }

    public final void A0A() {
        this.A03 = true;
    }

    public final void A0B(int i) {
        A02();
    }

    public final void A0C(int i, FG fg) {
        this.A05.add(new C0279Am(i, fg));
        if (this.A05.size() == 1) {
            boolean A0F = this.A00.A0F();
            if (A06[0].charAt(21) != 'U') {
                String[] strArr = A06;
                strArr[0] = "SFS5Xb2c2LrmqtbhPrHYALinOi1MehvJ";
                strArr[0] = "SFS5Xb2c2LrmqtbhPrHYALinOi1MehvJ";
                if (!A0F) {
                    A02();
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    public final void A0D(int i, FG fg) {
        C0279Am am;
        C0279Am am2 = new C0279Am(i, fg);
        this.A05.remove(am2);
        if (am2.equals(this.A02)) {
            if (this.A05.isEmpty()) {
                am = null;
            } else {
                am = this.A05.get(0);
            }
            this.A02 = am;
        }
    }

    public final void A0E(int i, FG fg) {
        this.A02 = new C0279Am(i, fg);
    }

    public final void A0F(AbstractC0276Aj aj) {
        for (int i = 0; i < this.A05.size(); i++) {
            ArrayList<C0279Am> arrayList = this.A05;
            arrayList.set(i, A00(arrayList.get(i), aj));
        }
        C0279Am am = this.A02;
        if (A06[0].charAt(21) != 'U') {
            String[] strArr = A06;
            strArr[1] = "OE27bQwCbSc4SHZoCTNTYydrCDTv";
            strArr[1] = "OE27bQwCbSc4SHZoCTNTYydrCDTv";
            if (am != null) {
                this.A02 = A00(am, aj);
            }
            this.A00 = aj;
            A02();
            return;
        }
        throw new RuntimeException();
    }

    public final boolean A0G() {
        return this.A03;
    }
}
