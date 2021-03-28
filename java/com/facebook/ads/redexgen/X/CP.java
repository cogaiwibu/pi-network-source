package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

public final class CP {
    public final IQ A00 = new IQ(10);

    @Nullable
    public final Metadata A00(CL cl, @Nullable EA ea) throws IOException, InterruptedException {
        int i = 0;
        Metadata metadata = null;
        while (true) {
            try {
                cl.ABZ(this.A00.A00, 0, 10);
                this.A00.A0Z(0);
                if (this.A00.A0H() != ZP.A03) {
                    break;
                }
                this.A00.A0a(3);
                int A0E = this.A00.A0E();
                int i2 = A0E + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.A00.A00, 0, bArr, 0, 10);
                    cl.ABZ(bArr, 10, A0E);
                    metadata = new ZP(ea).A0P(bArr, i2);
                } else {
                    cl.A3M(A0E);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        cl.ACa();
        cl.A3M(i);
        return metadata;
    }
}
