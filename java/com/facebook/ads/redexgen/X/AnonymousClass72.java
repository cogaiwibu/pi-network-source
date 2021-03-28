package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import javax.annotation.Nullable;

@SuppressLint({"StringFormatUse", "SharedPreferencesUse"})
/* renamed from: com.facebook.ads.redexgen.X.72  reason: invalid class name */
public final class AnonymousClass72 {
    public static AnonymousClass72 A01;
    public static byte[] A02;
    public static String[] A03;
    public final HashMap<Integer, String> A00 = new HashMap<>();

    static {
        A04();
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{103, 114, 116, -70};
    }

    public static void A04() {
        A03 = new String[]{"rLDjBgKz63Bn2bjdq5T9imrieVp5PIBM", "m8wp0Vw9GL6Om21Qq8m8Tj5zfu0l", "YgqNWwRBt3ccTC8L8vt9EnrOaTNX", "Ji4mlDElrKKLO0fU8k8hI0n9H2FXwyxW", "wf5MYK5ehGzLy7SkBsWbSYGwiXhb8bxZ", "VWIuBm7xkqaJ1AqGCIKfvhlqUEnKMMIs", "Q1uyQO5SpdafJkDIvdpZDIFmVDRWB0Ou", "30w5jfTvH5e90EUSXrOKs1RMT2PDXB24"};
    }

    @SuppressLint({"CatchGeneralException"})
    public AnonymousClass72(Context context, EnumC01856m r4, @Nullable String str) {
        try {
            A05(context);
            if (r4.A05() == EnumC01856m.A0G.A05()) {
                A06(context, str);
            }
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
    }

    public static AnonymousClass72 A00(Context context, EnumC01856m r2, @Nullable String str) {
        if (A01 == null) {
            A01 = new AnonymousClass72(context, r2, str);
        }
        return A01;
    }

    public static String A02(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format(A01(0, 4, 62), Byte.valueOf(bArr[i])));
        }
        String sb2 = sb.toString();
        String[] strArr = A03;
        if (strArr[5].charAt(8) != strArr[6].charAt(8)) {
            String[] strArr2 = A03;
            strArr2[0] = "YeSBMNELIt08AqlHIfsrA8EpBPFL6cGm";
            strArr2[0] = "YeSBMNELIt08AqlHIfsrA8EpBPFL6cGm";
            return sb2;
        }
        throw new RuntimeException();
    }

    private void A05(Context context) throws Exception {
        int read;
        InputStream inputStream = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.publicSourceDir)), 1024);
            MessageDigest instance = MessageDigest.getInstance(AnonymousClass75.A04.A03());
            MessageDigest instance2 = MessageDigest.getInstance(AnonymousClass75.A05.A03());
            MessageDigest instance3 = MessageDigest.getInstance(AnonymousClass75.A06.A03());
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                    instance2.update(bArr, 0, read);
                    instance3.update(bArr, 0, read);
                }
                if (A03[7].charAt(26) != 'P') {
                    throw new RuntimeException();
                }
                String[] strArr = A03;
                strArr[7] = "sHaOy6LtIlfUQKDjNh2L68IGHQPvVrDu";
                strArr[7] = "sHaOy6LtIlfUQKDjNh2L68IGHQPvVrDu";
            } while (read != -1);
            this.A00.put(10003, A02(instance.digest()));
            this.A00.put(10004, A02(instance2.digest()));
            this.A00.put(10005, A02(instance3.digest()));
            bufferedInputStream.close();
        } catch (Throwable th) {
            String[] strArr2 = A03;
            if (strArr2[4].charAt(30) != strArr2[3].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A03;
            strArr3[5] = "XS9zpWe4kggJPLQjl3jzxSvjjqaK1CvG";
            strArr3[6] = "1gkHVsehFegipbXpJD0YhFUDmEZYz3Bw";
            if (0 != 0) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A06(android.content.Context r6, @javax.annotation.Nullable java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x0008
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x0009
        L_0x0008:
            return
        L_0x0009:
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream
            android.content.res.AssetManager r0 = r6.getAssets()
            java.io.InputStream r0 = r0.open(r7)
            r1 = 1024(0x400, float:1.435E-42)
            r4.<init>(r0, r1)
            com.facebook.ads.redexgen.X.75 r0 = com.facebook.ads.redexgen.X.AnonymousClass75.A04     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = r0.A03()     // Catch:{ all -> 0x0048 }
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r0)     // Catch:{ all -> 0x0048 }
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x0048 }
        L_0x0024:
            int r1 = r4.read(r2)     // Catch:{ all -> 0x0048 }
            if (r1 <= 0) goto L_0x002e
            r0 = 0
            r3.update(r2, r0, r1)     // Catch:{ all -> 0x0048 }
        L_0x002e:
            r0 = -1
            if (r1 != r0) goto L_0x0024
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.A00     // Catch:{ all -> 0x0048 }
            r0 = 10010(0x271a, float:1.4027E-41)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0048 }
            byte[] r0 = r3.digest()     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = A02(r0)     // Catch:{ all -> 0x0048 }
            r2.put(r1, r0)     // Catch:{ all -> 0x0048 }
            r4.close()
            return
        L_0x0048:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x004e }
        L_0x004e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass72.A06(android.content.Context, java.lang.String):void");
    }

    @Nullable
    public final String A07(int i) {
        String str = this.A00.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        return null;
    }
}
