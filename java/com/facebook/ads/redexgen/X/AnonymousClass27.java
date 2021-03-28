package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.27  reason: invalid class name */
public final class AnonymousClass27 extends AnonymousClass3S implements IH {
    public static byte[] A0E;
    public static String[] A0F;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaFormat A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final Context A0B;
    public final BA A0C;
    public final BG A0D;

    static {
        A07();
        A06();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0E = new byte[]{7, 5, 16, 102, 27, 13, 11, 102, 41, 41, 43, 102, 44, 45, 43, 65, 67, 86, 32, 105, 97, 97, 105, 98, 107, 32, 124, 111, 121, 32, 106, 107, 109, 97, 106, 107, 124, 54, 57, 51, 37, 56, 62, 51, 121, 36, 56, 49, 35, 32, 54, 37, 50, 121, 59, 50, 54, 57, 53, 54, 52, 60, 64, 84, 69, 72, 78, 14, 83, 64, 86, 24, 19, 26, 21, 21, 30, 23, 86, 24, 20, 14, 21, 15, 63, 50, 37, 56, 59, 35, 50, 76, 65, 86, 75, 85, 72, 80, 65, 95, 83, 74, 31, 91, 92, 66, 71, 70, 31, 65, 91, 72, 87, 70, 66, 70, 78, 48, 50, 41, 47, 50, 41, 52, 57, 121, 107, 103, 122, 102, 111, 39, 120, 107, 126, 111, 70, 84, 88, 70, 64, 91, 82, 5, 26, 13, 16, 25, 19, 11, 26};
    }

    public static void A07() {
        A0F = new String[]{"aLXIjAOeq43kD47uUx47KIQfBztZ5JR6", "bYDvuG1CO7Q3NDumZhhBhB8jHe", "lzauC9VKCpzgBdv7KHug0xPju0EyyDRc", "zBmjWuq", "FwqFg", "FmVSMSIXQUSd0OcxsELVimAN3SmZwHxI", "I9K2sHUvqtNZm1Rj9xJMtQcmEPzsJytW", "SRtBuggTCbvw2MXSYfok3SEL95E53gc0"};
    }

    public AnonymousClass27(Context context, AbstractC0350Do r10, @Nullable C4<Y7> c4, boolean z, @Nullable Handler handler, @Nullable BB bb, @Nullable C0289Aw aw, B3... b3Arr) {
        this(context, r10, c4, z, handler, bb, new C0853Xo(aw, b3Arr));
    }

    public AnonymousClass27(Context context, AbstractC0350Do r4, @Nullable C4<Y7> c4, boolean z, @Nullable Handler handler, @Nullable BB bb, BG bg) {
        super(1, r4, c4, z);
        this.A0B = context.getApplicationContext();
        this.A0D = bg;
        this.A0C = new BA(handler, bb);
        bg.ACz(new C0855Xq(this));
    }

    private int A00(C0344Di di, Format format) {
        PackageManager packageManager;
        if (C0466Ig.A02 < 24) {
            if (A04(15, 22, 30).equals(di.A02)) {
                boolean z = true;
                if (C0466Ig.A02 == 23 && (packageManager = this.A0B.getPackageManager()) != null && packageManager.hasSystemFeature(A04(37, 25, 71))) {
                    z = false;
                }
                if (z) {
                    return -1;
                }
            }
        }
        return format.A09;
    }

    private final int A01(C0344Di di, Format format, Format[] formatArr) {
        return A00(di, format);
    }

