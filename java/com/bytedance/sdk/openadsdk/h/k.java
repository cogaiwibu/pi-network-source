package com.bytedance.sdk.openadsdk.h;

import com.bytedance.sdk.openadsdk.g.l;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* access modifiers changed from: package-private */
/* compiled from: Pinger */
public class k {
    private final ExecutorService a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    k(String str, int i) {
        this.b = (String) l.a(str);
        this.c = i;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2) {
        l.a(i >= 1);
        l.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.a.submit(new a()).get((long) i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (TimeoutException unused) {
                l.d("Pinger", "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            } catch (InterruptedException | ExecutionException e) {
                l.b("Pinger", "Error pinging server due to unexpected error", e);
            }
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a());
        l.b("Pinger", format, new n(format));
        return false;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        return "ping".equals(str);
    }

    /* access modifiers changed from: package-private */
    public void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean b() throws n {
        h hVar = new h(c());
        try {
            byte[] bytes = "ping ok".getBytes();
            hVar.a(0);
            byte[] bArr = new byte[bytes.length];
            hVar.a(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            l.c("Pinger", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (n e) {
            l.b("Pinger", "Error reading ping response", e);
            return false;
        } finally {
            hVar.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.c), "ping");
    }

    /* access modifiers changed from: private */
    /* compiled from: Pinger */
    public class a implements Callable<Boolean> {
        private a() {
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(k.this.b());
        }
    }
}
