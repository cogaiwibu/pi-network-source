package com.facebook.ads.redexgen.X;

import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3y  reason: invalid class name and case insensitive filesystem */
public final class C01203y {
    public static String[] A01;
    public final AbstractC01193x A00;

    static {
        A01();
    }

    public static void A01() {
        A01 = new String[]{"1CU3iw4Trc3qggngkxP7P26jEGLrLZaR", "qcH7HKgKdAybLTWn0rmK7JyCE0S9C8rn", "oNJ0dA1Zpt4CixMfeWT18n5RxX88Y0E3", "FZ8N3xW3PfzdZjJWrErZ2QIuE13XuJtD", "DvPOKoiXqOiYMgjx6IqCziqOSBLzEcJY", "MpMZeZ7xc490HXAXJonG5r1KTyiIoUHH", "NGMd8PbmdSzgSLgNcWdVjgLa", "jY1Ixh6DMe9BpV8yAbg842YJP45AQ2Eb"};
    }

    public C01203y(AbstractC01193x r1) {
        this.A00 = r1;
    }

    private int A00(List<C00973a> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).A00 != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void A02(List<C00973a> list, int i, int i2) {
        C00973a r5 = list.get(i);
        C00973a nextOp = list.get(i2);
        int i3 = nextOp.A00;
        if (i3 == 1) {
            String[] strArr = A01;
            if (strArr[1].charAt(7) != strArr[5].charAt(7)) {
                String[] strArr2 = A01;
                strArr2[0] = "aUQhN9RPINWHdtDS2haQB24BMlUHbr4B";
                strArr2[7] = "XOFwSchhjWWz78nEYYkf12AsjhBhdKRi";
                A03(list, i, r5, i2, nextOp);
                return;
            }
            throw new RuntimeException();
        } else if (i3 == 2) {
            A04(list, i, r5, i2, nextOp);
        } else if (i3 == 4) {
            A05(list, i, r5, i2, nextOp);
        }
    }

    private void A03(List<C00973a> list, int i, C00973a r6, int i2, C00973a r8) {
        int i3 = 0;
        if (r6.A01 < r8.A02) {
            i3 = 0 - 1;
        }
        if (r6.A02 < r8.A02) {
            i3++;
        }
        if (r8.A02 <= r6.A02) {
            r6.A02 += r8.A01;
        }
        if (r8.A02 <= r6.A01) {
            r6.A01 += r8.A01;
        }
        r8.A02 += i3;
        list.set(i, r8);
        list.set(i2, r6);
    }

    private final void A04(List<C00973a> list, int i, C00973a r11, int i2, C00973a r13) {
        boolean z;
        C00973a r2 = null;
        boolean z2 = false;
        if (r11.A02 < r11.A01) {
            z = false;
            if (r13.A02 == r11.A02 && r13.A01 == r11.A01 - r11.A02) {
                z2 = true;
            }
        } else {
            z = true;
            if (r13.A02 == r11.A01 + 1 && r13.A01 == r11.A02 - r11.A01) {
                z2 = true;
            }
        }
        if (r11.A01 < r13.A02) {
            r13.A02--;
        } else if (r11.A01 < r13.A02 + r13.A01) {
            r13.A01--;
            r11.A00 = 2;
            r11.A01 = 1;
            int i3 = r13.A01;
            if (A01[6].length() != 11) {
                String[] strArr = A01;
                strArr[2] = "8AUTweiK2qHuqKAjuAP9RAHRjtqC9cI5";
                strArr[3] = "fxjAamJyQJjVOLb9u9QxKoC9co41mLuZ";
                if (i3 == 0) {
                    list.remove(i2);
                    this.A00.AC8(r13);
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
        if (r11.A02 <= r13.A02) {
            r13.A02++;
        } else if (r11.A02 < r13.A02 + r13.A01) {
            r2 = this.A00.A8f(2, r11.A02 + 1, (r13.A02 + r13.A01) - r11.A02, null);
            r13.A01 = r11.A02 - r13.A02;
        }
        if (z2) {
            list.set(i, r13);
            list.remove(i2);
            this.A00.AC8(r11);
            return;
        }
        if (z) {
            if (r2 != null) {
                if (r11.A02 > r2.A02) {
                    r11.A02 -= r2.A01;
                }
                if (r11.A01 > r2.A02) {
                    r11.A01 -= r2.A01;
                }
            }
            if (r11.A02 > r13.A02) {
                r11.A02 -= r13.A01;
            }
            if (r11.A01 > r13.A02) {
                r11.A01 -= r13.A01;
            }
        } else {
            if (r2 != null) {
                if (r11.A02 >= r2.A02) {
                    r11.A02 -= r2.A01;
                }
                if (r11.A01 >= r2.A02) {
                    r11.A01 -= r2.A01;
                }
            }
            if (r11.A02 >= r13.A02) {
                r11.A02 -= r13.A01;
            }
            if (r11.A01 >= r13.A02) {
                r11.A01 -= r13.A01;
            }
        }
        list.set(i, r13);
        String[] strArr2 = A01;
        if (strArr2[1].charAt(7) != strArr2[5].charAt(7)) {
            String[] strArr3 = A01;
            strArr3[1] = "R1vl9Esi4EQuoIO0IEs3BYKA9Bp2yfIo";
            strArr3[5] = "ll7MLLjNdpT1F8Cd0W3dCYnGe1w6KT9M";
            if (r11.A02 != r11.A01) {
                list.set(i2, r11);
            } else {
                list.remove(i2);
            }
            if (r2 != null) {
                list.add(i, r2);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private final void A05(List<C00973a> list, int i, C00973a r11, int i2, C00973a r13) {
        C00973a r6 = null;
        C00973a r4 = null;
        if (r11.A01 < r13.A02) {
            r13.A02--;
        } else if (r11.A01 < r13.A02 + r13.A01) {
            r13.A01--;
            r6 = this.A00.A8f(4, r11.A02, 1, r13.A03);
        }
        if (r11.A02 <= r13.A02) {
            r13.A02++;
        } else if (r11.A02 < r13.A02 + r13.A01) {
            int i3 = (r13.A02 + r13.A01) - r11.A02;
            r4 = this.A00.A8f(4, r11.A02 + 1, i3, r13.A03);
            r13.A01 -= i3;
        }
        list.set(i2, r11);
        if (r13.A01 > 0) {
            list.set(i, r13);
        } else {
            list.remove(i);
            this.A00.AC8(r13);
        }
        if (r6 != null) {
            list.add(i, r6);
        }
        if (r4 != null) {
            list.add(i, r4);
        }
    }

    public final void A06(List<C00973a> list) {
        while (true) {
            int A002 = A00(list);
            if (A002 != -1) {
                A02(list, A002, A002 + 1);
            } else {
                return;
            }
        }
    }
}
