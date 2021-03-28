package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.Tu  reason: case insensitive filesystem */
public class C0755Tu implements AbstractC01816i {
    public final /* synthetic */ U7 A00;

    public C0755Tu(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() throws CertificateException, PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Signature[] signatureArr = this.A00.A00.getPackageManager().getPackageInfo(this.A00.A00.getPackageName(), 64).signatures;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < signatureArr.length; i++) {
            hashMap.put(Integer.valueOf(i), new U6(signatureArr[i]));
        }
        return this.A00.A05(hashMap);
    }
}
