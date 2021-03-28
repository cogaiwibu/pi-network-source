package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.redexgen.X.3q  reason: invalid class name and case insensitive filesystem */
public final class RunnableC01133q implements Runnable {
    public static Comparator<C01123p> A04 = new C01113o();
    public static byte[] A05;
    public static String[] A06;
    public static final ThreadLocal<RunnableC01133q> A07 = new ThreadLocal<>();
    public long A00;
    public long A01;
    public ArrayList<ES> A02 = new ArrayList<>();
    public ArrayList<C01123p> A03 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{97, 101, 47, 93, 116, -126, -125, 116, 115, 47, 95, -127, 116, 117, 116, -125, 114, 119, 92, 96, 42, 90, 124, 111, 112, 111, 126, 109, 114};
    }

    public static void A04() {
        A06 = new String[]{"C", "g", "thIgEQWd9nx", "UJ", "nKFIv9xSQBz", "WKzZJ6F0j2u08DpGCnjDR9E", "2Nt4JwZoKXCf4OpJNcF1oxTto7W5gJbD", "RW"};
    }

    static {
        A04();
        A03();
    }

    private AnonymousClass4X A00(ES es, int i, long j) {
        if (A09(es, i)) {
            return null;
        }
        AnonymousClass4N r3 = es.A0r;
        try {
            es.A1M();
            AnonymousClass4X A0J = r3.A0J(i, false, j);
            if (A0J != null) {
                if (!A0J.A0b() || A0J.A0c()) {
                    r3.A0e(A0J, false);
                } else {
                    r3.A0Y(A0J.A0H);
                }
            }
            return A0J;
        } finally {
            es.A1r(false);
        }
    }

    /* JADX INFO: Multiple debug info for r9v0 int: [D('totalTaskIndex' int), D('i' int)] */
    /* JADX INFO: Multiple debug info for r0v22 'task'  com.facebook.ads.redexgen.X.3p: [D('task' com.facebook.ads.redexgen.X.3p), D('prefetchRegistry' com.facebook.ads.redexgen.X.ST)] */
    private void A02() {
        C01123p task;
        boolean z;
        int i = this.A02.size();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ES es = this.A02.get(i3);
            if (es.getWindowVisibility() == 0) {
                es.A02.A05(es, false);
                i2 += es.A02.A00;
            }
        }
        this.A03.ensureCapacity(i2);
        int i4 = 0;
        String[] strArr = A06;
        if (strArr[3].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[3] = "OH";
        strArr2[7] = "7S";
        for (int i5 = 0; i5 < i; i5++) {
            ES es2 = this.A02.get(i5);
            if (es2.getWindowVisibility() == 0) {
                ST st = es2.A02;
                int abs = Math.abs(st.A01) + Math.abs(st.A02);
                for (int i6 = 0; i6 < st.A00 * 2; i6 += 2) {
                    if (i4 >= this.A03.size()) {
                        task = new C01123p();
                        this.A03.add(task);
                    } else {
                        task = this.A03.get(i4);
                    }
                    int i7 = st.A03[i6 + 1];
                    if (i7 <= abs) {
                        z = true;
                    } else {
                        z = false;
                    }
                    task.A04 = z;
                    task.A02 = abs;
                    task.A00 = i7;
                    task.A03 = es2;
                    task.A01 = st.A03[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.A03, A04);
    }

    private void A05(long j) {
        for (int i = 0; i < this.A03.size(); i++) {
            C01123p r1 = this.A03.get(i);
            if (r1.A03 != null) {
                A07(r1, j);
                r1.A00();
            } else {
                return;
            }
        }
    }

    private final void A06(long j) {
        A02();
        A05(j);
    }

    private void A07(C01123p r5, long j) {
        long j2;
        if (r5.A04) {
            j2 = Long.MAX_VALUE;
        } else {
            j2 = j;
        }
        AnonymousClass4X A002 = A00(r5.A03, r5.A01, j2);
        if (A002 != null && A002.A09 != null && A002.A0b() && !A002.A0c()) {
            A08(A002.A09.get(), j);
        }
    }

    private void A08(@Nullable ES es, long j) {
        if (es != null) {
            if (es.A0C) {
                C01003d r3 = es.A01;
                if (A06[5].length() != 17) {
                    String[] strArr = A06;
                    strArr[6] = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW";
                    strArr[6] = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW";
                    if (r3.A07() != 0) {
                        es.A1P();
                    }
                }
                throw new RuntimeException();
            }
            ST st = es.A02;
            st.A05(es, true);
            if (st.A00 != 0) {
                try {
                    AnonymousClass2H.A01(A01(0, 18, 7));
                    es.A0s.A05(es.A04);
                    int i = 0;
                    while (true) {
                        int i2 = st.A00 * 2;
                        if (A06[6].charAt(8) == 'I') {
                            break;
                        }
                        String[] strArr2 = A06;
                        strArr2[3] = "nG";
                        strArr2[7] = "TD";
                        if (i < i2) {
                            A00(es, st.A03[i], j);
                            i += 2;
                        } else {
                            return;
                        }
                    }
                    throw new RuntimeException();
                } finally {
                    AnonymousClass2H.A00();
                }
            }
        }
    }

    public static boolean A09(ES es, int i) {
        int A072 = es.A01.A07();
        for (int i2 = 0; i2 < A072; i2++) {
            AnonymousClass4X A0G = ES.A0G(es.A01.A0B(i2));
            if (A0G.A03 == i && !A0G.A0c()) {
                return true;
            }
        }
        return false;
    }

    public final void A0A(ES es) {
        this.A02.add(es);
    }

    public final void A0B(ES es) {
        this.A02.remove(es);
    }

    public final void A0C(ES es, int i, int i2) {
        if (es.isAttachedToWindow() && this.A01 == 0) {
            this.A01 = es.getNanoTime();
            es.post(this);
        }
        es.A02.A04(i, i2);
    }

    public final void run() {
        try {
            AnonymousClass2H.A01(A01(18, 11, 2));
            if (!this.A02.isEmpty()) {
                int size = this.A02.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    ES es = this.A02.get(i);
                    if (es.getWindowVisibility() == 0) {
                        j = Math.max(es.getDrawingTime(), j);
                    }
                }
                if (j == 0) {
                    this.A01 = 0;
                    if (A06[5].length() != 17) {
                        String[] strArr = A06;
                        strArr[5] = "H4nD1dOrFb1";
                        strArr[5] = "H4nD1dOrFb1";
                        AnonymousClass2H.A00();
                        return;
                    }
                    throw new RuntimeException();
                }
                A06(TimeUnit.MILLISECONDS.toNanos(j) + this.A00);
                this.A01 = 0;
                AnonymousClass2H.A00();
            }
        } finally {
            this.A01 = 0;
            AnonymousClass2H.A00();
        }
    }
}
