package com.bytedance.sdk.openadsdk.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.g.j;
import com.bytedance.sdk.openadsdk.g.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: AdEventThread */
public class g<T> extends HandlerThread implements Handler.Callback {
    private final e<T> a;
    private final k<T> b;
    private final List<T> c = Collections.synchronizedList(new LinkedList());
    private long d;
    private boolean e;
    private int f;
    private Handler g;
    private final a h;
    private final b i;

    /* compiled from: AdEventThread */
    public interface a {
        boolean a();
    }

    g(e<T> eVar, k<T> kVar, b bVar, a aVar) {
        super("ttad_bk");
        this.i = bVar;
        this.h = aVar;
        this.a = eVar;
        this.b = kVar;
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        this.d = System.currentTimeMillis();
        this.g = new Handler(getLooper(), this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.bytedance.sdk.openadsdk.b.g<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a(message.obj);
        } else if (i2 == 2) {
            d();
        } else if (i2 == 3) {
            c();
        } else if (i2 == 4) {
            b();
        } else if (i2 == 5) {
            a();
        }
        return true;
    }

    private void a() {
        this.a.a(this.i.d, this.i.e);
        this.e = this.a.b();
        this.f = this.a.c();
        if (this.e) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f);
            h();
            return;
        }
        this.c.addAll(this.a.a());
        a("onHandleInitEvent cacheData count = " + this.c.size());
        e();
    }

    private void b() {
        if (!this.h.a()) {
            a(4, this.i.c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> a2 = this.a.a();
        if (j.a(a2)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            n();
            j();
            return;
        }
        h a3 = this.b.a(a2);
        if (a3 == null) {
            return;
        }
        if (a3.a) {
            a("onHandleServerBusyRetryEvent, success");
            g();
            f();
        } else if (a(a3)) {
            int i2 = this.f + 1;
            this.f = i2;
            this.a.a(i2);
            this.a.a(a2, this.i.d, this.i.e);
            h();
            a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f);
        } else if (b(a3)) {
            g();
            f();
        } else {
            i();
            a("onHandleServerBusyRetryEvent, net fail");
        }
    }

    private void c() {
        if (!this.e) {
            a("onHandleRoutineRetryEvent");
            e();
        }
    }

    private void d() {
        if (!this.e) {
            a("onHandleRoutineUploadEvent");
            e();
        }
    }

    private void a(T t) {
        l.b("ReportEvent", "execute onHandleReceivedAdEvent()  start...");
        this.a.a((Object) t);
        if (!this.e) {
            this.c.add(t);
            l.b("ReportEvent", "execute onHandleReceivedAdEvent() ... mIsServerBusy =" + this.e);
            if (m()) {
                l.b("ReportEvent", "execute onHandleReceivedAdEvent()  needUploadRoutine ... upload ");
                e();
            }
        }
    }

    private void e() {
        l.c("ReportEvent", "execute doRoutineUpload ... start ");
        this.g.removeMessages(3);
        this.g.removeMessages(2);
        l.c("ReportEvent", "execute doRoutineUpload ... ListUtils.isEmpty(mCacheList) :" + j.a(this.c));
        if (j.a(this.c)) {
            this.d = System.currentTimeMillis();
            j();
        } else if (!this.h.a()) {
            l.c("ReportEvent", "execute doRoutineUpload ...no network, wait retry ");
            i();
        } else {
            h a2 = this.b.a(this.c);
            if (a2 == null) {
                return;
            }
            if (a2.a) {
                l.c("ReportEvent", "doRoutineUpload success");
                g();
                f();
            } else if (a(a2)) {
                l.c("ReportEvent", "doRoutineUpload serverbusy");
                k();
            } else if (b(a2)) {
                g();
                f();
            } else if (!this.e) {
                i();
                l.c("ReportEvent", "doRoutineUpload net fail retry");
            }
        }
    }

    private void f() {
        this.d = System.currentTimeMillis();
        n();
        j();
    }

    private void g() {
        this.a.a((List) this.c);
        this.c.clear();
    }

    private void h() {
        a(4, l());
    }

    private void i() {
        a(3, this.i.c);
    }

    private void j() {
        a(2, this.i.b);
    }

    private void a(int i2, long j) {
        Message obtainMessage = this.g.obtainMessage();
        obtainMessage.what = i2;
        this.g.sendMessageDelayed(obtainMessage, j);
    }

    private void k() {
        this.e = true;
        this.a.a(true);
        this.c.clear();
        this.g.removeMessages(3);
        this.g.removeMessages(2);
        h();
    }

    private long l() {
        return ((long) ((this.f % 3) + 1)) * this.i.f;
    }

    private static boolean a(h hVar) {
        return hVar.b == 509;
    }

    private static boolean b(h hVar) {
        return hVar.d;
    }

    private boolean m() {
        return !this.e && (this.c.size() >= this.i.a || System.currentTimeMillis() - this.d >= this.i.b);
    }

    private void n() {
        this.e = false;
        this.a.a(false);
        this.f = 0;
        this.a.a(0);
        this.g.removeMessages(4);
    }

    private void a(String str) {
        l.c("AdEventThread", str);
    }

    /* compiled from: AdEventThread */
    public static class b {
        final int a;
        final long b;
        final long c;
        final int d;
        final long e;
        final long f;

        b(int i, long j, long j2, int i2, long j3, long j4) {
            this.a = i;
            this.b = j;
            this.c = j2;
            this.d = i2;
            this.e = j3;
            this.f = j4;
        }

        public static b a() {
            return new b(1, 120000, 15000, 5, 86400000, 600000);
        }
    }
}
