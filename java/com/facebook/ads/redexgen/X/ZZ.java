package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.core.app.NotificationManagerCompat;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ZZ implements AbstractC0372Em {
    public static String[] A06;
    public final HQ A00;
    public final AbstractC0445Hl A01;
    public final C0971aw A02;
    public final C0450Hq A03 = new C0450Hq();
    public final IU A04;
    public final AtomicBoolean A05 = new AtomicBoolean();

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"0vmpU1QtAhI6qjIdcVId", "klBv", "qKjW3ego541fEYihs", "NuBFx4EY8fIgWeMvZ", "vAKBh2R", "FoB4J1nu", "9b5WU1uKCw6g3SYcMdOb", "twQXN8Z"};
    }

    public ZZ(Uri uri, String str, C0373En en) {
        this.A00 = new HQ(uri, 0, -1, str, 0);
        this.A01 = en.A00();
        this.A02 = en.A01(false);
        this.A04 = en.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0372Em
    public final void A4q() throws InterruptedException, IOException {
        this.A04.A00(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        try {
            C0451Hr.A04(this.A00, this.A01, this.A02, new byte[131072], this.A04, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, this.A03, this.A05, true);
            IU iu = this.A04;
            String[] strArr = A06;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "qX3fQQGAY3dTsBjdyBPn";
            strArr2[6] = "Z0TFAaYyqvVnxMY9deNw";
            iu.A03(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        } catch (Throwable th) {
            this.A04.A03(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0372Em
    public final float A62() {
        long j = this.A03.A01;
        if (j == -1) {
            return -1.0f;
        }
        return (((float) this.A03.A00()) * 100.0f) / ((float) j);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0372Em
    public final long A63() {
        return this.A03.A00();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0372Em
    public final void cancel() {
        this.A05.set(true);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0372Em
    public final void remove() {
        C0451Hr.A06(this.A01, C0451Hr.A02(this.A00));
    }
}
