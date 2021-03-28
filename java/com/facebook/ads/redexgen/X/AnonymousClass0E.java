package com.facebook.ads.redexgen.X;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.0E  reason: invalid class name */
public final class AnonymousClass0E implements Comparator<File> {
    public AnonymousClass0E() {
    }

    private int A00(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final int compare(File file, File file2) {
        return A00(file.lastModified(), file2.lastModified());
    }
}
