package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.imagepipeline.common.RotationOptions;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;

/* renamed from: com.facebook.ads.redexgen.X.2q  reason: invalid class name and case insensitive filesystem */
public final class C00892q extends AV {
    public static byte[] A09;
    public static String[] A0A;
    public int A00;
    public GN A01;
    public GO A02;
    public List<GF> A03;
    public List<GF> A04;
    public final int A05;
    public final IP A06 = new IP();
    public final IQ A07 = new IQ();
    public final GN[] A08;

    static {
        A0A();
        A09();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A09 = new byte[]{-102, -94, -19, -33, -21, -17, -33, -24, -35, -33, -102, -24, -17, -25, -36, -33, -20, -102, 108, 99, -70, -85, -88, -79, 99, -91, -81, -78, -90, -82, -106, -84, -67, -88, 99, -84, -74, 99, 115, 112, -126, 103, -80, -82, -75, -74, -71, -80, -75, -82, 103, -73, -88, -86, -78, -84, -69, 101, 89, -101, -82, -83, 89, -100, -82, -85, -85, -98, -89, -83, 89, -94, -89, -99, -98, -79, 89, -94, -84, 89, 116, -106, -110, 104, 97, 105, 117, -106, -108, -96, -107, -106, -93, -127, -77, -80, -80, -93, -84, -78, -86, -73, 94, -77, -84, -79, -77, -82, -82, -83, -80, -78, -93, -94, 94, -127, -115, -117, -117, ByteCompanionObject.MAX_VALUE, -116, -126, -99, -125, -106, -110, 111, 94, -127, -83, -85, -85, -97, -84, -94, 120, 94, -59, -9, -12, -12, -25, -16, -10, -18, -5, -94, -9, -16, -11, -9, -14, -14, -15, -12, -10, -25, -26, -94, -59, -47, -49, -49, -61, -48, -58, -31, -46, -77, -72, -94, -59, -15, -17, -17, -29, -16, -26, -68, -94, -103, -55, -53, -104, -72, -91, -74, -72, -64, -70, -55, 117, -70, -61, -71, -70, -71, 117, -59, -57, -70, -62, -74, -55, -54, -57, -70, -63, -50, -112, 117, -56, -66, -49, -70, 117, -66, -56, 117, 109, -106, -117, -105, -99, -106, -100, -115, -102, -115, -116, 72, 108, 124, 126, 107, 107, -121, 120, 105, 107, 115, 109, 124, -121, 108, 105, 124, 105, 72, -118, -115, -114, -105, -102, -115, 72, 108, 124, 126, 107, 107, -121, 120, 105, 107, 115, 109, 124, -121, 123, 124, 105, 122, 124, -119, -82, -74, -95, -84, -87, -92, 96, -125, 112, 96, -93, -81, -83, -83, -95, -82, -92, 122, 96, -42, -5, 3, -18, -7, -10, -15, -83, -48, -66, -83, -16, -4, -6, -6, -18, -5, -15, -57, -83, -110, -73, -65, -86, -75, -78, -83, 105, -112, 123, 105, -84, -79, -86, -69, -86, -84, -67, -82, -69, -125, 105, 118, -101, -93, -114, -103, -106, -111, 77, 116, 96, 77, -112, -107, -114, -97, -114, -112, -95, -110, -97, 103, 77, -104, -67, -59, -80, -69, -72, -77, 111, -79, -80, -62, -76, 111, -78, -66, -68, -68, -80, -67, -77, -119, 111, -55, -18, -10, -31, -20, -23, -28, -96, -27, -8, -12, -27, -18, -28, -27, -28, -96, -29, -17, -19, -19, -31, -18, -28, -70, -96, -6, -20, -7, -3, -16, -22, -20, -43, -4, -12, -23, -20, -7, -89, -16, -6, -89, -11, -10, -11, -76, 1, -20, -7, -10, -89, -81};
    }

