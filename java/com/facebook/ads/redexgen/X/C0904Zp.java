package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Zp  reason: case insensitive filesystem */
public final class C0904Zp implements HZ {
    public static String[] A0C;
    public long A00;
    public long A01 = -1;
    public long A02;
    public HQ A03;
    public boolean A04 = true;
    public final Uri A05;
    public final CR A06 = new CR();
    public final FC A07;
    public final HM A08;
    public final I7 A09;
    public volatile boolean A0A;
    public final /* synthetic */ C0292Az A0B;

    static {
        A04();
    }

    public static void A04() {
        A0C = new String[]{"nBGgOhUJr5w54zk2FcSY", "YYZuUd", "gwBohD1o6c6DfEcFdJm47xfjaEoVukk3", "3TNnSL", "hJWvKqQqk09hkKqv49F3L8Ilz7Jhye22", "G8FOHrMAxxSNQBngbaVWxtAhYQnldn5N", "v6FRbmkBAKb4FwdIpHjrHHJWg4k1tULi", "7hirQzfzNIRD79h7knAyc8"};
    }

    public C0904Zp(C0292Az az, Uri uri, HM hm, FC fc, I7 i7) {
        this.A0B = az;
        this.A05 = (Uri) I1.A01(uri);
        this.A08 = (HM) I1.A01(hm);
        this.A07 = (FC) I1.A01(fc);
        this.A09 = i7;
    }

    public final void A05(long j, long j2) {
        this.A06.A00 = j;
        this.A02 = j2;
        this.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.X.HZ
    public final void A3y() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.HZ
    public final void A7q() throws IOException, InterruptedException {
        int i = 0;
        while (i == 0) {
            boolean z = this.A0A;
            if (A0C[0].length() != 9) {
                String[] strArr = A0C;
                strArr[3] = "6lKOSY";
                strArr[1] = "aO7eUD";
                if (!z) {
                    CL cl = null;
                    try {
                        long j = this.A06.A00;
                        this.A03 = new HQ(this.A05, j, -1, this.A0B.A0b);
                        this.A01 = this.A08.ABP(this.A03);
                        if (this.A01 != -1) {
                            this.A01 += j;
                        }
                        YD yd = new YD(this.A08, j, this.A01);
                        CK A032 = this.A07.A03(yd, this.A08.A7C());
                        if (this.A04) {
                            A032.ACj(j, this.A02);
                            this.A04 = false;
                        }
                        while (i == 0 && !this.A0A) {
                            this.A09.A01();
                            i = A032.ABx(yd, this.A06);
                            if (yd.A6m() > this.A0B.A0P + j) {
                                j = yd.A6m();
                                this.A09.A02();
                                this.A0B.A0R.post(this.A0B.A0a);
                            }
                        }
                        if (i == 1) {
                            i = 0;
                        } else {
                            this.A06.A00 = yd.A6m();
                            this.A00 = this.A06.A00 - this.A03.A01;
                        }
                        C0466Ig.A0X(this.A08);
                    } catch (Throwable th) {
                        if (!(i == 1 || 0 == 0)) {
                            this.A06.A00 = cl.A6m();
                            this.A00 = this.A06.A00 - this.A03.A01;
                        }
                        C0466Ig.A0X(this.A08);
                        throw th;
                    }
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }
}
