package com.bytedance.sdk.adnet.a;

import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest */
public class j extends Request<String> {
    private final Object c = new Object();
    private m.a<String> d;

    public j(int i, String str, m.a<String> aVar) {
        super(i, str, aVar);
        this.d = aVar;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<String> mVar) {
        m.a<String> aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<String> a(com.bytedance.sdk.adnet.core.j jVar) {
        String str;
        try {
            str = new String(jVar.b, b.a(jVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(jVar.b);
        }
        return m.a(str, b.a(jVar));
    }
}
