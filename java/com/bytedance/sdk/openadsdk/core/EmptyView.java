package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.v;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmptyView extends View implements v.a {
    private boolean a;
    private boolean b;
    private a c;
    private View d;
    private List<View> e;
    private List<View> f;
    private boolean g;
    private int h;
    private final Handler i;
    private final AtomicBoolean j;

    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        this.g = false;
        a();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        a();
    }

    private void a() {
        a aVar;
        if (this.j.getAndSet(false) && (aVar = this.c) != null) {
            aVar.a();
        }
    }

    private void b() {
        a aVar;
        if (!this.j.getAndSet(true) && (aVar = this.c) != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
        this.g = true;
        b();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        b();
    }

    public void setRefClickViews(List<View> list) {
        this.e = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f = list;
    }

    private void c() {
        if (this.b && !this.a) {
            this.a = true;
            this.i.sendEmptyMessage(1);
        }
    }

    private void d() {
        if (this.a) {
            this.i.removeCallbacksAndMessages(null);
            this.a = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.b = z;
        if (!z && this.a) {
            d();
        } else if (z && !this.a) {
            c();
        }
    }

    public void setCallback(a aVar) {
        this.c = aVar;
    }

    public void setAdType(int i2) {
        this.h = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 == 2) {
                boolean c2 = t.c(j.a(), j.a().getPackageName());
                if (t.a(this.d, 20, this.h) || !c2) {
                    this.i.sendEmptyMessageDelayed(2, 1000);
                } else if (!this.g) {
                    setNeedCheckingShow(true);
                }
            }
        } else if (!this.a) {
        } else {
            if (t.a(this.d, 20, this.h)) {
                d();
                this.i.sendEmptyMessageDelayed(2, 1000);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a(this.d);
                    return;
                }
                return;
            }
            this.i.sendEmptyMessageDelayed(1, 1000);
        }
    }
}
