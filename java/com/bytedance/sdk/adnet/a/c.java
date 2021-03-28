package com.bytedance.sdk.adnet.a;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.react.animated.InterpolationAnimatedNode;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileRequest */
public class c extends Request<File> {
    private File c;
    private File d;
    private final Object e = new Object();
    private m.a<File> f;

    /* compiled from: FileRequest */
    public interface a extends m.a<File> {
        void a(long j, long j2);
    }

    public c(String str, String str2, m.a<File> aVar) {
        super(str2, aVar);
        this.f = aVar;
        this.c = new File(str);
        this.d = new File(str + DefaultDiskStorage.FileType.TEMP);
        try {
            if (!(this.c == null || this.c.getParentFile() == null || this.c.getParentFile().exists())) {
                this.c.getParentFile().mkdirs();
            }
        } catch (Throwable unused) {
        }
        setRetryPolicy(new e(25000, 1, 1.0f));
        setShouldCache(false);
    }

    public File f() {
        return this.c;
    }

    public File g() {
        return this.d;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.e) {
            this.f = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        HashMap hashMap = new HashMap();
        hashMap.put("Range", "bytes=" + this.d.length() + "-");
        hashMap.put("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<File> a(j jVar) {
        if (isCanceled()) {
            h();
            return m.a(new VAdError("Request was Canceled!"));
        } else if (!this.d.canRead() || this.d.length() <= 0) {
            h();
            return m.a(new VAdError("Download temporary file was invalid!"));
        } else if (this.d.renameTo(this.c)) {
            return m.a(null, b.a(jVar));
        } else {
            h();
            return m.a(new VAdError("Can't rename the download temporary file!"));
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() {
        /*
            r1 = this;
            java.io.File r0 = r1.c     // Catch:{ all -> 0x0005 }
            r0.delete()     // Catch:{ all -> 0x0005 }
        L_0x0005:
            java.io.File r0 = r1.c     // Catch:{ all -> 0x000a }
            r0.delete()     // Catch:{ all -> 0x000a }
        L_0x000a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.a.c.h():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0161 A[SYNTHETIC, Splitter:B:60:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016f A[SYNTHETIC, Splitter:B:66:0x016f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(com.bytedance.sdk.adnet.core.HttpResponse r20) throws java.io.IOException, com.bytedance.sdk.adnet.err.f {
        /*
        // Method dump skipped, instructions count: 388
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.a.c.a(com.bytedance.sdk.adnet.core.HttpResponse):byte[]");
    }

    private boolean b(HttpResponse httpResponse) {
        return TextUtils.equals(a(httpResponse, "Content-Encoding"), "gzip");
    }

    private boolean c(HttpResponse httpResponse) {
        if (TextUtils.equals(a(httpResponse, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String a2 = a(httpResponse, "Content-Range");
        if (a2 == null || !a2.startsWith("bytes")) {
            return false;
        }
        return true;
    }

    private String a(HttpResponse httpResponse, String str) {
        if (httpResponse == null || httpResponse.getHeaders() == null || httpResponse.getHeaders().isEmpty()) {
            return null;
        }
        for (Header header : httpResponse.getHeaders()) {
            if (header != null && TextUtils.equals(header.getName(), str)) {
                return header.getValue();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<File> mVar) {
        m.a<File> aVar;
        synchronized (this.e) {
            aVar = this.f;
        }
        if (aVar != null) {
            aVar.a(m.a(this.c, mVar.b));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(long j, long j2) {
        m.a<File> aVar;
        synchronized (this.e) {
            aVar = this.f;
        }
        if (aVar instanceof a) {
            ((a) aVar).a(j, j2);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }
}
