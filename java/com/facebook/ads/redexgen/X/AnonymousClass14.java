package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.14  reason: invalid class name */
public final class AnonymousClass14 extends BroadcastReceiver {
    public static byte[] A03;
    public static String[] A04;
    public Context A00;
    public C02619t A01;
    public boolean A02 = false;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{25, 3, 15, 13, 78, 6, 1, 3, 5, 2, 15, 15, 11, 78, 1, 4, 19, 78, 9, 14, 20, 5, 18, 19, 20, 9, 20, 9, 1, 12, 78, 4, 9, 19, 16, 12, 1, 25, 5, 4, 19, 31, 29, 94, 22, 17, 19, 21, 18, 31, 31, 27, 94, 17, 20, 3, 94, 25, 30, 4, 21, 2, 3, 4, 25, 4, 25, 17, 28, 94, 20, 25, 3, 0, 28, 17, 9, 21, 20, 74, 18, 1, 18, 25, 3, 81, 68, 83, 71, 78, 83, 76, 98, 85, 64, 98, 77, 72, 66, 74, 83, 70, 81, 69, 76, 81, 78, 96, 87, 66, 96, 79, 74, 64, 72, 25, 45, 50, 63, 62, 52, 18, 53, 47, 62, 41, 40, 47, 50, 47, 58, 55, 30, 45, 62, 53, 47, 2, 29, 16, 17, 27, 61, 26, 0, 17, 6, 7, 0, 29, 0, 21, 24, 49, 2, 17, 26, 0, 78};
    }

    public static void A02() {
        A04 = new String[]{"X1IVw5mZrPwWgp59pDL9aLZ3Fov3W2Wm", "N1AsLxATz8LfRIPBbwS0prqi9bKFNGwZ", "KvfN8PD7zJtQDsMeVTqT5dRzLvhiPQFs", "CwJ4sBopjGul5sxVyPsrv7O0APgi12j8", "riYYfsMk5nddhbnpPSj9znzkTr5bDpPf", "Be1xHvNUMQ0R9QZ", "t7JwnvsmbbV8km6q46", "oSYhwD14tF3vT8zAS1lFRiV2H2FAfEUD"};
    }

    public AnonymousClass14(C02619t r2, Context context) {
        this.A01 = r2;
        this.A00 = context;
    }

    public final void A03() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(40, 40, 17) + this.A01.getUniqueId());
        intentFilter.addAction(A00(137, 22, 21) + this.A01.getUniqueId());
        intentFilter.addAction(A00(100, 16, 66) + this.A01.getUniqueId());
        AnonymousClass2F.A00(this.A00).A07(this, intentFilter);
    }

    public final void A04() {
        try {
            AnonymousClass2F.A00(this.A00).A06(this);
        } catch (Exception unused) {
        }
    }

    public final void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(A00(0, 1, 66));
        if (split.length != 2 || !split[1].equals(this.A01.getUniqueId())) {
            return;
        }
        if (!split[0].equals(A00(1, 39, 1))) {
            String str = split[0];
            if (A04[2].charAt(17) != 'T') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[7] = "czH1g8WXqBVBzZgoSLVA20jYFFcQLh15";
            strArr[7] = "czH1g8WXqBVBzZgoSLVA20jYFFcQLh15";
            if (str.equals(A00(116, 21, 58))) {
                Serializable serializableExtra = intent.getSerializableExtra(A00(80, 5, 22));
                if (serializableExtra instanceof IW) {
                    if (this.A01.getListener() != null) {
                        this.A01.getListener().A9a();
                        this.A01.getListener().ABO();
                    }
                    if (this.A02) {
                        this.A01.A0V(1);
                    } else {
                        this.A01.A0V(((IW) serializableExtra).A01());
                    }
                    this.A01.setVisibility(0);
                    this.A01.A0Y(EnumC0626Os.A05, 1);
                } else if (serializableExtra instanceof K1) {
                    if (this.A01.getListener() != null) {
                        ME listener = this.A01.getListener();
                        if (A04[4].charAt(15) != 'p') {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A04;
                        strArr2[0] = "WizhEabCQfIhxCPZxjxQrLo8096TZ2te";
                        strArr2[0] = "WizhEabCQfIhxCPZxjxQrLo8096TZ2te";
                        listener.A9d();
                    }
                } else if (serializableExtra instanceof C0507Jz) {
                    if (this.A01.getListener() != null) {
                        this.A01.getListener().A9e();
                    }
                } else if (serializableExtra instanceof AnonymousClass7v) {
                    if (this.A01.getListener() != null) {
                        this.A01.getListener().A9B();
                    }
                    this.A02 = true;
                } else if (serializableExtra instanceof C0501Jt) {
                    if (this.A01.getListener() != null) {
                        ME listener2 = this.A01.getListener();
                        if (A04[5].length() != 15) {
                            String[] strArr3 = A04;
                            strArr3[5] = "OhpiyJuLhpOH2Z5";
                            strArr3[5] = "OhpiyJuLhpOH2Z5";
                            listener2.AAQ();
                        } else {
                            String[] strArr4 = A04;
                            strArr4[1] = "rjxpcIZarLCWG40Y5u8euDt94bevKfNO";
                            strArr4[1] = "rjxpcIZarLCWG40Y5u8euDt94bevKfNO";
                            listener2.AAQ();
                        }
                    }
                    this.A02 = false;
                } else if ((serializableExtra instanceof C02147t) && this.A01.getListener() != null) {
                    this.A01.getListener().onPause();
                }
            } else if (split[0].equals(A00(85, 15, 64))) {
                this.A01.A0i();
            }
        } else if (this.A01.getListener() != null) {
            this.A01.getListener().A9U();
            this.A01.getListener().ABO();
        }
    }
}
