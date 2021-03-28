package com.bytedance.sdk.adnet.b;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: TLSSocketFactory */
public class c extends SSLSocketFactory {
    private static final String[] a;
    private static final X509TrustManager b = new X509TrustManager() {
        /* class com.bytedance.sdk.adnet.b.c.AnonymousClass1 */

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };
    private SSLSocketFactory c;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            a = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else if (Build.VERSION.SDK_INT >= 16) {
            a = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            a = new String[]{"SSLv3", "TLSv1"};
        }
    }

    private static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(a);
        }
    }

    public c() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{b}, new SecureRandom());
            this.c = instance.getSocketFactory();
        } catch (Exception e) {
            Log.e("TLSSocketFactory", "TLSSocketFactory error: ", e);
        }
    }

    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory.getDefaultCipherSuites();
        }
        return null;
    }

    public String[] getSupportedCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory.getSupportedCipherSuites();
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(socket, str, i, z);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(str, i);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(str, i, inetAddress, i2);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(inetAddress, i);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        SSLSocketFactory sSLSocketFactory = this.c;
        if (sSLSocketFactory == null) {
            return null;
        }
        Socket createSocket = sSLSocketFactory.createSocket();
        a(createSocket);
        return createSocket;
    }
}
