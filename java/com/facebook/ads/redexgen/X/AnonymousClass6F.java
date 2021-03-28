package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.6F  reason: invalid class name */
public final class AnonymousClass6F {
    @Nullable
    public static AnonymousClass6F A07;
    public static String[] A08;
    public static final AtomicBoolean A09 = new AtomicBoolean();
    public AnonymousClass6E A00 = new AnonymousClass6E(this, AnonymousClass73.A00().A04().getLooper());
    public AnonymousClass6O A01;
    public AnonymousClass6P A02;
    public List<AnonymousClass6S> A03;
    public final Context A04;
    public final C01725z A05;
    public final EnumC01856m A06;

    public static void A02() {
        A08 = new String[]{"lhELmGRUtbYPcwJFNCjn5HfCntRtzqQU", "Mt1hbHTlPicMeG4rtX3JBcBhsjGdj", "WXTUL6dhKmyeG13MmR9X1nSF3ta0T4v7", "pnvqG2PyjZWupJIeMnGxGNF5M9wfPV2M", "tVIu8wQwIUzvrLJUsX9QEkuDOevngDVu", "qDTAVfu3jvCTQwnOSiE3SjcB7mVx4hBM", "klm6aBATY902pfwdRKxrpHOkJcym9ne5", "D4wxrsR0ab6WquJuKpvZlDWLQMdeNXqb"};
    }

    static {
        A02();
    }

    public AnonymousClass6F(C01725z r3, Context context) {
        this.A05 = r3;
        this.A04 = context;
        this.A06 = r3.A0a();
    }

    public static synchronized AnonymousClass6F A00(Context context, C01725z r3) {
        AnonymousClass6F r0;
        synchronized (AnonymousClass6F.class) {
            if (A07 == null) {
                A07 = new AnonymousClass6F(r3, context);
            }
            r0 = A07;
        }
        return r0;
    }

    private synchronized void A03() {
        A09.set(false);
        this.A03 = new ArrayList();
        String[] strArr = A08;
        if (strArr[2].charAt(18) != strArr[4].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "OJ9tJzFQNQxQ8qaEQfi4ar7y8Z5YVilt";
        strArr2[1] = "oKX4c494QlidqOlhH9QFYLNn1ihcq";
    }

    public final synchronized void A04() {
        if (this.A01 != null) {
            this.A01.A04(this.A03);
        }
        A03();
    }

    public final synchronized void A05(Map<Integer, C01786f> map, EnumC01826j r7) {
        A03();
        AnonymousClass6J r3 = new AnonymousClass6J(this.A05, map);
        for (Map.Entry<Integer, C01786f> entry : map.entrySet()) {
            C01786f bdSignal = entry.getValue();
            if (bdSignal != null) {
                if (bdSignal.A04(r7)) {
                    int intValue = entry.getKey().intValue();
                    if (intValue != 10800) {
                        switch (intValue) {
                            case 10810:
                                this.A03.add(AnonymousClass6S.A04);
                                continue;
                            case 10811:
                                this.A03.add(AnonymousClass6S.A08);
                                continue;
                            case 10812:
                                this.A03.add(AnonymousClass6S.A0A);
                                continue;
                            case 10813:
                                this.A03.add(AnonymousClass6S.A07);
                                continue;
                            case 10814:
                                this.A03.add(AnonymousClass6S.A0B);
                                continue;
                            case 10815:
                                this.A03.add(AnonymousClass6S.A0C);
                                continue;
                            case 10816:
                                this.A03.add(AnonymousClass6S.A0E);
                                continue;
                            case 10817:
                                this.A03.add(AnonymousClass6S.A09);
                                continue;
                            case 10818:
                                this.A03.add(AnonymousClass6S.A06);
                                continue;
                            case 10819:
                                this.A03.add(AnonymousClass6S.A05);
                                continue;
                            case 10820:
                                this.A03.add(AnonymousClass6S.A0D);
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        this.A02 = new AnonymousClass6P(this.A04, r3, this.A06);
                        A09.set(true);
                    }
                }
            }
        }
        this.A01 = new AnonymousClass6O(this.A04, r3, this.A06);
        this.A01.A03(this.A03);
        if (!this.A00.getLooper().getThread().isAlive()) {
            this.A00 = new AnonymousClass6E(this, AnonymousClass73.A00().A04().getLooper());
        }
    }

    public final synchronized boolean A06(MotionEvent motionEvent) {
        if (!A09.get()) {
            return false;
        }
        Message message = new Message();
        message.what = AnonymousClass6D.A03.ordinal();
        message.obj = motionEvent;
        this.A00.sendMessage(message);
        return true;
    }
}
