package androidx.core.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;

class DatagramSocketWrapper extends Socket {
    DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) throws SocketException {
        super(new DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }

    private static class DatagramSocketImplWrapper extends SocketImpl {
        DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
            this.localport = datagramSocket.getLocalPort();
            this.fd = fileDescriptor;
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void accept(SocketImpl socketImpl) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public int available() throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void bind(InetAddress inetAddress, int i) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void close() throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void connect(String str, int i) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void connect(InetAddress inetAddress, int i) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void create(boolean z) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public InputStream getInputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public OutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void listen(int i) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void connect(SocketAddress socketAddress, int i) throws IOException {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        @Override // java.net.SocketImpl
        public void sendUrgentData(int i) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public Object getOption(int i) throws SocketException {
            throw new UnsupportedOperationException();
        }

        @Override // java.net.SocketOptions
        public void setOption(int i, Object obj) throws SocketException {
            throw new UnsupportedOperationException();
        }
    }
}
