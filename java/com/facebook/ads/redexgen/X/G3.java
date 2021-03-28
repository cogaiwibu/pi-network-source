package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public final class G3 implements AbstractC0645Pl {
    public int A00;
    @Nullable
    public String A01;
    @Nullable
    public Map<String, List<String>> A02;
    @Nullable
    public byte[] A03;

    public G3(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.A00 = httpURLConnection.getResponseCode();
            this.A01 = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.A02 = httpURLConnection.getHeaderFields();
        this.A03 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0645Pl
    @Nullable
    public final byte[] A5T() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0645Pl
    @Nullable
    public final String A5U() {
        byte[] bArr = this.A03;
        if (bArr != null) {
            return new String(bArr);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0645Pl
    @Nullable
    public final Map<String, List<String>> A6L() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0645Pl
    public final int A74() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0645Pl
    @Nullable
    public final String getUrl() {
        return this.A01;
    }
}
