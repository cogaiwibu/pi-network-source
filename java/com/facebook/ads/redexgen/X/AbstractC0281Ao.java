package com.facebook.ads.redexgen.X;

import android.view.Surface;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Ao  reason: case insensitive filesystem */
public interface AbstractC0281Ao {
    void onAudioSessionId(C0280An an, int i);

    void onAudioUnderrun(C0280An an, int i, long j, long j2);

    void onDecoderDisabled(C0280An an, int i, C0297Be be);

    void onDecoderEnabled(C0280An an, int i, C0297Be be);

    void onDecoderInitialized(C0280An an, int i, String str, long j);

    void onDecoderInputFormatChanged(C0280An an, int i, Format format);

    void onDownstreamFormatChanged(C0280An an, FV fv);

    void onDrmKeysLoaded(C0280An an);

    void onDrmKeysRemoved(C0280An an);

    void onDrmKeysRestored(C0280An an);

    void onDrmSessionManagerError(C0280An an, Exception exc);

    void onDroppedVideoFrames(C0280An an, int i, long j);

    void onLoadError(C0280An an, FU fu, FV fv, IOException iOException, boolean z);

    void onLoadingChanged(C0280An an, boolean z);

    void onMediaPeriodCreated(C0280An an);

    void onMediaPeriodReleased(C0280An an);

    void onMetadata(C0280An an, Metadata metadata);

    void onPlaybackParametersChanged(C0280An an, AP ap);

    void onPlayerError(C0280An an, A4 a4);

    void onPlayerStateChanged(C0280An an, boolean z, int i);

    void onPositionDiscontinuity(C0280An an, int i);

    void onReadingStarted(C0280An an);

    void onRenderedFirstFrame(C0280An an, Surface surface);

    void onSeekProcessed(C0280An an);

    void onSeekStarted(C0280An an);

    void onTimelineChanged(C0280An an, int i);

    void onTracksChanged(C0280An an, TrackGroupArray trackGroupArray, H9 h9);

    void onVideoSizeChanged(C0280An an, int i, int i2, int i3, float f);
}
