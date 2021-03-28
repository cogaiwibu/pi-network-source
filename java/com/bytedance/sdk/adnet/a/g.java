package com.bytedance.sdk.adnet.a;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import com.ironsource.sdk.constants.Events;
import java.io.UnsupportedEncodingException;

/* compiled from: JsonRequest */
public abstract class g<T> extends Request<T> {
    private static final String c = String.format("application/json; charset=%s", Events.CHARSET_FORMAT);
    private final Object d = new Object();
    private m.a<T> e;
    private final String f;

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public abstract m<T> a(j jVar);

    public g(int i, String str, String str2, m.a<T> aVar) {
        super(i, str, aVar);
        this.e = aVar;
        this.f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.d) {
            this.e = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.d) {
            aVar = this.e;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            if (this.f == null) {
                return null;
            }
            return this.f.getBytes(Events.CHARSET_FORMAT);
        } catch (UnsupportedEncodingException unused) {
            n.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f, Events.CHARSET_FORMAT);
            return null;
        }
    }
}
