package com.tapjoy.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class gb {
    private final ReentrantLock a;
    volatile int b = c.a;
    b c;
    long d = 1000;
    a e;
    private final Condition f;
    private final LinkedList g = new LinkedList();
    private a h;

    public abstract boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    public gb() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.f = reentrantLock.newCondition();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* access modifiers changed from: package-private */
    public static final class c extends Enum {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    public final boolean b(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        this.a.lock();
        if (tJConnectListener != null) {
            try {
                this.g.addLast(fn.a(tJConnectListener, TJConnectListener.class));
            } catch (Throwable th) {
                this.a.unlock();
                throw th;
            }
        }
        a aVar = new a(context, str, hashtable);
        int i = AnonymousClass3.a[this.b - 1];
        if (i != 1) {
            if (i == 2) {
                this.e = aVar;
                fs.b.addObserver(new Observer() {
                    /* class com.tapjoy.internal.gb.AnonymousClass1 */

                    public final void update(Observable observable, Object obj) {
                        fs.b.deleteObserver(this);
                        if (!Boolean.valueOf(Boolean.TRUE.equals(obj)).booleanValue() && gb.this.e != null && gb.this.e.a != null) {
                            gb.this.c = new b(gb.this, (byte) 0);
                            gb.this.c.e();
                        }
                    }
                });
                if (a(aVar.a, aVar.b, aVar.c, new TJConnectListener() {
                    /* class com.tapjoy.internal.gb.AnonymousClass2 */

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectSuccess() {
                        gb gbVar = gb.this;
                        int i = c.e;
                        int i2 = c.b;
                        gbVar.a(i);
                        gb.this.a(true);
                    }

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectFailure() {
                        gb.this.a(false);
                    }
                })) {
                    int i2 = c.b;
                    int i3 = c.a;
                    a(i2);
                } else {
                    this.g.clear();
                }
            } else if (i == 3 || i == 4) {
                this.h = aVar;
            } else if (i != 5) {
                a(c.a);
            } else {
                this.h = aVar;
                b();
            }
            this.a.unlock();
            return false;
        }
        a(true);
        this.a.unlock();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.gb$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0027 */
        static {
            /*
                int[] r0 = com.tapjoy.internal.gb.c.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.gb.AnonymousClass3.a = r0
                r1 = 1
                int r2 = com.tapjoy.internal.gb.c.e     // Catch:{ NoSuchFieldError -> 0x000f }
                int r2 = r2 - r1
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = com.tapjoy.internal.gb.AnonymousClass3.a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = com.tapjoy.internal.gb.c.a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = r2 - r1
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = com.tapjoy.internal.gb.AnonymousClass3.a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.tapjoy.internal.gb.c.b     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = r2 - r1
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = com.tapjoy.internal.gb.AnonymousClass3.a     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = com.tapjoy.internal.gb.c.c     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2 - r1
                r3 = 4
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r0 = com.tapjoy.internal.gb.AnonymousClass3.a     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = com.tapjoy.internal.gb.c.d     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = r2 - r1
                r1 = 5
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gb.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        this.a.lock();
        try {
            this.b = i;
        } finally {
            this.a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final a a() {
        this.a.lock();
        try {
            if (this.h != null) {
                this.e = this.h;
                this.h = null;
            }
            return this.e;
        } finally {
            this.a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.a.lock();
        try {
            if (this.g.size() != 0) {
                ArrayList arrayList = new ArrayList(this.g);
                this.g.clear();
                this.a.unlock();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    TJConnectListener tJConnectListener = (TJConnectListener) it.next();
                    if (z) {
                        tJConnectListener.onConnectSuccess();
                    } else {
                        tJConnectListener.onConnectFailure();
                    }
                }
            }
        } finally {
            this.a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.a.lock();
        try {
            this.d = 1000;
            this.f.signal();
        } finally {
            this.a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(long j) {
        this.a.lock();
        try {
            int i = c.d;
            int i2 = c.c;
            a(i);
            if (this.f.await(j, TimeUnit.MILLISECONDS)) {
                this.d = 1000;
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            int i3 = c.c;
            int i4 = c.d;
            a(i3);
            this.a.unlock();
            throw th;
        }
        int i5 = c.c;
        int i6 = c.d;
        a(i5);
        this.a.unlock();
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a {
        public final Context a;
        public final String b;
        public final Hashtable c;

        public a(Context context, String str, Hashtable hashtable) {
            Context context2;
            if (context == null) {
                context2 = null;
            } else if (context instanceof Application) {
                context2 = context;
            } else {
                context2 = context.getApplicationContext();
            }
            this.a = context2 != null ? context2 : context;
            this.b = str;
            this.c = hashtable;
        }
    }

    class b extends ka {
        private boolean b;
        private boolean c;
        private Context d;
        private BroadcastReceiver e;

        private b() {
            this.e = new BroadcastReceiver() {
                /* class com.tapjoy.internal.gb.b.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    gb.this.b();
                }
            };
        }

        /* synthetic */ b(gb gbVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void a() {
            this.b = true;
            gb.this.b();
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void b() {
            gb gbVar = gb.this;
            int i = c.c;
            int i2 = c.b;
            gbVar.a(i);
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void c() {
            if (gb.this.c == this) {
                gb.this.c = null;
            }
            if (gb.this.b == c.c) {
                gb gbVar = gb.this;
                int i = c.a;
                int i2 = c.c;
                gbVar.a(i);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ka
        public final void d() {
            this.d = gb.this.a().a;
            this.d.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            while (!this.b) {
                try {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    fs.b.addObserver(new Observer() {
                        /* class com.tapjoy.internal.gb.b.AnonymousClass1 */

                        public final void update(Observable observable, Object obj) {
                            fs.b.deleteObserver(this);
                            b.this.c = Boolean.TRUE.equals(obj);
                            countDownLatch.countDown();
                        }
                    });
                    a a2 = gb.this.a();
                    if (!gb.this.a(a2.a, a2.b, a2.c, null)) {
                        gb.this.a((gb) false);
                        h();
                        return;
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                    }
                    if (this.c) {
                        gb gbVar = gb.this;
                        int i = c.e;
                        int i2 = c.c;
                        gbVar.a(i);
                        gb.this.a((gb) true);
                        return;
                    }
                    gb.this.a((gb) false);
                    long max = Math.max(gb.this.d, 1000L);
                    gb.this.d = Math.min(max << 2, 3600000L);
                    gb.this.a(max);
                } finally {
                    h();
                }
            }
            h();
        }

        private void h() {
            this.d.unregisterReceiver(this.e);
        }
    }
}
