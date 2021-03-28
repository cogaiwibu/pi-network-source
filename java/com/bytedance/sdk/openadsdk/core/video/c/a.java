package com.bytedance.sdk.openadsdk.core.video.c;

import com.bytedance.sdk.openadsdk.core.video.c.c;

/* compiled from: AbstractMediaPlayer */
public abstract class a implements c {
    private c.e a;
    private c.b b;
    private c.a c;
    private c.f d;
    private c.g e;
    private c.AbstractC0005c f;
    private c.d g;

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.e eVar) {
        this.a = eVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.b bVar) {
        this.b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.f fVar) {
        this.d = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.AbstractC0005c cVar) {
        this.f = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.g gVar) {
        this.e = gVar;
    }

    public void a() {
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        c.e eVar = this.a;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        c.b bVar = this.b;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i) {
        c.a aVar = this.c;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        c.f fVar = this.d;
        if (fVar != null) {
            fVar.c(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i, int i2, int i3, int i4) {
        c.g gVar = this.e;
        if (gVar != null) {
            gVar.a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, int i2) {
        c.AbstractC0005c cVar = this.f;
        return cVar != null && cVar.a(this, i, i2);
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i, int i2) {
        c.d dVar = this.g;
        return dVar != null && dVar.b(this, i, i2);
    }
}
