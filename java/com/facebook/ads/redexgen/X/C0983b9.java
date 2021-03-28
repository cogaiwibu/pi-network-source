package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.b9  reason: case insensitive filesystem */
public class C0983b9 extends AbstractRunnableC0510Kc {
    public static String[] A01;
    public final /* synthetic */ C0985bB A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Ghau2wrk1frvp21ETj6mp24XqInrZhWz", "17fIRlTyn5cqQeNpKhzMID", "pR32sk291HY6M3I9Rqv7DOtrmJFLMHGG", "lklFRXjqHO02dLIfiJk5MunT6DW2lX4u", "pu6rG6tzkOYAls8kWhwJFGkhlkg8qDKn", "lnKlSHHeiiV2wTMqAgm3Jfjv4MIuVQTY", "NrilDOC5Woxhobx5Zl8i48KFnKR1bBLL", "sE8NFlpROkCeKIAQdfQPoEsulpgCWNDW"};
    }

    public C0983b9(C0985bB bBVar) {
        this.A00 = bBVar;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        C0985bB.A00(this.A00);
        if (this.A00.A01 > 0) {
            try {
                Thread.sleep(this.A00.A01);
            } catch (InterruptedException unused) {
            }
        }
        this.A00.A0B();
        String[] strArr = A01;
        if (strArr[5].charAt(14) != strArr[6].charAt(14)) {
            String[] strArr2 = A01;
            strArr2[5] = "LjJXLz5e9h3DI08dt7Kr5SwInwXqLWiO";
            strArr2[6] = "Pc0bl4Jkvuydlkjlb12SvYG2JTb7UQAm";
            return;
        }
        throw new RuntimeException();
    }
}
