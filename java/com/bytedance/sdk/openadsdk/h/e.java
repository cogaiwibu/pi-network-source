package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: HttpProxyCache */
public class e extends m {
    private final h b;
    private final b c;
    private b d;

    public e(h hVar, b bVar) {
        super(hVar, bVar);
        this.c = bVar;
        this.b = hVar;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(d dVar, Socket socket) throws IOException, n {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.b;
        this.b.a = dVar.d;
        this.b.b = dVar.e;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    private boolean a(d dVar) throws n {
        long a = this.b.a();
        boolean z = a > 0;
        long a2 = this.c.a();
        if (!z || !dVar.c || ((float) dVar.b) <= ((float) a2) + (((float) a) * 0.2f)) {
            return true;
        }
        return false;
    }

    private String b(d dVar) throws IOException, n {
        String e = this.b.e();
        boolean z = !TextUtils.isEmpty(e);
        long a = this.c.d() ? this.c.a() : this.b.a();
        boolean z2 = a >= 0;
        long j = dVar.c ? a - dVar.b : a;
        boolean z3 = z2 && dVar.c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str = "";
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j)) : str);
        sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.b), Long.valueOf(a - 1), Long.valueOf(a)) : str);
        if (z) {
            str = a("Content-Type: %s\n", e);
        }
        sb.append(str);
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return sb.toString();
    }

    private void a(OutputStream outputStream, long j) throws n, IOException {
        byte[] bArr = new byte[8192];
        if (this.b.b) {
            outputStream.flush();
            while (true) {
                int a = a(bArr, j, 8192);
                if (a != -1) {
                    j += (long) a;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                boolean z = false;
                try {
                    int a2 = a(bArr, j, 8192);
                    if (a2 == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, a2);
                    j += (long) a2;
                } catch (Exception e) {
                    l.b("HttpProxyCache", "e:", e);
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("出错啦。。。。。可能进行重试播放。。。。");
                        if (this.a != null) {
                            z = true;
                        }
                        sb.append(z);
                        l.e("HttpProxyCache", sb.toString());
                        if (this.a != null) {
                            l.e("HttpProxyCache", "retryPlayerListener===被调用。。。。。");
                            this.a.a(this.b.f());
                        }
                    } catch (Exception unused) {
                    }
                } catch (Throwable th) {
                    outputStream.flush();
                    throw th;
                }
            }
            outputStream.flush();
        }
    }

    private void b(OutputStream outputStream, long j) throws n, IOException {
        h hVar = new h(this.b);
        try {
            hVar.a((long) ((int) j));
            byte[] bArr = new byte[8192];
            while (true) {
                int a = hVar.a(bArr);
                if (a != -1) {
                    outputStream.write(bArr, 0, a);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            hVar.b();
        }
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.h.m
    public void a(int i) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(this.c.a, this.b.f(), i);
        }
    }
}
