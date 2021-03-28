package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.openadsdk.g.l;
import java.io.File;
import java.util.List;

/* compiled from: TotalCountLruDiskFile */
public class f extends d {
    private int a = 15;
    private int b = 3;

    public f(int i, int i2) {
        if (i > 0) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public boolean a(long j, int i) {
        return i <= this.a;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public boolean a(File file, long j, int i) {
        return i <= this.b;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public void a(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        if (!a(b2, size)) {
            for (File file : list) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b2 -= length;
                    l.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    l.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
                }
                if (a(file, b2, size)) {
                    return;
                }
            }
        }
    }
}
