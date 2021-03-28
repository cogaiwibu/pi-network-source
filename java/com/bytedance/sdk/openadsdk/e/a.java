package com.bytedance.sdk.openadsdk.e;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.h.a.g;
import java.io.File;
import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
/* compiled from: DiskImageCache */
public class a extends com.bytedance.sdk.adnet.a.a {
    private static String b;
    private WeakHashMap<String, String> c = new WeakHashMap<>();
    private final com.bytedance.sdk.openadsdk.h.a.a d = new g();

    public static a a() {
        return new a();
    }

    private a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    @Override // com.bytedance.sdk.adnet.a.a, com.bytedance.sdk.adnet.a.d.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(java.lang.String r5) {
        /*
            r4 = this;
            android.graphics.Bitmap r0 = super.a(r5)
            if (r0 != 0) goto L_0x0045
            java.io.File r1 = new java.io.File
            java.lang.String r2 = b()
            r1.<init>(r2, r5)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x0045
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x002f }
            r3.<init>(r1)     // Catch:{ all -> 0x002f }
            java.io.FileDescriptor r1 = r3.getFD()     // Catch:{ all -> 0x002c }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFileDescriptor(r1, r2, r2)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0028
            super.a(r5, r0)     // Catch:{ all -> 0x002c }
        L_0x0028:
            r3.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0045
        L_0x002c:
            r5 = move-exception
            r2 = r3
            goto L_0x0030
        L_0x002f:
            r5 = move-exception
        L_0x0030:
            java.lang.String r1 = "diskImageCache getBitmap error "
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x003e }
            com.bytedance.sdk.adnet.core.n.a(r5, r1, r3)     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0045
            r2.close()
            goto L_0x0045
        L_0x003e:
            r5 = move-exception
            if (r2 == 0) goto L_0x0044
            r2.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            throw r5
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.e.a.a(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.adnet.a.a, com.bytedance.sdk.adnet.a.d.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r8, android.graphics.Bitmap r9) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.e.a.a(java.lang.String, android.graphics.Bitmap):void");
    }

    @Override // com.bytedance.sdk.adnet.a.a, com.bytedance.sdk.adnet.a.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.c.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String a = com.bytedance.sdk.openadsdk.g.g.a(str);
        this.c.put(str, a);
        return a;
    }

    private static String b() {
        if (TextUtils.isEmpty(b)) {
            File file = new File(com.bytedance.sdk.adnet.a.a(j.a()), "diskImage");
            file.mkdirs();
            b = file.getAbsolutePath();
        }
        return b;
    }
}
