package com.facebook.ads.redexgen.X;

import androidx.core.view.InputDeviceCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.Qw  reason: case insensitive filesystem */
public final class C0682Qw implements AnonymousClass0H {
    public static byte[] A03;
    public static String[] A04;
    public File A00;
    public RandomAccessFile A01;
    public final AnonymousClass0C A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-99, -34, -16, -99, -31, -26, -16, -32, -99, -32, -34, -32, -27, -30, 101, -85, -76, -73, 101, -88, -76, -78, -75, -79, -86, -71, -82, -76, -77, 102, -65, 8, 18, -65, 2, 14, 12, 15, 11, 4, 19, 4, 3, -64, -59, 25, 20, -59, 102, -100, -89, -81, -90, -92, -89, -103, -100, 114, -112, -99, 86, -93, 79, -110, -101, -108, -112, -99, 79, -107, -104, -101, -108, -94, -49, -49, -52, -49, 125, -66, -51, -51, -62, -53, -63, 125, -64, -66, -64, -59, -62, -105, 125, -64, -66, -64, -59, -62, 125, -61, -58, -55, -62, 125, -47, -2, -2, -5, -2, -84, -17, -8, -5, -1, -11, -6, -13, -84, -14, -11, -8, -15, -84, -22, 23, 23, 20, 23, -59, 20, 21, 10, 19, 14, 19, 12, -59, -65, -20, -20, -23, -20, -102, -20, -33, -37, -34, -29, -24, -31, -102, -26, -33, -24, -31, -18, -30, -102, -23, -32, -102, -32, -29, -26, -33, -102, -106, -61, -61, -64, -61, 113, -61, -74, -65, -78, -66, -70, -65, -72, 113, -73, -70, -67, -74, 113, -20, 25, 25, 22, 25, -57, 28, 26, 16, 21, 14, -57, 13, 16, 19, 12, -57, -41, 4, 4, 1, 4, -78, 9, 4, -5, 6, -5, 0, -7, -78, -73, -10, -78, -12, 11, 6, -9, 5, -78, 6, 1, -78, -73, 5, -78, -8, 4, 1, -1, -78, -12, 7, -8, -8, -9, 4, -78, 9, -5, 6, -6, -78, 5, -5, 12, -9, -78, -73, -10, -34, 18, 23};
    }

    public static void A02() {
        A04 = new String[]{"P4WBUOUbWFZVPUfllum665PEFtgA", "hl2hcMpTCTU39UgF1EW38AmixRhm49P4", "sNWuTokwvfj2sOZCyjSoO11B4mAkUdMG", "H", "URwERncuc0axl8tzw7s1hCSOmGWPEg1Z", "US601emoXJvV4DnAkF2mociZLiAqpNhW", "6", "hJG0zhFr2Lsx"};
    }

    public C0682Qw(File file, AnonymousClass0C r9) throws C0684Qy {
        File file2;
        if (r9 != null) {
            try {
                this.A02 = r9;
                AnonymousClass0F.A06(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + A00(48, 9, 15));
                }
                this.A00 = file2;
                this.A01 = new RandomAccessFile(this.A00, exists ? A00(256, 1, 67) : A00(InputDeviceCompat.SOURCE_KEYBOARD, 2, 119));
            } catch (IOException e) {
                throw new C0684Qy(A00(186, 17, 126) + file + A00(0, 14, 84), e);
            }
        } else {
            throw new NullPointerException();
        }
    }

    private boolean A03(File file) {
        return file.getName().endsWith(A00(48, 9, 15));
    }

    public final synchronized int A04() throws C0684Qy {
        try {
        } catch (IOException e) {
            throw new C0684Qy(A00(137, 29, 81) + this.A00, e);
        }
        return (int) this.A01.length();
    }

    public final File A05() {
        return this.A00;
    }

    public final synchronized void A06() throws C0684Qy {
        try {
            this.A01.setLength(0);
        } catch (IOException e) {
            throw new C0684Qy(A00(57, 16, 6), e);
        }
        String[] strArr = A04;
        if (strArr[7].length() != strArr[0].length()) {
            String[] strArr2 = A04;
            strArr2[2] = "4ly1cFvfi9Man28fVF2v4dhkOJlcUKEY";
            strArr2[2] = "4ly1cFvfi9Man28fVF2v4dhkOJlcUKEY";
            return;
        }
        throw new RuntimeException();
    }

    public final synchronized void A07() throws C0684Qy {
        try {
            this.A01.close();
            this.A02.ADX(this.A00);
        } catch (IOException e) {
            throw new C0684Qy(A00(104, 19, 99) + this.A00, e);
        }
    }

    /* JADX INFO: Multiple debug info for r0v11 boolean: [D('completedFile' java.io.File), D('renamed' boolean)] */
    public final synchronized void A08() throws C0684Qy {
        if (!A0A()) {
            A07();
            File file = new File(this.A00.getParentFile(), this.A00.getName().substring(0, this.A00.getName().length() - A00(48, 9, 15).length()));
            if (this.A00.renameTo(file)) {
                this.A00 = file;
                try {
                    this.A01 = new RandomAccessFile(this.A00, A00(256, 1, 67));
                } catch (IOException e) {
                    throw new C0684Qy(A00(123, 14, 124) + this.A00 + A00(0, 14, 84), e);
                }
            } else {
                throw new C0684Qy(A00(166, 20, 40) + this.A00 + A00(44, 4, 124) + file + A00(14, 16, 28));
            }
        }
    }

    public final synchronized void A09(byte[] bArr, int i) throws C0684Qy {
        try {
            if (!A0A()) {
                this.A01.seek((long) A04());
                this.A01.write(bArr, 0, i);
            } else {
                throw new C0684Qy(A00(73, 31, 52) + this.A00 + A00(30, 14, 118));
            }
        } catch (IOException e) {
            String A002 = A00(203, 53, 105);
            throw new C0684Qy(String.format(Locale.US, A002, Integer.valueOf(i), this.A01, Integer.valueOf(bArr.length)), e);
        }
    }

    public final synchronized boolean A0A() {
        return !A03(this.A00);
    }
}
