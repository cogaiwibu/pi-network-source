package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class ZN implements AbstractC0358Dy {
    /* JADX INFO: Multiple debug info for r0v1 java.nio.ByteBuffer: [D('buffer' java.nio.ByteBuffer), D('data' byte[])] */
    /* JADX INFO: Multiple debug info for r0v2 int: [D('data' byte[]), D('size' int)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0358Dy
    public final Metadata A4e(CC cc) {
        ByteBuffer buffer = cc.A01;
        byte[] array = buffer.array();
        int size = buffer.limit();
        IQ iq = new IQ(array, size);
        String A0R = iq.A0R();
        String A0R2 = iq.A0R();
        long A0N = iq.A0N();
        long timescale = C0466Ig.A0F(iq.A0N(), 1000000, A0N);
        return new Metadata(new EventMessage(A0R, A0R2, C0466Ig.A0F(iq.A0N(), 1000, A0N), iq.A0N(), Arrays.copyOfRange(array, iq.A07(), size), timescale));
    }
}
