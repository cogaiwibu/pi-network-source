package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Qx  reason: case insensitive filesystem */
public final class C0683Qx implements AnonymousClass0L {
    public static String A07 = C0683Qx.class.getSimpleName();
    public static byte[] A08;
    public static String[] A09;
    public int A00;
    public InputStream A01;
    public HttpURLConnection A02;
    public final String A03;
    public volatile int A04;
    public volatile int A05;
    @Nullable
    public volatile String A06;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] - i3) - 93);
            if (A09[7].charAt(10) != 'N') {
                String[] strArr = A09;
                strArr[3] = "xmylGJpTyqy6yVXTtCE3KaogQJsBWdto";
                strArr[3] = "xmylGJpTyqy6yVXTtCE3KaogQJsBWdto";
                copyOfRange[i4] = b;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-65, 8, 18, -65, 8, 13, 19, 4, 17, 17, 20, 15, 19, 4, 3, -65, 19, 14, -65, -45, 42, 28, 39, 27, -45, 34, 25, 25, 38, 24, 39, -45, -19, -31, 36, 48, 47, 53, 38, 47, 53, -18, 45, 38, 47, 40, 53, 41, -5, -31, -100, -84, -110, -43, -31, -32, -32, -41, -43, -26, -37, -31, -32, -110, -37, -27, -110, -45, -44, -27, -41, -32, -26, -109, 8, 52, 51, 57, 42, 51, 57, -27, 46, 51, 43, 52, -27, 43, 52, 55, -27, 37, -1, 44, 44, 41, 44, -38, 30, 35, 45, 29, 41, 40, 40, 31, 29, 46, 35, 40, 33, -38, 2, 46, 46, 42, 15, 44, 38, -3, 41, 40, 40, 31, 29, 46, 35, 41, 40, -17, 28, 28, 25, 28, -54, 16, 15, 30, 13, 18, 19, 24, 17, -54, 19, 24, 16, 25, -54, 16, 28, 25, 23, -54, -31, 14, 14, 11, 14, -68, 11, 12, 1, 10, 5, 10, 3, -68, -1, 11, 10, 10, 1, -1, 16, 5, 11, 10, -68, 2, 11, 14, -68, 10, 55, 55, 52, 55, -27, 55, 42, 38, 41, 46, 51, 44, -27, 41, 38, 57, 38, -27, 43, 55, 52, 50, -27, -50, -6, -6, -10, -37, -8, -14, -39, -11, -5, -8, -23, -21, 1, -5, -8, -14, -61, -83, -38, -3, -15, -17, 2, -9, -3, -4, 18, 51, 40, 49, -29, 38, 50, 49, 49, 40, 38, 55, 44, 50, 49, -29, -21, -6, 7, 0, -2, -53, -34, -38, -35, -103, -36, -24, -25, -19, -34, -25, -19, -103, -30, -25, -33, -24, -103, -33, -21, -24, -26, -103, 15, 34, 30, 33, 38, 43, 36, -35, 48, 44, 50, 47, 32, 34, -35, 27, 54, 54, -25, 52, 40, 53, 64, -25, 57, 44, 43, 48, 57, 44, 42, 59, 58, 1, -25, -9, -47, -73, 4, 0, 4, -4, -47, -73, 62, 85, 80, 65, 79, 25, 49};
    }

    public static void A05() {
        A09 = new String[]{"0sQYFfkZHHeVMKUBSEw8nV", "OMjsYZjecgzBPFsO2qu9DXSbxh5JXpo7", "UT2rHb55ERwVxNOqpRWPVvfe1UkWVyPP", "dnZnJ0uYb7k8tLcQy7f3QyFDUQrwjEiR", "oxpcdWRNT0kUjhHWpmvIkR5l", "M5dLDfrAE2TxcxVuZGCd0hZ7u7RiqVG3", "YVmAwTI", "30bRwIya64cDsyZ9K4ZP4bQrXzvqCneG"};
    }

    static {
        A05();
        A04();
    }

    public C0683Qx(String str) {
        this(str, AnonymousClass0J.A01(str));
    }

    public C0683Qx(String str, int i) {
        this(str);
        this.A00 = i;
    }

    public C0683Qx(String str, @Nullable String str2) {
        this.A05 = Integer.MIN_VALUE;
        this.A00 = -1;
        this.A03 = (String) AnonymousClass0K.A00(str);
        this.A06 = str2;
    }

    private int A00(HttpURLConnection httpURLConnection, int i, int i2) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        if (i2 == 200) {
            return contentLength;
        }
        return i2 == 206 ? contentLength + i : this.A05;
    }

    private HttpURLConnection A02(int i, int i2) throws IOException, C0681Qv {
        String A012;
        HttpURLConnection httpURLConnection;
        boolean z;
        int code = 0;
        String str = this.A03;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append(A01(234, 16, 102));
            if (i > 0) {
                A012 = A01(19, 13, 86) + i;
            } else {
                A012 = A01(0, 0, 78);
            }
            sb.append(A012);
            sb.append(A01(15, 4, 66));
            sb.append(str);
            sb.toString();
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty(A01(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, 5, 60), A01(322, 6, 127) + i + A01(50, 1, 18));
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            this.A04 = responseCode;
            String[] strArr = A09;
            if (strArr[1].charAt(4) != strArr[5].charAt(4)) {
                String[] strArr2 = A09;
                strArr2[2] = "PLgwygtF0FJvu0SiSas8utQP577qcxnM";
                strArr2[0] = "YPLv6eSsZkmOoYsRk43xhT";
                if (responseCode == 301 || responseCode == 302 || responseCode == 303) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = httpURLConnection.getHeaderField(A01(226, 8, 49));
                    code++;
                    httpURLConnection.disconnect();
                }
                if (code > 5) {
                    throw new C0681Qv(A01(293, 20, 106) + code);
                }
            } else {
                throw new RuntimeException();
            }
        } while (z);
        return httpURLConnection;
    }

    private void A03() throws C0681Qv {
        String str = A01(255, 23, 28) + this.A03;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try {
            httpURLConnection = A02(0, 10000);
            this.A05 = httpURLConnection.getContentLength();
            this.A06 = httpURLConnection.getContentType();
            inputStream = httpURLConnection.getInputStream();
            Log.i(A07, A01(74, 18, 104) + this.A03 + A01(313, 9, 58) + this.A06 + A01(32, 18, 100) + this.A05);
            AnonymousClass0J.A06(inputStream);
        } catch (IOException e) {
            Log.e(A07, A01(129, 25, 77) + this.A03, e);
            AnonymousClass0J.A06(inputStream);
            if (httpURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            AnonymousClass0J.A06(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private final void A06(int i, int i2) throws C0681Qv {
        try {
            this.A02 = A02(i, i2);
            this.A06 = this.A02.getContentType();
            this.A01 = new BufferedInputStream(this.A02.getInputStream(), 8192);
            this.A05 = A00(this.A02, i, this.A02.getResponseCode());
        } catch (IOException e) {
            throw new C0681Qv(A01(154, 29, 63) + this.A03 + A01(19, 13, 86) + i, e);
        }
    }

    public final int A07() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final void ABQ(int i) throws C0681Qv {
        A06(i, this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final void close() throws C0681Qv {
        HttpURLConnection httpURLConnection = this.A02;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (NullPointerException e) {
                throw new C0681Qv(A01(92, 37, 93), e);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final synchronized int length() throws C0681Qv {
        int i;
        int i2 = this.A05;
        if (A09[3].charAt(23) != 'b') {
            String[] strArr = A09;
            strArr[6] = "Gd5nVqL";
            strArr[4] = "KpxMbBcDmaRKResopmSYXqpZ";
            if (i2 == Integer.MIN_VALUE) {
                A03();
            }
            i = this.A05;
        } else {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        if (strArr2[6].length() != strArr2[4].length()) {
            String[] strArr3 = A09;
            strArr3[3] = "gS2RFCMrZVvAwZylX045evNEUJ7fs3DK";
            strArr3[3] = "gS2RFCMrZVvAwZylX045evNEUJ7fs3DK";
            return i;
        }
        String[] strArr4 = A09;
        strArr4[6] = "lavKIXl";
        strArr4[4] = "xddCZzh8okNZPw2KOzu6FC9g";
        return i;
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.Qx: [D('e' java.io.InterruptedIOException), D('e' java.io.IOException)] */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final int read(byte[] bArr) throws C0681Qv {
        InputStream inputStream = this.A01;
        String A012 = A01(183, 24, 104);
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new C0390Fg(A01(278, 15, 96) + this.A03 + A01(0, 15, 66), e);
            } catch (IOException e2) {
                throw new C0681Qv(A012 + this.A03, e2);
            }
        } else {
            throw new C0681Qv(A012 + this.A03 + A01(51, 23, 21));
        }
    }

    public final String toString() {
        return A01(207, 19, 41) + this.A03 + A01(328, 1, 87);
    }
}
