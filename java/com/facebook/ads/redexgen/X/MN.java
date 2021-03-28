package com.facebook.ads.redexgen.X;

public class MN extends AbstractRunnableC0510Kc {
    public static String[] A04;
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0532Lb A02;
    public final /* synthetic */ EnumC0638Pe A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"pUIboC8CwdUMtM1tPR8iEtPz8p", "ladzvmq", "gZiIZXhhpFNWaRiPv", "vQtAVDGFp8M", "7j30UYRlUEXcM4Kd2wK", "XchzO9Mtzl1GyvdPdWlZd1J0iwZmFx3H", "VTwPVxpRcW0", "YPnzN72MuP4y3lnuBhqZ0NoSyY"};
    }

    public MN(C0532Lb lb, EnumC0638Pe pe, int i, int i2) {
        this.A02 = lb;
        this.A03 = pe;
        this.A01 = i;
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (this.A03 == EnumC0638Pe.A07) {
            this.A02.A0J(JK.A0m);
            this.A02.A09.A0A().A30();
            this.A02.A0A.A03(C0532Lb.A0C());
        } else if (this.A03 == EnumC0638Pe.A03) {
            this.A02.A0J(JK.A0h);
            this.A02.A03 = true;
            this.A02.A0A.A03(C0532Lb.A0E);
        } else {
            EnumC0638Pe pe = this.A03;
            EnumC0638Pe pe2 = EnumC0638Pe.A06;
            String[] strArr = A04;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[5] = "Wlqb3PCyph61UkVVxo7ng7VZa1hYfmo4";
            strArr2[5] = "Wlqb3PCyph61UkVVxo7ng7VZa1hYfmo4";
            if (pe == pe2) {
                this.A02.A0J(JK.A0g);
                this.A02.A09.A0A().A2s();
                this.A02.A03 = true;
                this.A02.A06.removeCallbacksAndMessages(null);
                AnonymousClass9J r2 = this.A02.A0A;
                int i = this.A01;
                r2.A03(new AnonymousClass7v(i, i));
            } else if (this.A03 == EnumC0638Pe.A0A) {
                this.A02.A0J(JK.A0k);
                this.A02.A09.A0A().A37();
                this.A02.A0A.A03(C0532Lb.A0B());
                this.A02.A06.removeCallbacksAndMessages(null);
                this.A02.A0G();
            } else if (this.A03 == EnumC0638Pe.A05) {
                this.A02.A0J(JK.A0j);
                this.A02.A09.A0A().A2w();
                this.A02.A0A.A03(new C02147t(this.A00));
                this.A02.A06.removeCallbacksAndMessages(null);
            } else if (this.A03 == EnumC0638Pe.A04) {
                this.A02.A0J(JK.A0i);
                this.A02.A09.A0A().A2t();
                this.A02.A0A.A03(C0532Lb.A0I);
                this.A02.A06.removeCallbacksAndMessages(null);
            } else if (this.A03 == EnumC0638Pe.A09) {
                this.A02.A0J(JK.A0g);
                this.A02.A09.A0A().A32();
                this.A02.A03 = true;
                this.A02.A06.removeCallbacksAndMessages(null);
                this.A02.A0A.A03(new AnonymousClass7v(this.A00, this.A01));
            }
        }
    }
}
