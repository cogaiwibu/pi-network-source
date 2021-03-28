package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.ap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public final class hx {
    public static final bi e = new bi() {
        /* class com.tapjoy.internal.hx.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hx(bnVar);
        }
    };
    private static final an f;
    public URL a;
    public Bitmap b;
    public byte[] c;
    public ie d;

    static {
        an arVar = new ar();
        if (!(arVar instanceof as)) {
            arVar = new ap.a((aq) arVar);
        }
        f = arVar;
    }

    public hx(URL url) {
        this.a = url;
    }

    public final boolean a() {
        return (this.b == null && this.c == null) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hx.b():void");
    }

    private ByteArrayInputStream a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jx.a(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        Cif ifVar = new Cif();
        ifVar.a(byteArray);
        ie a2 = ifVar.a();
        if (a2.b == 0) {
            this.c = byteArray;
            this.d = a2;
        } else {
            s sVar = s.a;
            this.b = s.a(byteArrayInputStream);
            byteArrayInputStream.reset();
        }
        return byteArrayInputStream;
    }

    hx(bn bnVar) {
        if (bnVar.k() == bs.STRING) {
            this.a = bnVar.e();
            return;
        }
        bnVar.h();
        String l = bnVar.l();
        while (bnVar.j()) {
            if ("url".equals(l)) {
                this.a = bnVar.e();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
    }
}
