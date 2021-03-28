package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;

/* renamed from: com.facebook.ads.redexgen.X.Hy  reason: case insensitive filesystem */
public class C0458Hy extends Thread {
    public final /* synthetic */ ConditionVariable A00;
    public final /* synthetic */ b1 A01;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0458Hy(b1 b1Var, String str, ConditionVariable conditionVariable) {
        super(str);
        this.A01 = b1Var;
        this.A00 = conditionVariable;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                synchronized (this.A01) {
                    try {
                        this.A00.open();
                        this.A01.A04();
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (Throwable th2) {
                KU.A00(th2, this);
            }
        }
    }
}
