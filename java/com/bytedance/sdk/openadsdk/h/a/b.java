package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.h.a;
import com.bytedance.sdk.openadsdk.h.n;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: FileCache */
public class b implements a {
    public File a;
    private final a b;
    private RandomAccessFile c;

    public b(File file, a aVar) throws n {
        File file2;
        if (aVar != null) {
            try {
                this.b = aVar;
                h.a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.a = file2;
                this.c = new RandomAccessFile(this.a, exists ? "r" : "rw");
            } catch (IOException e) {
                l.b("FileCache", "Error using file " + file + " as disc cache ", e);
                throw new n("Error using file " + file + " as disc cache", e);
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public synchronized long a() throws n {
        try {
        } catch (IOException e) {
            l.b("FileCache", "Error reading length of file " + this.a + ", e :", e);
            throw new n("Error reading length of file " + this.a, e);
        }
        return this.c.length();
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public synchronized int a(byte[] bArr, long j, int i) throws n {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            l.b("FileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)) + "e: ", e);
            throw new n(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public synchronized void a(byte[] bArr, int i) throws n {
        try {
            if (!d()) {
                this.c.seek(a());
                this.c.write(bArr, 0, i);
            } else {
                throw new n("Error append cache: cache file " + this.a + " is completed!");
            }
        } catch (IOException e) {
            l.b("FileCache", String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)) + " , e :", e);
            throw new n(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public synchronized void b() throws n {
        try {
            this.c.close();
            this.b.a(this.a);
        } catch (IOException e) {
            l.b("FileCache", "Error closing file " + this.a + "e:", e);
            throw new n("Error closing file " + this.a, e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public synchronized void c() throws n {
        if (!d()) {
            b();
            File file = new File(this.a.getParentFile(), this.a.getName().substring(0, this.a.getName().length() - 9));
            if (this.a.renameTo(file)) {
                this.a = file;
                try {
                    this.c = new RandomAccessFile(this.a, "r");
                    this.b.a(this.a);
                } catch (IOException e) {
                    l.b("FileCache", "Error opening " + this.a + " as disc cache ,e:", e);
                    throw new n("Error opening " + this.a + " as disc cache", e);
                }
            } else {
                throw new n("Error renaming file " + this.a + " to " + file + " for completion!");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public synchronized boolean d() {
        return !a(this.a);
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }
}
