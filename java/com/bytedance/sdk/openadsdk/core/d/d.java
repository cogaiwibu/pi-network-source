package com.bytedance.sdk.openadsdk.core.d;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: PermissionsManager */
public class d {
    private static final String a = d.class.getSimpleName();
    private static d e = null;
    private static final Map<String, Integer> f;
    private final Set<String> b = new HashSet(1);
    private final List<WeakReference<e>> c = new ArrayList(1);
    private final List<e> d = new ArrayList(1);

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(o.b(j.a(), "tt_request_permission_descript_location")));
        f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(o.b(j.a(), "tt_request_permission_descript_location")));
        f.put("android.permission.READ_PHONE_STATE", Integer.valueOf(o.b(j.a(), "tt_request_permission_descript_read_phone_state")));
        f.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(o.b(j.a(), "tt_request_permission_descript_external_storage")));
        if (Build.VERSION.SDK_INT >= 16) {
            f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(o.b(j.a(), "tt_request_permission_descript_external_storage")));
        }
    }

    public static d a() {
        if (e == null) {
            e = new d();
        }
        return e;
    }

    private d() {
        b();
    }

    private synchronized void b() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e2) {
                Log.e(a, "Could not access field", e2);
            }
            this.b.add(str);
        }
    }

    private synchronized void a(String[] strArr, e eVar) {
        if (eVar != null) {
            eVar.a(strArr);
            this.d.add(eVar);
            this.c.add(new WeakReference<>(eVar));
        }
    }

    private synchronized void a(e eVar) {
        Iterator<WeakReference<e>> it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference<e> next = it.next();
            if (next.get() == eVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<e> it2 = this.d.iterator();
        while (it2.hasNext()) {
            if (it2.next() == eVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean a(Context context, String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (p.e()) {
            if (a.a(context, str) && (b.a(context, str) == 0 || !this.b.contains(str))) {
                z = true;
            }
            return z;
        }
        if (b.a(context, str) == 0 || !this.b.contains(str)) {
            z = true;
        }
        return z;
    }

    public synchronized void a(Activity activity, String[] strArr, e eVar) {
        if (activity != null) {
            try {
                a(strArr, eVar);
                if (Build.VERSION.SDK_INT < 23) {
                    b(activity, strArr, eVar);
                } else {
                    List<String> c2 = c(activity, strArr, eVar);
                    if (c2.isEmpty()) {
                        a(eVar);
                    } else {
                        b.a(activity, (String[]) c2.toArray(new String[c2.size()]), 1);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return;
        }
        return;
    }

    private void b(Activity activity, String[] strArr, e eVar) {
        boolean z;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.b.contains(str)) {
                        z = eVar.a(str, c.NOT_FOUND);
                    } else if (b.a(activity, str) != 0) {
                        z = eVar.a(str, c.DENIED);
                    } else {
                        z = eVar.a(str, c.GRANTED);
                    }
                    if (z) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(eVar);
    }

    private List<String> c(Activity activity, String[] strArr, e eVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!this.b.contains(str)) {
                if (eVar != null) {
                    eVar.a(str, c.NOT_FOUND);
                }
            } else if (!a(activity, str)) {
                arrayList.add(str);
            } else if (eVar != null) {
                eVar.a(str, c.GRANTED);
            }
        }
        return arrayList;
    }

    public synchronized void a(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (p.e() && !a.a(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0.remove();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String[] r6, int[] r7, java.lang.String[] r8) {
        /*
            r5 = this;
            int r8 = r6.length     // Catch:{ all -> 0x0047 }
            int r0 = r7.length     // Catch:{ all -> 0x0047 }
            if (r0 >= r8) goto L_0x0005
            int r8 = r7.length     // Catch:{ all -> 0x0047 }
        L_0x0005:
            java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.d.e>> r0 = r5.c     // Catch:{ all -> 0x0047 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0047 }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x0047 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0047 }
            com.bytedance.sdk.openadsdk.core.d.e r1 = (com.bytedance.sdk.openadsdk.core.d.e) r1     // Catch:{ all -> 0x0047 }
            r2 = 0
        L_0x001e:
            if (r2 >= r8) goto L_0x000b
            if (r1 == 0) goto L_0x0030
            r3 = r6[r2]     // Catch:{ all -> 0x0047 }
            r4 = r7[r2]     // Catch:{ all -> 0x0047 }
            boolean r3 = r1.a(r3, r4)     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x002d
            goto L_0x0030
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x001e
        L_0x0030:
            r0.remove()     // Catch:{ all -> 0x0047 }
            goto L_0x000b
        L_0x0034:
            java.util.List<com.bytedance.sdk.openadsdk.core.d.e> r6 = r5.d     // Catch:{ all -> 0x0047 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0047 }
        L_0x003a:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0047 }
            if (r7 == 0) goto L_0x004b
            r6.next()     // Catch:{ all -> 0x0047 }
            r6.remove()     // Catch:{ all -> 0x0047 }
            goto L_0x003a
        L_0x0047:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.d.d.a(java.lang.String[], int[], java.lang.String[]):void");
    }
}
