package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.a.c;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.f;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.adnet.face.b;
import com.bytedance.sdk.adnet.face.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: BasicNetwork */
public class a implements b {
    protected static final boolean a = n.a;
    protected final IHttpStack b;
    protected final b c;

    public a(IHttpStack iHttpStack) {
        this(iHttpStack, new b(4096));
    }

    public a(IHttpStack iHttpStack, b bVar) {
        this.b = iHttpStack;
        this.c = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        r18 = r1;
        r2 = r11;
        r14 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a6, code lost:
        r18 = r1;
        r14 = null;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ab, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ac, code lost:
        r18 = r1;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b1, code lost:
        r0 = r2.getStatusCode();
        com.bytedance.sdk.adnet.core.n.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r28.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        if (r14 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cd, code lost:
        r1 = new com.bytedance.sdk.adnet.core.j(r0, r14, false, android.os.SystemClock.elapsedRealtime() - r9, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r0 == 401) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e6, code lost:
        if (r0 < 400) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f2, code lost:
        throw new com.bytedance.sdk.adnet.err.b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        if (r0 < 500) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        if (r28.shouldRetryServerErrors() != false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0101, code lost:
        a("server", r28, new com.bytedance.sdk.adnet.err.f(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0112, code lost:
        throw new com.bytedance.sdk.adnet.err.f(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0118, code lost:
        throw new com.bytedance.sdk.adnet.err.f(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0119, code lost:
        a("auth", r28, new com.bytedance.sdk.adnet.err.a(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0125, code lost:
        a("network", r28, new com.bytedance.sdk.adnet.err.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0136, code lost:
        throw new com.bytedance.sdk.adnet.err.d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0137, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0152, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r28.getUrl(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0153, code lost:
        a("socket", r28, new com.bytedance.sdk.adnet.err.g());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0137 A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0131 A[SYNTHETIC] */
    @Override // com.bytedance.sdk.adnet.face.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.adnet.core.j a(com.bytedance.sdk.adnet.core.Request<?> r28) throws com.bytedance.sdk.adnet.err.VAdError {
        /*
        // Method dump skipped, instructions count: 351
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.a.a(com.bytedance.sdk.adnet.core.Request):com.bytedance.sdk.adnet.core.j");
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
            n.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        d retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.a(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VAdError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private Map<String, String> a(a.C0003a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (aVar.c != null) {
            hashMap.put("If-None-Match", aVar.c);
        }
        if (aVar.e > 0) {
            hashMap.put("If-Modified-Since", com.bytedance.sdk.adnet.b.b.a(aVar.e));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public byte[] a(Request<?> request, HttpResponse httpResponse) throws IOException, f {
        if (request instanceof c) {
            return ((c) request).a(httpResponse);
        }
        InputStream content = httpResponse.getContent();
        return content != null ? a(content, httpResponse.getContentLength()) : new byte[0];
    }

    private byte[] a(InputStream inputStream, int i) throws IOException, f {
        c cVar = new c(this.c, i);
        if (inputStream != null) {
            try {
                byte[] a2 = this.c.a(1024);
                while (true) {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    cVar.write(a2, 0, read);
                }
                byte[] byteArray = cVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        n.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.c.a(a2);
                cVar.close();
                return byteArray;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        n.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.c.a((byte[]) null);
                cVar.close();
                throw th;
            }
        } else {
            throw new f();
        }
    }

    private static List<Header> a(List<Header> list, a.C0003a aVar) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.getName());
                arrayList.add(header);
            }
        }
        if (aVar != null) {
            if (aVar.i != null) {
                if (!aVar.i.isEmpty()) {
                    for (Header header2 : aVar.i) {
                        if (!treeSet.contains(header2.getName())) {
                            arrayList.add(header2);
                        }
                    }
                }
            } else if (!aVar.h.isEmpty()) {
                for (Map.Entry<String, String> entry : aVar.h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new Header(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }
}
