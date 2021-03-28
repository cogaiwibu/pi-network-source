package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaViewListener;

public class T2 implements ME {
    public final /* synthetic */ MediaViewListener A00;
    public final /* synthetic */ T3 A01;

    public T2(T3 t3, MediaViewListener mediaViewListener) {
        this.A01 = t3;
        this.A00 = mediaViewListener;
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void A9B() {
        this.A00.onComplete(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void A9U() {
        this.A00.onEnterFullscreen(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void A9a() {
        this.A00.onExitFullscreen(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void A9d() {
        this.A00.onFullscreenBackground(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void A9e() {
        this.A00.onFullscreenForeground(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void AAQ() {
        this.A00.onPlay(this.A01.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void ABO() {
        this.A00.onVolumeChange(this.A01.A02, this.A01.A04.getVolume());
    }

    @Override // com.facebook.ads.redexgen.X.ME
    public final void onPause() {
        this.A00.onPause(this.A01.A02);
    }
}
