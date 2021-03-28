package com.tapjoy.internal;

import kotlin.jvm.internal.ByteCompanionObject;

public final class gk {
    public long a;
    public long b;
    public long c;

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r20, int r21) {
        /*
        // Method dump skipped, instructions count: 262
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gk.a(java.lang.String, int):boolean");
    }

    private static long a(byte[] bArr, int i) {
        byte b2 = bArr[i];
        byte b3 = bArr[i + 1];
        byte b4 = bArr[i + 2];
        byte b5 = bArr[i + 3];
        int i2 = b2 & ByteCompanionObject.MIN_VALUE;
        byte b6 = b2;
        if (i2 == 128) {
            b6 = (b2 & ByteCompanionObject.MAX_VALUE) + 128;
        }
        int i3 = b3 & ByteCompanionObject.MIN_VALUE;
        byte b7 = b3;
        if (i3 == 128) {
            b7 = (b3 & ByteCompanionObject.MAX_VALUE) + 128;
        }
        int i4 = b4 & ByteCompanionObject.MIN_VALUE;
        byte b8 = b4;
        if (i4 == 128) {
            b8 = (b4 & ByteCompanionObject.MAX_VALUE) + 128;
        }
        int i5 = b5 & ByteCompanionObject.MIN_VALUE;
        byte b9 = b5;
        if (i5 == 128) {
            b9 = (b5 & ByteCompanionObject.MAX_VALUE) + 128;
        }
        return ((b6 == 1 ? 1 : 0) << 24) + ((b7 == 1 ? 1 : 0) << 16) + ((b8 == 1 ? 1 : 0) << 8) + (b9 == 1 ? 1 : 0);
    }

    private static long b(byte[] bArr, int i) {
        return ((a(bArr, i) - 2208988800L) * 1000) + ((a(bArr, i + 4) * 1000) / 4294967296L);
    }
}
