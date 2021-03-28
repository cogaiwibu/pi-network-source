package com.facebook.ads.redexgen.X;

import com.onesignal.NotificationBundleProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.facebook.ads.redexgen.X.2m  reason: invalid class name and case insensitive filesystem */
public final class C00852m extends AbstractC0290Ax {
    public static byte[] A05;
    public static String[] A06;
    public int A00;
    public Inflater A01;
    public byte[] A02;
    public final C0408Ga A03 = new C0408Ga();
    public final IQ A04 = new IQ();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 117);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{97, 86, 66, 117, 84, 82, 94, 85, 84, 67};
    }

    public static void A03() {
        A06 = new String[]{"D8ktImD4gI341B9dMX", NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON, "8S1Qfr0uQHuWlKinBNgV3mwJeBc1O2wn", "O", "UgOsD1qslkvgk8WTNW5IJqqmR5mppeJL", "YmudOgNfte0R1MlRzZs3i7R", "t", "Vvarb6mClw"};
    }

    public C00852m() {
        super(A01(0, 10, 68));
    }

    public static GF A00(IQ iq, C0408Ga ga) {
        int sectionLength = iq.A08();
        int nextSectionPosition = iq.A0F();
        int A0J = iq.A0J();
        int A07 = iq.A07() + A0J;
        if (A07 > sectionLength) {
            iq.A0Z(sectionLength);
            return null;
        }
        GF gf = null;
        if (nextSectionPosition != 128) {
            switch (nextSectionPosition) {
                case 20:
                    ga.A06(iq, A0J);
                    break;
                case 21:
                    ga.A04(iq, A0J);
                    break;
                case 22:
                    ga.A05(iq, A0J);
                    break;
            }
        } else {
            gf = ga.A07();
            String[] strArr = A06;
            if (strArr[5].length() != strArr[7].length()) {
                String[] strArr2 = A06;
                strArr2[0] = "8Q7r9e8nqCgCYEZ6IU";
                strArr2[0] = "8Q7r9e8nqCgCYEZ6IU";
                ga.A08();
            } else {
                ga.A08();
            }
        }
        iq.A0Z(A07);
        if (A06[0].length() != 18) {
            throw new RuntimeException();
        }
        String[] strArr3 = A06;
        strArr3[2] = "BTE07TDUmys5OOcsYpYqmwkAe847KCkG";
        strArr3[2] = "BTE07TDUmys5OOcsYpYqmwkAe847KCkG";
        return gf;
    }

    private boolean A04(byte[] bArr, int i) {
        if (i != 0) {
            byte b = bArr[0];
            if (A06[3].length() != 1) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[4] = "3s6wsel2PksO74PVHVwG8hUXCMbdJ5Q0";
            strArr[4] = "3s6wsel2PksO74PVHVwG8hUXCMbdJ5Q0";
            if (b == 120) {
                if (this.A01 == null) {
                    this.A01 = new Inflater();
                    this.A02 = new byte[i];
                }
                this.A00 = 0;
                this.A01.setInput(bArr, 0, i);
                while (!this.A01.finished() && !this.A01.needsDictionary() && !this.A01.needsInput()) {
                    try {
                        if (this.A00 == this.A02.length) {
                            this.A02 = Arrays.copyOf(this.A02, this.A02.length * 2);
                        }
                        this.A00 += this.A01.inflate(this.A02, this.A00, this.A02.length - this.A00);
                    } catch (DataFormatException unused) {
                        return false;
                    } finally {
                        this.A01.reset();
                    }
                }
                return this.A01.finished();
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0290Ax
    public final GG A0d(byte[] bArr, int i, boolean z) throws GH {
        if (A04(bArr, i)) {
            this.A04.A0c(this.A02, this.A00);
        } else {
            IQ iq = this.A04;
            if (A06[0].length() != 18) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[2] = "roAZZspd009Dh1499aBQr6xCTRbeSGaA";
            strArr[2] = "roAZZspd009Dh1499aBQr6xCTRbeSGaA";
            iq.A0c(bArr, i);
        }
        this.A03.A08();
        ArrayList arrayList = new ArrayList();
        while (this.A04.A05() >= 3) {
            GF A002 = A00(this.A04, this.A03);
            if (A002 != null) {
                arrayList.add(A002);
            }
        }
        return new C0929aG(Collections.unmodifiableList(arrayList));
    }
}
