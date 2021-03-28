package com.facebook.ads.redexgen.X;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Vj  reason: case insensitive filesystem */
public class C0796Vj implements AbstractC01816i {
    public static byte[] A01;
    public final /* synthetic */ C0797Vk A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{ByteCompanionObject.MIN_VALUE, -28, -29, -43, -68, -57};
    }

    public C0796Vj(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (this.A00.A04 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.A00.A04.length; i++) {
            sb.append(this.A00.A04[i].name);
            if (i != this.A00.A04.length - 1) {
                sb.append(A00(0, 1, 37));
            }
        }
        return this.A00.A09(AnonymousClass76.A08(sb.toString().getBytes(A00(1, 5, 62)), AnonymousClass75.A06));
    }
}
