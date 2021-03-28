package com.bytedance.sdk.openadsdk.h;

import com.bytedance.sdk.openadsdk.h.a.a;
import com.bytedance.sdk.openadsdk.h.b.b;
import java.io.File;

/* access modifiers changed from: package-private */
/* compiled from: Config */
public class c {
    public final File a;
    public final com.bytedance.sdk.openadsdk.h.a.c b;
    public final a c;
    public final com.bytedance.sdk.openadsdk.h.c.c d;
    public final b e;

    c(File file, com.bytedance.sdk.openadsdk.h.a.c cVar, a aVar, com.bytedance.sdk.openadsdk.h.c.c cVar2, b bVar) {
        this.a = file;
        this.b = cVar;
        this.c = aVar;
        this.d = cVar2;
        this.e = bVar;
    }

    /* access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.a, this.b.a(str));
    }
}
