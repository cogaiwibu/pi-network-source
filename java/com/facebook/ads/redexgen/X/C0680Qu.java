package com.facebook.ads.redexgen.X;

import java.io.ByteArrayInputStream;

/* renamed from: com.facebook.ads.redexgen.X.Qu  reason: case insensitive filesystem */
public final class C0680Qu implements AnonymousClass0L {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C0680Qu(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final void ABQ(int i) throws C0681Qv {
        this.A00 = new ByteArrayInputStream(this.A01);
        this.A00.skip((long) i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final void close() throws C0681Qv {
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final int length() throws C0681Qv {
        return this.A01.length;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0L
    public final int read(byte[] bArr) throws C0681Qv {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
