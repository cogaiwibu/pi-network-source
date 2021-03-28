package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.ByteCompanionObject;

public final class A5 implements AbstractC0959ak {
    public static byte[] A0G;
    public static String[] A0H;
    public static final AtomicReference<byte[]> A0I = new AtomicReference<>();
    public static final Pattern A0J = Pattern.compile(A03(300, 25, 29));
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public HQ A04;
    public InputStream A05;
    public HttpURLConnection A06;
    public boolean A07;
    public final int A08;
    public final int A09;
    public final HW A0A;
    public final HW A0B = new HW();
    public final AbstractC0441Hh<? super A5> A0C;
    public final IS<String> A0D;
    public final String A0E;
    public final boolean A0F;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] ^ i3;
            String[] strArr = A0H;
            if (strArr[0].length() != strArr[1].length()) {
                String[] strArr2 = A0H;
                strArr2[0] = "a9yJ7ENBXfuIUHaNhs8YhzHERJT";
                strArr2[1] = "38v";
                copyOfRange[i4] = (byte) (i5 ^ 114);
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0G = new byte[]{31, 92, 126, 126, 120, 109, 105, 48, 88, 115, 126, 114, 121, 116, 115, 122, 8, 36, 37, 63, 46, 37, 63, 102, 7, 46, 37, 44, 63, 35, 84, 120, 121, 99, 114, 121, 99, 58, 69, 118, 121, 112, 114, 22, 55, 52, 51, 39, 62, 38, 26, 38, 38, 34, 22, 51, 38, 51, 1, 61, 39, 32, 49, 55, 82, 117, 120, 116, 117, 104, 114, 104, 111, 126, 117, 111, 59, 115, 126, 122, ByteCompanionObject.MAX_VALUE, 126, 105, 104, 59, 64, 48, 19, 31, 29, 8, 21, 19, 18, 38, 29, 4, 4, 72, 4, 7, 11, 9, 28, 1, 7, 6, 72, 26, 13, 12, 1, 26, 13, 11, 28, 54, 41, 53, 50, 109, 94, 81, 88, 90, 7, 60, 60, 115, 62, 50, 61, 42, 115, 33, 54, 55, 58, 33, 54, 48, 39, 32, 105, 115, 6, 61, 50, 49, 63, 54, 115, 39, 60, 115, 48, 60, 61, 61, 54, 48, 39, 115, 39, 60, 115, 45, 22, 29, 0, 8, 29, 27, 12, 29, 28, 88, 59, 23, 22, 12, 29, 22, 12, 85, 52, 29, 22, 31, 12, 16, 88, 35, ByteCompanionObject.MAX_VALUE, 68, 79, 82, 90, 79, 73, 94, 79, 78, 10, 105, 69, 68, 94, 79, 68, 94, 7, 120, 75, 68, 77, 79, 10, 113, 59, 0, 11, 22, 30, 11, 13, 26, 11, 10, 78, 11, 28, 28, 1, 28, 78, 25, 6, 7, 2, 11, 78, 10, 7, 29, 13, 1, 0, 0, 11, 13, 26, 7, 0, 9, 59, 0, 29, 27, 30, 30, 1, 28, 26, 11, 10, 78, 30, 28, 1, 26, 1, 13, 1, 2, 78, 28, 11, 10, 7, 28, 11, 13, 26, 84, 78, 23, 49, 39, 48, 111, 3, 37, 39, 44, 54, 122, 2, ByteCompanionObject.MAX_VALUE, 4, 49, 13, 22, 27, 10, 28, 79, 71, 51, 11, 68, 70, 66, 71, 51, 11, 68, 70, 64, 71, 51, 11, 68, 70, 75, 11, 16, 29, 12, 26, 84, 115, ByteCompanionObject.MAX_VALUE, 125, 62, 113, 126, 116, 98, ByteCompanionObject.MAX_VALUE, 121, 116, 62, ByteCompanionObject.MAX_VALUE, 123, 120, 100, 100, 96, 62, 121, 126, 100, 117, 98, 126, 113, 124, 62, 120, 100, 100, 96, 62, 88, 100, 100, 96, 68, 98, 113, 126, 99, 96, ByteCompanionObject.MAX_VALUE, 98, 100, 52, 83, 120, 101, 126, 123, 117, 116, 89, 126, 96, 101, 100, 67, 100, 98, 117, 113, 125, 41, 37, 39, 100, 43, 36, 46, 56, 37, 35, 46, 100, 37, 33, 34, 62, 62, 58, 100, 35, 36, 62, 47, 56, 36, 43, 38, 100, 34, 62, 62, 58, 100, 2, 62, 62, 58, 30, 56, 43, 36, 57, 58, 37, 56, 62, 110, 12, 35, 50, 47, 46, 6, 47, 36, 45, 62, 34, 3, 36, 58, 63, 62, 25, 62, 56, 47, 43, 39, 55, 43, 43, 47, 11, 23, 23, 19, 16, 2, 15, 14, 5, 31, 2, 31, 18, 126, 101, 110, 115, 123, 110, 104, ByteCompanionObject.MAX_VALUE, 110, 111, 78, 101, 111, 68, 109, 66, 101, 123, 126, ByteCompanionObject.MAX_VALUE};
    }

    public static void A0A() {
        A0H = new String[]{"8Cwpq0myFqrjMYQXCF426Bvv7lF", "BCZ", "9QEkehaQ45REYiwwIXw9otHnKiruCzQN", "DxeLZUhsDe6Etn8eMTd", "i0KDABCUI1wPuXC", "cHzp87p", "Z4Mhgoj", "Wxs5ICSBRzcNleT3VwYrHD2lep8WMSnM"};
    }

    static {
        A0A();
        A09();
    }

    public A5(String str, IS<String> is, AbstractC0441Hh<? super A5> hh, int i, int i2, boolean z, HW hw) {
        this.A0E = I1.A02(str);
        this.A0D = is;
        this.A0C = hh;
        this.A08 = i;
        this.A09 = i2;
        this.A0F = z;
        this.A0A = hw;
    }

    /* JADX INFO: Multiple debug info for r9v0 'this'  com.facebook.ads.redexgen.X.A5: [D('bytesRemaining' long), D('read' int)] */
    private int A00(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A02;
        String[] strArr = A0H;
        if (strArr[0].length() != strArr[1].length()) {
            String[] strArr2 = A0H;
            strArr2[0] = "bWPLRd721NhcJPFUmTbRIXPAhQ9";
            strArr2[1] = "JEA";
            if (j != -1) {
                long j2 = j - this.A00;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j2);
            }
            int read = this.A05.read(bArr, i, i2);
            String[] strArr3 = A0H;
            if (strArr3[6].length() != strArr3[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0H;
            strArr4[0] = "AfChosDvH2k0xVUSu60NEuB2wOO";
            strArr4[1] = "7R7";
            if (read != -1) {
                this.A00 += (long) read;
                AbstractC0441Hh<? super A5> hh = this.A0C;
                if (hh != null) {
                    hh.A95(this, read);
                }
                return read;
            } else if (this.A02 == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } else {
            throw new RuntimeException();
        }
    }

    private final long A01() {
        long j = this.A02;
        return j == -1 ? j : j - this.A00;
    }

    public static long A02(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField(A03(16, 14, 57));
        boolean isEmpty = TextUtils.isEmpty(headerField);
        String A032 = A03(296, 1, 85);
        String A033 = A03(43, 21, 32);
        if (!isEmpty) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                Log.e(A033, A03(166, 27, 10) + headerField + A032);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField(A03(30, 13, 101));
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = A0J.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w(A033, A03(64, 22, 105) + headerField + A03(297, 3, 45) + headerField2 + A032);
            return Math.max(j, parseLong);
        } catch (NumberFormatException unused2) {
            Log.e(A033, A03(193, 26, 88) + headerField2 + A032);
            return j;
        }
    }

    private HttpURLConnection A04(HQ hq) throws IOException {
        HttpURLConnection A052;
        URL url = new URL(hq.A04.toString());
        byte[] bArr = hq.A06;
        long j = hq.A03;
        long j2 = hq.A02;
        boolean A022 = hq.A02(1);
        if (this.A0F) {
            int redirectCount = 0;
            while (true) {
                int i = redirectCount + 1;
                if (redirectCount <= 20) {
                    A052 = A05(url, bArr, j, j2, A022, false);
                    int responseCode = A052.getResponseCode();
                    if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                        bArr = null;
                        String headerField = A052.getHeaderField(A03(86, 8, 14));
                        A052.disconnect();
                        url = A06(url, headerField);
                        redirectCount = i;
                    }
                } else {
                    throw new NoRouteToHostException(A03(125, 20, 33) + i);
                }
            }
            return A052;
        } else if (A0H[4].length() != 2) {
            String[] strArr = A0H;
            strArr[3] = "AfmLjTAqEjfBoFvfwAy";
            strArr[3] = "AfmLjTAqEjfBoFvfwAy";
            return A05(url, bArr, j, j2, A022, true);
        } else {
            throw new RuntimeException();
        }
    }

    private HttpURLConnection A05(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.A08);
        httpURLConnection.setReadTimeout(this.A09);
        HW hw = this.A0A;
        if (hw != null) {
            for (Map.Entry<String, String> entry : hw.A00().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.A0B.A00().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            String str = A03(325, 6, 27) + j + A03(0, 1, 64);
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty(A03(120, 5, 77), str);
        }
        httpURLConnection.setRequestProperty(A03(286, 10, 48), this.A0E);
        if (!z) {
            httpURLConnection.setRequestProperty(A03(1, 15, 111), A03(474, 8, 25));
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (A0H[2].charAt(11) != 'E') {
            throw new RuntimeException();
        }
        String[] strArr = A0H;
        strArr[7] = "Y4214PJ0d833V29vzm0V8RPiGXomA3ZU";
        strArr[7] = "Y4214PJ0d833V29vzm0V8RPiGXomA3ZU";
        if (bArr != null) {
            httpURLConnection.setRequestMethod(A03(116, 4, 20));
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public static URL A06(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (A03(469, 5, 17).equals(protocol) || A03(465, 4, 45).equals(protocol)) {
                return url2;
            }
            throw new ProtocolException(A03(255, 31, 28) + protocol);
        }
        throw new ProtocolException(A03(94, 22, 26));
    }

    private void A07() {
        HttpURLConnection httpURLConnection = this.A06;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e(A03(43, 21, 32), A03(219, 36, 28), e);
            }
            this.A06 = null;
        }
    }

    private void A08() throws IOException {
        if (this.A01 != this.A03) {
            byte[] andSet = A0I.getAndSet(null);
            if (andSet == null) {
                andSet = new byte[4096];
            }
            while (true) {
                long j = this.A01;
                long j2 = this.A03;
                if (j != j2) {
                    int read = this.A05.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (!Thread.currentThread().isInterrupted()) {
                        String[] strArr = A0H;
                        if (strArr[0].length() != strArr[1].length()) {
                            String[] strArr2 = A0H;
                            strArr2[2] = "xCxIxiNgjMSECsgVhCWdWfEPU1XUNw0H";
                            strArr2[2] = "xCxIxiNgjMSECsgVhCWdWfEPU1XUNw0H";
                            if (read != -1) {
                                this.A01 += (long) read;
                                AbstractC0441Hh<? super A5> hh = this.A0C;
                                if (hh != null) {
                                    hh.A95(this, read);
                                }
                            } else {
                                throw new EOFException();
                            }
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        throw new InterruptedIOException();
                    }
                } else {
                    A0I.set(andSet);
                    return;
                }
            }
        }
    }

    public static void A0B(HttpURLConnection httpURLConnection, long j) {
        if (C0466Ig.A02 == 19 || C0466Ig.A02 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j != -1) {
                    int i = (j > PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH ? 1 : (j == PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH ? 0 : -1));
                    if (A0H[4].length() != 2) {
                        String[] strArr = A0H;
                        strArr[7] = "fvAwzL9wombuya3LmhGM8hGg4ouN1XgQ";
                        strArr[7] = "fvAwzL9wombuya3LmhGM8hGg4ouN1XgQ";
                        if (i <= 0) {
                            return;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } else if (inputStream.read() == -1) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (A03(331, 65, 98).equals(name) || A03(396, 69, 56).equals(name)) {
                    Method unexpectedEndOfInput = inputStream.getClass().getSuperclass().getDeclaredMethod(A03(482, 20, 121), new Class[0]);
                    unexpectedEndOfInput.setAccessible(true);
                    unexpectedEndOfInput.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final Uri A7C() {
        HttpURLConnection httpURLConnection = this.A06;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX INFO: Multiple debug info for r11v0 com.facebook.ads.redexgen.X.HQ: [D('headers' java.util.Map<java.lang.String, java.util.List<java.lang.String>>), D('e' java.io.IOException)] */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        if (r5 != -1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r5 != -1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b8, code lost:
        r5 = A02(r10.A06);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c0, code lost:
        if (r5 == r2) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
        r2 = r5 - r10.A03;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c6, code lost:
        r10.A02 = r2;
     */
    @Override // com.facebook.ads.redexgen.X.HM
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ABP(com.facebook.ads.redexgen.X.HQ r11) throws com.facebook.ads.redexgen.X.HV {
        /*
        // Method dump skipped, instructions count: 303
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.A5.ABP(com.facebook.ads.redexgen.X.HQ):long");
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws HV {
        try {
            if (this.A05 != null) {
                A0B(this.A06, A01());
                try {
                    this.A05.close();
                } catch (IOException e) {
                    throw new HV(e, this.A04, 3);
                }
            }
            this.A05 = null;
            if (A0H[3].length() != 19) {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[0] = "hQ3mc1CdxqPeh2AA8lkYs0MW7MP";
            strArr[1] = "PCj";
            A07();
            if (this.A07) {
                this.A07 = false;
                AbstractC0441Hh<? super A5> hh = this.A0C;
                if (hh != null) {
                    hh.AB9(this);
                }
            }
        } catch (Throwable th) {
            this.A05 = null;
            A07();
            if (this.A07) {
                this.A07 = false;
                AbstractC0441Hh<? super A5> hh2 = this.A0C;
                if (hh2 != null) {
                    hh2.AB9(this);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws HV {
        try {
            A08();
            return A00(bArr, i, i2);
        } catch (IOException e) {
            throw new HV(e, this.A04, 2);
        }
    }
}
