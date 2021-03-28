package com.bytedance.sdk.adnet.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.adnet.a.c;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FileLoader */
public class b {
    private final Map<String, C0000b> a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final l c;
    private Context d;

    /* compiled from: FileLoader */
    public interface a extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, l lVar) {
        this.d = context;
        this.c = lVar;
        this.a = Collections.synchronizedMap(new LinkedHashMap());
    }

    public void a(String str, a aVar) {
        a(str, aVar, true);
    }

    public void a(String str, final a aVar, boolean z) {
        C0000b bVar;
        if (!TextUtils.isEmpty(str)) {
            if (!a(str) || (bVar = this.a.get(str)) == null) {
                final File a2 = aVar.a(str);
                if (a2 == null || aVar == null) {
                    a(b(str, aVar, z));
                } else {
                    this.b.post(new Runnable() {
                        /* class com.bytedance.sdk.adnet.a.b.AnonymousClass1 */

                        public void run() {
                            aVar.a(a2.length(), a2.length());
                            aVar.a(m.a(a2, null));
                        }
                    });
                }
            } else {
                bVar.a(aVar);
            }
        }
    }

    private void a(C0000b bVar) {
        if (bVar != null) {
            bVar.a();
            this.a.put(bVar.a, bVar);
        }
    }

    private boolean a(String str) {
        return this.a.containsKey(str);
    }

    private C0000b b(String str, a aVar, boolean z) {
        String str2;
        File b2 = aVar != null ? aVar.b(str) : null;
        if (b2 == null) {
            str2 = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            str2 = b2.getAbsolutePath();
        }
        return new C0000b(str, str2, aVar, z);
    }

    private String a() {
        File file = new File(com.bytedance.sdk.adnet.a.a(this.d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.adnet.a.b$b  reason: collision with other inner class name */
    /* compiled from: FileLoader */
    public class C0000b {
        String a;
        String b;
        List<a> c;
        boolean d;
        c e;

        C0000b(String str, String str2, a aVar, boolean z) {
            this.a = str;
            this.b = str2;
            this.d = z;
            a(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            if (aVar != null) {
                if (this.c == null) {
                    this.c = Collections.synchronizedList(new ArrayList());
                }
                this.c.add(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            c cVar = new c(this.b, this.a, new c.a() {
                /* class com.bytedance.sdk.adnet.a.b.C0000b.AnonymousClass1 */

                @Override // com.bytedance.sdk.adnet.a.c.a
                public void a(long j, long j2) {
                    if (C0000b.this.c != null) {
                        for (a aVar : C0000b.this.c) {
                            try {
                                aVar.a(j, j2);
                            } catch (Throwable th) {
                                n.a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<File> mVar) {
                    if (C0000b.this.c != null) {
                        for (a aVar : C0000b.this.c) {
                            try {
                                aVar.a(mVar);
                            } catch (Throwable th) {
                                n.a(th, "file loader onResponse error", new Object[0]);
                            }
                            try {
                                aVar.a(C0000b.this.a, mVar.a);
                            } catch (Throwable th2) {
                                n.a(th2, "file loader putFile error", new Object[0]);
                            }
                        }
                        C0000b.this.c.clear();
                    }
                    b.this.a.remove(C0000b.this.a);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    if (C0000b.this.c != null) {
                        for (a aVar : C0000b.this.c) {
                            try {
                                aVar.b(mVar);
                            } catch (Throwable th) {
                                n.a(th, "file loader onErrorResponse error", new Object[0]);
                            }
                        }
                        C0000b.this.c.clear();
                    }
                    b.this.a.remove(C0000b.this.a);
                }
            });
            this.e = cVar;
            cVar.setTag("FileLoader#" + this.a);
            b.this.c.a(this.e);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0000b) {
                return ((C0000b) obj).a.equals(this.a);
            }
            return super.equals(obj);
        }
    }
}
