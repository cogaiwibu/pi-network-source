package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Wc  reason: case insensitive filesystem */
public class C0815Wc extends AbstractRunnableC0510Kc {
    public static byte[] A02;
    public final /* synthetic */ C0816Wd A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 31);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{117, 87, 85, 94, 83, 22, 80, 87, 95, 90, 24, 77, 111, 109, 102, 107, 46, 125, 123, 109, 109, 107, 125, 125, 32};
    }

    public C0815Wc(C0816Wd wd, AtomicBoolean atomicBoolean) {
        this.A00 = wd;
        this.A01 = atomicBoolean;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (this.A00.A00 == null) {
            return;
        }
        if (this.A01.get()) {
            this.A00.A02.A0G(JK.A0H);
            AnonymousClass7K.A02(this.A00.A02.A04, this.A00.A01, AnonymousClass7K.A00, A00(11, 14, 17), this.A00.A02.A00);
            this.A00.A02.A0N();
            this.A00.A00.A9E();
            return;
        }
        this.A00.A02.A0G(JK.A0G);
        AnonymousClass7K.A02(this.A00.A02.A04, this.A00.A01, AnonymousClass7K.A04, A00(0, 11, 41), this.A00.A02.A00);
        this.A00.A02.A0O();
        this.A00.A00.A97();
    }
}
