package com.bytedance.sdk.adnet.core;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.adnet.face.b;
import com.bytedance.sdk.adnet.face.c;
import java.util.concurrent.BlockingQueue;

/* access modifiers changed from: package-private */
/* compiled from: NetworkDispatcher */
public class i extends Thread {
    private final BlockingQueue<Request<?>> a;
    private final b b;
    private final a c;
    private final c d;
    private volatile boolean e = false;

    public i(BlockingQueue<Request<?>> blockingQueue, b bVar, a aVar, c cVar) {
        this.a = blockingQueue;
        this.b = bVar;
        this.c = aVar;
        this.d = cVar;
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    private void b(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                n.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.a.take());
    }

    /* access modifiers changed from: package-private */
    public void a(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.a(3);
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.a("network-discard-cancelled");
                request.e();
                request.a(4);
                return;
            }
            b(request);
            j a2 = this.b.a(request);
            request.addMarker("network-http-complete");
            if (!a2.e || !request.hasHadResponseDelivered()) {
                m<?> a3 = request.a(a2);
                request.addMarker("network-parse-complete");
                if (request.shouldCache() && a3.b != null) {
                    this.c.a(request.getCacheKey(), a3.b);
                    request.addMarker("network-cache-written");
                }
                request.markDelivered();
                this.d.a(request, a3);
                request.b(a3);
                request.a(4);
                return;
            }
            request.a("not-modified");
            request.e();
            request.a(4);
        } catch (VAdError e2) {
            e2.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            a(request, e2);
            request.e();
        } catch (Exception e3) {
            n.a(e3, "Unhandled exception %s", e3.toString());
            VAdError vAdError = new VAdError(e3);
            vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.a(request, vAdError);
            request.e();
        } catch (Throwable th) {
            request.a(4);
            throw th;
        }
    }

    private void a(Request<?> request, VAdError vAdError) {
        this.d.a(request, request.a(vAdError));
    }
}
