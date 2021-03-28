package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.face.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: DiskBasedCache */
public class f implements com.bytedance.sdk.adnet.face.a {
    private final Map<String, a> a;
    private long b;
    private final File c;
    private final int d;

    public f(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = i;
    }

    public f(File file) {
        this(file, 5242880);
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized a.C0003a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = this.a.get(str);
        if (aVar == null) {
            return null;
        }
        File c2 = c(str);
        try {
            b bVar = new b(new BufferedInputStream(a(c2)), c2.length());
            try {
                a a2 = a.a(bVar);
                if (!TextUtils.equals(str, a2.b)) {
                    n.b("%s: key=%s, found=%s", c2.getAbsolutePath(), str, a2.b);
                    e(str);
                    return null;
                }
                a.C0003a a3 = aVar.a(a(bVar, bVar.a()));
                bVar.close();
                return a3;
            } finally {
                bVar.close();
            }
        } catch (Throwable th) {
            n.b("%s: %s", c2.getAbsolutePath(), th.toString());
            b(str);
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized void a() {
        if (!this.c.exists()) {
            if (!this.c.mkdirs()) {
                n.c("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    long length = file.length();
                    b bVar = new b(new BufferedInputStream(a(file)), length);
                    try {
                        a a2 = a.a(bVar);
                        a2.a = length;
                        a(a2.b, a2);
                    } catch (Throwable unused) {
                    }
                    bVar.close();
                } catch (Throwable unused2) {
                    file.delete();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized void a(String str, a.C0003a aVar) {
        if (this.b + ((long) aVar.b.length) > ((long) this.d)) {
            if (((float) aVar.b.length) > ((float) this.d) * 0.9f) {
                return;
            }
        }
        File c2 = c(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b(c2));
            a aVar2 = new a(str, aVar);
            if (aVar2.a(bufferedOutputStream)) {
                bufferedOutputStream.write(aVar.b);
                bufferedOutputStream.close();
                aVar2.a = c2.length();
                a(str, aVar2);
                b();
                return;
            }
            bufferedOutputStream.close();
            n.b("Failed to write header for %s", c2.getAbsolutePath());
            throw new IOException();
        } catch (Throwable unused) {
            if (!c2.delete()) {
                n.b("Could not clean up file %s", c2.getAbsolutePath());
            }
        }
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            n.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    private String d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public File c(String str) {
        return new File(this.c, d(str));
    }

    private void b() {
        if (this.b >= ((long) this.d)) {
            if (n.a) {
                n.a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.a.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (c(value.b).delete()) {
                    this.b -= value.a;
                } else {
                    n.b("Could not delete cache entry for key=%s, filename=%s", value.b, d(value.b));
                }
                it.remove();
                i++;
                if (((float) this.b) < ((float) this.d) * 0.9f) {
                    break;
                }
            }
            if (n.a) {
                n.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void a(String str, a aVar) {
        if (!this.a.containsKey(str)) {
            this.b += aVar.a;
        } else {
            this.b += aVar.a - this.a.get(str).a;
        }
        this.a.put(str, aVar);
    }

    private void e(String str) {
        a remove = this.a.remove(str);
        if (remove != null) {
            this.b -= remove.a;
        }
    }

    static byte[] a(b bVar, long j) throws Throwable {
        long a2 = bVar.a();
        if (j >= 0 && j <= a2) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + a2);
    }

    /* access modifiers changed from: package-private */
    public InputStream a(File file) throws Throwable {
        return new FileInputStream(file);
    }

    /* access modifiers changed from: package-private */
    public OutputStream b(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DiskBasedCache */
    public static class a {
        long a;
        final String b;
        final String c;
        final long d;
        final long e;
        final long f;
        final long g;
        final List<Header> h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.b = str;
            this.c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        a(String str, a.C0003a aVar) {
            this(str, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, a(aVar));
        }

        private static List<Header> a(a.C0003a aVar) {
            if (aVar.i != null) {
                return aVar.i;
            }
            return com.bytedance.sdk.adnet.b.b.b(aVar.h);
        }

        static a a(b bVar) throws Throwable {
            if (f.a((InputStream) bVar) == 538247942) {
                return new a(f.a(bVar), f.a(bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b(bVar));
            }
            throw new IOException();
        }

        /* access modifiers changed from: package-private */
        public a.C0003a a(byte[] bArr) {
            a.C0003a aVar = new a.C0003a();
            aVar.b = bArr;
            aVar.c = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.g = this.g;
            aVar.h = com.bytedance.sdk.adnet.b.b.a(this.h);
            aVar.i = Collections.unmodifiableList(this.h);
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(OutputStream outputStream) {
            try {
                f.a(outputStream, 538247942);
                f.a(outputStream, this.b);
                f.a(outputStream, this.c == null ? "" : this.c);
                f.a(outputStream, this.d);
                f.a(outputStream, this.e);
                f.a(outputStream, this.f);
                f.a(outputStream, this.g);
                f.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                n.b("%s", th.toString());
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DiskBasedCache */
    public static class b extends FilterInputStream {
        private final long a;
        private long b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.a = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.b += (long) read;
            }
            return read;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.a - this.b;
        }
    }

    private static int c(InputStream inputStream) throws Throwable {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void a(OutputStream outputStream, int i) throws Throwable {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws Throwable {
        return (c(inputStream) << 24) | (c(inputStream) << 0) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) throws Throwable {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long b(InputStream inputStream) throws Throwable {
        return ((((long) c(inputStream)) & 255) << 0) | 0 | ((((long) c(inputStream)) & 255) << 8) | ((((long) c(inputStream)) & 255) << 16) | ((((long) c(inputStream)) & 255) << 24) | ((((long) c(inputStream)) & 255) << 32) | ((((long) c(inputStream)) & 255) << 40) | ((((long) c(inputStream)) & 255) << 48) | ((255 & ((long) c(inputStream))) << 56);
    }

    static void a(OutputStream outputStream, String str) throws Throwable {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String a(b bVar) throws Throwable {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    static void a(List<Header> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            a(outputStream, list.size());
            for (Header header : list) {
                a(outputStream, header.getName());
                a(outputStream, header.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }

    static List<Header> b(b bVar) throws Throwable {
        int a2 = a((InputStream) bVar);
        if (a2 >= 0) {
            List<Header> emptyList = a2 == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < a2; i++) {
                emptyList.add(new Header(a(bVar).intern(), a(bVar).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=" + a2);
    }
}
