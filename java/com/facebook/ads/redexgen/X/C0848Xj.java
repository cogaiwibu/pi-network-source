package com.facebook.ads.redexgen.X;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.checkerframework.checker.nullness.qual.MonotonicNonNull;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.facebook.ads.redexgen.X.Xj  reason: case insensitive filesystem */
public final class C0848Xj implements AS, E1, BB, J4, FW, HG, Bs {
    public static String[] A05;
    @MonotonicNonNull
    public AX A00;
    public final C0275Ai A01 = new C0275Ai();
    public final C0278Al A02 = new C0278Al();
    public final I4 A03;
    public final CopyOnWriteArraySet<AbstractC0281Ao> A04 = new CopyOnWriteArraySet<>();

    static {
        A06();
    }

    public static void A06() {
        A05 = new String[]{"oWxliEG", "84CCzfJSWHAMzlT", "dVPYU5AFfnLld9", "202VfNqPV04zLFr42xUQnFXcv", "6C2OHs0d6U2aNpx0mThNdUqCMJf7H", "j36hHuSQknS9Y2BeP2DWP06EygcBzL55", "WN9koNHhTr4SbLKtJDKTY2JTPC", "f2Eog"};
    }

    /* JADX WARNING: Error to parse debug info: 9 in method: com.facebook.ads.redexgen.X.Xj.A90(int, long, long):void, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:127)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    @Override // com.facebook.ads.redexgen.X.HG
    public final void A90(int i, long j, long j2) {
        A01();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public C0848Xj(@Nullable AX ax, I4 i4) {
        this.A00 = ax;
        this.A03 = (I4) I1.A01(i4);
    }

    private C0280An A00() {
        return A05(this.A02.A04());
    }

    private C0280An A01() {
        return A05(this.A02.A05());
    }

    private C0280An A02() {
        return A05(this.A02.A06());
    }

    private C0280An A03() {
        return A05(this.A02.A07());
    }

    private final C0280An A04(int i, @Nullable FG fg) {
        long j;
        I1.A01(this.A00);
        long A4r = this.A03.A4r();
        AbstractC0276Aj timeline = this.A00.A5v();
        if (i == this.A00.A5w()) {
            if (fg == null || !fg.A02()) {
                j = this.A00.A5o();
            } else if (this.A00.A5q() == fg.A00 && this.A00.A5r() == fg.A01) {
                j = this.A00.A5t();
            } else {
                j = 0;
            }
        } else if (i >= timeline.A02() || (fg != null && fg.A02())) {
            j = 0;
        } else {
            j = timeline.A0C(i, this.A01).A00();
        }
        return new C0280An(A4r, timeline, i, fg, j, this.A00.A5t(), this.A00.A5X() - this.A00.A5o());
    }

    private C0280An A05(@Nullable C0279Am am) {
        if (am != null) {
            return A04(am.A00, am.A01);
        }
        int A5w = ((AX) I1.A01(this.A00)).A5w();
        return A04(A5w, this.A02.A08(A5w));
    }

    public final void A07() {
        if (!this.A02.A0G()) {
            C0280An A022 = A02();
            this.A02.A0A();
            Iterator<AbstractC0281Ao> it = this.A04.iterator();
            while (it.hasNext()) {
                AbstractC0281Ao next = it.next();
                String[] strArr = A05;
                if (strArr[1].length() != strArr[4].length()) {
                    String[] strArr2 = A05;
                    strArr2[1] = "PBkwxeOlbvYzAOz";
                    strArr2[4] = "zMCnce58Qhbdr93RoMzV7EOLVlkYq";
                    next.onSeekStarted(A022);
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }

    public final void A08() {
        Iterator it = new ArrayList(C0278Al.A01(this.A02)).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[1].length() != strArr[4].length()) {
                String[] strArr2 = A05;
                strArr2[0] = "gG2PlvUwOW39eC8R";
                strArr2[0] = "gG2PlvUwOW39eC8R";
                if (hasNext) {
                    C0279Am mediaPeriod = (C0279Am) it.next();
                    AAB(mediaPeriod.A00, mediaPeriod.A01);
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8u(String str, long j, long j2) {
        C0280An eventTime = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTime, 1, str, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8v(C0297Be be) {
        C0280An A002 = A00();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(A002, 1, be);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8w(C0297Be be) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(A022, 1, be);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8x(Format format) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(A032, 1, format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8y(int i) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(A032, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BB
    public final void A8z(int i, long j, long j2) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A05[2].length() != 13) {
                String[] strArr = A05;
                strArr[1] = "uqo4gq1KBxiMktN";
                strArr[4] = "Ndm2ibG2UK8Su1apjnSt0jhcojAUZ";
                if (hasNext) {
                    it.next().onAudioUnderrun(A032, i, j, j2);
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void A9O(int i, @Nullable FG fg, FV fv) {
        C0280An A042 = A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(A042, fv);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bs
    public final void A9P() {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(A032);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bs
    public final void A9Q() {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRemoved(A032);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bs
    public final void A9R() {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(A032);
        }
    }

    @Override // com.facebook.ads.redexgen.X.Bs
    public final void A9S(Exception exc) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(A032, exc);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void A9T(int i, long j) {
        C0280An A002 = A00();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(A002, i, j);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void A9w(int i, @Nullable FG fg, FU fu, FV fv) {
        A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void A9y(int i, @Nullable FG fg, FU fu, FV fv) {
        A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void AA1(int i, @Nullable FG fg, FU fu, FV fv, IOException iOException, boolean z) {
        C0280An A042 = A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(A042, fu, fv, iOException, z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void AA3(int i, @Nullable FG fg, FU fu, FV fv) {
        A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AA5(boolean z) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            AbstractC0281Ao next = it.next();
            if (A05[2].length() != 13) {
                String[] strArr = A05;
                strArr[5] = "61iKEbH7Elk598B8IvoVeyiFcghmzjBq";
                strArr[5] = "61iKEbH7Elk598B8IvoVeyiFcghmzjBq";
                next.onLoadingChanged(A022, z);
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void AAA(int i, FG fg) {
        this.A02.A0C(i, fg);
        C0280An A042 = A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(A042);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void AAB(int i, FG fg) {
        this.A02.A0D(i, fg);
        C0280An A042 = A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[7].length() != strArr[6].length()) {
                String[] strArr2 = A05;
                strArr2[1] = "xQuAJnMHmsnkUtn";
                strArr2[4] = "I7nuhInD03G6TyFgZN1tEp7XA66Po";
                if (hasNext) {
                    it.next().onMediaPeriodReleased(A042);
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.E1
    public final void AAE(Metadata metadata) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(A022, metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AAT(AP ap) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            AbstractC0281Ao next = it.next();
            if (A05[5].charAt(25) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "6kCd761y4Sm0JC2HIy7vlDu4Zge9adCZ";
            strArr[5] = "6kCd761y4Sm0JC2HIy7vlDu4Zge9adCZ";
            next.onPlaybackParametersChanged(A022, ap);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AAV(A4 a4) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            AbstractC0281Ao next = it.next();
            String[] strArr = A05;
            if (strArr[7].length() != strArr[6].length()) {
                String[] strArr2 = A05;
                strArr2[3] = "4uLQlqFUz3TKu9PUP8Ua0";
                strArr2[3] = "4uLQlqFUz3TKu9PUP8Ua0";
                next.onPlayerError(A022, a4);
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AAX(boolean z, int i) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(A022, z, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AAZ(int i) {
        this.A02.A0B(i);
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(A022, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FW
    public final void AAh(int i, FG fg) {
        this.A02.A0E(i, fg);
        C0280An A042 = A04(i, fg);
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(A042);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void AAk(Surface surface) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[1].length() != strArr[4].length()) {
                String[] strArr2 = A05;
                strArr2[0] = "zEYrHw08cBp169ZitgaAlaUGutwvX";
                strArr2[0] = "zEYrHw08cBp169ZitgaAlaUGutwvX";
                if (hasNext) {
                    it.next().onRenderedFirstFrame(A032, surface);
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AAu() {
        if (this.A02.A0G()) {
            this.A02.A09();
            C0280An A022 = A02();
            Iterator<AbstractC0281Ao> it = this.A04.iterator();
            while (it.hasNext()) {
                it.next().onSeekProcessed(A022);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AB6(AbstractC0276Aj aj, @Nullable Object obj, int i) {
        this.A02.A0F(aj);
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(A022, i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final void AB7(TrackGroupArray trackGroupArray, H9 h9) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(A022, trackGroupArray, h9);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABF(String str, long j, long j2) {
        C0280An eventTime = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTime, 2, str, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABG(C0297Be be) {
        C0280An A002 = A00();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(A002, 2, be);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABH(C0297Be be) {
        C0280An A022 = A02();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(A022, 2, be);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABJ(Format format) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(A032, 2, format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void ABM(int i, int i2, int i3, float f) {
        C0280An A032 = A03();
        Iterator<AbstractC0281Ao> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(A032, i, i2, i3, f);
        }
    }
}
