package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;

public final class G2 implements AbstractC0646Pm {
    public static byte[] A07;
    public static String[] A08;
    public static final String A09 = AbstractC0646Pm.class.getSimpleName();
    public AbstractC02238h A00;
    public Executor A01;
    public boolean A02;
    public C0651Pr A03;
    public Q2 A04 = new G1();
    public final AbstractC0656Pw A05 = new G9();
    public final Q1 A06;

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A07 = new byte[]{16, 18, 55, 58, 95, 55, 53, 74, 71, 14, 74, 72, 15, 76, 90, 93, 67, 15, 14, 71, 93, 14, 64, 65, 90, 14, 79, 14, 88, 79, 66, 71, 74, 14, 123, 124, 98, 14, 65, 72, 14, 94, 102, 106, 9, 30, 106, 119, 106, 28, 16, 98, 100, 16, 13, 16, 55, 59, 111, 105, 98, 114, 117, 124, 59, 81, 17, 59, 50, 63, 46, 45, 59, 58, 94, 42, 55, 51, 59, 94, 67, 94, 1, 35, 50, 50, 47, 40, 33, 102, 50, 46, 35, 102, 46, 50, 50, 54, 102, 52, 35, 53, 54, 41, 40, 53, 35, 102, 50, 47, 43, 35, 34, 102, 41, 51, 50, 61, 60, 46, 69, 80, 22, 7, 7, 27, 30, 20, 22, 3, 30, 24, 25, 88, 15, 90, 0, 0, 0, 90, 17, 24, 5, 26, 90, 2, 5, 27, 18, 25, 20, 24, 19, 18, 19, 76, 20, 31, 22, 5, 4, 18, 3, 74, 34, 35, 49, 90, 79, 120, 110, 105, 119, 59, 54, 112, 59, 54, 114, 34, 41, 56, 59, 35, 62, 39};
    }

    public static void A0A() {
        A08 = new String[]{"Z3ZBH3trhaxMswGoeO0i3WMhBsCqcWgs", "P814sFImmOC", "INcscN3Z5kcfIuBeknVxelrdNm8ANoXs", "RvJjsajerkLdUat3TDI8NPR3DDSWtO", "ZLSXhw", "wxtWSqUF9a7Aw2d1StIocmcoa4QX", "58xAXbC3p", "Zj1UZNXOzFX"};
    }

    static {
        A0A();
        A09();
    }

    public G2(C0651Pr pr, AbstractC02238h r3, Executor executor) {
        A0B();
        this.A03 = pr;
        this.A06 = new AnonymousClass4E(this);
        this.A01 = executor;
        this.A00 = r3;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = this.A06.ABU(httpURLConnection);
            if (outputStream != null) {
                this.A06.ADx(outputStream, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Multiple debug info for r8v0 'this'  com.facebook.ads.redexgen.X.G2: [D('httpResponse' com.facebook.ads.redexgen.X.Pl), D('e' java.lang.Exception)] */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:54|55|(2:80|91)(4:70|(2:72|(1:74)(2:78|79))|(1:76)|77)) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f9, code lost:
        if (0 == 0) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0107, code lost:
        if (r8.A04.A7f() != false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0109, code lost:
        r5 = r8.A04;
        r2 = com.facebook.ads.redexgen.X.G2.A08;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x011d, code lost:
        if (r2[0].charAt(28) != r2[2].charAt(28)) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x011f, code lost:
        r2 = com.facebook.ads.redexgen.X.G2.A08;
        r2[1] = "yaq9HQ3M3BI";
        r2[7] = "lkFDbfWlXmK";
        r5.A8F(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012e, code lost:
        if (0 != 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0130, code lost:
        r4.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0139, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        throw new com.facebook.ads.redexgen.X.C0659Pz(r1, null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00d4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.ads.redexgen.X.AbstractC0645Pl A01(com.facebook.ads.redexgen.X.AbstractC0658Py r9) throws com.facebook.ads.redexgen.X.C0659Pz {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G2.A01(com.facebook.ads.redexgen.X.Py):com.facebook.ads.redexgen.X.Pl");
    }

    @Nullable
    private final AbstractC0645Pl A02(AbstractC0658Py py) {
        if (this.A03.A04()) {
            A0C(py);
        }
        AbstractC0645Pl pl = null;
        try {
            pl = A01(py);
            return pl;
        } catch (C0659Pz e) {
            this.A06.A9Z(e);
            return pl;
        } catch (Exception e2) {
            this.A06.A9Z(new C0659Pz(e2, pl));
            return pl;
        }
    }

    @Nullable
    private final AbstractC0645Pl A03(String str, Q0 q0, C0654Pu pu) {
        return A02(new G6(str, q0, pu));
    }

    @Nullable
    private final AbstractC0645Pl A04(String str, String str2, byte[] bArr, C0654Pu pu) {
        return A02(new G5(str, null, str2, bArr, pu));
    }

    private final AbstractC0645Pl A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                bArr = this.A06.AC4(inputStream);
            }
            return new G3(httpURLConnection, bArr);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final AbstractC0645Pl A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = this.A06.ABT(httpURLConnection);
            if (inputStream != null) {
                bArr = this.A06.AC4(inputStream);
            }
            return new G3(httpURLConnection, bArr);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final HttpURLConnection A08(String str) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A06.ABS(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + A07(18, 19, 115), e);
        }
    }

    public static synchronized void A0B() {
        synchronized (G2.class) {
            if (CookieHandler.getDefault() == null) {
                CookieHandler.setDefault(new CookieManager());
            }
        }
    }

    private void A0C(AbstractC0658Py py) {
        StringBuilder sb = new StringBuilder(A07(169, 10, 70));
        boolean equals = py.A03().equals(EnumC0657Px.A06);
        String A072 = A07(41, 1, 33);
        if (equals && py.A06() != null) {
            sb.append(A07(7, 5, 55));
            sb.append(new String(py.A06(), Charset.forName(A07(117, 5, 53))));
            sb.append(A072);
        }
        Map<String, String> A062 = py.A02().A06();
        String[] strArr = A08;
        if (strArr[1].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "s0c02ga9sXqOOqZgqzjFkG4II3gfLx";
        strArr2[6] = "iECV1gT3x";
        for (Map.Entry<String, String> entry : A062.entrySet()) {
            sb.append(A07(2, 5, 74));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 118));
            sb.append(entry.getValue());
            sb.append(A072);
        }
        sb.append(A07(0, 2, 109));
        sb.append(py.A05());
        sb.append(A072);
        String sb2 = sb.toString();
        A0E(sb2, 1, (sb2.length() / 4000) + 1);
    }

    private void A0D(AbstractC0658Py py, AbstractC0647Pn pn) {
        this.A05.A5P(this, pn, this.A01).A4z(py);
        if (this.A03.A04()) {
            A0C(py);
        }
    }

    private void A0E(String str, int i, int i2) {
        String str2 = A09 + A07(12, 6, 114) + i + A07(65, 1, 35) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i + 1, i2);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, AbstractC0647Pn pn, C0654Pu pu) {
        A0D(new G5(str, null, str2, bArr, pu), pn);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC0658Py py) {
        Map<String, String> A062 = py.A02().A06();
        AbstractC0644Pk A052 = py.A02().A05();
        for (String str : A062.keySet()) {
            httpURLConnection.setRequestProperty(str, A062.get(str));
        }
        if (A052 != null) {
            Map<String, String> A5C = A052.A5C(this.A03.A03());
            for (String str2 : A5C.keySet()) {
                httpURLConnection.setRequestProperty(str2, A5C.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC0658Py py) throws IOException {
        C0654Pu A022 = py.A02();
        httpURLConnection.setConnectTimeout(A022.A00());
        httpURLConnection.setReadTimeout(A022.A02());
        this.A06.ABk(httpURLConnection, py.A03(), py.A04());
    }

    private final boolean A0I(Throwable th, long j, AbstractC0658Py py) {
        C0654Pu A022 = py.A02();
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.A04.A7f()) {
            Q2 q2 = this.A04;
            q2.A7u(A07(67, 15, 35) + currentTimeMillis + A07(42, 7, 23) + A022.A00() + A07(49, 7, 109) + A022.A02());
        }
        if (!this.A02) {
            long A002 = (long) A022.A00();
            if (A08[5].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[3] = "UT6xnSlzbr9JaeC9T1uoRQiwoDXC3Y";
            strArr[6] = "g5URFCrsk";
            if (currentTimeMillis >= A002) {
                return true;
            }
            return false;
        } else if (currentTimeMillis >= ((long) A022.A02())) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.ads.redexgen.X.AbstractC0645Pl A0J(com.facebook.ads.redexgen.X.AbstractC0658Py r31) throws com.facebook.ads.redexgen.X.C0659Pz {
        /*
        // Method dump skipped, instructions count: 534
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G2.A0J(com.facebook.ads.redexgen.X.Py):com.facebook.ads.redexgen.X.Pl");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0646Pm
    @Nullable
    @Deprecated
    public final AbstractC0645Pl ABc(String str, Map<String, String> map) {
        return A03(str, new Q0(map), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0646Pm
    @Nullable
    @Deprecated
    public final AbstractC0645Pl ABd(String str, byte[] bArr) {
        return A04(str, A07(122, 47, 42), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0646Pm
    public final void ABe(String str, byte[] bArr, AbstractC0647Pn pn) {
        A0F(str, A07(122, 47, 42), bArr, pn, this.A03.A00());
    }
}
