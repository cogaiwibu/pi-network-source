package com.ss.android.crash.log;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: FileUtils */
public class n {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.io.File r3, java.lang.String r4) throws java.io.IOException {
        /*
            if (r3 == 0) goto L_0x0036
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0009
            goto L_0x0036
        L_0x0009:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x002f }
            r2 = 1
            r1.<init>(r3, r2)     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r3.<init>()     // Catch:{ all -> 0x002c }
            r3.append(r4)     // Catch:{ all -> 0x002c }
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch:{ all -> 0x002c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002c }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x002c }
            r1.write(r3)     // Catch:{ all -> 0x002c }
            r1.close()
            return
        L_0x002c:
            r3 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x002f:
            r3 = move-exception
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            throw r3
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.crash.log.n.a(java.io.File, java.lang.String):void");
    }

    static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    static String b(String str) throws FileNotFoundException, IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                l.a(bufferedReader);
                return sb.toString();
            }
        }
    }
}