    public static void A0A() {
        A0A = new String[]{"L1xpy5cp85DZhci17XuVPwuBI", "YkTNFPOzwzkJtYlViXkR23NQqoCQppA0", "SGim0bOTaYlclFO3csKadT6H6g9xYkcM", "jQ8PzV3P", "QC0kpNF7RiOrPOmNNHkvJn0tMmNRSOb3", "UpfI1Vr3VxozUqaf4r1nY355XZgGFNi", "PidsADYQpUdS401V", "6iBltx3Oq3HhhZI1vDwKIUw2PCH0pZTk"};
    }

    public C00892q(int i) {
        this.A05 = i == -1 ? 1 : i;
        this.A08 = new GN[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.A08[i2] = new GN();
        }
        this.A01 = this.A08[0];
        A08();
    }

    private List<GF> A01() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.A08[i].A0I() && this.A08[i].A0J()) {
                arrayList.add(this.A08[i].A06());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void A02() {
        if (this.A02 != null) {
            A07();
            this.A02 = null;
        }
    }

    private void A03() {
        this.A01.A0D(this.A06.A05(4), this.A06.A05(2), this.A06.A05(2), this.A06.A0G(), this.A06.A0G(), this.A06.A05(3), this.A06.A05(3));
    }

    /* JADX INFO: Multiple debug info for r0v9 int: [D('backgroundB' int), D('backgroundG' int)] */
    /* JADX INFO: Multiple debug info for r3v2 int: [D('foregroundG' int), D('edgeG' int)] */
    /* JADX INFO: Multiple debug info for r0v14 int: [D('edgeR' int), D('edgeB' int)] */
    private void A04() {
        int backgroundColor = GN.A01(this.A06.A05(2), this.A06.A05(2), this.A06.A05(2), this.A06.A05(2));
        int edgeG = GN.A01(this.A06.A05(2), this.A06.A05(2), this.A06.A05(2), this.A06.A05(2));
        this.A06.A09(2);
        this.A01.A0C(backgroundColor, edgeG, GN.A00(this.A06.A05(2), this.A06.A05(2), this.A06.A05(2)));
    }

    private void A05() {
        this.A06.A09(4);
        int A052 = this.A06.A05(4);
        this.A06.A09(2);
        this.A01.A0B(A052, this.A06.A05(6));
    }

    /* JADX INFO: Multiple debug info for r4v1 int: [D('borderType' int), D('borderR' int)] */
    /* JADX INFO: Multiple debug info for r0v9 int: [D('fillColor' int), D('borderB' int)] */
    private void A06() {
        int fillG = GN.A01(this.A06.A05(2), this.A06.A05(2), this.A06.A05(2), this.A06.A05(2));
        int borderG = this.A06.A05(2);
        int scrollDirection = GN.A00(this.A06.A05(2), this.A06.A05(2), this.A06.A05(2));
        if (this.A06.A0G()) {
            borderG |= 4;
        }
        boolean A0G = this.A06.A0G();
        int A052 = this.A06.A05(2);
        int A053 = this.A06.A05(2);
        int A054 = this.A06.A05(2);
        this.A06.A09(8);
        this.A01.A0E(fillG, scrollDirection, A0G, borderG, A052, A053, A054);
    }

    private void A07() {
        int i = this.A02.A00;
        int i2 = (this.A02.A01 * 2) - 1;
        String A002 = A00(80, 13, 35);
        if (i != i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(A00(RotationOptions.ROTATE_180, 39, 71));
            sb.append((this.A02.A01 * 2) - 1);
            sb.append(A00(57, 23, 43));
            sb.append(this.A02.A00);
            sb.append(A00(0, 18, 108));
            sb.append(this.A02.A02);
            sb.append(A00(39, 18, 57));
            Log.w(A002, sb.toString());
            return;
        }
        this.A06.A0D(this.A02.A03, this.A02.A00);
        int A052 = this.A06.A05(3);
        int A053 = this.A06.A05(5);
        if (A052 == 7) {
            this.A06.A09(2);
            A052 += this.A06.A05(6);
        }
        if (A053 == 0) {
            if (A052 != 0) {
                Log.w(A002, A00(406, 27, 121) + A052 + A00(18, 21, 53));
            }
        } else if (A052 == this.A05) {
            boolean z = false;
            while (this.A06.A02() > 0) {
                int A054 = this.A06.A05(8);
                String[] strArr = A0A;
                if (strArr[2].charAt(6) != strArr[1].charAt(6)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0A;
                strArr2[4] = "ms0OGa625FAXtw1h35os66EQGefGqsb0";
                strArr2[7] = "y0WyytXakCt9dcKCWCePMiqFSD1TGdmN";
                if (A054 == 16) {
                    int A055 = this.A06.A05(8);
                    if (A055 <= 31) {
                        A0D(A055);
                    } else if (A055 <= 127) {
                        A0I(A055);
                        z = true;
                    } else if (A055 <= 159) {
                        A0E(A055);
                    } else if (A055 <= 255) {
                        A0J(A055);
                        z = true;
                    } else {
                        Log.w(A002, A00(380, 26, 114) + A055);
                    }
                } else if (A054 <= 31) {
                    A0B(A054);
                } else if (A054 <= 127) {
                    A0G(A054);
                    z = true;
                } else if (A054 <= 159) {
                    A0C(A054);
                    z = true;
                } else if (A054 <= 255) {
                    A0H(A054);
                    z = true;
                } else {
                    Log.w(A002, A00(358, 22, 65) + A054);
                }
            }
            if (z) {
                this.A03 = A01();
            }
        }
    }

    private void A08() {
        for (int i = 0; i < 8; i++) {
            GN[] gnArr = this.A08;
            if (A0A[5].length() != 25) {
                String[] strArr = A0A;
                strArr[5] = "s2U2A8";
                strArr[5] = "s2U2A8";
                gnArr[i].A09();
            } else {
                throw new RuntimeException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        if (r7 <= 23) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0079, code lost:
        if (r7 <= 23) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0B(int r7) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00892q.A0B(int):void");
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.2q: [D('window' int), D('i' int)] */
    private void A0C(int i) {
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i2 = i - 128;
                if (this.A00 != i2) {
                    this.A00 = i2;
                    this.A01 = this.A08[i2];
                    return;
                }
                return;
            case 136:
                for (int i3 = 1; i3 <= 8; i3++) {
                    if (this.A06.A0G()) {
                        this.A08[8 - i3].A08();
                    }
                }
                return;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    boolean A0G = this.A06.A0G();
                    String[] strArr = A0A;
                    if (strArr[4].charAt(10) != strArr[7].charAt(10)) {
                        String[] strArr2 = A0A;
                        strArr2[5] = "EEpd";
                        strArr2[5] = "EEpd";
                        if (A0G) {
                            this.A08[8 - i4].A0F(true);
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
                return;
            case 138:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.A06.A0G()) {
                        this.A08[8 - i5].A0F(false);
                    }
                }
                return;
            case 139:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.A06.A0G()) {
                        GN gn = this.A08[8 - i6];
                        gn.A0F(!gn.A0J());
                    }
                }
                return;
            case IronSourceConstants.USING_CACHE_FOR_INIT_EVENT /*{ENCODED_INT: 140}*/:
                for (int i7 = 1; i7 <= 8; i7++) {
                    if (this.A06.A0G()) {
                        this.A08[8 - i7].A09();
                    }
                }
                return;
            case 141:
                this.A06.A09(8);
                return;
            case 142:
                return;
            case 143:
                A08();
                return;
            case 144:
                if (!this.A01.A0H()) {
                    this.A06.A09(16);
                    return;
                } else {
                    A03();
                    return;
                }
            case 145:
                if (!this.A01.A0H()) {
                    this.A06.A09(24);
                    return;
                } else {
                    A04();
                    return;
                }
            case 146:
                if (!this.A01.A0H()) {
                    this.A06.A09(16);
                    return;
                } else {
                    A05();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED /*{ENCODED_INT: 150}*/:
            default:
                Log.w(A00(80, 13, 35), A00(294, 20, 127) + i);
                return;
            case 151:
                if (!this.A01.A0H()) {
                    this.A06.A09(32);
                    return;
                } else {
                    A06();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i8 = i - 152;
                A0F(i8);
                if (this.A00 != i8) {
                    this.A00 = i8;
                    this.A01 = this.A08[i8];
                    return;
                }
                return;
        }
    }

    private void A0D(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.A06.A09(8);
            } else if (i <= 23) {
                this.A06.A09(16);
            } else if (i <= 31) {
                this.A06.A09(24);
            }
        }
    }

    private void A0E(int i) {
        if (i <= 135) {
            this.A06.A09(32);
            return;
        }
        String[] strArr = A0A;
        if (strArr[3].length() != strArr[6].length()) {
            String[] strArr2 = A0A;
            strArr2[3] = "CkyZUSwm";
            strArr2[6] = "y0ZSf6RqH8VvK6A8";
            if (i <= 143) {
                this.A06.A09(40);
            } else if (i <= 159) {
                this.A06.A09(2);
                this.A06.A09(this.A06.A05(6) * 8);
            }
        } else {
            throw new RuntimeException();
        }
    }

    private void A0F(int i) {
        GN gn = this.A08[i];
        this.A06.A09(2);
        boolean A0G = this.A06.A0G();
        boolean A0G2 = this.A06.A0G();
        boolean A0G3 = this.A06.A0G();
        int A052 = this.A06.A05(3);
        boolean columnLock = this.A06.A0G();
        int verticalAnchor = this.A06.A05(7);
        int rowCount = this.A06.A05(8);
        int penStyle = this.A06.A05(4);
        int A053 = this.A06.A05(4);
        this.A06.A09(2);
        int A054 = this.A06.A05(6);
        this.A06.A09(2);
        gn.A0G(A0G, A0G2, A0G3, A052, columnLock, verticalAnchor, rowCount, A053, A054, penStyle, this.A06.A05(3), this.A06.A05(3));
    }

    private void A0G(int i) {
        if (i == 127) {
            this.A01.A0A(9835);
        } else {
            this.A01.A0A((char) (i & 255));
        }
    }

    private void A0H(int i) {
        this.A01.A0A((char) (i & 255));
    }

    private void A0I(int i) {
        if (i == 32) {
            this.A01.A0A(' ');
        } else if (i == 33) {
            this.A01.A0A(Typography.nbsp);
        } else if (i == 37) {
            this.A01.A0A(Typography.ellipsis);
        } else if (i == 42) {
            this.A01.A0A(352);
        } else if (i == 44) {
            this.A01.A0A(338);
        } else if (i != 63) {
            String[] strArr = A0A;
            if (strArr[2].charAt(6) == strArr[1].charAt(6)) {
                String[] strArr2 = A0A;
                strArr2[5] = "VBgxEtCZM8hUXU02q62ejO2N";
                strArr2[5] = "VBgxEtCZM8hUXU02q62ejO2N";
                if (i == 57) {
                    this.A01.A0A(Typography.tm);
                    return;
                } else if (i == 58) {
                    GN gn = this.A01;
                    if (A0A[0].length() != 12) {
                        String[] strArr3 = A0A;
                        strArr3[2] = "Hn1frjObrkKWee9bQkUvSoGsCyNbx6K5";
                        strArr3[1] = "5jLxiAOonCPZsccE4Rlf5xBOSnJI2Mxj";
                        gn.A0A(353);
                        return;
                    }
                } else if (i == 60) {
                    this.A01.A0A(339);
                    return;
                } else if (i != 61) {
                    switch (i) {
                        case 48:
                            this.A01.A0A(9608);
                            return;
                        case 49:
                            this.A01.A0A(Typography.leftSingleQuote);
                            return;
                        case 50:
                            GN gn2 = this.A01;
                            String[] strArr4 = A0A;
                            if (strArr4[3].length() != strArr4[6].length()) {
                                String[] strArr5 = A0A;
                                strArr5[0] = "pntPsILDFVvSJsAkqe";
                                strArr5[0] = "pntPsILDFVvSJsAkqe";
                                gn2.A0A(Typography.rightSingleQuote);
                                return;
                            }
                            throw new RuntimeException();
                        case 51:
                            this.A01.A0A(Typography.leftDoubleQuote);
                            return;
                        case 52:
                            GN gn3 = this.A01;
                            if (A0A[0].length() != 12) {
                                String[] strArr6 = A0A;
                                strArr6[4] = "pjkXXm09rSmpulg3ZnQvc2tVnRpvsPhy";
                                strArr6[7] = "1ZIH3c3lD2nrVh46isF21y1NEU8S3DGz";
                                gn3.A0A(Typography.rightDoubleQuote);
                                return;
                            }
                            throw new RuntimeException();
                        case 53:
                            this.A01.A0A(Typography.bullet);
                            return;
                        default:
                            switch (i) {
                                case 118:
                                    this.A01.A0A(8539);
                                    return;
                                case 119:
                                    this.A01.A0A(8540);
                                    return;
                                case 120:
                                    this.A01.A0A(8541);
                                    return;
                                case 121:
                                    this.A01.A0A(8542);
                                    return;
                                case 122:
                                    this.A01.A0A(9474);
                                    return;
                                case 123:
                                    this.A01.A0A(9488);
                                    return;
                                case 124:
                                    this.A01.A0A(9492);
                                    return;
                                case 125:
                                    this.A01.A0A(9472);
                                    return;
                                case 126:
                                    this.A01.A0A(9496);
                                    return;
                                case 127:
                                    this.A01.A0A(9484);
                                    return;
                                default:
                                    Log.w(A00(80, 13, 35), A00(314, 22, 59) + i);
                                    return;
                            }
                    }
                } else {
                    this.A01.A0A(8480);
                    return;
                }
            }
            throw new RuntimeException();
        } else {
            this.A01.A0A(376);
        }
    }

    private void A0J(int i) {
        if (i == 160) {
            this.A01.A0A(13252);
            return;
        }
        Log.w(A00(80, 13, 35), A00(336, 22, 31) + i);
        this.A01.A0A('_');
    }

    @Override // com.facebook.ads.redexgen.X.AV
    public final GG A0N() {
        List<GF> list = this.A03;
        this.A04 = list;
        return new C0927aE(list);
    }

    @Override // com.facebook.ads.redexgen.X.AV
    public final /* bridge */ /* synthetic */ C0283Aq A0O() throws GH {
        return super.A4h();
    }

    @Override // com.facebook.ads.redexgen.X.AV
    public final /* bridge */ /* synthetic */ AbstractC0269Ab A0P() throws GH {
        return super.A4i();
    }

    @Override // com.facebook.ads.redexgen.X.AV
    public final /* bridge */ /* synthetic */ void A0Q(C0283Aq aq) throws GH {
        super.ABw(aq);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b2, code lost:
        if (r0 == null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00db, code lost:
        if (r0 == null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00de, code lost:
        r3 = r0.A03;
        r2 = r10.A02;
        r1 = r2.A00;
        r2.A00 = r1 + 1;
        r3[r1] = r5;
        r3 = r10.A02.A03;
        r2 = r10.A02;
        r1 = r2.A00;
        r2.A00 = r1 + 1;
        r3[r1] = r4;
     */
    @Override // com.facebook.ads.redexgen.X.AV
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0R(com.facebook.ads.redexgen.X.C0283Aq r11) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00892q.A0R(com.facebook.ads.redexgen.X.Aq):void");
    }

    @Override // com.facebook.ads.redexgen.X.AV
    public final boolean A0T() {
        return this.A03 != this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0296Bd, com.facebook.ads.redexgen.X.AV
    public final /* bridge */ /* synthetic */ void ACD() {
        super.ACD();
    }

    @Override // com.facebook.ads.redexgen.X.AV, com.facebook.ads.redexgen.X.AbstractC0923aA
    public final /* bridge */ /* synthetic */ void AD4(long j) {
        super.AD4(j);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0296Bd, com.facebook.ads.redexgen.X.AV
    public final void flush() {
        super.flush();
        this.A03 = null;
        this.A04 = null;
        this.A00 = 0;
        this.A01 = this.A08[this.A00];
        A08();
        this.A02 = null;
    }
}
