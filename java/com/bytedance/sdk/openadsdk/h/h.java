package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.h.b.a;
import com.bytedance.sdk.openadsdk.h.b.b;
import com.bytedance.sdk.openadsdk.h.c.c;
import com.bytedance.sdk.openadsdk.h.c.d;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlSource */
public class h implements q {
    public int a;
    public boolean b;
    private final c c;
    private final b d;
    private r e;
    private HttpURLConnection f;
    private InputStream g;

    public h(String str) {
        this(str, d.a());
    }

    public h(String str, c cVar) {
        this(str, cVar, new a());
    }

    public h(String str, c cVar, b bVar) {
        this.a = 204800;
        this.b = false;
        this.c = (c) l.a(cVar);
        this.d = (b) l.a(bVar);
        r a2 = cVar.a(str);
        this.e = a2 == null ? new r(str, -2147483648L, o.a(str)) : a2;
    }

    public h(h hVar) {
        this.a = 204800;
        this.b = false;
        this.e = hVar.e;
        this.c = hVar.c;
        this.d = hVar.d;
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public synchronized long a() throws n {
        if (this.e.b == -2147483648L) {
            g();
        }
        return this.e.b;
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public void a(long j) throws n {
        try {
            HttpURLConnection a2 = a(j, -1);
            this.f = a2;
            String contentType = a2.getContentType();
            this.g = new BufferedInputStream(this.f.getInputStream(), 8192);
            r rVar = new r(this.e.a, a(this.f, j, this.f.getResponseCode()), contentType);
            this.e = rVar;
            this.c.a(rVar.a, this.e);
        } catch (IOException e2) {
            throw new n("Error opening connection for " + this.e.a + " with offset " + j, e2);
        }
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) throws IOException {
        long a2 = a(httpURLConnection);
        if (i == 200) {
            return a2;
        }
        if (i == 206) {
            return a2 + j;
        }
        return this.e.b;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public void b() throws n {
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e2) {
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e2);
            } catch (ArrayIndexOutOfBoundsException e3) {
                l.b("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e3);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public int c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public boolean d() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public int a(byte[] bArr) throws n {
        InputStream inputStream = this.g;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new j("Reading source " + this.e.a + " is interrupted", e2);
            } catch (IOException e3) {
                throw new n("Error reading data from " + this.e.a, e3);
            }
        } else {
            throw new n("Error reading data from " + this.e.a + ": connection is absent!");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() throws com.bytedance.sdk.openadsdk.h.n {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.h.g():void");
    }

    private HttpURLConnection a(long j, int i) throws IOException, n {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.e.a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            l.b("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            a(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new n("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.d.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public synchronized String e() throws n {
        if (TextUtils.isEmpty(this.e.c)) {
            g();
        }
        return this.e.c;
    }

    @Override // com.bytedance.sdk.openadsdk.h.q
    public String f() {
        return this.e.a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.e + "}";
    }
}
