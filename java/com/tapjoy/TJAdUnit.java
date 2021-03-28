package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.ironsource.sdk.constants.Events;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.hn;
import com.tapjoy.internal.jq;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class TJAdUnit implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener {
    public static TJVideoListener a;
    private boolean A;
    private boolean B;
    private int C = -1;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private fm H;
    private final Runnable I = new Runnable() {
        /* class com.tapjoy.TJAdUnit.AnonymousClass1 */

        public final void run() {
            int streamVolume = TJAdUnit.this.s.getStreamVolume(3);
            if (TJAdUnit.this.t != streamVolume) {
                TJAdUnit.this.t = streamVolume;
                TJAdUnit.c(TJAdUnit.this);
            }
        }
    };
    private final Runnable J = new Runnable() {
        /* class com.tapjoy.TJAdUnit.AnonymousClass8 */

        public final void run() {
            if (TJAdUnit.this.e.getCurrentPosition() != 0) {
                if (!TJAdUnit.this.p) {
                    TJAdUnit.this.p = true;
                }
                TJAdUnit.this.b.onVideoStarted(TJAdUnit.this.n);
                TJAdUnit.this.K.run();
            } else if (!TJAdUnit.this.F) {
                TJAdUnit.this.i.postDelayed(TJAdUnit.this.J, 200);
            } else {
                TJAdUnit.this.G = true;
            }
        }
    };
    private final Runnable K = new Runnable() {
        /* class com.tapjoy.TJAdUnit.AnonymousClass9 */

        public final void run() {
            TJAdUnit.this.b.onVideoProgress(TJAdUnit.this.e.getCurrentPosition());
            TJAdUnit.this.i.postDelayed(TJAdUnit.this.K, 500);
        }
    };
    TJAdUnitJSBridge b;
    TJWebView c;
    TJWebView d;
    VideoView e;
    volatile boolean f;
    WebViewClient g = new WebViewClient() {
        /* class com.tapjoy.TJAdUnit.AnonymousClass2 */

        public final void onLoadResource(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(str);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl().toString());
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            TapjoyLog.d("TJAdUnit", "onPageStarted: " + str);
            if (TJAdUnit.this.b != null) {
                TJAdUnit.this.b.allowRedirect = true;
                TJAdUnit.this.b.customClose = false;
                TJAdUnit.this.b.closeRequested = false;
                TJAdUnit.this.a();
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            TapjoyLog.d("TJAdUnit", "onPageFinished: " + str);
            if (TJAdUnit.this.l != null) {
                TJAdUnit.this.l.setProgressSpinnerVisibility(false);
            }
            TJAdUnit.this.B = true;
            if (TJAdUnit.this.y) {
                TJAdUnit.u(TJAdUnit.this);
            }
            TJAdUnit.this.b.flushMessageQueue();
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            TapjoyLog.d("TJAdUnit", "error:" + str);
            if (TJAdUnit.this.l != null) {
                TJAdUnit.this.l.showErrorDialog();
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            TapjoyCachedAssetData cachedDataForURL;
            WebResourceResponse a2;
            if (TapjoyCache.getInstance() == null || (cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(str)) == null || (a2 = a(cachedDataForURL)) == null) {
                return super.shouldInterceptRequest(webView, str);
            }
            TapjoyLog.d("TJAdUnit", "Reading request for " + str + " from cache -- localPath: " + cachedDataForURL.getLocalFilePath());
            return a2;
        }

        private boolean a(String str) {
            if (!TJAdUnit.this.e() || !URLUtil.isValidUrl(str)) {
                if (TJAdUnit.this.l != null) {
                    TJAdUnit.this.l.showErrorDialog();
                }
                return true;
            } else if (TJAdUnit.b(str)) {
                return false;
            } else {
                if (TJAdUnit.this.b.allowRedirect) {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.addFlags(268435456);
                    if (TJAdUnit.this.d.getContext() != null) {
                        try {
                            TJAdUnit.this.d.getContext().startActivity(intent);
                            return true;
                        } catch (Exception e) {
                            TapjoyLog.e("TJAdUnit", "Exception in loading URL. " + e.getMessage());
                        }
                    }
                } else if (str.startsWith("javascript:") && Build.VERSION.SDK_INT >= 19) {
                    try {
                        TJAdUnit.this.d.evaluateJavascript(str.replaceFirst("javascript:", ""), null);
                        return true;
                    } catch (Exception e2) {
                        TapjoyLog.e("TJAdUnit", "Exception in evaluateJavascript. Device not supported. " + e2.toString());
                    }
                }
                return false;
            }
        }

        private static WebResourceResponse a(TapjoyCachedAssetData tapjoyCachedAssetData) {
            if (tapjoyCachedAssetData == null) {
                return null;
            }
            try {
                return new WebResourceResponse(tapjoyCachedAssetData.getMimeType(), "UTF-8", new FileInputStream(tapjoyCachedAssetData.getLocalFilePath()));
            } catch (Exception unused) {
                return null;
            }
        }
    };
    WebChromeClient h = new WebChromeClient() {
        /* class com.tapjoy.TJAdUnit.AnonymousClass3 */

        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            TapjoyLog.d("TJAdUnit", str2);
            return false;
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (TJAdUnit.this.b.closeRequested) {
                int i = 0;
                String[] strArr = {"Uncaught", "uncaught", "Error", "error", "not defined"};
                if (TJAdUnit.this.l != null) {
                    while (true) {
                        if (i >= 5) {
                            break;
                        }
                        if (consoleMessage.message().contains(strArr[i])) {
                            TJAdUnit.this.l.handleClose();
                            break;
                        }
                        i++;
                    }
                }
            }
            return true;
        }
    };
    private final Handler i = new Handler(Looper.getMainLooper());
    private TJAdUnitWebViewListener j;
    private TJAdUnitVideoListener k;
    private TJAdUnitActivity l;
    private MediaPlayer m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    @Nullable
    private ScheduledFuture r;
    private AudioManager s;
    private int t = 0;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public interface TJAdUnitVideoListener {
        void onVideoCompleted();

        void onVideoError(String str);

        void onVideoStart();
    }

    public interface TJAdUnitWebViewListener {
        void onClick();

        void onClosed();

        void onContentReady();
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 6 || i2 == 11;
    }

    private static boolean b(int i2) {
        return i2 == 1 || i2 == 9 || i2 == 7 || i2 == 12;
    }

    public boolean preload(TJPlacementData tJPlacementData, Context context) {
        if (this.z || !tJPlacementData.isPrerenderingRequested() || !TJPlacementManager.canPreRenderPlacement() || TapjoyConnectCore.isViewOpen()) {
            fireContentReady();
            return false;
        }
        TapjoyLog.i("TJAdUnit", "Pre-rendering ad unit for placement: " + tJPlacementData.getPlacementName());
        TJPlacementManager.incrementPlacementPreRenderCount();
        load(tJPlacementData, true, context);
        return true;
    }

    public void load(final TJPlacementData tJPlacementData, final boolean z2, final Context context) {
        this.z = false;
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnit.AnonymousClass4 */

            public final void run() {
                TJAdUnit tJAdUnit = TJAdUnit.this;
                Context context = context;
                boolean z = true;
                if (Looper.myLooper() == Looper.getMainLooper() && !tJAdUnit.f && context != null) {
                    TapjoyLog.d("TJAdUnit", "Constructing ad unit");
                    tJAdUnit.f = true;
                    tJAdUnit.c = new TJWebView(context);
                    tJAdUnit.c.loadDataWithBaseURL(null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", Events.CHARSET_FORMAT, null);
                    tJAdUnit.d = new TJWebView(context);
                    tJAdUnit.d.setWebViewClient(tJAdUnit.g);
                    tJAdUnit.d.setWebChromeClient(tJAdUnit.h);
                    tJAdUnit.e = new VideoView(context);
                    tJAdUnit.e.setOnCompletionListener(tJAdUnit);
                    tJAdUnit.e.setOnErrorListener(tJAdUnit);
                    tJAdUnit.e.setOnPreparedListener(tJAdUnit);
                    tJAdUnit.e.setVisibility(4);
                    tJAdUnit.b = new TJAdUnitJSBridge(context, tJAdUnit);
                    if (context instanceof TJAdUnitActivity) {
                        tJAdUnit.setAdUnitActivity((TJAdUnitActivity) context);
                    }
                }
                if (tJAdUnit.f) {
                    TapjoyLog.i("TJAdUnit", "Loading ad unit content");
                    TJAdUnit.this.z = true;
                    if (!jq.c(tJPlacementData.getRedirectURL())) {
                        if (tJPlacementData.isPreloadDisabled()) {
                            TJAdUnit.this.d.postUrl(tJPlacementData.getRedirectURL(), null);
                        } else {
                            TJAdUnit.this.d.loadUrl(tJPlacementData.getRedirectURL());
                        }
                    } else if (tJPlacementData.getBaseURL() == null || tJPlacementData.getHttpResponse() == null) {
                        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error loading ad unit content"));
                        TJAdUnit.this.z = false;
                    } else {
                        TJAdUnit.this.d.loadDataWithBaseURL(tJPlacementData.getBaseURL(), tJPlacementData.getHttpResponse(), "text/html", Events.CHARSET_FORMAT, null);
                    }
                    TJAdUnit tJAdUnit2 = TJAdUnit.this;
                    if (!tJAdUnit2.z || !z2) {
                        z = false;
                    }
                    tJAdUnit2.A = z;
                }
            }
        });
    }

    public void resume(TJAdUnitSaveStateData tJAdUnitSaveStateData) {
        if (this.b.didLaunchOtherActivity) {
            TapjoyLog.d("TJAdUnit", "onResume bridge.didLaunchOtherActivity callbackID: " + this.b.otherActivityCallbackID);
            TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
            tJAdUnitJSBridge.invokeJSCallback(tJAdUnitJSBridge.otherActivityCallbackID, Boolean.TRUE);
            this.b.didLaunchOtherActivity = false;
        }
        this.F = false;
        this.b.setEnabled(true);
        if (tJAdUnitSaveStateData != null) {
            int i2 = tJAdUnitSaveStateData.seekTime;
            this.n = i2;
            this.e.seekTo(i2);
            if (this.m != null) {
                this.v = tJAdUnitSaveStateData.isVideoMuted;
            }
        }
        if (this.G) {
            this.G = false;
            this.i.postDelayed(this.J, 200);
        }
    }

    public void pause() {
        this.F = true;
        this.b.setEnabled(false);
        pauseVideo();
    }

    public void invokeBridgeCallback(String str, Object... objArr) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
        if (tJAdUnitJSBridge != null && str != null) {
            tJAdUnitJSBridge.invokeJSCallback(str, objArr);
        }
    }

    public void destroy() {
        this.b.destroy();
        c();
        TJWebView tJWebView = this.c;
        if (tJWebView != null) {
            tJWebView.removeAllViews();
            this.c = null;
        }
        TJWebView tJWebView2 = this.d;
        if (tJWebView2 != null) {
            tJWebView2.removeAllViews();
            this.d = null;
        }
        this.f = false;
        this.y = false;
        setAdUnitActivity(null);
        a();
        this.m = null;
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClosed();
        }
        resetContentLoadState();
    }

    public void resetContentLoadState() {
        this.z = false;
        this.B = false;
        this.A = false;
        this.C = -1;
        this.x = false;
        this.v = false;
    }

    public void setVisible(boolean z2) {
        this.b.notifyOrientationChanged(getScreenOrientationString(), this.D, this.E);
        this.y = z2;
        if (z2 && this.B) {
            this.b.display();
        }
    }

    public void fireContentReady() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onContentReady();
        }
    }

    public void fireOnClick() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClick();
        }
    }

    public void closeRequested(boolean z2) {
        this.b.closeRequested(Boolean.valueOf(z2));
    }

    public void setOrientation(int i2) {
        TJAdUnitActivity tJAdUnitActivity = this.l;
        if (tJAdUnitActivity != null) {
            int b2 = b();
            int i3 = this.C;
            if (i3 != -1) {
                b2 = i3;
            }
            if ((a(b2) && a(i2)) || (b(b2) && b(i2))) {
                i2 = b2;
            }
            tJAdUnitActivity.setRequestedOrientation(i2);
            this.C = i2;
            this.x = true;
        }
    }

    public void unsetOrientation() {
        TJAdUnitActivity tJAdUnitActivity = this.l;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setRequestedOrientation(-1);
        }
        this.C = -1;
        this.x = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a() {
        TapjoyLog.d("TJAdUnit", "detachVolumeListener");
        ScheduledFuture scheduledFuture = this.r;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.r = null;
        }
        this.s = null;
    }

    private int b() {
        TJAdUnitActivity tJAdUnitActivity = this.l;
        if (tJAdUnitActivity == null) {
            return -1;
        }
        int rotation = tJAdUnitActivity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        tJAdUnitActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.D = displayMetrics.widthPixels;
        this.E = displayMetrics.heightPixels;
        if (((rotation == 0 || rotation == 2) && this.E > this.D) || ((rotation == 1 || rotation == 3) && this.D > this.E)) {
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation != 3) {
                            return 1;
                        }
                        return 8;
                    }
                }
                return 0;
            }
            return 1;
        }
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation == 2) {
                    return 8;
                }
                if (rotation != 3) {
                    TapjoyLog.w("TJAdUnit", "Unknown screen orientation. Defaulting to landscape.");
                }
            }
            return 1;
        }
        return 0;
        return 9;
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.l = tJAdUnitActivity;
        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setAdUnitActivity(tJAdUnitActivity);
        }
    }

    public void setAdContentTracker(fm fmVar) {
        this.H = fmVar;
    }

    public void setBackgroundColor(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnit.AnonymousClass5 */

            public final void run() {
                try {
                    TapjoyLog.d("TJAdUnit", "setBackgroundColor: " + str);
                    TJAdUnit.this.c.setBackgroundColor(Color.parseColor(str));
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    TapjoyLog.d("TJAdUnit", "Error setting background color. backgroundWebView: " + TJAdUnit.this.c + ", hexColor: " + str);
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setBackgroundContent(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnit.AnonymousClass6 */

            public final void run() {
                try {
                    TapjoyLog.d("TJAdUnit", "setBackgroundContent: " + str);
                    TJAdUnit.this.c.loadDataWithBaseURL(null, str, "text/html", Events.CHARSET_FORMAT, null);
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    TapjoyLog.d("TJAdUnit", "Error setting background content. backgroundWebView: " + TJAdUnit.this.c + ", content: " + str);
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setWebViewListener(TJAdUnitWebViewListener tJAdUnitWebViewListener) {
        this.j = tJAdUnitWebViewListener;
    }

    public void setVideoListener(TJAdUnitVideoListener tJAdUnitVideoListener) {
        this.k = tJAdUnitVideoListener;
    }

    public int getLockedOrientation() {
        return this.C;
    }

    public int getScreenWidth() {
        return this.D;
    }

    public int getScreenHeight() {
        return this.E;
    }

    public String getScreenOrientationString() {
        return a(b()) ? "landscape" : "portrait";
    }

    public boolean hasCalledLoad() {
        return this.z;
    }

    public boolean isPrerendered() {
        return this.A;
    }

    public boolean isLockedOrientation() {
        return this.x;
    }

    public TJWebView getBackgroundWebView() {
        return this.c;
    }

    public TJWebView getWebView() {
        return this.d;
    }

    public boolean getCloseRequested() {
        return this.b.closeRequested;
    }

    public void loadVideoUrl(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() {
            /* class com.tapjoy.TJAdUnit.AnonymousClass7 */

            public final void run() {
                if (TJAdUnit.this.e != null) {
                    TapjoyLog.i("TJAdUnit", "loadVideoUrl: " + str);
                    TJAdUnit.this.e.setVideoPath(str);
                    TJAdUnit.this.e.setVisibility(0);
                    TJAdUnit.this.e.seekTo(0);
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                adUnitAsyncTaskListner.onComplete(false);
            }
        });
    }

    public boolean playVideo() {
        TapjoyLog.i("TJAdUnit", "playVideo");
        VideoView videoView = this.e;
        if (videoView == null) {
            return false;
        }
        videoView.start();
        this.q = false;
        this.i.postDelayed(this.J, 200);
        return true;
    }

    public boolean pauseVideo() {
        c();
        VideoView videoView = this.e;
        if (videoView == null || !videoView.isPlaying()) {
            return false;
        }
        this.e.pause();
        this.n = this.e.getCurrentPosition();
        TapjoyLog.i("TJAdUnit", "Video paused at: " + this.n);
        this.b.onVideoPaused(this.n);
        return true;
    }

    public void clearVideo(final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner, final boolean z2) {
        if (this.e != null) {
            c();
            TapjoyUtil.runOnMainThread(new Runnable() {
                /* class com.tapjoy.TJAdUnit.AnonymousClass10 */

                public final void run() {
                    TJAdUnit.this.e.setVisibility(z2 ? 0 : 4);
                    TJAdUnit.this.e.stopPlayback();
                    TJAdUnit.this.p = false;
                    TJAdUnit.this.o = false;
                    TJAdUnit.this.n = 0;
                    adUnitAsyncTaskListner.onComplete(true);
                }
            });
            return;
        }
        adUnitAsyncTaskListner.onComplete(false);
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            if (z2) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            if (this.w != z2) {
                this.w = z2;
                this.b.onVolumeChanged();
                return;
            }
            return;
        }
        this.v = z2;
    }

    public void attachVolumeListener(boolean z2, int i2) {
        TJAdUnitActivity tJAdUnitActivity;
        TapjoyLog.d("TJAdUnit", "attachVolumeListener: isAttached=" + z2 + "; interval=" + i2);
        a();
        if (z2 && (tJAdUnitActivity = this.l) != null) {
            AudioManager audioManager = (AudioManager) tJAdUnitActivity.getSystemService("audio");
            this.s = audioManager;
            this.t = audioManager.getStreamVolume(3);
            this.u = this.s.getStreamMaxVolume(3);
            long j2 = (long) i2;
            this.r = hn.a.scheduleWithFixedDelay(this.I, j2, j2, TimeUnit.MILLISECONDS);
        }
    }

    public VideoView getVideoView() {
        return this.e;
    }

    public int getVideoSeekTime() {
        return this.n;
    }

    public boolean isVideoComplete() {
        return this.q;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        TapjoyLog.i("TJAdUnit", "video -- onPrepared");
        final int duration = this.e.getDuration();
        final int measuredWidth = this.e.getMeasuredWidth();
        final int measuredHeight = this.e.getMeasuredHeight();
        this.m = mediaPlayer;
        boolean z2 = this.v;
        if (z2) {
            a(z2);
        }
        if (this.n <= 0 || this.e.getCurrentPosition() == this.n) {
            this.b.onVideoReady(duration, measuredWidth, measuredHeight);
        } else {
            this.m.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                /* class com.tapjoy.TJAdUnit.AnonymousClass11 */

                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                    TJAdUnit.this.b.onVideoReady(duration, measuredWidth, measuredHeight);
                }
            });
        }
        this.m.setOnInfoListener(this);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        String str;
        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating the VideoView: " + i2 + " - " + i3));
        this.o = true;
        c();
        String str2 = (i2 != 100 ? "MEDIA_ERROR_UNKNOWN" : "MEDIA_ERROR_SERVER_DIED") + " -- ";
        if (i3 == -1010) {
            str = str2 + "MEDIA_ERROR_UNSUPPORTED";
        } else if (i3 == -1007) {
            str = str2 + "MEDIA_ERROR_MALFORMED";
        } else if (i3 == -1004) {
            str = str2 + "MEDIA_ERROR_IO";
        } else if (i3 != -110) {
            str = str2 + "MEDIA_ERROR_EXTRA_UNKNOWN";
        } else {
            str = str2 + "MEDIA_ERROR_TIMED_OUT";
        }
        this.b.onVideoError(str);
        if (i2 == 1 || i3 == -1004) {
            return true;
        }
        return false;
    }

    private void c() {
        this.i.removeCallbacks(this.J);
        this.i.removeCallbacks(this.K);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        TapjoyLog.i("TJAdUnit", "video -- onCompletion");
        c();
        this.q = true;
        if (!this.o) {
            this.b.onVideoCompletion();
        }
        this.o = false;
    }

    public void fireOnVideoStart() {
        TapjoyLog.v("TJAdUnit", "Firing onVideoStart");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoStart();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoStart();
        }
    }

    public void fireOnVideoError(String str) {
        TapjoyLog.e("TJAdUnit", "Firing onVideoError with error: " + str);
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoError(3);
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoError(str);
        }
    }

    public void fireOnVideoComplete() {
        TapjoyLog.v("TJAdUnit", "Firing onVideoComplete");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoComplete();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoCompleted();
        }
    }

    public float getVolume() {
        return ((float) this.t) / ((float) this.u);
    }

    public boolean isMuted() {
        return this.w;
    }

    public void startAdContentTracking(String str, JSONObject jSONObject) {
        fm fmVar = this.H;
        if (fmVar != null) {
            fmVar.a(str, jSONObject);
        }
    }

    public void endAdContentTracking(String str, JSONObject jSONObject) {
        if (this.H != null) {
            d();
            this.H.b(str, jSONObject);
        }
    }

    public void sendAdContentTracking(String str, JSONObject jSONObject) {
        if (this.H != null) {
            d();
            fm fmVar = this.H;
            Map a2 = fm.a(jSONObject);
            gf.e(str).a(fmVar.a).a(a2).b(fm.b(jSONObject)).c();
        }
    }

    private void d() {
        fm fmVar = this.H;
        if (fmVar != null) {
            fmVar.a("prerendered", Boolean.valueOf(this.A));
        }
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        String str;
        if (i2 == 3) {
            str = "MEDIA_INFO_VIDEO_RENDERING_START";
        } else if (i2 != 801) {
            switch (i2) {
                case 700:
                    str = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
                    break;
                case 701:
                    str = "MEDIA_INFO_BUFFERING_START";
                    break;
                case 702:
                    str = "MEDIA_INFO_BUFFERING_END";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "MEDIA_INFO_NOT_SEEKABLE";
        }
        this.b.onVideoInfo(str);
        return false;
    }

    public TJVideoListener getPublisherVideoListener() {
        return a;
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        try {
            String host = new URL(TapjoyConfig.TJC_SERVICE_URL).getHost();
            if ((host == null || !str.contains(host)) && !str.contains(TapjoyConnectCore.getRedirectDomain()) && !str.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()))) {
                return false;
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean e() {
        NetworkInfo activeNetworkInfo;
        try {
            if (this.d.getContext() == null || (activeNetworkInfo = ((ConnectivityManager) this.d.getContext().getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            TapjoyLog.d("TJAdUnit", "Exception getting NetworkInfo: " + e2.getLocalizedMessage());
        }
        return false;
    }

    public void notifyOrientationChanged() {
        this.b.notifyOrientationChanged(getScreenOrientationString(), this.D, this.E);
    }

    static /* synthetic */ void c(TJAdUnit tJAdUnit) {
        tJAdUnit.b.onVolumeChanged();
    }

    static /* synthetic */ void u(TJAdUnit tJAdUnit) {
        tJAdUnit.b.display();
    }
}
