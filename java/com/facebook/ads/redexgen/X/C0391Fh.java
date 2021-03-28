package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Fh  reason: case insensitive filesystem */
public final class C0391Fh extends AbstractC0679Qt {
    public static byte[] A01;
    public static String[] A02;
    public final long A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[1].charAt(11) != strArr[7].charAt(11)) {
                String[] strArr2 = A02;
                strArr2[2] = "gnOcZLWDvxdPQhFZXDuJbQjlKnJrGFNK";
                strArr2[2] = "gnOcZLWDvxdPQhFZXDuJbQjlKnJrGFNK";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 84);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A01 = new byte[]{-71, -51, -28, -116, -33, -43, -26, -47, -116, -39, -31, -33, -32, -116, -50, -47, -116, -36, -37, -33, -43, -32, -43, -30, -47, -116, -38, -31, -39, -50, -47, -34, -115};
    }

    public static void A02() {
        A02 = new String[]{"rUhg5nWIULCK5t0gW05eAQLFFSPSWMvZ", "IWlot4Qxgt9kC5cL8sfJp7UuHzQVcIMi", "pyGO9NZUXO3VfNbPYY8A9lbBjy3aVFuI", "BR2eyutWjUUloqp0GJ1CKmWpDC9ci7iC", "R8", "7OIMX1dy42ob61A4JIfUI17XWGQLX3ws", "f7SraaJMsc9s0A0ZVYKOMxYCK6pogew2", "N778iUAZTctb3pJ5Cpi07oq2oMO9GnTO"};
    }

    public C0391Fh(long j) {
        if (j > 0) {
            this.A00 = j;
            return;
        }
        throw new IllegalArgumentException(A00(0, 33, 24));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0679Qt
    public final boolean A0A(File file, long j, int i) {
        return j <= this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0679Qt, com.facebook.ads.redexgen.X.AnonymousClass0C
    public final /* bridge */ /* synthetic */ void ADX(File file) throws IOException {
        super.ADX(file);
    }
}
