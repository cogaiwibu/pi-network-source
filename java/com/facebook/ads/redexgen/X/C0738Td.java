package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;

/* renamed from: com.facebook.ads.redexgen.X.Td  reason: case insensitive filesystem */
public class C0738Td implements AbstractC01816i {
    public final /* synthetic */ C0747Tm A00;

    public C0738Td(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 16) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A02 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.A00.A02.getMemoryInfo(memoryInfo);
        return this.A00.A07(memoryInfo.totalMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    }
}
