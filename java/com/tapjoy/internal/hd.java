package com.tapjoy.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import javax.annotation.Nullable;

public final class hd {
    private final File a;

    public hd(File file) {
        this.a = file;
    }

    /* JADX INFO: finally extract failed */
    public final synchronized boolean a() {
        if (b() != null) {
            return false;
        }
        try {
            File file = this.a;
            String uuid = UUID.randomUUID().toString();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bg.a(fileOutputStream, uuid);
                jz.a(fileOutputStream);
                if (b() != null) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                jz.a(fileOutputStream);
                throw th;
            }
        } catch (IOException e) {
            this.a.delete();
            throw e;
        } catch (IOException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final String b() {
        if (!this.a.exists()) {
            return null;
        }
        try {
            String a2 = bg.a(this.a, ak.c);
            if (a2.length() > 0) {
                return a2;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }
}
