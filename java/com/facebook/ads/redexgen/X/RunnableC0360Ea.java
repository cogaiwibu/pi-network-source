package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ea  reason: case insensitive filesystem */
public class RunnableC0360Ea implements Runnable {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ C0368Ei A00;
    public final /* synthetic */ DownloadAction[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {56, 19, 11, 18, 16, 19, 29, 24, 49, 29, 18, 29, 27, 25, 14, 121, 76, 91, 90, 64, 90, 93, 64, 71, 78, 9, 72, 74, 93, 64, 70, 71, 90, 9, 79, 72, 64, 69, 76, 77, 7};
        if (A03[6].charAt(27) != 't') {
            String[] strArr = A03;
            strArr[3] = "P9OfQ9yL9WD45vqgxteLJEc4LCKor8r2";
            strArr[3] = "P9OfQ9yL9WD45vqgxteLJEc4LCKor8r2";
            A02 = bArr;
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A03 = new String[]{"ygrR2oCQuDV4", "DNKcGXijWm6BAbsHYB9tJVHVwOJf9ZE7", "LXio5gucrx5pRKqWpkHtzDtUlmJWag3t", "79sxQvyKDcGCor525oKKoplIPAz2exYS", "G4RdIjdfwRebxnJM9f1GRZk4OR8ZnwMf", "KNt7Wd51BXMZnN1lzx9YZQc0XvITGZGG", "KZ351c6FjYQvk7DZPBJOKLteXh4ScOon", "e5Lfk6CJXwKq"};
    }

    public RunnableC0360Ea(C0368Ei ei, DownloadAction[] downloadActionArr) {
        this.A00 = ei;
        this.A01 = downloadActionArr;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A09.A03(this.A01);
            } catch (IOException e) {
                Log.e(A00(0, 15, 80), A00(15, 26, 5), e);
            } catch (Throwable th) {
                KU.A00(th, this);
                String[] strArr = A03;
                if (strArr[2].charAt(26) != strArr[1].charAt(26)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[5] = "LLc1NddejmN7rNF53s5OYYgeggfBVRnl";
                strArr2[5] = "LLc1NddejmN7rNF53s5OYYgeggfBVRnl";
            }
        }
    }
}
