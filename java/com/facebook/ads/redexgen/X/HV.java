package com.facebook.ads.redexgen.X;

import java.io.IOException;

public class HV extends IOException {
    public final int A00;
    public final HQ A01;

    public HV(IOException iOException, HQ hq, int i) {
        super(iOException);
        this.A01 = hq;
        this.A00 = i;
    }

    public HV(String str, HQ hq, int i) {
        super(str);
        this.A01 = hq;
        this.A00 = i;
    }

    public HV(String str, IOException iOException, HQ hq, int i) {
        super(str, iOException);
        this.A01 = hq;
        this.A00 = i;
    }
}
