package com.facebook.ads.redexgen.X;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public abstract class G8 implements Q1 {
    public static byte[] A01;
    public static String[] A02;
    public final Q2 A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{89, 123, 123, 125, -120, -116, 69, 91, ByteCompanionObject.MIN_VALUE, 121, -118, -117, 125, -116, -98, -67, -49, -59, -65, -82, -63, -51, -47, -63, -49, -48, -92, -67, -54, -64, -56, -63, -50, -118, -53, -54, -95, -50, -50, -53, -50, 124, -61, -53, -48, -102, -58, -59, -53, -68, -59, -53, -124, -85, -48, -57, -68, -71, -72, -86, -111, -100};
    }

    public static void A02() {
        A02 = new String[]{"rzjVC70O4bd9DzHjbWZgWXgUSmVLYSU4", "d5zo8W4K", "Hv98ROwnq0amXTKQof8zpMynpU6nXYzw", "m02wtPmJvn7xvEVIhgILVdsvYaekd1y1", "NwXA6aDXoJPzKJxJycW", "lujFiBBwg3lGF", "5iNla1hEs57TMoL8Mlh58N0Q757SBHKY", "iek06qmxI9TIJY"};
    }

    public G8() {
        this(new G1());
    }

    public G8(Q2 q2) {
        this.A00 = q2;
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final boolean A9Z(C0659Pz pz) {
        AbstractC0645Pl A002 = pz.A00();
        if (this.A00.A7f()) {
            this.A00.A7u(A00(14, 31, 78));
            pz.printStackTrace();
        }
        if (A002 == null || A002.A74() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final HttpURLConnection ABS(String str) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final InputStream ABT(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final OutputStream ABU(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final void ABk(HttpURLConnection httpURLConnection, EnumC0657Px px, String str) throws IOException {
        httpURLConnection.setRequestMethod(px.A03());
        httpURLConnection.setDoOutput(px.A05());
        httpURLConnection.setDoInput(px.A04());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(45, 12, 73), str);
        }
        httpURLConnection.setRequestProperty(A00(0, 14, 10), A00(57, 5, 86));
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final byte[] AC4(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } else if (A02[4].length() != 19) {
                throw new RuntimeException();
            } else {
                String[] strArr = A02;
                strArr[2] = "eO7qbggyddGiOQuVn8N8jDULGwym82oB";
                strArr[6] = "iN6CFd4LV6hdOWp44ZZbGtT2nODAuDvC";
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.Q1
    public final void ADx(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
