package com.facebook.ads.redexgen.X;

public class XI implements AnonymousClass99 {
    public final /* synthetic */ String[] A00;

    public XI(String[] strArr) {
        this.A00 = strArr;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass99
    public final boolean A2O(String str) {
        for (String str2 : this.A00) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }
}
