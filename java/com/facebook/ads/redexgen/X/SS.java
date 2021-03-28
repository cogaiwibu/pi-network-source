package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SS implements AbstractC01193x {
    public static byte[] A08;
    public static String[] A09;
    public int A00;
    public AnonymousClass2Q<C00973a> A01;
    public final AnonymousClass3Z A02;
    public final C01203y A03;
    public final Runnable A04;
    public final ArrayList<C00973a> A05;
    public final ArrayList<C00973a> A06;
    public final boolean A07;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A08 = new byte[]{-100, -75, -78, -75, -74, -66, -75, 103, -68, -73, -85, -88, -69, -84, 103, -74, -73, 103, -69, -64, -73, -84, 103, -83, -74, -71, 103, -44, -45, -47, -34, -123, -41, -54, -46, -44, -37, -54, -123, -58, -45, -55, -123, -38, -43, -55, -58, -39, -54, -123, -44, -43, -40, -123, -56, -58, -45, -123, -57, -54, -123, -55, -50, -40, -43, -58, -39, -56, -51, -54, -55, -123, -50, -45, -123, -53, -50, -41, -40, -39, -123, -43, -58, -40, -40, -24, -23, -103, -20, -31, -24, -18, -27, -35, -103, -37, -34, -103, -21, -34, -26, -24, -17, -34, -103, -24, -21, -103, -18, -23, -35, -38, -19, -34, -89, 30, 19, 26, 32, 23, 15, -53, 25, 26, 31, -53, 15, 20, 30, 27, 12, 31, 14, 19, -53, 12, 15, 15, -53, 26, 29, -53, 24, 26, 33, 16, -53, 17, 26, 29, -53, 27, 29, 16, -53, 23, 12, 36, 26, 32, 31};
    }

    public static void A04() {
        A09 = new String[]{"X1JWoRd1RTsi5LXg3YfkE890Z0SkAp6s", "8cHG76lMVFwKxBGRg2kgut24eHhxfbd", "G9TzZa55JFGh4eGgvGtqHGY1m3qrW6LM", "T7A4lgHZzGr7V1uQcw7LfDSO4lerGRH7", "wT7nveBXif1G6UL4LkiEJi9kfhK", "XR1Jqmc9zxsTs7lfyBsyi3NvUHLKhP3K", "pVA6ZWYUVwE4UScIoRBBosOqE3FsfWwK", "nWmw"};
    }

    public SS(AnonymousClass3Z r2) {
        this(r2, false);
    }

    public SS(AnonymousClass3Z r3, boolean z) {
        this.A01 = new SA(30);
        this.A05 = new ArrayList<>();
        this.A06 = new ArrayList<>();
        this.A00 = 0;
        this.A02 = r3;
        this.A07 = z;
        this.A03 = new C01203y(this);
    }

    private int A00(int i, int start) {
        int i2;
        int i3;
        for (int end = this.A06.size() - 1; end >= 0; end--) {
            C00973a r2 = this.A06.get(end);
            if (r2.A00 == 8) {
                if (r2.A02 < r2.A01) {
                    i2 = r2.A02;
                    i3 = r2.A01;
                } else {
                    i2 = r2.A01;
                    i3 = r2.A02;
                }
                if (i < i2 || i > i3) {
                    if (i < r2.A02) {
                        if (start == 1) {
                            r2.A02++;
                            r2.A01++;
                        } else if (start == 2) {
                            r2.A02--;
                            r2.A01--;
                        }
                    }
                } else if (i2 == r2.A02) {
                    if (start == 1) {
                        r2.A01++;
                    } else if (start == 2) {
                        r2.A01--;
                    }
                    i++;
                } else {
                    if (start == 1) {
                        r2.A02++;
                    } else if (start == 2) {
                        r2.A02--;
                    }
                    i--;
                }
            } else if (r2.A02 <= i) {
                if (r2.A00 == 1) {
                    int i4 = r2.A01;
                    if (A09[7].length() != 4) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A09;
                    strArr[7] = "N0sU";
                    strArr[7] = "N0sU";
                    i -= i4;
                } else if (r2.A00 == 2) {
                    i += r2.A01;
                }
            } else if (start == 1) {
                r2.A02++;
            } else if (start == 2) {
                r2.A02--;
            }
        }
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            C00973a r22 = this.A06.get(size);
            if (r22.A00 == 8) {
                if (r22.A01 == r22.A02 || r22.A01 < 0) {
                    this.A06.remove(size);
                    AC8(r22);
                }
            } else if (r22.A01 <= 0) {
                this.A06.remove(size);
                AC8(r22);
            }
        }
        return i;
    }

    private final int A01(int i, int i2) {
        int size = this.A06.size();
        while (i2 < size) {
            C00973a r6 = this.A06.get(i2);
            if (r6.A00 == 8) {
                if (r6.A02 == i) {
                    i = r6.A01;
                } else {
                    if (r6.A02 < i) {
                        i--;
                    }
                    if (r6.A01 <= i) {
                        i++;
                    }
                }
            } else if (r6.A02 > i) {
                continue;
            } else if (r6.A00 != 2) {
                int i3 = r6.A00;
                String[] strArr = A09;
                if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[1] = "6d2Cvy1MfGwOem3AHh21iiz4RwVuOhP";
                strArr2[1] = "6d2Cvy1MfGwOem3AHh21iiz4RwVuOhP";
                if (i3 == 1) {
                    i += r6.A01;
                }
            } else if (i < r6.A02 + r6.A01) {
                return -1;
            } else {
                i -= r6.A01;
            }
            i2++;
        }
        return i;
    }

    private void A05(C00973a r1) {
        A0A(r1);
    }

    private void A06(C00973a r1) {
        A0A(r1);
    }

    private void A07(C00973a r11) {
        int tmpEnd = r11.A02;
        int type = 0;
        int position = r11.A02 + r11.A01;
        char c = 65535;
        int i = r11.A02;
        while (i < position) {
            boolean z = false;
            if (this.A02.A57(i) != null || A0D(i)) {
                if (c == 0) {
                    A09(A8f(2, tmpEnd, type, null));
                    z = true;
                }
                c = 1;
            } else {
                if (c == 1) {
                    A0A(A8f(2, tmpEnd, type, null));
                    z = true;
                }
                c = 0;
            }
            if (z) {
                i -= type;
                position -= type;
                type = 1;
            } else {
                type++;
            }
            i++;
        }
        if (type != r11.A01) {
            AC8(r11);
            r11 = A8f(2, tmpEnd, type, null);
        }
        if (c == 0) {
            A09(r11);
        } else {
            A0A(r11);
        }
    }

    private void A08(C00973a r10) {
        int tmpEnd = r10.A02;
        int type = 0;
        int position = r10.A02 + r10.A01;
        char c = 65535;
        int i = r10.A02;
        while (true) {
            String[] strArr = A09;
            if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[0] = "QVMb2fRXyzWHiAZPpRD1aZXDVthvAAWC";
            strArr2[0] = "QVMb2fRXyzWHiAZPpRD1aZXDVthvAAWC";
            if (i < position) {
                if (this.A02.A57(i) != null || A0D(i)) {
                    if (c == 0) {
                        A09(A8f(4, tmpEnd, type, r10.A03));
                        type = 0;
                        tmpEnd = i;
                    }
                    c = 1;
                } else {
                    if (c == 1) {
                        A0A(A8f(4, tmpEnd, type, r10.A03));
                        type = 0;
                        tmpEnd = i;
                    }
                    c = 0;
                }
                type++;
                i++;
            } else {
                if (type != r10.A01) {
                    Object obj = r10.A03;
                    AC8(r10);
                    r10 = A8f(4, tmpEnd, type, obj);
                }
                if (c == 0) {
                    A09(r10);
                    return;
                } else {
                    A0A(r10);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Multiple debug info for r1v13 int: [D('pos' int), D('tmpCnt' int)] */
    private void A09(C00973a r12) {
        int i;
        if (r12.A00 != 1) {
            int i2 = r12.A00;
            if (A09[4].length() != 28) {
                String[] strArr = A09;
                strArr[7] = "fuh7";
                strArr[7] = "fuh7";
                if (i2 != 8) {
                    int A002 = A00(r12.A02, r12.A00);
                    int i3 = 1;
                    int i4 = r12.A02;
                    int offsetPositionForPartial = r12.A00;
                    if (offsetPositionForPartial == 2) {
                        i = 0;
                    } else if (offsetPositionForPartial == 4) {
                        i = 1;
                    } else {
                        throw new IllegalArgumentException(A02(85, 30, 55) + r12);
                    }
                    int positionMultiplier = 1;
                    while (true) {
                        int i5 = r12.A01;
                        if (A09[1].length() != 31) {
                            if (positionMultiplier >= i5) {
                                break;
                            }
                        } else {
                            String[] strArr2 = A09;
                            strArr2[4] = "Sd1L0VSyo86shE8ew7ry1Omr";
                            strArr2[4] = "Sd1L0VSyo86shE8ew7ry1Omr";
                            if (positionMultiplier >= i5) {
                                break;
                            }
                        }
                        int A003 = A00(r12.A02 + (i * positionMultiplier), r12.A00);
                        int i6 = 0;
                        int updatedPos = r12.A00;
                        int pos = 0;
                        if (updatedPos == 2) {
                            if (A003 == A002) {
                                pos = 1;
                            }
                            i6 = pos;
                        } else if (updatedPos == 4) {
                            if (A003 == A002 + 1) {
                                pos = 1;
                            }
                            i6 = pos;
                        }
                        if (i6 != 0) {
                            i3++;
                        } else {
                            C00973a A8f = A8f(r12.A00, A002, i3, r12.A03);
                            A0B(A8f, i4);
                            AC8(A8f);
                            if (r12.A00 == 4) {
                                i4 += i3;
                            }
                            A002 = A003;
                            if (A09[0].charAt(28) != 'A') {
                                i3 = 1;
                            } else {
                                String[] strArr3 = A09;
                                strArr3[3] = "EcOQEIn9Q5XvTjS6SUXoeHtz7oIrLcgt";
                                strArr3[2] = "qdxRTeDYAvuRxJ3EQmMRRmoNV8wrEDZm";
                                i3 = 1;
                            }
                        }
                        positionMultiplier++;
                    }
                    Object obj = r12.A03;
                    AC8(r12);
                    if (i3 > 0) {
                        C00973a A8f2 = A8f(r12.A00, A002, i3, obj);
                        A0B(A8f2, i4);
                        AC8(A8f2);
                        return;
                    }
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
        throw new IllegalArgumentException(A02(115, 46, 105));
    }

    private void A0A(C00973a r6) {
        this.A06.add(r6);
        int i = r6.A00;
        if (i == 1) {
            this.A02.A8g(r6.A02, r6.A01);
        } else if (i == 2) {
            this.A02.A8j(r6.A02, r6.A01);
        } else if (i == 4) {
            this.A02.A8S(r6.A02, r6.A01, r6.A03);
        } else if (i == 8) {
            this.A02.A8h(r6.A02, r6.A01);
        } else {
            throw new IllegalArgumentException(A02(0, 27, 5) + r6);
        }
    }

    private final void A0B(C00973a r5, int i) {
        this.A02.A9K(r5);
        int i2 = r5.A00;
        if (i2 == 2) {
            this.A02.A8i(i, r5.A01);
        } else if (i2 == 4) {
            this.A02.A8S(i, r5.A01, r5.A03);
        } else {
            throw new IllegalArgumentException(A02(27, 58, 35));
        }
    }

    private final void A0C(List<C00973a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AC8(list.get(i));
        }
        list.clear();
    }

    private boolean A0D(int i) {
        int size = this.A06.size();
        for (int pos = 0; pos < size; pos++) {
            C00973a r6 = this.A06.get(pos);
            if (r6.A00 != 8) {
                int i2 = r6.A00;
                if (A09[4].length() != 28) {
                    String[] strArr = A09;
                    strArr[7] = "h3FT";
                    strArr[7] = "h3FT";
                    if (i2 == 1) {
                        int i3 = r6.A02 + r6.A01;
                        for (int i4 = r6.A02; i4 < i3; i4++) {
                            if (A01(i4, pos + 1) == i) {
                                return true;
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (A01(r6.A01, pos + 1) == i) {
                return true;
            }
        }
        return false;
    }

    public final int A0E(int i) {
        return A01(i, 0);
    }

    public final int A0F(int i) {
        int size = this.A05.size();
        for (int i2 = 0; i2 < size; i2++) {
            C00973a r4 = this.A05.get(i2);
            int i3 = r4.A00;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (r4.A02 == i) {
                            i = r4.A01;
                        } else {
                            if (r4.A02 < i) {
                                i--;
                            }
                            if (r4.A01 <= i) {
                                i++;
                            }
                        }
                    }
                } else if (r4.A02 > i) {
                    continue;
                } else if (r4.A02 + r4.A01 > i) {
                    return -1;
                } else {
                    i -= r4.A01;
                }
            } else if (r4.A02 <= i) {
                i += r4.A01;
            }
        }
        return i;
    }

    public final void A0G() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            this.A02.A9M(this.A06.get(i));
        }
        A0C(this.A06);
        this.A00 = 0;
    }

    public final void A0H() {
        A0G();
        int size = this.A05.size();
        for (int i = 0; i < size; i++) {
            C00973a r5 = this.A05.get(i);
            int i2 = r5.A00;
            if (i2 == 1) {
                this.A02.A9M(r5);
                this.A02.A8g(r5.A02, r5.A01);
            } else if (i2 == 2) {
                this.A02.A9M(r5);
                AnonymousClass3Z r7 = this.A02;
                int i3 = r5.A02;
                int i4 = r5.A01;
                if (A09[0].charAt(28) != 'A') {
                    String[] strArr = A09;
                    strArr[0] = "CM7MK7KhSxDopOj0YrHNMoPSB3hYAvlM";
                    strArr[0] = "CM7MK7KhSxDopOj0YrHNMoPSB3hYAvlM";
                    r7.A8i(i3, i4);
                } else {
                    String[] strArr2 = A09;
                    strArr2[0] = "0a4GBd0juwjU6ZOPGBL8pgIRsQZTAwEC";
                    strArr2[0] = "0a4GBd0juwjU6ZOPGBL8pgIRsQZTAwEC";
                    r7.A8i(i3, i4);
                }
            } else if (i2 == 4) {
                this.A02.A9M(r5);
                AnonymousClass3Z r8 = this.A02;
                int i5 = r5.A02;
                int i6 = r5.A01;
                if (A09[0].charAt(28) != 'A') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A09;
                strArr3[1] = "6Qpi3zwbHCTXm3nhA4JhLro11ECL3LU";
                strArr3[1] = "6Qpi3zwbHCTXm3nhA4JhLro11ECL3LU";
                r8.A8S(i5, i6, r5.A03);
            } else if (i2 == 8) {
                this.A02.A9M(r5);
                this.A02.A8h(r5.A02, r5.A01);
            }
            Runnable runnable = this.A04;
            if (runnable != null) {
                runnable.run();
            }
        }
        A0C(this.A05);
        this.A00 = 0;
    }

    public final void A0I() {
        this.A03.A06(this.A05);
        int size = this.A05.size();
        for (int i = 0; i < size; i++) {
            C00973a r6 = this.A05.get(i);
            int i2 = r6.A00;
            String[] strArr = A09;
            if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[1] = "1BDdKJQJlsgxETOK14Gjs1hC7fjbuKK";
            strArr2[1] = "1BDdKJQJlsgxETOK14Gjs1hC7fjbuKK";
            if (i2 == 1) {
                A05(r6);
            } else if (i2 == 2) {
                A07(r6);
            } else if (i2 == 4) {
                A08(r6);
            } else if (i2 == 8) {
                A06(r6);
            }
            Runnable runnable = this.A04;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.A05.clear();
    }

    public final void A0J() {
        A0C(this.A05);
        A0C(this.A06);
        this.A00 = 0;
    }

    public final boolean A0K() {
        return this.A05.size() > 0;
    }

    public final boolean A0L() {
        return !this.A06.isEmpty() && !this.A05.isEmpty();
    }

    public final boolean A0M(int i) {
        return (this.A00 & i) != 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01193x
    public final C00973a A8f(int i, int i2, int i3, Object obj) {
        C00973a A2P = this.A01.A2P();
        if (A2P == null) {
            return new C00973a(i, i2, i3, obj);
        }
        A2P.A00 = i;
        A2P.A02 = i2;
        A2P.A01 = i3;
        A2P.A03 = obj;
        return A2P;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01193x
    public final void AC8(C00973a r2) {
        if (!this.A07) {
            r2.A03 = null;
            this.A01.ACG(r2);
        }
    }
}
