package com.ironsource.network;

import android.net.Uri;
import android.util.Pair;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ISHttpService {
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final String TAG = "ISHttpService";

    public static Response sendGETRequest(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri build = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        Request.Builder builder = new Request.Builder();
        builder.setEndpoint(build.toString()).setData(str2).setMethod("GET").addHeaders(list);
        return sendRequest(builder.build());
    }

    public static Response sendPOSTRequest(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Request.Builder builder = new Request.Builder();
        builder.setEndpoint(str).setData(str2).setMethod("POST").addHeaders(list);
        return sendRequest(builder.build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047 A[SYNTHETIC, Splitter:B:21:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ironsource.network.Response sendRequest(com.ironsource.network.ISHttpService.Request r7) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.network.ISHttpService.sendRequest(com.ironsource.network.ISHttpService$Request):com.ironsource.network.Response");
    }

    private static void setPostBody(HttpURLConnection httpURLConnection, Request request) throws Exception {
        if (request.allowRequestBody()) {
            byte[] bytes = request.data.getBytes(request.encoding);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
            writeRequestBody(httpURLConnection, bytes);
        }
    }

    private static void setHeaders(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair<String, String> pair : list) {
            httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
    }

    private static void writeRequestBody(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }

    private static boolean areRequestParametersValid(String str, String str2) {
        return str != null && !str.isEmpty() && str2 != null && !str2.isEmpty();
    }

    private static HttpURLConnection createConnection(Request request) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.endpoint).openConnection();
        httpURLConnection.setConnectTimeout(request.connectTimeOut);
        httpURLConnection.setReadTimeout(request.readTimeOut);
        httpURLConnection.setRequestMethod(request.method);
        return httpURLConnection;
    }

    public static class Request {
        private static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 15000;
        private static final String DEFAULT_ENCODING = "UTF-8";
        private static final int DEFAULT_READ_TIMEOUT_MILLIS = 15000;
        final int connectTimeOut;
        final String data;
        final String encoding;
        final String endpoint;
        ArrayList<Pair<String, String>> headers;
        final String method;
        final int readTimeOut;

        public Request(Builder builder) {
            this.endpoint = builder.endpoint;
            this.method = builder.method;
            this.data = builder.data;
            this.headers = new ArrayList<>(builder.headers);
            this.connectTimeOut = builder.connectTimeOut;
            this.readTimeOut = builder.readTimeOut;
            this.encoding = builder.encoding;
        }

        /* access modifiers changed from: package-private */
        public boolean allowRequestBody() {
            return "POST".equals(this.method);
        }

        static class Builder {
            int connectTimeOut = 15000;
            String data;
            String encoding = Request.DEFAULT_ENCODING;
            String endpoint;
            List<Pair<String, String>> headers = new ArrayList();
            String method = "POST";
            int readTimeOut = 15000;

            Builder() {
            }

            /* access modifiers changed from: package-private */
            public Builder setData(String str) {
                this.data = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder setEncoding(String str) {
                this.encoding = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder setReadTimeOut(int i) {
                this.readTimeOut = i;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder setConnectTimeOut(int i) {
                this.connectTimeOut = i;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder setEndpoint(String str) {
                this.endpoint = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder addHeader(Pair<String, String> pair) {
                this.headers.add(pair);
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder addHeaders(List<Pair<String, String>> list) {
                this.headers.addAll(list);
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder setMethod(String str) {
                this.method = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Request build() {
                return new Request(this);
            }
        }
    }
}
