package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;

/* compiled from: IMediaPlayer */
public interface c {

    /* compiled from: IMediaPlayer */
    public interface a {
        void a(c cVar, int i);
    }

    /* compiled from: IMediaPlayer */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.c$c  reason: collision with other inner class name */
    /* compiled from: IMediaPlayer */
    public interface AbstractC0005c {
        boolean a(c cVar, int i, int i2);
    }

    /* compiled from: IMediaPlayer */
    public interface d {
        boolean b(c cVar, int i, int i2);
    }

    /* compiled from: IMediaPlayer */
    public interface e {
        void b(c cVar);
    }

    /* compiled from: IMediaPlayer */
    public interface f {
        void c(c cVar);
    }

    /* compiled from: IMediaPlayer */
    public interface g {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    void a(float f2, float f3) throws Throwable;

    void a(long j) throws Throwable;

    @Deprecated
    void a(Context context, int i) throws Throwable;

    void a(Surface surface) throws Throwable;

    void a(SurfaceHolder surfaceHolder) throws Throwable;

    void a(a aVar);

    void a(b bVar);

    void a(AbstractC0005c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(FileDescriptor fileDescriptor) throws Throwable;

    void a(String str) throws Throwable;

    void a(boolean z) throws Throwable;

    void b(boolean z) throws Throwable;

    void f() throws Throwable;

    void g() throws Throwable;

    void h() throws Throwable;

    long i() throws Throwable;

    long j() throws Throwable;

    void k() throws Throwable;

    void l() throws Throwable;
}
