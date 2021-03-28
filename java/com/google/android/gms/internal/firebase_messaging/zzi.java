package com.google.android.gms.internal.firebase_messaging;

import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class zzi {
    private static final Logger zza = Logger.getLogger(zzi.class.getName());

    private zzi() {
    }

    public static void zza(@NullableDecl InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                try {
                    zza.logp(Level.WARNING, "com.google.common.io.Closeables", TJAdUnitConstants.String.CLOSE, "IOException thrown while closing Closeable.", (Throwable) e);
                } catch (IOException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
    }
}
