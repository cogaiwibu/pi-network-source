package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AndroidMediaPlayer */
public class b extends a {
    private final MediaPlayer a;
    private final a b;
    private MediaDataSource c;
    private final Object d;
    private boolean e;

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.d = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            this.a.setAudioStreamType(3);
        } catch (Throwable th) {
            l.a("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.b = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 28) {
            try {
                Class<?> cls = Class.forName("android.media.MediaTimeProvider");
                Class<?> cls2 = Class.forName("android.media.SubtitleController");
                Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
                Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(j.a(), null, null);
                Field declaredField = cls2.getDeclaredField("mHandler");
                declaredField.setAccessible(true);
                try {
                    declaredField.set(newInstance, new Handler());
                    declaredField.setAccessible(false);
                    mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
                } catch (Throwable th) {
                    declaredField.setAccessible(false);
                    throw th;
                }
            } catch (Throwable th2) {
                l.a("AndroidMediaPlayer", "setSubtitleController error: ", th2);
            }
        }
    }

    public MediaPlayer e() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.d) {
            if (!this.e) {
                this.a.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(Surface surface) {
        this.a.setSurface(surface);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.a.setDataSource(str);
        } else {
            this.a.setDataSource(parse.getPath());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.a.setDataSource(fileDescriptor);
    }

    private void m() {
        MediaDataSource mediaDataSource = this.c;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (Throwable th) {
                l.a("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
            }
            this.c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void f() throws Throwable {
        this.a.start();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void g() throws Throwable {
        this.a.stop();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void h() throws Throwable {
        this.a.pause();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(boolean z) throws Throwable {
        this.a.setScreenOnWhilePlaying(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(long j) throws Throwable {
        this.a.seekTo((int) j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public long i() {
        try {
            return (long) this.a.getCurrentPosition();
        } catch (Throwable th) {
            l.a("AndroidMediaPlayer", "getCurrentPosition error: ", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public long j() {
        try {
            return (long) this.a.getDuration();
        } catch (Throwable th) {
            l.a("AndroidMediaPlayer", "getDuration error: ", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void k() throws Throwable {
        this.e = true;
        this.a.release();
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void l() throws Throwable {
        try {
            this.a.reset();
        } catch (Throwable th) {
            l.a("AndroidMediaPlayer", "reset error: ", th);
        }
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void b(boolean z) throws Throwable {
        this.a.setLooping(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(float f, float f2) throws Throwable {
        this.a.setVolume(f, f2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(Context context, int i) throws Throwable {
        this.a.setWakeMode(context, i);
    }

    private void n() {
        this.a.setOnPreparedListener(this.b);
        this.a.setOnBufferingUpdateListener(this.b);
        this.a.setOnCompletionListener(this.b);
        this.a.setOnSeekCompleteListener(this.b);
        this.a.setOnVideoSizeChangedListener(this.b);
        this.a.setOnErrorListener(this.b);
        this.a.setOnInfoListener(this.b);
    }

    /* access modifiers changed from: private */
    /* compiled from: AndroidMediaPlayer */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<b> b;

        public a(b bVar) {
            this.b = new WeakReference<>(bVar);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return this.b.get() != null && b.this.b(i, i2);
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return this.b.get() != null && b.this.a(i, i2);
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.b.get() != null) {
                b.this.a(i, i2, 1, 1);
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.b.get() != null) {
                b.this.d();
            }
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.b.get() != null) {
                b.this.a(i);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.b.get() != null) {
                b.this.c();
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.b.get() != null) {
                b.this.b();
            }
        }
    }
}
