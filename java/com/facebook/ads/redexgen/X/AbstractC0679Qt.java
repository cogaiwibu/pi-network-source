package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.redexgen.X.Qt  reason: case insensitive filesystem */
public abstract class AbstractC0679Qt implements AnonymousClass0C {
    public static byte[] A01;
    public static String[] A02;
    public static final String A03 = AbstractC0679Qt.class.getSimpleName();
    public final ExecutorService A00 = Executors.newSingleThreadExecutor();

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 54);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{-104, -34, -25, -22, -104, -20, -22, -31, -27, -27, -31, -26, -33, -104, -37, -39, -37, -32, -35, -50, 23, 33, -50, 18, 19, 26, 19, 34, 19, 18, -50, 16, 19, 17, 15, 35, 33, 19, -50, 23, 34, -50, 19, 38, 17, 19, 19, 18, 33, -50, 17, 15, 17, 22, 19, -50, 26, 23, 27, 23, 34, -125, -95, -93, -88, -91, 96, -90, -87, -84, -91, 96, -10, 35, 35, 32, 35, -47, 21, 22, 29, 22, 37, 26, 31, 24, -47, 23, 26, 29, 22, -47};
    }

    public static void A06() {
        A02 = new String[]{"0PvfoUFANCVNmnYZfPoejD6ohCtuxysE", "CTVBuEwwodohpQOP7b4j4", "9BgxiAbaVpMmFPJgyPUrG0VpyjL4diCu", "0p8mXLPxFyBv4phdqx8YrWMD1W9nJbZf", "G0yvPsPNC2vYmeMn8hYLEKyQ1tXXfhoe", "IW3zcZDApc8b2NyXBv", "Oqr2oLquorC4BSN9LXFNL8a9XNzmbM1Z", "n"};
    }

    public abstract boolean A0A(File file, long j, int i);

    static {
        A06();
        A05();
    }

    private long A03(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* access modifiers changed from: private */
    public void A08(File file) throws IOException {
        AnonymousClass0F.A03(file);
        A09(AnonymousClass0F.A01(file.getParentFile()));
    }

    private void A09(List<File> list) {
        long A032 = A03(list);
        int size = list.size();
        for (File file : list) {
            String[] strArr = A02;
            if (strArr[5].length() != strArr[1].length()) {
                String[] strArr2 = A02;
                strArr2[0] = "0WEexOrIiLXDlCjHBxNry1dxuPi8TFF2";
                strArr2[3] = "0ARlW4XVdH4TDXa7R7a2wpH1vFPRrHRN";
                if (!A0A(file, A032, size)) {
                    long length = file.length();
                    if (file.delete()) {
                        size--;
                        A032 -= length;
                        Log.i(A03, A04(61, 11, 10) + file + A04(19, 42, 120));
                    } else {
                        Log.e(A03, A04(72, 20, 123) + file + A04(0, 19, 66));
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0C
    public void ADX(File file) throws IOException {
        this.A00.submit(new AnonymousClass0G(this, file));
    }
}
