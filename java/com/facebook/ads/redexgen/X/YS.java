package com.facebook.ads.redexgen.X;

import com.facebook.imageutils.JfifUtil;
import com.google.firebase.FirebaseError;
import java.io.IOException;

public final class YS implements AbstractC0314Ce {
    public static String[] A01;
    public final /* synthetic */ YT A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"QxyXczWrJPO3wVR2PYQEuzattRFJZIJg", "XsmQOXxz56F8ZFhcTY7SGeacCVF", "LQ6zZ9Zapjn1TRDyEulQRXNFGY7QAnZu", "xNUQQ3qsLAAUx2yJDK4JRdV8dnV4oHU2", "y0XWt2t2M5t5jOwvErVmSfYW64pV03wh", "08OFOgjSb41ktoPQP1wiTHuWkUblsKHS", "6O4T6stZYTO64A1eR5mIXItGp3sSNy8u", "W8gkc1teFinis0XUwJ8nE"};
    }

    public YS(YT yt) {
        this.A00 = yt;
    }

    public /* synthetic */ YS(YT yt, YR yr) {
        this(yt);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final void A3r(int i, int i2, CL cl) throws IOException, InterruptedException {
        this.A00.A0L(i, i2, cl);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final void A4v(int i) throws AN {
        this.A00.A0J(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final void A58(int i, double d) throws AN {
        this.A00.A0K(i, d);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final int A66(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case JfifUtil.MARKER_RST7 /*{ENCODED_INT: 215}*/:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*{ENCODED_INT: 17026}*/:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1 /*{ENCODED_INT: 225}*/:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                if (A01[5].charAt(21) != 'H') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[5] = "OUtMPH0VOq9GijvQqOpwMHvOHPexZJaI";
                strArr[5] = "OUtMPH0VOq9GijvQqOpwMHvOHPexZJaI";
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final void A7T(int i, long j) throws AN {
        this.A00.A0M(i, j);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final boolean A7e(int i) {
        if (i != 357149030) {
            if (A01[3].charAt(17) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "tUcPl0tEvSxC8oU8uPz5JVtDe3SsNXw6";
            strArr[2] = "wRikutKgqwJwqf30vjhaLiDyNnSQZYBE";
            return i == 524531317 || i == 475249515 || i == 374648427;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final void ADK(int i, long j, long j2) throws AN {
        this.A00.A0N(i, j, j2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0314Ce
    public final void ADR(int i, String str) throws AN {
        this.A00.A0O(i, str);
    }
}
