package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager;
import com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Xa  reason: case insensitive filesystem */
public final class C0839Xa implements AbstractC0272Ae {
    public static byte[] A04;
    public final int A00;
    public final long A01;
    public final Context A02;
    @Nullable
    public final C4<Y7> A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{73, 104, 107, 108, 120, 97, 121, 95, 104, 99, 105, 104, ByteCompanionObject.MAX_VALUE, 104, ByteCompanionObject.MAX_VALUE, 126, 75, 108, 110, 121, 98, ByteCompanionObject.MAX_VALUE, 116, 31, 40, 40, 53, 40, 122, 51, 52, 41, 46, 59, 52, 46, 51, 59, 46, 51, 52, 61, 122, 28, 28, 55, 42, 63, 61, 122, 63, 34, 46, 63, 52, 41, 51, 53, 52, 28, 43, 43, 54, 43, 121, 48, 55, 42, 45, 56, 55, 45, 48, 56, 45, 48, 55, 62, 121, 31, 21, 24, 26, 121, 60, 33, 45, 60, 55, 42, 48, 54, 55, 92, 107, 107, 118, 107, 57, 112, 119, 106, 109, 120, 119, 109, 112, 120, 109, 112, 119, 126, 57, 86, 105, 108, 106, 57, 124, 97, 109, 124, 119, 106, 112, 118, 119, 52, 3, 3, 30, 3, 81, 24, 31, 2, 5, 16, 31, 5, 24, 16, 5, 24, 31, 22, 81, 39, 33, 72, 81, 20, 9, 5, 20, 31, 2, 24, 30, 31, 108, 79, 65, 68, 69, 68, 0, 102, 70, 77, 80, 69, 71, 97, 85, 68, 73, 79, 114, 69, 78, 68, 69, 82, 69, 82, 14, 31, 60, 50, 55, 54, 55, 115, 31, 58, 49, 53, 63, 50, 48, 18, 38, 55, 58, 60, 1, 54, 61, 55, 54, 33, 54, 33, 125, 65, 98, 108, 105, 104, 105, 45, 65, 100, 111, 98, 125, 120, 126, 76, 120, 105, 100, 98, 95, 104, 99, 105, 104, ByteCompanionObject.MAX_VALUE, 104, ByteCompanionObject.MAX_VALUE, 35, 126, 93, 83, 86, 87, 86, 18, 126, 91, 80, 68, 66, 74, 100, 91, 86, 87, 93, 96, 87, 92, 86, 87, 64, 87, 64, 28, 119, 123, 121, 58, 114, 117, 119, 113, 118, 123, 123, ByteCompanionObject.MAX_VALUE, 58, 117, 112, 103, 58, 125, 122, 96, 113, 102, 122, 117, 120, 58, 113, 108, 123, 100, 120, 117, 109, 113, 102, 38, 58, 113, 108, 96, 58, 114, 114, 121, 100, 113, 115, 58, 82, 114, 121, 100, 113, 115, 85, 97, 112, 125, 123, 70, 113, 122, 112, 113, 102, 113, 102, 37, 41, 43, 104, 32, 39, 37, 35, 36, 41, 41, 45, 104, 39, 34, 53, 104, 47, 40, 50, 35, 52, 40, 39, 42, 104, 35, 62, 41, 54, 42, 39, 63, 35, 52, 116, 104, 35, 62, 50, 104, 32, 42, 39, 37, 104, 10, 47, 36, 32, 42, 39, 37, 7, 51, 34, 47, 41, 20, 35, 40, 34, 35, 52, 35, 52, 121, 117, 119, 52, 124, 123, 121, ByteCompanionObject.MAX_VALUE, 120, 117, 117, 113, 52, 123, 126, 105, 52, 115, 116, 110, ByteCompanionObject.MAX_VALUE, 104, 116, 123, 118, 52, ByteCompanionObject.MAX_VALUE, 98, 117, 106, 118, 123, 99, ByteCompanionObject.MAX_VALUE, 104, 40, 52, ByteCompanionObject.MAX_VALUE, 98, 110, 52, 117, 106, 111, 105, 52, 86, 115, 120, 117, 106, 111, 105, 91, 111, 126, 115, 117, 72, ByteCompanionObject.MAX_VALUE, 116, 126, ByteCompanionObject.MAX_VALUE, 104, ByteCompanionObject.MAX_VALUE, 104, 92, 80, 82, 17, 89, 94, 92, 90, 93, 80, 80, 84, 17, 94, 91, 76, 17, 86, 81, 75, 90, 77, 81, 94, 83, 17, 90, 71, 80, 79, 83, 94, 70, 90, 77, 13, 17, 90, 71, 75, 17, 73, 79, 6, 17, 115, 86, 93, 73, 79, 71, 105, 86, 91, 90, 80, 109, 90, 81, 91, 90, 77, 90, 77};
    }

    public C0839Xa(Context context) {
        this(context, 0);
    }

    public C0839Xa(Context context, int i) {
        this(context, null, i, 5000);
    }

    @Deprecated
    public C0839Xa(Context context, @Nullable C4<Y7> c4, int i, long j) {
        this.A02 = context;
        this.A00 = i;
        this.A01 = j;
        this.A03 = c4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008e, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:7:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void A02(android.content.Context r19, @androidx.annotation.Nullable com.facebook.ads.redexgen.X.C4<com.facebook.ads.redexgen.X.Y7> r20, long r21, android.os.Handler r23, com.facebook.ads.redexgen.X.J4 r24, int r25, java.util.ArrayList<com.facebook.ads.redexgen.X.AbstractC0844Xf> r26) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0839Xa.A02(android.content.Context, com.facebook.ads.redexgen.X.C4, long, android.os.Handler, com.facebook.ads.redexgen.X.J4, int, java.util.ArrayList):void");
    }

    /* JADX INFO: Multiple debug info for r0v35 com.facebook.ads.redexgen.X.Xf: [D('constructor' java.lang.reflect.Constructor<?>), D('extensionRendererIndex' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011d, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:31:0x00e4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void A03(android.content.Context r15, @androidx.annotation.Nullable com.facebook.ads.redexgen.X.C4<com.facebook.ads.redexgen.X.Y7> r16, com.facebook.ads.redexgen.X.B3[] r17, android.os.Handler r18, com.facebook.ads.redexgen.X.BB r19, int r20, java.util.ArrayList<com.facebook.ads.redexgen.X.AbstractC0844Xf> r21) {
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0839Xa.A03(android.content.Context, com.facebook.ads.redexgen.X.C4, com.facebook.ads.redexgen.X.B3[], android.os.Handler, com.facebook.ads.redexgen.X.BB, int, java.util.ArrayList):void");
    }

    private final void A04(Context context, E1 e1, Looper looper, int i, ArrayList<AbstractC0844Xf> arrayList) {
        arrayList.add(new AnonymousClass3I(e1, looper));
    }

    private final void A05(Context context, GJ gj, Looper looper, int i, ArrayList<AbstractC0844Xf> arrayList) {
        arrayList.add(new AnonymousClass32(gj, looper));
    }

    private final B3[] A06() {
        return new B3[0];
    }

    /* JADX INFO: Multiple debug info for r11v0 java.util.ArrayList<com.facebook.ads.redexgen.X.Xf>: [D('renderersList' java.util.ArrayList<com.facebook.ads.internal.exoplayer2.Renderer>), D('drmSessionManager' com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto>)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0272Ae
    public final AbstractC0844Xf[] A4Q(Handler handler, J4 j4, BB bb, GJ gj, E1 e1, @Nullable C4<Y7> c4) {
        C4<Y7> c42 = c4;
        if (c42 == null) {
            c42 = this.A03;
        }
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager = new ArrayList<>();
        A02(this.A02, c42, this.A01, handler, j4, this.A00, drmSessionManager);
        A03(this.A02, c42, A06(), handler, bb, this.A00, drmSessionManager);
        A05(this.A02, gj, handler.getLooper(), this.A00, drmSessionManager);
        A04(this.A02, e1, handler.getLooper(), this.A00, drmSessionManager);
        return (AbstractC0844Xf[]) drmSessionManager.toArray(new AbstractC0844Xf[drmSessionManager.size()]);
    }
}
