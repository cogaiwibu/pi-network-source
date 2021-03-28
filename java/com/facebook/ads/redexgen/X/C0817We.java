package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.We  reason: case insensitive filesystem */
public class C0817We implements AnonymousClass0M {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ C0821Wi A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A02[3].charAt(2) != 'x') {
                String[] strArr = A02;
                strArr[0] = "5v5qZEzKm5dZGLy7lyhruzHwv9U4ulwR";
                strArr[0] = "5v5qZEzKm5dZGLy7lyhruzHwv9U4ulwR";
                copyOfRange[i4] = (byte) ((b ^ i3) ^ 108);
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{5, 1, 13, 11, 9};
    }

    public static void A02() {
        A02 = new String[]{"aROWSCJTZ7USEA9NykDAgKPqU9Hz2yMC", "Zqbs868sBagHNlYScp55lXssWh10RIQa", "mbYc5GC1jhCg", "AuzesFDqytnerPl8cSxQvwaSTNgSXgGN", "J34OJh55Zf7CVcps1JZJSO0d6JwePACZ", "sgVYwbqUus7", "7dh0o4NaZc6u8WRc1KGfxvMUmypAWeMQ", "ZE0swazaf"};
    }

    public C0817We(C0821Wi wi) {
        this.A00 = wi;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0M
    public final void A7w(Throwable th) {
        this.A00.A04().A82(A00(0, 5, 0), C02248i.A1K, new C02258j(th));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0M
    public final void A85(Throwable th) {
        this.A00.A04().A82(A00(0, 5, 0), C02248i.A1M, new C02258j(th));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0M
    public final void AC6(String str, int i, @Nullable String str2, @Nullable Integer num, @Nullable Long l, AnonymousClass06 r18) {
        AnonymousClass7K.A05(this.A00, r18.A06, r18.A08, r18.A09, r18.A07, r18.A03, i, str2, num, l, null);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0M
    public final void AC7(String str, boolean z, AnonymousClass06 r10) {
        AnonymousClass7K.A04(this.A00, new AnonymousClass7J(r10.A06, r10.A08, r10.A07, r10.A03, str), z);
    }
}
