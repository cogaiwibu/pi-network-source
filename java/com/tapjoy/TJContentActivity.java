package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gz;

public class TJContentActivity extends Activity {
    private static volatile ContentProducer a;
    private ContentProducer b;
    private boolean c = false;

    public static abstract class AbstractContentProducer implements ContentProducer {
        @Override // com.tapjoy.TJContentActivity.ContentProducer
        public void dismiss(Activity activity) {
        }

        @Override // com.tapjoy.TJContentActivity.ContentProducer
        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        }
    }

    public interface ContentProducer {
        void dismiss(Activity activity);

        void onActivityResult(Activity activity, int i, int i2, Intent intent);

        void show(Activity activity);
    }

    public static void start(Context context, ContentProducer contentProducer, boolean z) {
        Intent intent = new Intent(context, TJContentActivity.class);
        intent.setFlags(276889600);
        intent.putExtra("com.tapjoy.internal.content.producer.id", toIdentityString(contentProducer));
        intent.putExtra("com.tapjoy.internal.content.fullscreen", z);
        synchronized (TJContentActivity.class) {
            a = contentProducer;
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (!a(getIntent())) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ContentProducer contentProducer = this.b;
        if (contentProducer != null) {
            contentProducer.dismiss(this);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (gz.a().n) {
            this.c = true;
            gn.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (this.c) {
            this.c = false;
            gn.b(this);
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.b.onActivityResult(this, i, i2, intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r5.getBooleanExtra("com.tapjoy.internal.content.fullscreen", false) == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        getWindow().setFlags(1024, 1024);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r4.b.show(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "com.tapjoy.internal.content.producer.id"
            java.lang.String r0 = r5.getStringExtra(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Class<com.tapjoy.TJContentActivity> r2 = com.tapjoy.TJContentActivity.class
            monitor-enter(r2)
            com.tapjoy.TJContentActivity$ContentProducer r3 = com.tapjoy.TJContentActivity.a     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x003d
            com.tapjoy.TJContentActivity$ContentProducer r3 = com.tapjoy.TJContentActivity.a     // Catch:{ all -> 0x003f }
            java.lang.String r3 = toIdentityString(r3)     // Catch:{ all -> 0x003f }
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            com.tapjoy.TJContentActivity$ContentProducer r0 = com.tapjoy.TJContentActivity.a     // Catch:{ all -> 0x003f }
            r4.b = r0     // Catch:{ all -> 0x003f }
            r0 = 0
            com.tapjoy.TJContentActivity.a = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r2)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = "com.tapjoy.internal.content.fullscreen"
            boolean r5 = r5.getBooleanExtra(r0, r1)
            if (r5 == 0) goto L_0x0036
            android.view.Window r5 = r4.getWindow()
            r0 = 1024(0x400, float:1.435E-42)
            r5.setFlags(r0, r0)
        L_0x0036:
            com.tapjoy.TJContentActivity$ContentProducer r5 = r4.b
            r5.show(r4)
            r5 = 1
            return r5
        L_0x003d:
            monitor-exit(r2)
            return r1
        L_0x003f:
            r5 = move-exception
            monitor-exit(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJContentActivity.a(android.content.Intent):boolean");
    }

    public static String toIdentityString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + System.identityHashCode(obj);
    }
}
