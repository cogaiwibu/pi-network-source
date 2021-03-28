package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.c;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* compiled from: ExecutorDelivery */
public class g implements c {
    private final Executor a;

    public g(final Handler handler) {
        this.a = new Executor() {
            /* class com.bytedance.sdk.adnet.core.g.AnonymousClass1 */

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, m<?> mVar) {
        a(request, mVar, (Runnable) null);
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, m<?> mVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.a.execute(new a(request, mVar, runnable));
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        this.a.execute(new a(request, m.a(vAdError), null));
    }

    @Override // com.bytedance.sdk.adnet.face.c
    public void a(final Request<?> request, final long j, final long j2) {
        this.a.execute(new Runnable() {
            /* class com.bytedance.sdk.adnet.core.g.AnonymousClass2 */

            public void run() {
                try {
                    request.a(j, j2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* compiled from: ExecutorDelivery */
    public static class a implements Runnable {
        private final Request a;
        private final m b;
        private final Runnable c;

        public a(Request request, m mVar, Runnable runnable) {
            this.a = request;
            this.b = mVar;
            this.c = runnable;
        }

        public void run() {
            if (this.a.isCanceled()) {
                this.a.a("canceled-at-delivery");
                return;
            }
            this.b.e = System.currentTimeMillis() - this.a.getStartTime();
            if (this.b.a()) {
                try {
                    this.a.a(this.b);
                } catch (Throwable unused) {
                }
            } else {
                this.a.deliverError(this.b);
            }
            if (this.b.d) {
                this.a.addMarker("intermediate-response");
            } else {
                this.a.a("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
