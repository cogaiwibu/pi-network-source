package com.facebook.ads.redexgen.X;

public class W1 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ WE A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"1jYE18OinQfv5WLTq2cVBe585KmN", "X325BmovX2W2cAXv5JjOdne9uqamI6Ku", "itArcmOQ038W2qOxTmWDysJ", "YLO301mgb0CV", "8Iuh4U1kakUbsQ2Nn", "O3ZH7jI89PddtJoXg7iV4O6wtsqjtnrU", "1x9H6MAyleaM4oP8QSazbLvKby53Pv0n", "YmZygv2VfDGVkOFuuIE9CAITaRVNY9b1"};
    }

    public W1(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        WE we = this.A00;
        String simCountryIso = we.A00.getSimCountryIso();
        String[] strArr = A01;
        if (strArr[6].charAt(3) != strArr[5].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "tduom2IhCerqtA7iCB";
        strArr2[2] = "tduom2IhCerqtA7iCB";
        return we.A09(simCountryIso);
    }
}
