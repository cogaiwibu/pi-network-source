package com.bytedance.sdk.adnet.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ImageLoader */
public class d {
    private final ExecutorService a = Executors.newCachedThreadPool();
    private final l b;
    private int c = 50;
    private final b d;
    private final Map<String, a> e = Collections.synchronizedMap(new HashMap());
    private final Map<String, a> f = Collections.synchronizedMap(new HashMap());
    private final Handler g = new Handler(Looper.getMainLooper());

    /* compiled from: ImageLoader */
    public interface b {
        Bitmap a(String str);

        String a(String str, int i, int i2, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap);
    }

    /* renamed from: com.bytedance.sdk.adnet.a.d$d  reason: collision with other inner class name */
    /* compiled from: ImageLoader */
    public interface AbstractC0001d extends m.a<Bitmap> {
        void a();

        void a(c cVar, boolean z);

        void b();
    }

    public d(l lVar, b bVar) {
        this.b = lVar;
        this.d = bVar == null ? new a() : bVar;
    }

    public void a(String str, AbstractC0001d dVar) {
        a(str, dVar, 0, 0);
    }

    public void a(String str, AbstractC0001d dVar, int i, int i2) {
        a(str, dVar, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final AbstractC0001d dVar, final int i, final int i2, final ImageView.ScaleType scaleType) {
        this.a.execute(new Runnable() {
            /* class com.bytedance.sdk.adnet.a.d.AnonymousClass1 */

            public void run() {
                d.this.b(str, dVar, i, i2, scaleType);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(String str, final AbstractC0001d dVar, int i, int i2, ImageView.ScaleType scaleType) {
        this.g.post(new Runnable() {
            /* class com.bytedance.sdk.adnet.a.d.AnonymousClass2 */

            public void run() {
                dVar.a();
            }
        });
        String a2 = a(str, i, i2, scaleType);
        Bitmap a3 = this.d.a(a2);
        if (a3 != null) {
            final c cVar = new c(a3, str, null, null);
            this.g.post(new Runnable() {
                /* class com.bytedance.sdk.adnet.a.d.AnonymousClass3 */

                public void run() {
                    dVar.a(cVar, true);
                    dVar.b();
                }
            });
            return;
        }
        c cVar2 = new c(null, str, a2, dVar);
        a aVar = this.e.get(a2);
        if (aVar == null) {
            aVar = this.f.get(a2);
        }
        if (aVar != null) {
            aVar.a(cVar2);
            return;
        }
        Request<Bitmap> a4 = a(str, i, i2, scaleType, a2);
        this.b.a(a4);
        this.e.put(a2, new a(a4, cVar2));
    }

    /* access modifiers changed from: protected */
    public Request<Bitmap> a(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new e(str, new m.a<Bitmap>() {
            /* class com.bytedance.sdk.adnet.a.d.AnonymousClass4 */

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(final m<Bitmap> mVar) {
                d.this.a.execute(new Runnable() {
                    /* class com.bytedance.sdk.adnet.a.d.AnonymousClass4.AnonymousClass1 */

                    public void run() {
                        d.this.a(str2, mVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(final m<Bitmap> mVar) {
                d.this.a.execute(new Runnable() {
                    /* class com.bytedance.sdk.adnet.a.d.AnonymousClass4.AnonymousClass2 */

                    public void run() {
                        d.this.b(str2, mVar);
                    }
                });
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
    }

    /* access modifiers changed from: protected */
    public void a(String str, m<Bitmap> mVar) {
        this.d.a(str, mVar.a);
        a remove = this.e.remove(str);
        if (remove != null) {
            remove.c = mVar.a;
            remove.a(mVar);
            a(str, remove);
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str, m<Bitmap> mVar) {
        a remove = this.e.remove(str);
        if (remove != null) {
            remove.a(mVar.c);
            remove.a(mVar);
            a(str, remove);
        }
    }

    /* compiled from: ImageLoader */
    public class c {
        private Bitmap b;
        private final AbstractC0001d c;
        private final String d;
        private final String e;

        public c(Bitmap bitmap, String str, String str2, AbstractC0001d dVar) {
            this.b = bitmap;
            this.e = str;
            this.d = str2;
            this.c = dVar;
        }

        public Bitmap a() {
            return this.b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ImageLoader */
    public static class a {
        private final Request<?> a;
        private m<Bitmap> b;
        private Bitmap c;
        private VAdError d;
        private final List<c> e;

        public a(Request<?> request, c cVar) {
            List<c> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.e = synchronizedList;
            this.a = request;
            synchronizedList.add(cVar);
        }

        public void a(VAdError vAdError) {
            this.d = vAdError;
        }

        public VAdError a() {
            return this.d;
        }

        public m<Bitmap> b() {
            return this.b;
        }

        public void a(m<Bitmap> mVar) {
            this.b = mVar;
        }

        public void a(c cVar) {
            this.e.add(cVar);
        }
    }

    private void a(final String str, a aVar) {
        this.f.put(str, aVar);
        this.g.postDelayed(new Runnable() {
            /* class com.bytedance.sdk.adnet.a.d.AnonymousClass5 */

            public void run() {
                a aVar = (a) d.this.f.get(str);
                if (aVar != null) {
                    for (c cVar : aVar.e) {
                        if (cVar.c != null) {
                            if (aVar.a() == null) {
                                cVar.b = aVar.c;
                                cVar.c.a(cVar, false);
                            } else {
                                cVar.c.b(aVar.b());
                            }
                            cVar.c.b();
                        }
                    }
                }
                d.this.f.remove(str);
            }
        }, (long) this.c);
    }

    private String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        String a2 = this.d.a(str, i, i2, scaleType);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }
}
