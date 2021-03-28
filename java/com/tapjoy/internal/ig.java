package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.nio.ByteBuffer;

public final class ig extends ImageView implements Runnable {
    private ic a;
    private Bitmap b;
    private final Handler c = new Handler(Looper.getMainLooper());
    private boolean d;
    private boolean e;
    private boolean f;
    private Thread g;
    private b h = null;
    private long i = -1;
    private a j = null;
    private final Runnable k = new Runnable() {
        /* class com.tapjoy.internal.ig.AnonymousClass1 */

        public final void run() {
            if (ig.this.b != null && !ig.this.b.isRecycled()) {
                ig igVar = ig.this;
                igVar.setImageBitmap(igVar.b);
            }
        }
    };
    private final Runnable l = new Runnable() {
        /* class com.tapjoy.internal.ig.AnonymousClass2 */

        public final void run() {
            ig.this.b = null;
            ig.this.a = null;
            ig.this.g = null;
            ig.this.f = false;
        }
    };

    public interface a {
    }

    public interface b {
        Bitmap a();
    }

    public ig(Context context) {
        super(context);
    }

    public final void a(ie ieVar, byte[] bArr) {
        try {
            this.a = new ic(new ih(), ieVar, ByteBuffer.wrap(bArr));
            if (this.d) {
                e();
            } else {
                d();
            }
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public final void setBytes(byte[] bArr) {
        ic icVar = new ic();
        this.a = icVar;
        try {
            icVar.a(bArr);
            if (this.d) {
                e();
            } else {
                d();
            }
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public final long getFramesDisplayDuration() {
        return this.i;
    }

    public final void setFramesDisplayDuration(long j2) {
        this.i = j2;
    }

    public final void a() {
        this.d = true;
        e();
    }

    public final void b() {
        this.d = false;
        Thread thread = this.g;
        if (thread != null) {
            thread.interrupt();
            this.g = null;
        }
    }

    private void d() {
        boolean z;
        if (this.a.a != 0) {
            ic icVar = this.a;
            if (-1 >= icVar.c.c) {
                z = false;
            } else {
                icVar.a = -1;
                z = true;
            }
            if (z && !this.d) {
                this.e = true;
                e();
            }
        }
    }

    public final void c() {
        this.d = false;
        this.e = false;
        this.f = true;
        b();
        this.c.post(this.l);
    }

    public final int getGifWidth() {
        return this.a.c.f;
    }

    public final int getGifHeight() {
        return this.a.c.g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ig.run():void");
    }

    public final b getOnFrameAvailable() {
        return this.h;
    }

    public final void setOnFrameAvailable(b bVar) {
        this.h = bVar;
    }

    public final a getOnAnimationStop() {
        return this.j;
    }

    public final void setOnAnimationStop(a aVar) {
        this.j = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    private void e() {
        if ((this.d || this.e) && this.a != null && this.g == null) {
            Thread thread = new Thread(this);
            this.g = thread;
            thread.start();
        }
    }
}
