package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@SuppressLint({"CatchGeneralException"})
/* renamed from: com.facebook.ads.redexgen.X.Kc  reason: case insensitive filesystem */
public abstract class AbstractRunnableC0510Kc implements Runnable {
    public static byte[] A01;
    public static final AtomicBoolean A02 = new AtomicBoolean();
    public static final AtomicBoolean A03 = new AtomicBoolean(false);
    public static final AtomicReference<KS> A04 = new AtomicReference<>();
    @Nullable
    public final KQ A00;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{124, 91, 64, 64, 79, 76, 66, 75, 14, 77, 92, 75, 79, 90, 75, 74, 0, 14, 122, 70, 92, 75, 79, 74, 20, 14};
    }

    public abstract void A07();

    static {
        A03();
    }

    public AbstractRunnableC0510Kc() {
        if (A03.get()) {
            this.A00 = C0515Kh.A01(new C0514Kg(A02(0, 26, 90) + Thread.currentThread().getName()));
            return;
        }
        this.A00 = null;
    }

    public static void A04(boolean z) {
        A03.set(z);
    }

    public static void A05(boolean z, KS ks) {
        A02.set(z);
        A04.set(ks);
    }

    @Nullable
    public final KQ A06() {
        return this.A00;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                if (A03.get()) {
                    C0515Kh.A04(this);
                }
                try {
                    A07();
                } catch (Throwable th) {
                    if (A02.get()) {
                        C0517Kj.A00().A7t(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR, th);
                        KS ks = A04.get();
                        if (ks != null) {
                            ks.ACR(th, this);
                        }
                    } else {
                        throw th;
                    }
                }
                if (A03.get()) {
                    C0515Kh.A05(this);
                }
            } catch (Throwable t) {
                KU.A00(t, this);
            }
        }
    }
}
