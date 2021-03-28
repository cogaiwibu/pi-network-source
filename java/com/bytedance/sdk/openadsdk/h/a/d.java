package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.g.l;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: LruDiskFile */
public abstract class d implements a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* access modifiers changed from: protected */
    public abstract void a(List<File> list);

    /* access modifiers changed from: protected */
    public abstract boolean a(long j, int i);

    /* access modifiers changed from: protected */
    public abstract boolean a(File file, long j, int i);

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public void a(File file) throws IOException {
        this.a.submit(new a(file));
    }

    public File a(String str, File file) throws IOException {
        return b(str, file);
    }

    private File b(String str, File file) {
        List<File> b = h.b(file);
        if (b == null || b.size() <= 0) {
            return null;
        }
        for (File file2 : b) {
            if (file2 != null && str.equals(file2.getName())) {
                l.e("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
                return file2;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(File file) throws IOException {
        h.c(file);
        a(h.b(file.getParentFile()));
    }

    /* access modifiers changed from: package-private */
    public long b(List<File> list) {
        long j = 0;
        for (File file : list) {
            j += file.length();
        }
        return j;
    }

    /* compiled from: LruDiskFile */
    private class a implements Callable<Void> {
        private final File b;

        private a(File file) {
            this.b = file;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            d.this.b((d) this.b);
            return null;
        }
    }
}
