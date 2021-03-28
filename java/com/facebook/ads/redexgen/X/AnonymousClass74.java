package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.io.File;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.74  reason: invalid class name */
public final class AnonymousClass74 {
    public static byte[] A00;
    public static String[] A01;

    static {
        A04();
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 80);
            if (A01[6].charAt(16) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "4KTBK77LN1KTDos5IeArWQYcubpfVnlF";
            strArr[7] = "4KTBK77LN1KTDos5IeArWQYcubpfVnlF";
            copyOfRange[i4] = b;
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{75, 101, 102, 126, 111, 96, 122, 97, 115, 114, 115, 26, 61, 37, 50, 63, 58, 55, 115, 26, 5, 98, 69, 93, 74, 71, 66, 79, 11, 98, 69, 91, 94, 95, 71, 96, 120, 111, 98, 103, 106, 46, 66, 107, 96, 105, 122, 102, 17, 42, 51, 51, ByteCompanionObject.MAX_VALUE, 29, 27, ByteCompanionObject.MAX_VALUE, 12, 58, 44, 44, 54, 48, 49, ByteCompanionObject.MAX_VALUE, 22, 59, 33, 58, 50, 34, 68, 33, 16, 21, 21, 24, 31, 22, 69, 101, 92, 90};
    }

    public static void A04() {
        A01 = new String[]{"eFrFuMkSf6MHcof7LOi6YZLllbM352nJ", "mAvGXXYFupd5OuM4XCWCl6Ymf1L0CYcu", "NOO30l6olRO1IZ4LfmYkunta1od", "bvzGMF7Q1FtgEXIkORXr7PxZ7BJPLsgM", "hXdYhHbEFyr1sbwxo", "3nkhTPKg5suoqFFED69qNRFImDpUoi1X", "AqSvMoRqc6BrPHC1U9YSDW7FElWr0vU0", "cACdptFygePFXCUb5rEKoIEmqMGQ4nRx"};
    }

    @SuppressLint({"CatchGeneralException", "BadMethodUse-java.lang.String.length"})
    public static String A01(String str, String str2) {
        try {
            String[] split = str2.split(A00(78, 2, 73));
            if (split == null || split.length == 0) {
                throw new IllegalArgumentException(A00(48, 18, 15));
            }
            String str3 = split[split.length - 1];
            if (str3.length() == 16) {
                return A02(str, str3);
            }
            throw new InvalidParameterSpecException(A00(34, 14, 94));
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
            String A002 = A00(80, 2, 119);
            String[] strArr = A01;
            if (strArr[4].length() != strArr[2].length()) {
                String[] strArr2 = A01;
                strArr2[0] = "q1rcyONSgbGNz9bqB8WSs99USD9RjoFj";
                strArr2[5] = "jIC3cCNXapYytCTk8CpXHStINYfHDphY";
                return A002;
            }
            throw new RuntimeException();
        }
    }

    /* JADX INFO: Multiple debug info for r0v18 byte[]: [D('key' javax.crypto.SecretKey), D('ivBytes' byte[])] */
    @SuppressLint({"TrulyRandom", "BadMethodUse-java.lang.String.length"})
    public static String A02(String str, String str2) throws Throwable {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException(A00(21, 13, 123));
        }
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        String A002 = A00(0, 8, 89);
        sb.append(A002);
        sb.append(File.separatorChar);
        sb.append(A00(8, 3, 96));
        sb.append(File.separatorChar);
        sb.append(A00(66, 12, 33));
        Cipher instance = Cipher.getInstance(sb.toString());
        instance.init(1, new SecretKeySpec(str2.getBytes(), A002), new IvParameterSpec(A05(str2.substring(0, length / 2).getBytes(), str2.substring(length / 2, length).getBytes())));
        return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
    }

    public static byte[] A05(byte[] result, byte[] bArr) throws NullPointerException {
        if (result == null || bArr == null || result.length != bArr.length) {
            throw new NullPointerException(A00(11, 10, 3));
        }
        byte[] bArr2 = new byte[result.length];
        for (int i = 0; i < result.length; i++) {
            bArr2[i] = (byte) (result[i] ^ bArr[i]);
        }
        return bArr2;
    }
}
