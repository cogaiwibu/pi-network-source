package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.facebook.common.util.UriUtil;
import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.mediationsdk.config.VersionInfo;
import com.ironsource.sdk.constants.Events;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack */
public class h implements IHttpStack {
    private final b a;
    private final SSLSocketFactory b;

    /* compiled from: HurlStack */
    public interface b {
        String a(String str);
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public h() {
        this(null);
    }

    public h(b bVar) {
        this(bVar, null);
    }

    public h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.a = bVar;
        this.b = sSLSocketFactory;
    }

    @Override // com.bytedance.sdk.adnet.face.IHttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(request.getUserAgent())) {
            hashMap.put("User-Agent", request.getUserAgent());
        }
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        b bVar = this.a;
        if (bVar != null) {
            String a2 = bVar.a(url);
            if (a2 != null) {
                url = a2;
            } else {
                throw new IOException("URL blocked by rewriter: " + url);
            }
        }
        HttpURLConnection a3 = a(new URL(url), request);
        try {
            for (String str : hashMap.keySet()) {
                a3.setRequestProperty(str, (String) hashMap.get(str));
            }
            a(a3, request);
            int responseCode = a3.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } else if (a(request.getMethod(), responseCode)) {
                return new HttpResponse(responseCode, a(a3.getHeaderFields()), a3.getContentLength(), new a(a3));
            } else {
                HttpResponse httpResponse = new HttpResponse(responseCode, a(a3.getHeaderFields()));
                a3.disconnect();
                return httpResponse;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                a3.disconnect();
            }
            throw th;
        }
    }

    static List<Header> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new Header(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    /* compiled from: HurlStack */
    static class a extends FilterInputStream {
        private final HttpURLConnection a;

        a(HttpURLConnection httpURLConnection) {
            super(h.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            super.close();
            this.a.disconnect();
        }
    }

    /* access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    private HttpURLConnection a(URL url, Request<?> request) throws IOException {
        HttpURLConnection a2 = a(url);
        int timeoutMs = request.getTimeoutMs();
        a2.setConnectTimeout(timeoutMs);
        a2.setReadTimeout(timeoutMs);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if (UriUtil.HTTPS_SCHEME.equals(url.getProtocol())) {
            SSLSocketFactory sSLSocketFactory = this.b;
            if (sSLSocketFactory == null) {
                com.bytedance.sdk.adnet.b.a.a();
            } else {
                ((HttpsURLConnection) a2).setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return a2;
    }

    static void a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod(NativeEventsConstants.HTTP_METHOD_POST);
                    a(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod(NativeEventsConstants.HTTP_METHOD_GET);
                return;
            case 1:
                httpURLConnection.setRequestMethod(NativeEventsConstants.HTTP_METHOD_POST);
                b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod(VersionInfo.GIT_BRANCH);
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body != null) {
            a(httpURLConnection, request, body);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey(Events.CONTENT_TYPE)) {
            httpURLConnection.setRequestProperty(Events.CONTENT_TYPE, request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
