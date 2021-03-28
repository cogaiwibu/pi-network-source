package com.bytedance.sdk.openadsdk.h;

import android.content.Context;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.h.a.e;
import com.bytedance.sdk.openadsdk.h.a.g;
import com.bytedance.sdk.openadsdk.h.c.d;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HttpProxyCacheServer */
public class f {
    private final Object a;
    private final ExecutorService b;
    private final Map<String, g> c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final c g;
    private final k h;
    private int i;

    private f(c cVar) {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.i = 204800;
        this.g = (c) l.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new k("127.0.0.1", this.e);
        } catch (IOException | InterruptedException e2) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    public String a(com.bytedance.sdk.openadsdk.core.video.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (j.e().d(aVar.b) || aVar.c != 0) {
            return a(aVar.a, true);
        }
        return aVar.a;
    }

    public String a(String str, boolean z) {
        if (!z || !c(str)) {
            return a() ? d(str) : str;
        }
        File e2 = e(str);
        a(e2);
        return Uri.fromFile(e2).toString();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.openadsdk.h.b r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r3
            r1 = 1
            r0[r1] = r4
            com.bytedance.sdk.openadsdk.h.l.a(r0)
            java.lang.Object r0 = r2.a
            monitor-enter(r0)
            com.bytedance.sdk.openadsdk.h.g r4 = r2.g(r4)     // Catch:{ all -> 0x0016 }
            r4.a(r3)     // Catch:{ all -> 0x0016 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.f.a(com.bytedance.sdk.openadsdk.h.b, java.lang.String):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bytedance.sdk.openadsdk.h.b r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r3
            r3 = 1
            r0[r3] = r4
            com.bytedance.sdk.openadsdk.h.l.a(r0)
            java.lang.Object r3 = r2.a
            monitor-enter(r3)
            r2.f(r4)     // Catch:{ all -> 0x0012 }
        L_0x0012:
            monitor-exit(r3)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0014 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.f.b(com.bytedance.sdk.openadsdk.h.b, java.lang.String):void");
    }

    public void a(String str) {
        if (str != null) {
            try {
                g gVar = this.c.get(str);
                if (gVar != null) {
                    gVar.a();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(p pVar, String str) {
        if (str != null) {
            try {
                g g2 = g(str);
                if (g2 != null) {
                    g2.a(pVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(String str) {
        if (str != null) {
            try {
                g gVar = this.c.get(str);
                if (gVar != null) {
                    gVar.a(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean c(String str) {
        l.a(str, "Url can't be null!");
        return e(str).exists();
    }

    private boolean a() {
        return this.h.a(3, 70);
    }

    private String d(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.e), o.b(str));
    }

    private File e(String str) {
        return new File(this.g.a, this.g.b.a(str));
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (IOException e2) {
            l.b("HttpProxyCacheServer", "Error touching file " + file, e2);
        }
    }

    private void f(String str) {
        synchronized (this.a) {
            g gVar = this.c.get(str);
            if (gVar != null) {
                this.c.remove(a(str, this.i));
                this.c.remove(str);
                gVar.b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.d.accept();
                l.b("HttpProxyCacheServer", "Accept new socket " + accept);
                this.b.submit(new b(accept));
            } catch (IOException e2) {
                a(new n("Error during waiting connection", e2));
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Socket socket) {
        StringBuilder sb;
        try {
            d a2 = d.a(socket.getInputStream());
            l.b("HttpProxyCacheServer", "Request to cache proxy:" + a2);
            String c2 = o.c(a2.a);
            if (this.h.a(c2)) {
                this.h.a(socket);
            } else {
                g(c2).a(a2, socket);
            }
            b(socket);
            sb = new StringBuilder();
        } catch (SocketException unused) {
            l.b("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
            b(socket);
            sb = new StringBuilder();
        } catch (n | IOException e2) {
            a(new n("Error processing request", e2));
            b(socket);
            sb = new StringBuilder();
        } catch (Throwable th) {
            b(socket);
            l.b("HttpProxyCacheServer", "Opened connections: " + c());
            throw th;
        }
        sb.append("Opened connections: ");
        sb.append(c());
        l.b("HttpProxyCacheServer", sb.toString());
    }

    private g g(String str) throws n {
        g gVar;
        synchronized (this.a) {
            gVar = this.c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.g);
                this.c.put(str, gVar);
            }
        }
        return gVar;
    }

    private String a(String str, int i2) {
        if (str == null || !str.contains("?")) {
            return str + "?size=" + i2 + "&preload=true&hasPrefix=false";
        }
        return str + "&size=" + i2 + "&preload=true&hasPrefix=true";
    }

    private int c() {
        int i2;
        synchronized (this.a) {
            i2 = 0;
            for (g gVar : this.c.values()) {
                i2 += gVar.c();
            }
        }
        return i2;
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            l.b("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            a(new n("Error closing socket input stream", e2));
        }
    }

    private void d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e2) {
            l.d("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection." + e2.getMessage());
        }
    }

    private void e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e2) {
            a(new n("Error closing socket", e2));
        }
    }

    private void a(Throwable th) {
        l.b("HttpProxyCacheServer", "HttpProxyCacheServer error", th);
    }

    /* compiled from: HttpProxyCacheServer */
    private final class c implements Runnable {
        private final CountDownLatch b;

        public c(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        public void run() {
            this.b.countDown();
            f.this.b();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: HttpProxyCacheServer */
    public final class b implements Runnable {
        private final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        public void run() {
            f.this.a((f) this.b);
        }
    }

    /* compiled from: HttpProxyCacheServer */
    public static final class a {
        private File a;
        private com.bytedance.sdk.openadsdk.h.a.c b = new e();
        private com.bytedance.sdk.openadsdk.h.a.a c = new g(83886080);
        private com.bytedance.sdk.openadsdk.h.c.c d;
        private com.bytedance.sdk.openadsdk.h.b.b e = new com.bytedance.sdk.openadsdk.h.b.a();

        public a(Context context) {
            this.d = d.a(context);
            this.a = s.a(context);
        }

        public a a(File file) {
            this.a = (File) l.a(file);
            return this;
        }

        public f a() {
            return new f(b());
        }

        private c b() {
            return new c(this.a, this.b, this.c, this.d, this.e);
        }
    }
}
