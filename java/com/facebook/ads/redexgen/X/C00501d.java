package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.1d  reason: invalid class name and case insensitive filesystem */
public final class C00501d {
    public static byte[] A0C;
    public static String[] A0D;
    public AbstractC00430w A00;
    public AnonymousClass16 A01;
    public AnonymousClass7H A02;
    public String A03;
    public String A04;
    public List<AnonymousClass1Z> A05;
    public List<C00471a> A06;
    public List<C00481b> A07;
    public List<AnonymousClass1Z> A08;
    public List<C00471a> A09;
    public List<C00481b> A0A;
    public boolean A0B;

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0C = new byte[]{70, 97, 121, 110, 99, 102, 107, 47, 76, 110, 108, 103, 106, 71, 106, 99, ByteCompanionObject.MAX_VALUE, 106, 125, 47, 102, 124, 47, 123, 125, 118, 102, 97, 104, 47, 123, 96, 47, 108, 110, 108, 103, 106, 47, 110, 124, 124, 106, 123, 124, 98, 96, 98, 105, 100, 94, 108, 96, 111, 101, 96, 117, 110, 115, 120, 94, 103, 104, 109, 100, 114, 71, 69, 71, 76, 65, 123, 73, 69, 74, 64, 69, 80, 75, 86, 93, 123, 77, 73, 69, 67, 65, 87, 81, 83, 81, 90, 87, 109, 95, 83, 92, 86, 83, 70, 93, 64, 75, 109, 68, 91, 86, 87, 93, 65};
    }

    public static void A06() {
        A0D = new String[]{"sSa", "mi5m9ruhoFx", "", "s1wudweLxGs6i20t889bnIZHd8X0m2eo", "Fcx9vpMoDT8ZievIpIvDEirtE1Us4xir", "sWXb4LdtlKvePJz7J6b2Ft", "9VqadD5Zvd9D5BEd6Wk7rSckzIYQNWUp", "eNXwk482U"};
    }

    public C00501d(AbstractC00430w r3, AnonymousClass16 r4, String str, AnonymousClass7H r6) {
        this.A01 = r4;
        if (!A09()) {
            this.A0B = false;
            return;
        }
        this.A0B = true;
        JSONObject A0X = this.A01.A0X();
        this.A00 = r3;
        try {
            this.A06 = C00491c.A05(A0X);
            this.A07 = C00491c.A06(A0X);
            this.A05 = C00491c.A04(A0X);
            this.A09 = C00491c.A08(A0X);
            this.A0A = C00491c.A09(A0X);
            this.A08 = C00491c.A07(A0X);
        } catch (IllegalStateException unused) {
            this.A00.A97();
        }
        this.A04 = r4.A0U();
        this.A03 = str;
        this.A02 = r6;
    }

    private void A02() {
        Iterator<AnonymousClass1Z> it;
        Iterator<C00471a> it2 = this.A06.iterator();
        while (true) {
            boolean hasNext = it2.hasNext();
            if (A0D[7].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[2] = "s43HwKDQ";
            strArr[2] = "s43HwKDQ";
            if (hasNext) {
                C00471a next = it2.next();
                this.A02.A0R(new AnonymousClass7E(next.A02(), next.A00(), next.A01(), this.A04, this.A03));
            } else {
                for (C00481b r1 : this.A07) {
                    this.A02.A0W(new AnonymousClass7G(r1.A01(), this.A04, this.A03, r1.A00()));
                }
                List<AnonymousClass1Z> list = this.A05;
                if (A0D[2].length() != 15) {
                    String[] strArr2 = A0D;
                    strArr2[5] = "Ng223TSybiacEU1WWPLk2q";
                    strArr2[5] = "Ng223TSybiacEU1WWPLk2q";
                    it = list.iterator();
                } else {
                    String[] strArr3 = A0D;
                    strArr3[7] = "18SymYfpU";
                    strArr3[7] = "18SymYfpU";
                    it = list.iterator();
                }
                while (true) {
                    boolean hasNext2 = it.hasNext();
                    if (A0D[7].length() != 9) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A0D;
                    strArr4[4] = "gi3GLNiIWCAwlyNF5UJWvDNlEZ56BupW";
                    strArr4[4] = "gi3GLNiIWCAwlyNF5UJWvDNlEZ56BupW";
                    if (hasNext2) {
                        AnonymousClass1Z next2 = it.next();
                        AnonymousClass7G cacheFileData = new AnonymousClass7G(next2.A01(), this.A04, this.A03);
                        cacheFileData.A04 = !next2.A00().equals(A01(0, 0, 60));
                        cacheFileData.A03 = next2.A00();
                        this.A02.A0T(cacheFileData);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void A03() {
        for (C00471a r1 : this.A09) {
            this.A02.A0S(new AnonymousClass7E(r1.A02(), r1.A00(), r1.A01(), this.A04, this.A03));
        }
        List<C00481b> list = this.A0A;
        if (A0D[7].length() != 9) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[2] = "XaDaKpjcAfkqTK4VX";
        strArr[2] = "XaDaKpjcAfkqTK4VX";
        for (C00481b videoCacheData : list) {
            this.A02.A0V(new AnonymousClass7G(videoCacheData.A01(), this.A04, this.A03));
        }
        for (AnonymousClass1Z r5 : this.A08) {
            AnonymousClass7G r4 = new AnonymousClass7G(r5.A01(), this.A04, this.A03);
            r4.A04 = !r5.A00().equals(A01(0, 0, 60));
            r4.A03 = r5.A00();
            this.A02.A0U(r4);
        }
    }

    private void A04() {
        this.A02.A0Q(new RV(this), new AnonymousClass7A(this.A04, this.A03));
    }

    private boolean A07(String str) {
        AnonymousClass16 r0 = this.A01;
        if (r0 != null) {
            return r0.A0X().has(str);
        }
        return false;
    }

    public final void A08() {
        if (A09()) {
            A02();
            A03();
            A04();
            return;
        }
        throw new IllegalStateException(A01(0, 45, 50));
    }

    public final boolean A09() {
        AnonymousClass16 r0 = this.A01;
        if (r0 == null) {
            return this.A0B;
        }
        JSONObject A0X = r0.A0X();
        if (A0D[5].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[5] = "0MUxNIoi6mFZgBaSZOUpUP";
        strArr[5] = "0MUxNIoi6mFZgBaSZOUpUP";
        return this.A0B || (A0X != null && A07(A01(66, 22, 25)) && A07(A01(88, 22, 15)) && A07(A01(45, 21, 60)));
    }
}
