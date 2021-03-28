package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

public final class RR extends AnonymousClass16 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 2751287062553772011L;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{123, 108, 126, 104, 123, 109, 108, 109, 86, ByteCompanionObject.MAX_VALUE, 96, 109, 108, 102};
    }

    public RR(List<AnonymousClass19> list) {
        super(list);
    }

    public static RR A01(JSONObject jSONObject) {
        AnonymousClass19 A002 = AnonymousClass19.A00(jSONObject);
        A002.A0K(true);
        A002.A0J(jSONObject);
        ArrayList arrayList = new ArrayList();
        arrayList.add(A002);
        RR rr = new RR(arrayList);
        rr.A0e(jSONObject);
        rr.A0c(A02(0, 14, 8));
        return rr;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0I() {
        return A0M().A0E().A06() != null ? 1 : 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0J() {
        return A0M().A0E().A04();
    }
}
