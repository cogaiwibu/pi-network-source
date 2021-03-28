package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.ByteCompanionObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.facebook.ads.redexgen.X.2j  reason: invalid class name and case insensitive filesystem */
public final class C00822j extends AbstractC0290Ax {
    public static byte[] A01;
    public static String[] A02;
    public static final C0409Gb A03 = new C0409Gb(32, 15);
    public static final C0410Gc A04 = new C0410Gc(30.0f, 1, 1);
    public static final Pattern A05 = Pattern.compile(A08(941, 13, 76));
    public static final Pattern A06 = Pattern.compile(A08(856, 85, 72));
    public static final Pattern A07 = Pattern.compile(A08(790, 29, 120));
    public static final Pattern A08 = Pattern.compile(A08(819, 37, 6));
    public static final Pattern A09 = Pattern.compile(A08(954, 29, 91));
    public final XmlPullParserFactory A00;

    /* JADX WARNING: Error to parse debug info: 14 in method: com.facebook.ads.redexgen.X.2j.A00(java.lang.String, com.facebook.ads.redexgen.X.Gc):long, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:127)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static long A00(String str, C0410Gc gc) throws GH {
        Matcher matcher = A06.matcher(str);
        if (matcher.matches()) {
            double parseLong = ((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)) + ((double) Long.parseLong(matcher.group(3)));
            String group = matcher.group(4);
            double d = 0.0d;
            double parseDouble = parseLong + (group != null ? Double.parseDouble(group) : 0.0d);
            String group2 = matcher.group(5);
            double parseLong2 = parseDouble + (group2 != null ? (double) (((float) Long.parseLong(group2)) / gc.A00) : 0.0d);
            String group3 = matcher.group(6);
            if (group3 != null) {
                d = (((double) Long.parseLong(group3)) / ((double) gc.A01)) / ((double) gc.A00);
            }
            return (long) (1000000.0d * (parseLong2 + d));
        }
        Matcher matcher2 = A08.matcher(str);
        if (matcher2.matches()) {
            double parseDouble2 = Double.parseDouble(matcher2.group(1));
            String group4 = matcher2.group(2);
            char c = 65535;
            int hashCode = group4.hashCode();
            if (hashCode != 102) {
                if (hashCode != 104) {
                    if (hashCode != 109) {
                        if (hashCode != 3494) {
                            if (hashCode != 115) {
                                if (hashCode == 116 && group4.equals(A08(1374, 1, 68))) {
                                    c = 5;
                                }
                            } else if (group4.equals(A08(IronSourceConstants.RV_AUCTION_SUCCESS, 1, 5))) {
                                c = 2;
                            }
                        } else if (group4.equals(A08(1256, 2, 1))) {
                            c = 3;
                        }
                    } else if (group4.equals(A08(1247, 1, 86))) {
                        c = 1;
                    }
                } else if (group4.equals(A08(1178, 1, 87))) {
                    c = 0;
                }
            } else if (group4.equals(A08(1072, 1, 23))) {
                c = 4;
            }
            if (c == 0) {
                parseDouble2 *= 3600.0d;
            } else if (c == 1) {
                parseDouble2 *= 60.0d;
            } else if (c != 2) {
                if (c == 3) {
                    String[] strArr = A02;
                    if (strArr[1].length() != strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[6] = "4wWFQkJIgDUDxvhbLoyjDEJLfIHbXKXA";
                    strArr2[4] = "i9Tkte0qzP2dvhcWyRZLUYoYUmQQFstK";
                    parseDouble2 /= 1000.0d;
                } else if (c == 4) {
                    parseDouble2 /= (double) gc.A00;
                } else if (c == 5) {
                    parseDouble2 /= (double) gc.A02;
                }
            }
            return (long) (1000000.0d * parseDouble2);
        }
        throw new GH(A08(556, 27, 38) + str);
    }

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 51);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{-69, -61, -98, -91, 113, -52, -8, -2, -11, -19, -9, -80, -3, -87, -20, -5, -18, -22, -3, -18, -87, -31, -10, -11, -39, -2, -11, -11, -39, -22, -5, -4, -18, -5, -49, -22, -20, -3, -8, -5, 2, -87, -14, -9, -4, -3, -22, -9, -20, -18, -43, -16, -8, -5, -12, -13, -81, -1, -16, 1, 2, -8, -3, -10, -81, -15, -16, -14, -6, -10, 1, -2, 4, -3, -13, -81, 5, -16, -5, 4, -12, -55, -81, -117, -90, -82, -79, -86, -87, 101, -75, -90, -73, -72, -82, -77, -84, 101, -88, -76, -79, -76, -73, 101, -69, -90, -79, -70, -86, ByteCompanionObject.MAX_VALUE, 101, -10, 17, 25, 28, 21, 20, -48, 32, 17, 34, 35, 25, 30, 23, -48, 22, 31, 30, 36, 3, 25, 42, 21, -48, 38, 17, 28, 37, 21, -22, -48, -101, -71, -64, -63, -60, -69, -64, -71, 114, -65, -77, -66, -72, -63, -60, -65, -73, -74, 114, -75, -73, -66, -66, 114, -60, -73, -59, -63, -66, -57, -58, -69, -63, -64, -116, 114, -90, -60, -53, -52, -49, -58, -53, -60, 125, -49, -62, -60, -58, -52, -53, 125, -44, -58, -47, -59, 125, -54, -66, -55, -61, -52, -49, -54, -62, -63, 125, -62, -43, -47, -62, -53, -47, -105, 125, -39, -9, -2, -1, 2, -7, -2, -9, -80, 2, -11, -9, -7, -1, -2, -80, 7, -7, 4, -8, -80, -3, -15, -4, -10, -1, 2, -3, -11, -12, -80, -1, 2, -7, -9, -7, -2, -54, -80, -108, -78, -71, -70, -67, -76, -71, -78, 107, -67, -80, -78, -76, -70, -71, 107, -62, -76, -65, -77, 107, -64, -71, -66, -64, -69, -69, -70, -67, -65, -80, -81, 107, -80, -61, -65, -80, -71, -65, -123, 107, -95, -65, -58, -57, -54, -63, -58, -65, 120, -54, -67, -65, -63, -57, -58, 120, -49, -63, -52, -64, 120, -51, -58, -53, -51, -56, -56, -57, -54, -52, -67, -68, 120, -57, -54, -63, -65, -63, -58, -110, 120, -54, -24, -17, -16, -13, -22, -17, -24, -95, -13, -26, -24, -22, -16, -17, -95, -8, -22, -11, -23, -16, -10, -11, -95, -30, -17, -95, -26, -7, -11, -26, -17, -11, -75, -45, -38, -37, -34, -43, -38, -45, -116, -34, -47, -45, -43, -37, -38, -116, -29, -43, -32, -44, -37, -31, -32, -116, -51, -38, -116, -37, -34, -43, -45, -43, -38, -50, -20, -13, -12, -9, -18, -13, -20, -91, -6, -13, -8, -6, -11, -11, -12, -9, -7, -22, -23, -91, -7, -26, -20, -65, -91, -111, -74, -66, -87, -76, -79, -84, 104, -85, -83, -76, -76, 104, -70, -83, -69, -73, -76, -67, -68, -79, -73, -74, 104, -6, 31, 39, 18, 29, 26, 21, -47, 22, 41, 33, 35, 22, 36, 36, 26, 32, 31, -47, 23, 32, 35, -47, 23, 32, 31, 37, 4, 26, 43, 22, -21, -47, -40, -19, 18, 26, 5, 16, 13, 8, -60, 18, 25, 17, 6, 9, 22, -60, 19, 10, -60, 9, 18, 24, 22, 13, 9, 23, -60, 10, 19, 22, -60, 10, 19, 18, 24, -9, 13, 30, 9, -34, -60, -9, 28, 36, 15, 26, 23, 18, -50, 35, 28, 23, 34, -50, 20, 29, 32, -50, 20, 29, 28, 34, 1, 23, 40, 19, -24, -50, -43, -90, -70, -59, -65, -56, -53, -58, -66, -67, 121, -51, -62, -58, -66, 121, -66, -47, -55, -53, -66, -52, -52, -62, -56, -57, -109, 121, -43, -3, -12, -4, -15, -8, -12, -19, -88, -2, -23, -12, -3, -19, -5, -88, -15, -10, -88, -18, -9, -10, -4, -37, -15, 2, -19, -88, -23, -4, -4, -6, -15, -22, -3, -4, -19, -74, -88, -40, -15, -21, -13, -15, -10, -17, -88, -4, -16, -19, -88, -5, -19, -21, -9, -10, -20, -88, -2, -23, -12, -3, -19, -88, -18, -9, -6, -88, -2, -19, -6, -4, -15, -21, -23, -12, -88, -18, -9, -10, -4, -88, -5, -15, 2, -19, -88, -23, -10, -20, -88, -15, -17, -10, -9, -6, -15, -10, -17, -88, -4, -16, -19, -88, -18, -15, -6, -5, -4, -74, 1, 35, 30, 30, 32, 19, 33, 33, 23, 28, 21, -50, 30, 15, 32, 33, 19, 32, -50, 19, 32, 32, 29, 32, -97, -65, -72, -73, -113, -80, -82, -70, -81, -80, -67, -18, 7, -6, -5, 5, -2, -71, 13, 8, -71, -3, -2, -4, 8, -3, -2, -71, 12, 8, 14, 11, -4, -2, -60, -35, -44, -25, -33, -44, -46, -29, -44, -45, -113, -44, -31, -31, -34, -31, -113, -26, -41, -44, -35, -113, -31, -44, -48, -45, -40, -35, -42, -113, -40, -35, -33, -28, -29, -99, -41, -18, -90, 9, -45, -45, 6, -37, -40, -28, 8, -43, -39, -44, -22, 6, -37, -40, -28, 8, -42, -44, -45, 27, 35, 39, 16, 24, 39, -48, -44, -49, -105, 97, -108, 105, 102, 114, -106, 100, 97, 120, 115, -107, 103, -108, 105, 102, 114, -106, 100, 98, 120, 98, 97, -95, -75, -90, -75, -84, -75, -90, -84, -75, -97, -75, -83, 98, 93, -39, -93, -42, -85, -88, -76, -40, -42, -85, -88, -76, -40, -90, -92, -75, -93, -42, -85, -88, -76, -40, -42, -85, -88, -76, -40, -92, -75, -93, -42, -85, -88, -76, -40, -42, -85, -88, -76, -40, -92, -93, -70, -75, -93, -41, -87, -42, -85, -88, -76, -40, -90, -92, -9, -75, -93, -42, -85, -88, -76, -40, -42, -85, -88, -76, -40, -92, -93, -70, -75, -41, -87, -93, -42, -85, -88, -76, -40, -90, -92, -92, -70, -92, -70, -97, -35, -89, -37, -29, -86, -88, -97, -89, -37, -29, -86, -88, -93, -20, -74, -22, -14, -71, -22, -68, -51, -22, -14, -72, -51, -73, -77, -82, -74, -22, -14, -71, -22, -68, -51, -22, -14, -72, -51, -73, -77, -78, -64, -59, -45, -60, -47, -79, -80, -78, -70, -74, -63, -66, -60, -67, -77, -110, -66, -69, -66, -63, -60, -57, -55, -53, -48, -94, -81, -92, -71, -100, -87, -90, -98, -54, -38, -28, -26, -19, -19, -45, -26, -12, -16, -19, -10, -11, -22, -16, -17, -62, -60, -51, -45, -60, -47, -15, -3, -6, -3, 0, -72, -67, -57, -60, -64, -75, -51, -107, -64, -67, -69, -62, -24, -19, -6, -105, -88, -91, -92, -84, -28, -19, -29, -52, -33, -37, -52, -43, -37, -80, -58, -49, -50, -44, -90, -63, -51, -55, -52, -39, -82, -73, -74, -68, -101, -79, -62, -83, -61, -52, -53, -47, -80, -47, -42, -55, -62, -2, 7, 6, 12, -17, -3, 1, -1, 0, 12, -13, -1, -18, -6, -14, -33, -18, 1, -14, -60, -48, -65, -53, -61, -80, -65, -46, -61, -85, -45, -54, -46, -57, -50, -54, -57, -61, -48, 2, 14, -3, 9, 1, -18, -3, 16, 1, -23, 17, 8, 16, 5, 12, 8, 5, 1, 14, -68, 0, 11, 1, 15, 10, -61, 16, -68, 4, -3, 18, 1, -68, -50, -68, 12, -3, 14, 16, 15, -14, 6, 3, -1, 2, 0, 12, 12, 8, -46, -57, -57, 15, 15, 15, -58, 15, -53, -58, 7, 10, -1, -57, 6, 11, -57, 12, 12, 5, 4, -69, 8, -7, 10, -7, 5, -3, 12, -3, 10, 23, 18, -24, -13, -32, -21, -24, -30, -10, -21, 3, -7, -1, -2, -49, -56, -55, -41, -1, -4, 1, -8, 7, -5, 5, 2, 8, -6, -5, -10, 14, 6, 21, 2, 5, 2, 21, 2, -95, -89, 17, 18, 15, 12, 17, 8, 23, 11, 21, 18, 24, 10, 11, -67, -66, -60, -67, -77, -76, -63, -69, -72, -67, -76, -3, 0, -9, -11, -9, -4, -7, -89, -81, -8, -21, -19, -17, -11, -12, -67, -76, -78, -77, -65, -85, -44, -50, -47, -43, -58, -101, -59, -62, -43, -62, -46, -52, -49, -45, -60, -103, -56, -52, -64, -58, -60, 20, 14, 17, 21, 6, -37, 10, 15, 7, 16, 19, 14, 2, 21, 10, 16, 15, 4, 1, -14, -1, -85, -84, -103, -86, -84, 6, 7, 12, -1, -8, -80, -79, -74, -87, -90, -85, -92, 7, 9, -10, -38, 6, -11, 1, -7, -26, -11, 8, -7, -21, 2, -13, 6, 2, -49, -6, -9, -11, -4, -33, -48, -29, -33, -81, -48, -50, -38, -35, -52, -33, -44, -38, -39, -62, -73, -79, -71, -96, -81, -62, -77, -12, -12, -16, -23, -33, -32, -19, -25, -28, -23, -32};
    }

    public static void A0B() {
        A02 = new String[]{"PhyvuE7y18", "xBnTZw3ZbiLDM63QcLiGd0", "O9uX8", "8b1nsz8L9hYpMQj9k3QW3WLnldrKItOm", "IMNHpcvYsehX8cLei6jDJchiF9gMYU0V", "8kdCvXuY1XJXgrxFttVDI6044U6IZeyY", "sEif2eB2MLrj2k4lXiRDbZReHYoJKwJL", "5aPBLAKnhKpgqnxagNkfr0"};
    }

    static {
        A0B();
        A0A();
    }

    public C00822j() {
        super(A08(717, 11, 24));
        try {
            this.A00 = XmlPullParserFactory.newInstance();
            this.A00.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException(A08(5, 45, 86), e);
        }
    }

    private C0409Gb A01(XmlPullParser xmlPullParser, C0409Gb gb) throws GH {
        String attributeValue = xmlPullParser.getAttributeValue(A08(1183, 35, 101), A08(1018, 14, 78));
        if (attributeValue == null) {
            return gb;
        }
        Matcher matcher = A05.matcher(attributeValue);
        boolean matches = matcher.matches();
        String A082 = A08(142, 36, 31);
        String A083 = A08(717, 11, 24);
        if (!matches) {
            Log.w(A083, A082 + attributeValue);
            return gb;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new C0409Gb(parseInt, parseInt2);
            }
            throw new GH(A08(430, 24, 21) + parseInt + A08(0, 1, 104) + parseInt2);
        } catch (NumberFormatException unused) {
            Log.w(A083, A082 + attributeValue);
            return gb;
        }
    }

    /* JADX INFO: Multiple debug info for r6v0 java.lang.String: [D('subFrameRateString' java.lang.String), D('numerator' float)] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a4, code lost:
        if (r0 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e0, code lost:
        if (r0 != null) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.redexgen.X.C0410Gc A02(org.xmlpull.v1.XmlPullParser r10) throws com.facebook.ads.redexgen.X.GH {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00822j.A02(org.xmlpull.v1.XmlPullParser):com.facebook.ads.redexgen.X.Gc");
    }

    /* JADX INFO: Multiple debug info for r2v2 java.lang.String: [D('attr' java.lang.String), D('ids' java.lang.String[])] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private C0411Gd A03(XmlPullParser xmlPullParser, C0411Gd gd, Map<String, C0412Ge> map, C0410Gc gc) throws GH {
        char c;
        C00822j r6 = this;
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        String A082 = A08(0, 0, 105);
        String[] strArr = null;
        int attributeCount = xmlPullParser.getAttributeCount();
        C0417Gj A062 = r6.A06(xmlPullParser, null);
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attr = xmlPullParser.getAttributeValue(i);
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals(A08(1291, 6, 83))) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 99841:
                    if (attributeName.equals(A08(IronSourceError.ERROR_RV_LOAD_NO_FILL, 3, 0))) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (attributeName.equals(A08(1063, 3, 76))) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals(A08(1003, 5, 47))) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals(A08(1350, 5, 96))) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                j2 = A00(attr, gc);
            } else if (c == 1) {
                j3 = A00(attr, gc);
            } else if (c == 2) {
                j = A00(attr, gc);
            } else if (c == 3) {
                String[] A0E = r6.A0E(attr);
                if (A0E.length > 0) {
                    strArr = A0E;
                }
            } else if (c == 4 && map.containsKey(attr)) {
                A082 = attr;
            }
            i++;
            r6 = this;
        }
        if (!(gd == null || gd.A02 == -9223372036854775807L)) {
            if (j2 != -9223372036854775807L) {
                j2 += gd.A02;
            }
            if (j3 != -9223372036854775807L) {
                j3 += gd.A02;
            }
        }
        if (j3 == -9223372036854775807L) {
            if (j != -9223372036854775807L) {
                j3 = j2 + j;
            } else if (!(gd == null || gd.A01 == -9223372036854775807L)) {
                j3 = gd.A01;
            }
        }
        return C0411Gd.A05(xmlPullParser.getName(), j2, j3, A062, strArr, A082);
    }

    /* JADX INFO: Multiple debug info for r0v38 java.lang.String: [D('lineAnchor' int), D('displayAlign' java.lang.String)] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.redexgen.X.C0412Ge A04(org.xmlpull.v1.XmlPullParser r20, com.facebook.ads.redexgen.X.C0409Gb r21) {
        /*
        // Method dump skipped, instructions count: 425
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00822j.A04(org.xmlpull.v1.XmlPullParser, com.facebook.ads.redexgen.X.Gb):com.facebook.ads.redexgen.X.Ge");
    }

    private C0417Gj A05(C0417Gj gj) {
        return gj == null ? new C0417Gj() : gj;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0375, code lost:
        if (r14.equals(r2) != false) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x038a, code lost:
        if (r14.equals(r2) != false) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x023a, code lost:
        if (r2.equals(r10) != false) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x024e, code lost:
        if (r2.equals(r10) != false) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x027a, code lost:
        if (r2.equals(A08(1236, 11, 96)) != false) goto L_0x027c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0289, code lost:
        if (r2.equals(A08(1236, 11, 96)) != false) goto L_0x027c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02dd, code lost:
        if (r14 != false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02e2, code lost:
        if (r14 != false) goto L_0x02df;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.redexgen.X.C0417Gj A06(org.xmlpull.v1.XmlPullParser r17, com.facebook.ads.redexgen.X.C0417Gj r18) {
        /*
        // Method dump skipped, instructions count: 1072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00822j.A06(org.xmlpull.v1.XmlPullParser, com.facebook.ads.redexgen.X.Gj):com.facebook.ads.redexgen.X.Gj");
    }

    /* JADX INFO: Multiple debug info for r0v9 int: [D('inputStream' java.io.ByteArrayInputStream), D('parent' com.facebook.ads.redexgen.X.Gd)] */
    /* JADX INFO: Multiple debug info for r2v5 com.facebook.ads.redexgen.X.Gd: [D('cellResolution' com.facebook.ads.redexgen.X.Gb), D('inputStream' java.io.ByteArrayInputStream)] */
    /* access modifiers changed from: private */
    /* renamed from: A07 */
    public final C0932aJ A0d(byte[] bArr, int i, boolean z) throws GH {
        XmlPullParserException e;
        IOException e2;
        try {
            XmlPullParser newPullParser = this.A00.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(A08(0, 0, 105), new C0412Ge(null));
            try {
                newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
                C0932aJ aJVar = null;
                ArrayDeque arrayDeque = new ArrayDeque();
                int i2 = 0;
                C0410Gc gc = A04;
                C0409Gb gb = A03;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                    C0411Gd gd = (C0411Gd) arrayDeque.peek();
                    if (i2 == 0) {
                        String name = newPullParser.getName();
                        String A082 = A08(1406, 2, 77);
                        if (eventType == 2) {
                            if (A082.equals(name)) {
                                gc = A02(newPullParser);
                                gb = A01(newPullParser, A03);
                            }
                            boolean A0D = A0D(name);
                            String A083 = A08(717, 11, 24);
                            if (!A0D) {
                                Log.i(A083, A08(404, 26, 82) + newPullParser.getName());
                                i2++;
                            } else if (A08(1179, 4, 107).equals(name)) {
                                A09(newPullParser, hashMap, hashMap2, gb);
                            } else {
                                try {
                                    C0411Gd A032 = A03(newPullParser, gd, hashMap2, gc);
                                    arrayDeque.push(A032);
                                    if (gd != null) {
                                        gd.A0F(A032);
                                    }
                                } catch (GH e3) {
                                    Log.w(A083, A08(693, 24, 123), e3);
                                    i2++;
                                }
                            }
                        } else if (eventType == 4) {
                            gd.A0F(C0411Gd.A04(newPullParser.getText()));
                        } else if (eventType == 3) {
                            if (newPullParser.getName().equals(A082)) {
                                aJVar = new C0932aJ((C0411Gd) arrayDeque.peek(), hashMap, hashMap2);
                            }
                            arrayDeque.pop();
                        }
                    } else if (eventType == 2) {
                        i2++;
                    } else if (eventType == 3) {
                        i2--;
                    }
                    newPullParser.next();
                }
                return aJVar;
            } catch (XmlPullParserException e4) {
                e = e4;
                throw new GH(A08(728, 23, 102), e);
            } catch (IOException e5) {
                e2 = e5;
                throw new IllegalStateException(A08(751, 36, 60), e2);
            }
        } catch (XmlPullParserException e6) {
            e = e6;
            throw new GH(A08(728, 23, 102), e);
        } catch (IOException e7) {
            e2 = e7;
            throw new IllegalStateException(A08(751, 36, 60), e2);
        }
    }

    private Map<String, C0417Gj> A09(XmlPullParser xmlPullParser, Map<String, C0417Gj> map, Map<String, C0412Ge> map2, C0409Gb gb) throws IOException, XmlPullParserException {
        C0412Ge A042;
        do {
            xmlPullParser.next();
            String A082 = A08(1350, 5, 96);
            if (C0467Ih.A04(xmlPullParser, A082)) {
                String A002 = C0467Ih.A00(xmlPullParser, A082);
                C0417Gj A062 = A06(xmlPullParser, new C0417Gj());
                if (A002 != null) {
                    for (String str : A0E(A002)) {
                        A062.A0F(map.get(str));
                        if (A02[0].length() != 24) {
                            String[] strArr = A02;
                            strArr[3] = "r1XXjzavA19mnteqm7IXmxWY8MBC2sF6";
                            strArr[3] = "r1XXjzavA19mnteqm7IXmxWY8MBC2sF6";
                        } else {
                            throw new RuntimeException();
                        }
                    }
                }
                if (A062.A0N() != null) {
                    map.put(A062.A0N(), A062);
                }
            } else if (C0467Ih.A04(xmlPullParser, A08(1291, 6, 83)) && (A042 = A04(xmlPullParser, gb)) != null) {
                map2.put(A042.A07, A042);
            }
        } while (!C0467Ih.A03(xmlPullParser, A08(1179, 4, 107)));
        return map;
    }

    public static void A0C(String str, C0417Gj gj) throws GH {
        Matcher matcher;
        String[] A0m = C0466Ig.A0m(str, A08(787, 3, 72));
        if (A0m.length == 1) {
            matcher = A07.matcher(str);
        } else if (A0m.length == 2) {
            matcher = A07.matcher(A0m[1]);
            Log.w(A08(717, 11, 24), A08(583, 110, 85));
        } else {
            throw new GH(A08(488, 40, 113) + A0m.length + A08(4, 1, 16));
        }
        boolean matches = matcher.matches();
        String A082 = A08(2, 2, 68);
        if (matches) {
            String group = matcher.group(3);
            char c = 65535;
            int hashCode = group.hashCode();
            if (hashCode != 37) {
                if (A02[5].charAt(9) != 'f') {
                    String[] strArr = A02;
                    strArr[2] = "t0LdGmQ0v8qyO2";
                    strArr[2] = "t0LdGmQ0v8qyO2";
                    if (hashCode != 3240) {
                        if (hashCode == 3592 && group.equals(A08(1289, 2, 4))) {
                            c = 0;
                        }
                    } else if (group.equals(A08(IronSourceError.ERROR_DO_IS_LOAD_MISSING_ACTIVITY, 2, 12))) {
                        c = 1;
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (group.equals(A08(1, 1, 107))) {
                c = 2;
            }
            if (c == 0) {
                gj.A0D(1);
            } else if (c == 1) {
                gj.A0D(2);
            } else if (c == 2) {
                gj.A0D(3);
            } else {
                throw new GH(A08(528, 28, 123) + group + A082);
            }
            float floatValue = Float.valueOf(matcher.group(1)).floatValue();
            String[] strArr2 = A02;
            if (strArr2[1].length() != strArr2[7].length()) {
                String[] strArr3 = A02;
                strArr3[1] = "urdYGq7WwvJk1zliqVN4P2";
                strArr3[7] = "ZdoJtzuRVAPxJXqYig85Db";
                gj.A0A(floatValue);
                return;
            }
            String[] strArr4 = A02;
            strArr4[1] = "Kk4kf6fnicwp8j22CAgUPO";
            strArr4[7] = "fW8tIDgKJv3U6D0UEBEE9j";
            gj.A0A(floatValue);
            return;
        }
        throw new GH(A08(454, 34, 126) + str + A082);
    }

    public static boolean A0D(String str) {
        return str.equals(A08(1406, 2, 77)) || str.equals(A08(1179, 4, 107)) || str.equals(A08(1008, 4, 13)) || str.equals(A08(IronSourceError.ERROR_DO_RV_LOAD_TIMED_OUT, 3, 81)) || str.equals(A08(1288, 1, 86)) || str.equals(A08(1341, 4, 94)) || str.equals(A08(1016, 2, 53)) || str.equals(A08(1350, 5, 96)) || str.equals(A08(1355, 7, 10)) || str.equals(A08(1226, 6, 87)) || str.equals(A08(1291, 6, 83)) || str.equals(A08(1248, 8, 110)) || str.equals(A08(1313, 11, 44)) || str.equals(A08(1303, 10, 46)) || str.equals(A08(1324, 17, 110));
    }

    private String[] A0E(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : C0466Ig.A0m(trim, A08(787, 3, 72));
    }
}
