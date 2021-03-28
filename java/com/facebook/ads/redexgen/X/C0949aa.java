package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.aa  reason: case insensitive filesystem */
public final class C0949aa implements HM {
    public static byte[] A0A;
    public static String[] A0B;
    public HM A00;
    public HM A01;
    public HM A02;
    public HM A03;
    public HM A04;
    public HM A05;
    public HM A06;
    public final Context A07;
    public final HM A08;
    public final AbstractC0441Hh<? super HM> A09;

    static {
        A08();
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 49);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        byte[] bArr = {119, -87, -74, -84, -70, -73, -79, -84, -89, -87, -69, -69, -83, -68, 119, -40, 11, 11, -4, 4, 7, 11, 0, 5, -2, -73, 11, 6, -73, 7, 3, -8, 16, -73, -23, -21, -28, -25, -73, 10, 11, 9, -4, -8, 4, -73, 14, 0, 11, -1, 6, 12, 11, -73, -5, -4, 7, -4, 5, -5, 0, 5, -2, -73, 6, 5, -73, 11, -1, -4, -73, -23, -21, -28, -25, -73, -4, 15, 11, -4, 5, 10, 0, 6, 5, -13, 20, 21, 16, 36, 27, 35, -13, 16, 35, 16, 2, 30, 36, 33, 18, 20, -90, -45, -45, -48, -45, -127, -54, -49, -44, -43, -62, -49, -43, -54, -62, -43, -54, -49, -56, -127, -77, -75, -82, -79, -127, -58, -39, -43, -58, -49, -44, -54, -48, -49, -82, -64, -64, -78, -63, -33, -21, -23, -86, -30, -35, -33, -31, -34, -21, -21, -25, -86, -35, -32, -17, -86, -27, -22, -16, -31, -18, -22, -35, -24, -86, -31, -12, -21, -20, -24, -35, -11, -31, -18, -82, -86, -31, -12, -16, -86, -18, -16, -23, -20, -86, -50, -16, -23, -20, -64, -35, -16, -35, -49, -21, -15, -18, -33, -31, 17, 29, 28, 34, 19, 28, 34, -13, -16, 3, -16, -30, -47, -25, -30, -43, -29, -33, -27, -30, -45, -43, -27, -25, -32, -29};
        if (A0B[7].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[1] = "aTM6G8lKpIJ6RP017QMILejHyUH2B7dh";
        strArr[3] = "ERhfqbVtKjwR0y0XTQNxaBJXl7PFqJQV";
        A0A = bArr;
    }

    public static void A08() {
        A0B = new String[]{"FbuaOXxD8R3r2Sez", "nl2ebpznfahqYQ0iJMeMraM5u9ytbnkM", "LukWv8Q1lv25Jz9VZoWHVgr80BMsfj7N", "UITThFDmXIK6qk0JXllT0SDhOskljLuD", "WWGwJIDbyg2bl1Mdb", "YrbKAvAwCNNri3u3ecPrw9BDMC3UJFWv", "h8pfgUZlB4VhxmKVTbPlaDG6t2cnqOd2", "IQvStArhblJullrSqn3"};
    }

    public C0949aa(Context context, AbstractC0441Hh<? super HM> hh, HM hm) {
        this.A07 = context.getApplicationContext();
        this.A09 = hh;
        this.A08 = (HM) I1.A01(hm);
    }

    private HM A00() {
        if (this.A00 == null) {
            this.A00 = new C0942aT(this.A07, this.A09);
        }
        return this.A00;
    }

    private HM A01() {
        if (this.A01 == null) {
            this.A01 = new C0945aW(this.A07, this.A09);
        }
        HM hm = this.A01;
        if (A0B[4].length() != 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[7] = "5KWAQaHsfffdQGrIbOe";
        strArr[7] = "5KWAQaHsfffdQGrIbOe";
        return hm;
    }

    private HM A02() {
        if (this.A02 == null) {
            this.A02 = new C0946aX();
        }
        return this.A02;
    }

    private HM A03() {
        if (this.A04 == null) {
            this.A04 = new C0953ae(this.A09);
        }
        return this.A04;
    }

    private HM A04() {
        if (this.A05 == null) {
            this.A05 = new C0965aq(this.A07, this.A09);
        }
        return this.A05;
    }

    /* JADX INFO: Multiple debug info for r5v0 'this'  com.facebook.ads.redexgen.X.aa: [D('clazz' java.lang.Class<?>), D('e' java.lang.ClassNotFoundException)] */
    private HM A05() {
        if (this.A06 == null) {
            try {
                this.A06 = (HM) Class.forName(A06(141, 60, 75)).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.w(A06(85, 17, 126), A06(15, 70, 102));
            } catch (Exception e) {
                throw new RuntimeException(A06(102, 34, 48), e);
            }
            if (this.A06 == null) {
                this.A06 = this.A08;
            }
        }
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final Uri A7C() {
        HM hm = this.A03;
        if (hm == null) {
            return null;
        }
        return hm.A7C();
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final long ABP(HQ hq) throws IOException {
        boolean z;
        if (this.A03 == null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        String scheme = hq.A04.getScheme();
        if (C0466Ig.A0f(hq.A04)) {
            if (hq.A04.getPath().startsWith(A06(0, 15, 23))) {
                this.A03 = A00();
            } else {
                this.A03 = A03();
            }
        } else if (A06(136, 5, 28).equals(scheme)) {
            this.A03 = A00();
        } else if (A06(201, 7, 125).equals(scheme)) {
            this.A03 = A01();
        } else if (A06(223, 4, 66).equals(scheme)) {
            this.A03 = A05();
        } else if (A06(JfifUtil.MARKER_RST0, 4, 94).equals(scheme)) {
            this.A03 = A02();
        } else if (A0B[7].length() != 19) {
            throw new RuntimeException();
        } else {
            String[] strArr = A0B;
            strArr[6] = "D4NYqGk09rVUGFQV4qQWMtXs9QaZTkcz";
            strArr[2] = "qnlKhzyemJcEWBYVQAP4EuZEjLdcMELi";
            if (A06(212, 11, 63).equals(scheme)) {
                this.A03 = A04();
            } else {
                this.A03 = this.A08;
            }
        }
        return this.A03.ABP(hq);
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws IOException {
        HM hm = this.A03;
        if (hm != null) {
            try {
                hm.close();
            } finally {
                this.A03 = null;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.A03.read(bArr, i, i2);
    }
}
