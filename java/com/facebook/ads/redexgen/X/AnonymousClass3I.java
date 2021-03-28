package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.3I  reason: invalid class name */
public final class AnonymousClass3I extends AbstractC0313Cd implements Handler.Callback {
    public static String[] A0B;
    public int A00;
    public int A01;
    public AbstractC0358Dy A02;
    public boolean A03;
    public final Handler A04;
    public final AH A05;
    public final E0 A06;
    public final CC A07;
    public final E1 A08;
    public final long[] A09;
    public final Metadata[] A0A;

    static {
        A01();
    }

    public static void A01() {
        A0B = new String[]{"03Bqi0KbTszfVpZRuJU3ds8C", "k1GP5ixeRS7AgIgDUeTgx", "4NCpljRKbMpI7nrSCbEL8iNDtCMdRKX", "14neR4MzrfGB8mqjKcaUOPf9qenZk", "2yEqk33zpOnAOPOYE0N2JJzqUjZjGZ3w", "pyvhSQAAYlr5mafzJ0Hik2RvaYh4S", "eoJA2AjfdFBVMgfGYGogvo8ECKzj9gDa", "xUrUxSkwRZIOD3qEvYK8t45D"};
    }

    public AnonymousClass3I(E1 e1, Looper looper) {
        this(e1, looper, E0.A00);
    }

    public AnonymousClass3I(E1 e1, Looper looper, E0 e0) {
        super(4);
        Handler handler;
        this.A08 = (E1) I1.A01(e1);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.A04 = handler;
        this.A06 = (E0) I1.A01(e0);
        this.A05 = new AH();
        this.A07 = new CC();
        this.A0A = new Metadata[5];
        this.A09 = new long[5];
    }

    private void A00() {
        Arrays.fill(this.A0A, (Object) null);
        this.A01 = 0;
        this.A00 = 0;
    }

    private void A02(Metadata metadata) {
        Handler handler = this.A04;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            A03(metadata);
        }
    }

    private void A03(Metadata metadata) {
        this.A08.AAE(metadata);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A14() {
        A00();
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A17(long j, boolean z) {
        A00();
        this.A03 = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A19(Format[] formatArr, long j) throws A4 {
        this.A02 = this.A06.A4E(formatArr[0]);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7Z() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7i() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final void ACQ(long j, long j2) throws A4 {
        if (!this.A03 && this.A00 < 5) {
            this.A07.A07();
            if (A12(this.A05, this.A07, false) == -4) {
                if (this.A07.A04()) {
                    this.A03 = true;
                } else if (!this.A07.A03()) {
                    CC cc = this.A07;
                    String[] strArr = A0B;
                    if (strArr[0].length() != strArr[7].length()) {
                        String[] strArr2 = A0B;
                        strArr2[6] = "oJNy7wvRq4TsnN4Ik7JOHneCelTjV3TM";
                        strArr2[4] = "4f5lGS7X1G5JYf6Usji5tJWLoKljCGYJ";
                        cc.A00 = this.A05.A00.A0G;
                        this.A07.A08();
                    } else {
                        String[] strArr3 = A0B;
                        strArr3[0] = "JrbxqibW71vJtGIxmKNzu0gc";
                        strArr3[7] = "aBslXCcOqyoFcXReLJb0k0eg";
                        cc.A00 = this.A05.A00.A0G;
                        this.A07.A08();
                    }
                    try {
                        int i = (this.A01 + this.A00) % 5;
                        this.A0A[i] = this.A02.A4e(this.A07);
                        this.A09[i] = ((C0861Xw) this.A07).A00;
                        this.A00++;
                    } catch (C0359Dz e) {
                        throw A4.A01(e, A10());
                    }
                }
            }
        }
        int i2 = this.A00;
        String[] strArr4 = A0B;
        if (strArr4[0].length() != strArr4[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr5 = A0B;
        strArr5[2] = "FI5ou6JhGKfNQASG6lr2Dh53KdKmMJ1";
        strArr5[1] = "8nK6Ac79BLzTFAHCrRK9v";
        if (i2 > 0) {
            long[] jArr = this.A09;
            int i3 = this.A01;
            if (jArr[i3] <= j) {
                A02(this.A0A[i3]);
                Metadata[] metadataArr = this.A0A;
                int i4 = this.A01;
                metadataArr[i4] = null;
                this.A01 = (i4 + 1) % 5;
                this.A00--;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0270Ac
    public final int ADS(Format format) {
        if (this.A06.ADT(format)) {
            return AbstractC0313Cd.A0z(null, format.A0H) ? 4 : 2;
        }
        return 0;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            A03((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
}
