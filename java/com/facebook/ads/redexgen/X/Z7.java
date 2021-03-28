package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.io.IOException;
import kotlin.UByte;

public final class Z7 implements CK {
    public static String[] A08;
    public static final CN A09 = new Z6();
    public long A00;
    public CM A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final SparseArray<DX> A05;
    public final IQ A06;
    public final C0462Ic A07;

    public static void A00() {
        A08 = new String[]{"", "mExdGVP0maPlz", "mtU4GW9lJGPRgwi7WTtJ47xTDMOD9Jvz", "mnVK2jaR5CYO63Y95SEKprVffrLm5k0s", "WHnhbYArFQVibafDHBFVvoYN0aOa9WUH", "bzekXst0bt0AdcZvIiwJXkkJcIHRgIjU", "gyTL2jV1VgKAzlNybmW", "q"};
    }

    static {
        A00();
    }

    public Z7() {
        this(new C0462Ic(0));
    }

    public Z7(C0462Ic ic) {
        this.A07 = ic;
        this.A06 = new IQ(4096);
        this.A05 = new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A01 = cm;
        cm.ACk(new YH(-9223372036854775807L));
    }

    /* JADX INFO: Multiple debug info for r10v0 com.facebook.ads.redexgen.X.CL: [D('payloadLength' int), D('systemHeaderLength' int), D('packStuffingLength' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0138, code lost:
        if (r4 == null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013e, code lost:
        if (r4 == null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0141, code lost:
        r9.A06.A0X(r5);
        r10.readFully(r9.A06.A00, 0, r5);
        r9.A06.A0Z(6);
        r4.A03(r9.A06);
        r1 = r9.A06;
        r1.A0Y(r1.A06());
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102  */
    @Override // com.facebook.ads.redexgen.X.CK
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int ABx(com.facebook.ads.redexgen.X.CL r10, com.facebook.ads.redexgen.X.CR r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z7.ABx(com.facebook.ads.redexgen.X.CL, com.facebook.ads.redexgen.X.CR):int");
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A07.A09();
        for (int i = 0; i < this.A05.size(); i++) {
            this.A05.valueAt(i).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        cl.ABZ(bArr, 0, 14);
        if (442 != (((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        if (A08[7].length() != 3) {
            String[] strArr = A08;
            strArr[4] = "dWjhqjXulz1hd3AtKzuGBSPNQhOMyT1H";
            strArr[4] = "dWjhqjXulz1hd3AtKzuGBSPNQhOMyT1H";
            cl.A3M(bArr[13] & 7);
            cl.ABZ(bArr, 0, 3);
            if (1 == ((bArr[2] & UByte.MAX_VALUE) | ((bArr[0] & UByte.MAX_VALUE) << 16) | ((bArr[1] & UByte.MAX_VALUE) << 8))) {
                return true;
            }
            return false;
        }
        throw new RuntimeException();
    }
}
