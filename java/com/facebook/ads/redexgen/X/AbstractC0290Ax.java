package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ax  reason: case insensitive filesystem */
public abstract class AbstractC0290Ax extends AbstractC0863Xy<C0283Aq, AbstractC0269Ab, GH> implements AbstractC0923aA {
    public static byte[] A01;
    public final String A00;

    static {
        A0K();
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 125);
        }
        return new String(copyOfRange);
    }

    public static void A0K() {
        A01 = new byte[]{63, 88, 79, 98, 90, 79, 77, 94, 79, 78, 10, 78, 79, 77, 89, 78, 79, 10, 79, 92, 92, 89, 92};
    }

    public abstract GG A0d(byte[] bArr, int i, boolean z) throws GH;

    public AbstractC0290Ax(String str) {
        super(new C0283Aq[2], new AbstractC0269Ab[2]);
        this.A00 = str;
        A0a(1024);
    }

    /* access modifiers changed from: private */
    /* renamed from: A0F */
    public final GH A0Y(C0283Aq aq, AbstractC0269Ab ab, boolean z) {
        try {
            ByteBuffer byteBuffer = aq.A01;
            ab.A09(((C0861Xw) aq).A00, A0d(byteBuffer.array(), byteBuffer.limit(), z), aq.A00);
            ab.A01(Integer.MIN_VALUE);
            return null;
        } catch (GH e) {
            return e;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A0G */
    public final GH A0Z(Throwable th) {
        return new GH(A0J(0, 23, 109), th);
    }

    /* access modifiers changed from: private */
    /* renamed from: A0H */
    public final C0283Aq A0V() {
        return new C0283Aq();
    }

    /* access modifiers changed from: private */
    /* renamed from: A0I */
    public final AbstractC0269Ab A0X() {
        return new AnonymousClass3E(this);
    }

    /* renamed from: A0e */
    public final void A0c(AbstractC0269Ab ab) {
        super.A0c(ab);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0923aA
    public final void AD4(long j) {
    }
}
