package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.metadata.id3.ApicFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.BinaryFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.ChapterFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.ChapterTocFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.CommentFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.PrivFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.TextInformationFrame;
import com.facebook.ads.internal.exoplayer2.metadata.id3.UrlLinkFrame;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tapjoy.TapjoyAuctionFlags;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;

public final class ZP implements AbstractC0358Dy {
    public static byte[] A01;
    public static String[] A02;
    public static final int A03 = C0466Ig.A08(A0I(166, 3, 87));
    public static final EA A04 = new ZO();
    public final EA A00;

    /* JADX WARNING: Error to parse debug info: 21 in method: com.facebook.ads.redexgen.X.ZP.A06(com.facebook.ads.redexgen.X.IQ, int, int, boolean, int, com.facebook.ads.redexgen.X.EA):com.facebook.ads.internal.exoplayer2.metadata.id3.ChapterFrame, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 21
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:137)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static ChapterFrame A06(IQ iq, int i, int i2, boolean z, int i3, EA ea) throws UnsupportedEncodingException {
        int A07 = iq.A07();
        int A022 = A02(iq.A00, A07);
        String str = new String(iq.A00, A07, A022 - A07, A0I(169, 10, 52));
        iq.A0Z(A022 + 1);
        int A09 = iq.A09();
        int A092 = iq.A09();
        long A0N = iq.A0N();
        if (A0N == 4294967295L) {
            A0N = -1;
        }
        long A0N2 = iq.A0N();
        if (A0N2 == 4294967295L) {
            A0N2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = A07 + i;
        while (iq.A07() < i4) {
            Id3Frame A0B = A0B(i2, iq, z, i3, ea);
            if (A0B != null) {
                arrayList.add(A0B);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, A09, A092, A0N, A0N2, id3FrameArr);
    }

    public static String A0I(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 106);
        }
        return new String(copyOfRange);
    }

    public static void A0L() {
        A01 = new byte[]{-4, 58, -4, 58, -4, 58, -103, -41, -103, -41, -103, -41, -103, -41, -51, -63, 7, 19, 2, 14, 6, -12, 10, 27, 6, -34, 38, 67, 86, 67, 2, 86, 81, 81, 2, 85, 74, 81, 84, 86, 2, 86, 81, 2, 68, 71, 2, 67, 80, 2, 43, 38, 21, 2, 86, 67, 73, 16, 43, 51, 54, 47, 46, -22, 62, 57, -22, 46, 47, 45, 57, 46, 47, -22, 48, 60, 43, 55, 47, 4, -22, 51, 46, 7, -78, -51, -43, -40, -47, -48, -116, -32, -37, -116, -30, -51, -40, -43, -48, -51, -32, -47, -116, -75, -80, -97, -116, -32, -51, -45, -116, -29, -43, -32, -44, -116, -39, -51, -42, -37, -34, -62, -47, -34, -33, -43, -37, -38, -87, -38, 6, -11, 1, -7, -76, 7, -3, 14, -7, -76, -7, 12, -9, -7, -7, -8, 7, -76, 6, -7, 1, -11, -3, 2, -3, 2, -5, -76, 8, -11, -5, -76, -8, -11, 8, -11, 10, 5, -12, -25, -15, -19, -53, -42, -42, -45, -41, -53, -49, 37, 64, 15, 32, 65, 63, 75, 64, 65, 78, -19, 5, 3, 10, 10, -1, -2, -70, -29, -34, -51, -70, 14, -5, 1, -70, 17, 3, 14, 2, -70, 7, -5, 4, 9, 12, -16, -1, 12, 13, 3, 9, 8, -41, -52, -70, -5, 8, -2, -70, 15, 8, -2, -1, 0, 3, 8, -1, -2, -70, -3, 9, 7, 10, 12, -1, 13, 13, 3, 9, 8, -70, 13, -3, 2, -1, 7, -1, -25, -1, -3, 4, 4, -7, -8, -76, -35, -40, -57, -76, 8, -11, -5, -76, 11, -3, 8, -4, -76, 9, 2, 7, 9, 4, 4, 3, 6, 8, -7, -8, -76, 1, -11, -2, 3, 6, -22, -7, 6, 7, -3, 3, 2, -47, 49, 73, 71, 78, 78, 71, 76, 69, -2, 83, 76, 81, 83, 78, 78, 77, 80, 82, 67, 66, -2, 65, 77, 75, 78, 80, 67, 81, 81, 67, 66, -2, 77, 80, -2, 67, 76, 65, 80, 87, 78, 82, 67, 66, -2, 68, 80, 63, 75, 67, 20, 24, 24, 24, -60, -61, -75, -100, -96, -91, -61, -62, -76, -101, -97, -92, -80, -77, 59, 58, 44, 19, 30, 38, 63, 54, 73, 65, 54, 52, 69, 54, 53, -15, 55, 58, 67, 68, 69, -15, 69, 57, 67, 54, 54, -15, 51, 74, 69, 54, 68, -15, 64, 55, -15, 26, 21, 4, -15, 69, 50, 56, -15, 57, 54, 50, 53, 54, 67, 11, -15, -18, 7, 12, 14, 9, 9, 8, 11, 13, -2, -3, -71, -4, 1, -6, 11, -6, -4, 13, -2, 11, -71, -2, 7, -4, 8, -3, 2, 7, 0, -47, -46, -46, -46, 18, 22, 10, 16, 14, -40, -4, 0, -12, -6, -8, -62, -3, 3, -8, -6, -31, -27, -39, -33, -35, -89, -30, -24, -33};
    }

    public static void A0M() {
        A02 = new String[]{"sMUxEv8h1aqUKtOfXRhWvF4cd3jhCIiv", TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE, "jdWxaIwDf600E5fQi1jvtrBwOfx6AZo5", "VxysSZONWs4Fbmb", "6vXrI6nW4BVssue1T84qDnzAdKjaXJyK", "dpBJthFwlwkteZKALF9GwsW9kwjpNbjg", "2vyk08U", "E"};
    }

    static {
        A0M();
        A0L();
    }

    public ZP() {
        this(null);
    }

    public ZP(EA ea) {
        this.A00 = ea;
    }

    public static int A00(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static int A01(IQ iq, int i) {
        byte[] bArr = iq.A00;
        for (int A07 = iq.A07(); A07 + 1 < i; A07++) {
            if ((bArr[A07] & UByte.MAX_VALUE) == 255 && bArr[A07 + 1] == 0) {
                System.arraycopy(bArr, A07 + 2, bArr, A07 + 1, (i - A07) - 2);
                i--;
            }
        }
        return i;
    }

    public static int A02(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int A03(byte[] bArr, int i, int i2) {
        int A022 = A02(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return A022;
        }
        while (A022 < bArr.length - 1) {
            if (A022 % 2 == 0 && bArr[A022 + 1] == 0) {
                return A022;
            }
            A022 = A02(bArr, A022 + 1);
        }
        return bArr.length;
    }

    public static ApicFrame A04(IQ iq, int i, int i2) throws UnsupportedEncodingException {
        int A022;
        String A0M;
        int A0F = iq.A0F();
        String A0H = A0H(A0F);
        byte[] bArr = new byte[(i - 1)];
        iq.A0d(bArr, 0, i - 1);
        String A0I = A0I(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 6, 63);
        String A0I2 = A0I(169, 10, 52);
        if (i2 == 2) {
            A022 = 2;
            A0M = A0I + C0466Ig.A0M(new String(bArr, 0, 3, A0I2));
            if (A0I(474, 9, 14).equals(A0M)) {
                A0M = A0I(464, 10, 41);
            }
        } else {
            A022 = A02(bArr, 0);
            A0M = C0466Ig.A0M(new String(bArr, 0, A022, A0I2));
            if (A0M.indexOf(47) == -1) {
                A0M = A0I + A0M;
            }
        }
        int encoding = bArr[A022 + 1] & UByte.MAX_VALUE;
        int i3 = A022 + 2;
        int A032 = A03(bArr, i3, A0F);
        return new ApicFrame(A0M, new String(bArr, i3, A032 - i3, A0H), encoding, A0O(bArr, A00(A0F) + A032, bArr.length));
    }

    public static BinaryFrame A05(IQ iq, int i, String str) {
        byte[] bArr = new byte[i];
        iq.A0d(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    /* JADX INFO: Multiple debug info for r3v2 int: [D('endIndex' int), D('i' int)] */
    public static ChapterTocFrame A07(IQ iq, int framePosition, int elementIdEndIndex, boolean z, int limit, EA ea) throws UnsupportedEncodingException {
        boolean z2;
        int A07 = iq.A07();
        int A022 = A02(iq.A00, A07);
        String A0I = A0I(169, 10, 52);
        String str = new String(iq.A00, A07, A022 - A07, A0I);
        iq.A0Z(A022 + 1);
        int A0F = iq.A0F();
        boolean z3 = false;
        if ((A0F & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((A0F & 1) != 0) {
            z3 = true;
        }
        int ctocFlags = iq.A0F();
        String[] strArr = new String[ctocFlags];
        for (int i = 0; i < ctocFlags; i++) {
            int A072 = iq.A07();
            int i2 = A02(iq.A00, A072);
            strArr[i] = new String(iq.A00, A072, i2 - A072, A0I);
            iq.A0Z(i2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i3 = A07 + framePosition;
        while (iq.A07() < i3) {
            Id3Frame A0B = A0B(elementIdEndIndex, iq, z, limit, ea);
            if (A0B != null) {
                arrayList.add(A0B);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    /* JADX INFO: Multiple debug info for r0v5 int: [D('textEndIndex' int), D('language' java.lang.String)] */
    public static CommentFrame A08(IQ iq, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int A0F = iq.A0F();
        String A0H = A0H(A0F);
        byte[] data = new byte[3];
        iq.A0d(data, 0, 3);
        String str = new String(data, 0, 3);
        byte[] bArr = new byte[(i - 4)];
        iq.A0d(bArr, 0, i - 4);
        int A032 = A03(bArr, 0, A0F);
        String str2 = new String(bArr, 0, A032, A0H);
        int A002 = A00(A0F) + A032;
        return new CommentFrame(str, str2, A0K(bArr, A002, A03(bArr, A002, A0F), A0H));
    }

    /* JADX INFO: Multiple debug info for r0v4 int: [D('mimeType' java.lang.String), D('filenameEndIndex' int)] */
    public static GeobFrame A09(IQ iq, int i) throws UnsupportedEncodingException {
        int A0F = iq.A0F();
        String A0H = A0H(A0F);
        byte[] bArr = new byte[(i - 1)];
        iq.A0d(bArr, 0, i - 1);
        int A022 = A02(bArr, 0);
        String str = new String(bArr, 0, A022, A0I(169, 10, 52));
        int i2 = A022 + 1;
        int filenameEndIndex = A03(bArr, i2, A0F);
        String A0K = A0K(bArr, i2, filenameEndIndex, A0H);
        int A002 = A00(A0F) + filenameEndIndex;
        int filenameEndIndex2 = A03(bArr, A002, A0F);
        return new GeobFrame(str, A0K, A0K(bArr, A002, filenameEndIndex2, A0H), A0O(bArr, A00(A0F) + filenameEndIndex2, bArr.length));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008c, code lost:
        if (r4 == 1) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bf, code lost:
        if (r4 == 2) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c3, code lost:
        if (r4 != 3) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c7, code lost:
        if ((r6 & 64) == 0) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ca, code lost:
        if (r0 == 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cc, code lost:
        r0 = r9.A09();
        r9.A0a(r0);
        r2 = r2 - (r0 + 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e4, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e6, code lost:
        if (r4 != r5) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if ((r6 & 64) == 0) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ec, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ed, code lost:
        if (r0 == 0) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
        r1 = r9.A0E();
        r9.A0a(r1 - 4);
        r2 = r2 - r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fb, code lost:
        if ((r6 & 16) == 0) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fd, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fe, code lost:
        if (r0 == 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0100, code lost:
        r2 = r2 - 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0103, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0105, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0107, code lost:
        android.util.Log.w(r7, A0I(androidx.core.view.InputDeviceCompat.SOURCE_KEYBOARD, 46, 42) + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0123, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.redexgen.X.EB A0A(com.facebook.ads.redexgen.X.IQ r9) {
        /*
        // Method dump skipped, instructions count: 298
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZP.A0A(com.facebook.ads.redexgen.X.IQ):com.facebook.ads.redexgen.X.EB");
    }

    /* JADX INFO: Multiple debug info for r8v1 'frameId2'  int: [D('flags' int), D('frameId2' int)] */
    /* JADX INFO: Multiple debug info for r7v2 'frameSize'  int: [D('frameSize' int), D('isEncrypted' boolean)] */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x019f, code lost:
        if (r8 == 67) goto L_0x01a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame A0B(int r23, com.facebook.ads.redexgen.X.IQ r24, boolean r25, int r26, com.facebook.ads.redexgen.X.EA r27) {
        /*
        // Method dump skipped, instructions count: 606
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZP.A0B(int, com.facebook.ads.redexgen.X.IQ, boolean, int, com.facebook.ads.redexgen.X.EA):com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame");
    }

    public static PrivFrame A0C(IQ iq, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        iq.A0d(bArr, 0, i);
        int A022 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, A022, A0I(169, 10, 52)), A0O(bArr, A022 + 1, bArr.length));
    }

    /* JADX INFO: Multiple debug info for r0v3 int: [D('data' byte[]), D('descriptionEndIndex' int)] */
    /* JADX INFO: Multiple debug info for r0v4 int: [D('descriptionEndIndex' int), D('valueEndIndex' int)] */
    public static TextInformationFrame A0D(IQ iq, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int A0F = iq.A0F();
        String A0H = A0H(A0F);
        byte[] bArr = new byte[(i - 1)];
        iq.A0d(bArr, 0, i - 1);
        int descriptionEndIndex = A03(bArr, 0, A0F);
        String str = new String(bArr, 0, descriptionEndIndex, A0H);
        int A002 = A00(A0F) + descriptionEndIndex;
        return new TextInformationFrame(A0I(353, 4, 86), str, A0K(bArr, A002, A03(bArr, A002, A0F), A0H));
    }

    public static TextInformationFrame A0E(IQ iq, int encoding, String charset) throws UnsupportedEncodingException {
        if (encoding < 1) {
            return null;
        }
        int A0F = iq.A0F();
        String A0H = A0H(A0F);
        byte[] bArr = new byte[(encoding - 1)];
        iq.A0d(bArr, 0, encoding - 1);
        return new TextInformationFrame(charset, null, new String(bArr, 0, A03(bArr, 0, A0F), A0H));
    }

    public static UrlLinkFrame A0F(IQ iq, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            String[] strArr = A02;
            if (strArr[2].charAt(11) != strArr[5].charAt(11)) {
                String[] strArr2 = A02;
                strArr2[7] = Const.X;
                strArr2[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                return null;
            }
            throw new RuntimeException();
        }
        int descriptionEndIndex = iq.A0F();
        String A0H = A0H(descriptionEndIndex);
        byte[] bArr = new byte[(i - 1)];
        iq.A0d(bArr, 0, i - 1);
        int A032 = A03(bArr, 0, descriptionEndIndex);
        String str = new String(bArr, 0, A032, A0H);
        int A002 = A00(descriptionEndIndex) + A032;
        return new UrlLinkFrame(A0I(454, 4, 16), str, A0K(bArr, A002, A02(bArr, A002), A0I(169, 10, 52)));
    }

    public static UrlLinkFrame A0G(IQ iq, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        iq.A0d(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), A0I(169, 10, 52)));
    }

    public static String A0H(int i) {
        String A0I = A0I(169, 10, 52);
        if (i == 0) {
            return A0I;
        }
        if (i == 1) {
            return A0I(357, 6, 5);
        }
        if (i == 2) {
            return A0I(363, 8, 4);
        }
        if (i != 3) {
            return A0I;
        }
        String[] strArr = A02;
        if (strArr[2].charAt(11) != strArr[5].charAt(11)) {
            String[] strArr2 = A02;
            strArr2[0] = "Xs3p10eLQltfrtGuZ9I87GBEYIMhEDM2";
            strArr2[0] = "Xs3p10eLQltfrtGuZ9I87GBEYIMhEDM2";
            return A0I(371, 5, 124);
        }
        throw new RuntimeException();
    }

    public static String A0J(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, A0I(0, 6, 109), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, A0I(6, 8, 10), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String A0K(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        if (i2 <= i || i2 > bArr.length) {
            return A0I(0, 0, 105);
        }
        return new String(bArr, i, i2 - i, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
        if (r8 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bd, code lost:
        if (r8 != false) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A0N(com.facebook.ads.redexgen.X.IQ r17, int r18, int r19, boolean r20) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZP.A0N(com.facebook.ads.redexgen.X.IQ, int, int, boolean):boolean");
    }

    public static byte[] A0O(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        if (A02[3].length() != 29) {
            String[] strArr = A02;
            strArr[2] = "BXfcBk8SW4yeYxu44B11cVVkBGYBzlAv";
            strArr[5] = "okWvwdNSxMQpYeQbiZnCLiGxFx7BKew9";
            return copyOfRange;
        }
        throw new RuntimeException();
    }

    public final Metadata A0P(byte[] bArr, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        IQ iq = new IQ(bArr, i);
        EB A0A = A0A(iq);
        if (A0A == null) {
            return null;
        }
        int A07 = iq.A07();
        if (EB.A00(A0A) == 2) {
            i2 = 6;
        } else {
            i2 = 10;
        }
        int A012 = EB.A01(A0A);
        if (EB.A02(A0A)) {
            A012 = A01(iq, EB.A01(A0A));
        }
        iq.A0Y(A07 + A012);
        boolean unsignedIntFrameSizeHack = false;
        if (!A0N(iq, EB.A00(A0A), i2, false)) {
            int A002 = EB.A00(A0A);
            if (A02[4].charAt(24) != '1') {
                String[] strArr = A02;
                strArr[0] = "uYZb4rh3wheJht2DQ5CIaEPvRS4bXzrD";
                strArr[0] = "uYZb4rh3wheJht2DQ5CIaEPvRS4bXzrD";
                if (A002 != 4 || !A0N(iq, 4, i2, true)) {
                    Log.w(A0I(179, 10, 114), A0I(84, 45, 2) + EB.A00(A0A));
                    return null;
                }
                unsignedIntFrameSizeHack = true;
            } else {
                throw new RuntimeException();
            }
        }
        while (iq.A05() >= i2) {
            Id3Frame A0B = A0B(EB.A00(A0A), iq, unsignedIntFrameSizeHack, i2, this.A00);
            if (A0B != null) {
                arrayList.add(A0B);
            }
        }
        return new Metadata(arrayList);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0358Dy
    public final Metadata A4e(CC cc) {
        ByteBuffer byteBuffer = cc.A01;
        return A0P(byteBuffer.array(), byteBuffer.limit());
    }
}
