package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Qq  reason: case insensitive filesystem */
public final class C0676Qq implements AnonymousClass03<Bitmap> {
    public static byte[] A06;
    public static String[] A07;
    public final int A00;
    public final int A01;
    public final String A02 = C0676Qq.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 8);
            if (A07[7].charAt(0) != 'p') {
                String[] strArr = A07;
                strArr[6] = "rTtdlTA5qc3UePbll3p";
                strArr[6] = "rTtdlTA5qc3UePbll3p";
                copyOfRange[i4] = b;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A07[4].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "j2OKbozXXbIBudrsn6AX9zPsXXh";
        strArr[6] = "j2OKbozXXbIBudrsn6AX9zPsXXh";
        A06 = new byte[]{1, 91, 66, 95, 7, 44, 49, 40, 36, 53, 101, 44, 54, 101, 43, 48, 41, 41, 124, 65, 90, 92, 73, 77, 80, 86, 87, 25, 93, 76, 75, 80, 87, 94, 25, 95, 80, 85, 92, 25, 90, 86, 84, 73, 75, 92, 74, 74, 80, 86, 87};
    }

    public static void A03() {
        A07 = new String[]{"O8BWLXPdzHA", "6sEzkrKiC7tSlAyzako7Jr1QeLTjq7r7", "buIAODYM5Oo034kKCIV4I7ZzRqvLqiIh", "ENOGp8Grp5cb6hByXNSQMpF2JyONyocp", "tnh", "2Zn0DxkDz4CuR43sN", "3j1ga9q4MlHQ2cRzMN", "NuleDR7CXAFlpWhCDunnHJWIhrQ2pSEs"};
    }

    public C0676Qq(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.A01 = i;
        this.A00 = i2;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = z3;
    }

    public static AnonymousClass02<Bitmap> A00(Throwable th) {
        return new AnonymousClass02<>(false, null, th);
    }

    private void A04(File file, @Nullable Bitmap bitmap) throws IOException {
        if (bitmap != null) {
            FileOutputStream updatedCacheFileOS = null;
            try {
                updatedCacheFileOS = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, updatedCacheFileOS);
                if (updatedCacheFileOS.size() < 3145728) {
                    String str = file.getCanonicalPath() + A01(0, 4, 39);
                    File file2 = new File(str);
                    file2.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    updatedCacheFileOS.writeTo(fileOutputStream);
                    fileOutputStream.flush();
                    FileInputStream fileInputStream = new FileInputStream(str);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            file2.delete();
                            AnonymousClass0N.A07(updatedCacheFileOS);
                            AnonymousClass0N.A07(fileOutputStream);
                            AnonymousClass0N.A07(fileInputStream);
                            AnonymousClass0N.A07(fileOutputStream2);
                            return;
                        }
                    }
                }
            } finally {
                AnonymousClass0N.A07(updatedCacheFileOS);
                AnonymousClass0N.A07(null);
                AnonymousClass0N.A07(null);
                AnonymousClass0N.A07(null);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    @SuppressLint({"CatchGeneralException"})
    public final AnonymousClass02<Bitmap> A3E(File file, AnonymousClass0M r8) {
        if (!this.A04) {
            return new AnonymousClass02<>(true, null);
        }
        try {
            Bitmap A032 = AnonymousClass0N.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (A032 != null) {
                return new AnonymousClass02<>(true, A032);
            }
            r8.A7w(new C0681Qv(A01(4, 14, 77)));
            return A00(null);
        } catch (Throwable th) {
            if (A07[6].length() != 26) {
                String[] strArr = A07;
                strArr[2] = "Rre6UfQ4j0qmCPYEhTx2DnaeM5gEursB";
                strArr[1] = "Gg2NoIsyPtMRdLQD2TdVPdh2XNeZHi6S";
                file.delete();
                r8.A7w(th);
                return A00(th);
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    @SuppressLint({"CatchGeneralException"})
    public final void A4B(File file, AnonymousClass0M r7) throws C0681Qv {
        if (this.A03) {
            try {
                Bitmap A032 = AnonymousClass0N.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (A032 != null) {
                    A04(file, A032);
                } else {
                    file.delete();
                    throw new C0681Qv(A01(4, 14, 77));
                }
            } catch (C0681Qv e) {
                r7.A85(e);
                throw e;
            } catch (Throwable th) {
                r7.A85(th);
                throw new C0681Qv(A01(18, 33, 49), th);
            }
        }
    }
}
