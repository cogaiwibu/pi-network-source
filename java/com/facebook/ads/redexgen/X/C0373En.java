package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

/* renamed from: com.facebook.ads.redexgen.X.En  reason: case insensitive filesystem */
public final class C0373En {
    public final HJ A00;
    public final HL A01;
    public final HL A02;
    public final AbstractC0445Hl A03;
    public final IU A04;

    public C0373En(AbstractC0445Hl hl, HL hl2) {
        this(hl, hl2, null, null, null);
    }

    public C0373En(AbstractC0445Hl hl, HL hl2, @Nullable HL hl3, @Nullable HJ hj, @Nullable IU iu) {
        I1.A01(hl2);
        this.A03 = hl;
        this.A02 = hl2;
        this.A01 = hl3;
        this.A00 = hj;
        this.A04 = iu;
    }

    public final AbstractC0445Hl A00() {
        return this.A03;
    }

    public final C0971aw A01(boolean z) {
        HM cacheReadDataSource;
        HK auVar;
        HL hl = this.A01;
        if (hl != null) {
            cacheReadDataSource = hl.A4D();
        } else {
            cacheReadDataSource = new C0953ae();
        }
        if (z) {
            return new C0971aw(this.A03, C0952ad.A02, cacheReadDataSource, null, 1, null);
        }
        HJ hj = this.A00;
        if (hj != null) {
            auVar = hj.createDataSink();
        } else {
            auVar = new C0969au(this.A03, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        }
        HM A4D = this.A02.A4D();
        IU iu = this.A04;
        if (iu != null) {
            A4D = new C0963ao(A4D, iu, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        }
        return new C0971aw(this.A03, A4D, cacheReadDataSource, auVar, 1, null);
    }

    public final IU A02() {
        IU iu = this.A04;
        return iu != null ? iu : new IU();
    }
}