    @SuppressLint({"InlinedApi"})
    private final MediaFormat A02(Format format, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A04(113, 4, 59), str);
        mediaFormat.setInteger(A04(71, 13, 107), format.A05);
        mediaFormat.setInteger(A04(125, 11, 26), format.A0C);
        C0356Du.A07(mediaFormat, format.A0P);
        C0356Du.A05(mediaFormat, A04(99, 14, 34), i);
        if (C0466Ig.A02 >= 23) {
            mediaFormat.setInteger(A04(117, 8, 80), 0);
        }
        return mediaFormat;
    }

    private void A05() {
        long A5u = this.A0D.A5u(A7Z());
        if (A5u != Long.MIN_VALUE) {
            if (!this.A08) {
                A5u = Math.max(this.A05, A5u);
            }
            this.A05 = A5u;
            this.A08 = false;
        }
    }

    public static boolean A09(String str) {
        if (C0466Ig.A02 < 24 && A04(0, 15, 88).equals(str)) {
            return A04(136, 7, 37).equals(C0466Ig.A05) && (C0466Ig.A03.startsWith(A04(143, 8, 111)) || C0466Ig.A03.startsWith(A04(84, 7, 71)) || C0466Ig.A03.startsWith(A04(91, 8, 52)));
        }
    }

    private final boolean A0A(String str) {
        int A002 = IJ.A00(str);
        if (A002 != 0) {
            boolean A7Y = this.A0D.A7Y(A002);
            if (A0F[5].charAt(2) != 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[1] = "OP";
            strArr[1] = "OP";
            if (A7Y) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A14() {
        try {
            this.A0D.ACD();
            try {
                super.A14();
            } finally {
                this.A0U.A00();
                this.A0C.A04(this.A0U);
            }
        } catch (Throwable th) {
            super.A14();
            throw th;
        } finally {
            this.A0U.A00();
            this.A0C.A04(this.A0U);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A15() {
        super.A15();
        this.A0D.ABg();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A16() {
        A05();
        this.A0D.pause();
        super.A16();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A17(long j, boolean z) throws A4 {
        super.A17(j, z);
        this.A0D.reset();
        this.A05 = j;
        this.A07 = true;
        this.A08 = true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A18(boolean z) throws A4 {
        super.A18(z);
        this.A0C.A05(this.A0U);
        int i = A13().A00;
        if (i != 0) {
            this.A0D.A4u(i);
        } else {
            this.A0D.A4l();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final int A1C(MediaCodec mediaCodec, C0344Di di, Format format, Format format2) {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d9, code lost:
        if (r7 != -1) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e1, code lost:
        if (r4.A0H(r17.A0C) != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e5, code lost:
        if (r17.A05 == -1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ed, code lost:
        if (r4.A0G(r17.A05) == false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0104, code lost:
        if (r7 != -1) goto L_0x00db;
     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int A1D(com.facebook.ads.redexgen.X.AbstractC0350Do r15, com.facebook.ads.redexgen.X.C4<com.facebook.ads.redexgen.X.Y7> r16, com.facebook.ads.internal.exoplayer2.Format r17) throws com.facebook.ads.redexgen.X.C0353Dr {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass27.A1D(com.facebook.ads.redexgen.X.Do, com.facebook.ads.redexgen.X.C4, com.facebook.ads.internal.exoplayer2.Format):int");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final C0344Di A1G(AbstractC0350Do r2, Format format, boolean z) throws C0353Dr {
        C0344Di A6g;
        if (!A0A(format.A0O) || (A6g = r2.A6g()) == null) {
            return super.A1G(r2, format, z);
        }
        return A6g;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1J() throws A4 {
        try {
            this.A0D.ABh();
        } catch (BF e) {
            throw A4.A01(e, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1M(MediaCodec mediaCodec, MediaFormat mediaFormat) throws A4 {
        int i;
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.A06;
        if (mediaFormat2 != null) {
            i = IJ.A00(mediaFormat2.getString(A04(113, 4, 59)));
            mediaFormat = this.A06;
        } else {
            i = this.A04;
        }
        int integer = mediaFormat.getInteger(A04(71, 13, 107));
        int integer2 = mediaFormat.getInteger(A04(125, 11, 26));
        if (!this.A09 || integer != 6 || (i2 = this.A00) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i2];
            for (int i3 = 0; i3 < this.A00; i3++) {
                iArr[i3] = i3;
            }
        }
        try {
            this.A0D.A46(i, integer, integer2, 0, iArr, this.A02, this.A03);
        } catch (BC e) {
            throw A4.A01(e, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1N(Format format) throws A4 {
        int i;
        super.A1N(format);
        this.A0C.A03(format);
        if (A04(62, 9, 49).equals(format.A0O)) {
            i = format.A0A;
        } else {
            i = 2;
        }
        this.A04 = i;
        this.A00 = format.A05;
        this.A02 = format.A06;
        this.A03 = format.A07;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1O(C0861Xw xw) {
        if (this.A07 && !xw.A03()) {
            if (Math.abs(xw.A00 - this.A05) > 500000) {
                this.A05 = xw.A00;
            }
            this.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1P(C0344Di di, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        String str;
        this.A01 = A01(di, format, A1B());
        this.A09 = A09(di.A02);
        this.A0A = di.A04;
        if (di.A01 == null) {
            str = A04(62, 9, 49);
        } else {
            str = di.A01;
        }
        MediaFormat A022 = A02(format, str, this.A01);
        mediaCodec.configure(A022, (Surface) null, mediaCrypto, 0);
        if (this.A0A) {
            this.A06 = A022;
            this.A06.setString(A04(113, 4, 59), format.A0O);
            return;
        }
        this.A06 = null;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1Q(String str, long j, long j2) {
        this.A0C.A06(str, j, j2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final boolean A1R(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws A4 {
        if (this.A0A && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.A0U.A08++;
            this.A0D.A7G();
            return true;
        } else {
            try {
                if (!this.A0D.A7F(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.A0U.A06++;
                return true;
            } catch (BD | BF e) {
                throw A4.A01(e, A10());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final IH A6V() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final AP A6l() {
        return this.A0D.A6l();
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final long A6o() {
        if (A70() == 2) {
            A05();
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AZ
    public final void A7H(int i, Object obj) throws A4 {
        if (i == 2) {
            BG bg = this.A0D;
            if (A0F[7].charAt(17) != 'P') {
                String[] strArr = A0F;
                strArr[4] = "awvXiH99cLu1HaadjiPENScqQYAeI";
                strArr[4] = "awvXiH99cLu1HaadjiPENScqQYAeI";
                bg.setVolume(((Float) obj).floatValue());
                return;
            }
            throw new RuntimeException();
        } else if (i != 3) {
            super.A7H(i, obj);
        } else {
            this.A0D.ACs((C0288Av) obj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S, com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7Z() {
        return super.A7Z() && this.A0D.A7Z();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S, com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7i() {
        return this.A0D.A7J() || super.A7i();
    }

    @Override // com.facebook.ads.redexgen.X.IH
    public final AP AD3(AP ap) {
        return this.A0D.AD3(ap);
    }
}
